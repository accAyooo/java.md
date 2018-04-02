package com.study.cart.data;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午12:44 2018/3/18
 */
public class Product {
    private long id;
    private String name;
    private String level;
    private String desc;
    private int price;

    public Product(long id, String name, String level, String desc, int price) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.desc = desc;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
