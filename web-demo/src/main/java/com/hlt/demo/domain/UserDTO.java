package com.qiao.demo.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: qiaolongjin
 * @date: 2019/7/17
 * @desc: 用户信息 dto
 *
 *
 */
@Data
public class UserDTO implements Serializable {

    @NotNull
    private Integer id;
    @NotBlank
    private String name;


}
