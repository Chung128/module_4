package com.example.ket_noi_db_quan_li_san_pham.repository;

import com.example.ket_noi_db_quan_li_san_pham.model.Product;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class ProductRepository implements IProductRepository {
    //kết nối DB
    @Override
    public List<Product> findAll() {
        Session session =  ConnectionUtil.sessionFactory.openSession();
        //truy vấn theo HQL
       // TypedQuery<Product> query = session.createQuery("from Product",Product.class);
        //truy vấn theo SQL
        TypedQuery<Product> query = session.createNativeQuery("select * from products",Product.class);
        List<Product> productList =query.getResultList();
        return productList;
    }

    @Override
    public void add(Product product) {
        Session session =ConnectionUtil.sessionFactory.openSession();
        Transaction transaction=session.getTransaction();
        transaction.begin();
        try{
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public Product findById(int id) {
        Session session= ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query=session.createNativeQuery("select * from products where id= :id",Product.class);
        Product product=query.setParameter("id",id).getSingleResult();
        return product;
    }

    @Override
    public void update(Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(product); // Cập nhật entity
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Failed to update product: " + e.getMessage(), e);
        } finally {
            session.close(); // Đóng session
        }
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> findByName(String name) {
        Session session= ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query=session.createNativeQuery("select * from products where name like :name",Product.class);
        Product products=query.setParameter(name,"%"+name+"%").getSingleResult();
        return (List<Product>) products;
    }
}
