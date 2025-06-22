package com.example.quan_li_san_pham.model;


import javax.persistence.*;

@Entity(name = "product")
public class ProductDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT")
    private Integer id;
    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String name;
    @Column(name = "price", columnDefinition = "DOUBLE")
    private Double price;
    @Column(name = "description", columnDefinition = "VARCHAR(100)")
    private String description;
    @Column(name = "product_actor", columnDefinition = "VARCHAR(100)")
    private String productActor;

    public ProductDB() {
    }

    public ProductDB(Integer id, String name, Double price, String description, String productActor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.productActor = productActor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductActor() {
        return productActor;
    }

    public void setProductActor(String productActor) {
        this.productActor = productActor;
    }
}
