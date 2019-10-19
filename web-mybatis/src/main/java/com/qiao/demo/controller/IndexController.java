package com.qiao.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiao.demo.domain.User;
import com.qiao.demo.service.UserService;
import com.qiao.demo.config.RegisterProperties;

import com.qiao.demo.enums.HttpStatusEnums;
import com.qiao.demo.exception.PaymentException;
import com.qiao.demo.utils.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * @author: qiaolongjin
 * @date: 2019/7/17
 * @desc: demo controller层
 */
@Api(tags = "index")
@RestController
@RequestMapping("")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    UserService userService;
    @Autowired
    RegisterProperties registerProperties;
    @Autowired
    private Environment env;


    @ApiOperation(value = "")
    @GetMapping(value = "/")
    public BaseResponse<String> index(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        logger.info("hello java1");
        logger.info("hello java1");
        logger.info("hello java1"+userId);
        return BaseResponse.isSucess("s1rr");
    }

    @ApiOperation(value = "")
    @GetMapping(value = "/index")
    public void index1(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        final String[] activeProfiles = env.getActiveProfiles();
        for (String profile:activeProfiles) {
            logger.info("hello profile"+profile);
        }

        logger.info("hello index"+userId);
     }

    @ApiOperation(value = "获取单个请求参数")
    @GetMapping(value = "/get_user")
    public String getParam(@ApiParam(name = "userId") @RequestParam(value = "userId", required = false) Integer userId ) {
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
        userService.save(user);
        return "返回当前id";
    }




    @ApiOperation(value = "根据年龄分页获取用户信息")
    @GetMapping(value = "/selectUserPage/{age}")
    public IPage<User> selectUserPage(@PathVariable Integer age) {
        final IPage<User> user = userService.selectUserPage(new Page<User>(), age);
        return user;
    }


    @ApiOperation(value = "根据年龄分页获取用户信息")
    @GetMapping(value = "/throw")
    public String throwExce(int status) {
        if (status == 1) {
            throw new PaymentException("测试异常");
        }
        if (status == 2) {
            throw new PaymentException(HttpStatusEnums.ACCESS_DENIDED_EXCEPTION);
        }
        if (status == 3) {
            throw new PaymentException(HttpStatusEnums.ACCESS_DENIDED_EXCEPTION, "测试异常");
        }

        return "123";
    }


}
