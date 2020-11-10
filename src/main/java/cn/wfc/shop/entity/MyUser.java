package cn.wfc.shop.entity;

import lombok.Data;

import java.util.Date;
@Data
public class MyUser {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Date created;
    private Date updated;

}
