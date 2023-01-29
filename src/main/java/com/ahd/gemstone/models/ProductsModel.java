package com.ahd.gemstone.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;


@Entity
@Table(name = "products")
public class ProductsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @NotNull(message = "massage")
    @Column(name = "name")
    private String name;

    @NotNull(message = "يجب ادخال حقل الوصف")
    @Column(name = "description")
    private String description;
    @Column(name = "createAt")
    private String createAt;
    @Column(name = "category")
    private String category;
    @NotNull(message = "يجب ادخال حقل السعر")
    @Column(name = "price")
    private double price;
    @NotNull(message = "يجب ادخال حقل الكمية")
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "discount")
    private float discount;
    public ProductsModel(String name, String description, String category, double price, int quantity, float discount) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        createAt = new Date().toString();
    }
    public ProductsModel() {
        createAt = new Date().toString();
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
