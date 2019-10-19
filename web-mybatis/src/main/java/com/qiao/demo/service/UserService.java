package com.qiao.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiao.demo.domain.User;

/**
 * @author: qiaolongjin
 * @date: 2019/7/18
 * @desc:UserService 接口层
 */
public interface UserService {


    User getUser(int userId);

    int save(User user);

    IPage<User> selectUserPage(Page<User> page, Integer age);

}
