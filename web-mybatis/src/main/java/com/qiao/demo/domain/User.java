package com.qiao.demo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: qiaolongjin
 * @date: 2019/7/31
 * @desc:
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * nick_name
     */
    private String nickName;

    /**
     * age
     */
    private Integer age;

    public User() {
    }

}