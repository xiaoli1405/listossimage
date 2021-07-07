package com.example.listossimage.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 用户实体
 */
@Data
@Entity
@Table(name = "user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String user_id;//唯一id
    @Column
    private String user_name;//名字
    @Column
    private String user_number;//账号
    @Column
    private String user_password;//密码

}
