package com.webstoreproducts.model;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tab_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
//    private String group;
    private String item;
    private Integer memorySize;
    private Integer storageSize;
    private String manufacturer;

    public Product() {
    }

    public Product(String item, Integer memorySize, Integer storageSize, String manufacturer) {
        this.item = item;
        this.memorySize = memorySize;
        this.storageSize = storageSize;
        this.manufacturer = manufacturer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public String getGroup() {
//        return group;
//    }
//
//    public void setGroup(String group) {
//        this.group = group;
//    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(Integer memorySize) {
        this.memorySize = memorySize;
    }

    public Integer getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(Integer storageSize) {
        this.storageSize = storageSize;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(item, product.item) && Objects.equals(memorySize, product.memorySize) && Objects.equals(storageSize, product.storageSize) && Objects.equals(manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, memorySize, storageSize, manufacturer);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", memorySize=" + memorySize +
                ", storageSize=" + storageSize +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
