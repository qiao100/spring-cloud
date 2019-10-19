package com.qiao.demo.controller;

import com.qiao.demo.domain.User;
import com.qiao.demo.domain.UserDTO;
import com.qiao.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



/**
 * @author: qiaolongjin
 * @date: 2019/7/17
 * @desc: demo controller层
 */
@Api(tags = "index")
@RestController
@RequestMapping("")
public class IndexController {

    private  static  final  Logger  logger  =  LoggerFactory.getLogger(IndexController.class);
    @Autowired
    UserService userService;

    @ApiOperation(value = "")
    @GetMapping(value = "/")
    public String index() {
        logger.info("hello java");
        return "hello java";
    }

    @ApiOperation(value = "获取单个请求参数")
    @GetMapping(value = "/get_user")
    public String getParam(@ApiParam(name = "请求参数", value = "userId")@RequestParam(value = "userId",required = false) Integer userId) {
        final User user = userService.getUser(userId);
        return "请求参数 get username:" + user.getName();
    }
    @ApiOperation(value = "获取单个请求参数")
    @RequestMapping(value = "/get_user1",method = RequestMethod.GET)
    public String getParam1(@ApiParam(name = "请求参数", value = "userId")  int userId) {
        final User user = userService.getUser(userId);
        return "请求参数 get username:" + user.getName();
    }

    @ApiOperation(value = "rest形式")
    @GetMapping(value = "/get_user/{userId}")
    public String getOrderStatus(@PathVariable int userId) {
        final User user = userService.getUser(userId);
        return "请求参数 get username:" + user.getName();
    }

    @ApiOperation(value = "获取用户多个参数")
    @GetMapping(value = "/user_info")
    public void getUser(@ApiParam(name = "查询条件", required = true) User user) {

        System.out.println("用户信息查询参数信息" + user.getId());
    }

    @ApiOperation(value = "保存用户信息")
    @PostMapping(value = "/insert")
    public String insert(@ApiParam(name = "查询条件", required = true) User user) {
        final User user1 = userService.save(user);
        return "返回当前id" + user1.getId();
    }


    @ApiOperation(value = "更新用户信息")
    @PostMapping(value = "/update_user")
    public String updateUser(@ApiParam(name = "查询条件", required = true) @Validated UserDTO dto) {
        userService.update(dto);
        return "操作成功";
    }

}
