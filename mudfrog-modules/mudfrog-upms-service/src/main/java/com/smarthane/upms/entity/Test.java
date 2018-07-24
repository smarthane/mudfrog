package com.smarthane.upms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/7/24 15:55
 * @Description:
 */
@Entity
@Table(name = "test")
public class Test implements Serializable {

    private static final long serialVersionUID = -1756087696221171302L;

    @Id
    @Column(name = "code", length = 128)
    private String code;

    @Column(name = "name", length = 128)
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
