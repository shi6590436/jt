package com.net.jianshu.pojo;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "jt" ,type="product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private  String name;
    private String desc;
    private String img;

    public Product(Long id, String name, String desc, String img) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Product setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getImg() {
        return img;
    }

    public Product setImg(String img) {
        this.img = img;
        return this;
    }
}
