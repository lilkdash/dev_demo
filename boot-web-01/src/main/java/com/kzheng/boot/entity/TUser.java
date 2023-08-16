package com.kzheng.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/27 21:57
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TUser {
    private int id;
    private String userId;
    private String username;
    private String password;
    private int age;
    private String sex;
    private String email;
    private String token;
}
