package com.example.newsModule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proto_type")
public class ProtoType {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "num")
    private int num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ProtoType() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProtoType(String id, int num) {
        super();
        this.id = id;
        this.num = num;
    }

}



