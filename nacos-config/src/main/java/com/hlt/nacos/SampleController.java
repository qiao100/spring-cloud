package com.qiao.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author: qiaolongjin
 * @date: 2019/8/2
 * @desc:
 */

@RestController
@RefreshScope
public class SampleController   {
    @Value("${user.name}")
    String userName;

    @Value("${user.age:25}")
    int age;
    @Value("${user.id:13}")
    String id;

    @GetMapping("/user")
    public String simple() {
        return "Hello Nacos Config!" + "id" + id +""+ userName + " " + age + "!";
    }

}
