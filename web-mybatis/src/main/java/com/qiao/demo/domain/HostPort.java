package com.qiao.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: qiaolongjin
 * @date: 2019/9/23
 * @desc:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HostPort implements Serializable{
    private String host;
    private String port;
}
