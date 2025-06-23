package com.example.quan_li_san_pham.repository;

import com.example.quan_li_san_pham.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private static final List<Product> productList = new ArrayList<>();
    private static int idAutoCrement = 1;

    static {
        productList.add(new Product(idAutoCrement++, "Laptop Dell XPS 13", 25999.99, "Laptop cao cấp, mỏng nhẹ", "Dell"));
        productList.add(new Product(idAutoCrement++, "iPhone 14 Pro", 32999.00, "Điện thoại flagship của Apple", "Apple"));
        productList.add(new Product(idAutoCrement++, "Samsung Galaxy S24", 27999.50, "Điện thoại cao cấp mới nhất", "Samsung"));
        productList.add(new Product(idAutoCrement++, "Tai nghe Sony WH-1000XM5", 8999.00, "Tai nghe chống ồn cực tốt", "Sony"));
        productList.add(new Product(idAutoCrement++, "Máy ảnh Canon EOS M50", 18999.90, "Máy ảnh không gương lật", "Canon"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        product.setId(idAutoCrement++);
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        Product searchById;
        for (Product product:productList) {
            if (product.getId()==id){
                searchById=product;
                return searchById;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (Product p:productList){
            if(p.getId()==product.getId()){
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setManufacture(product.getManufacture());
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        Product product=null;
        for (Product p:productList){
            if(p.getId()==id){
                product=p;
                break;
            }
        }
        if (product!=null){
            productList.remove(product);
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products=new ArrayList<>();
        for (Product p:productList){
            if(p.getName().toLowerCase().contains(name.toLowerCase())){
                products.add(p);
            }
        }
        return products;
    }
}
