package com.smarthane.mudfrog.auth.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/11 13:51
 * @Description:
 */
@Entity
public class Student {
    //自增ID
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer age;

    //需要声明无参数的构造函数
    public Student(){

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
