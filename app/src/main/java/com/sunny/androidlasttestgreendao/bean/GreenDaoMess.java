package com.sunny.androidlasttestgreendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * Created by 张玗 on 2018/3/27.
 */
@Entity
public class GreenDaoMess implements Serializable{
    private static final long serialVersionUID = 42L;

    @Id
    private Long id;
    private String image;
    private String name;
    private String stage;

    public GreenDaoMess(String image, String name, String stage) {
        this.image = image;
        this.name = name;
        this.stage = stage;
    }

    @Generated(hash = 99317147)
    public GreenDaoMess(Long id, String image, String name, String stage) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.stage = stage;
    }
    @Generated(hash = 231297332)
    public GreenDaoMess() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStage() {
        return this.stage;
    }
    public void setStage(String stage) {
        this.stage = stage;
    }
    
}
