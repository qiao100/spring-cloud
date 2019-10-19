package com.qiao.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.qiao.demo.dao.UserMapper;
import com.qiao.demo.domain.User;
import com.qiao.demo.service.UserService;
import com.qiao.demo.exception.PaymentException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: qiaolongjin
 * @date: 2019/7/18
 * @desc: 接口实现层
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;



    @Override
    public User getUser(int userId) {
        return userMapper.selectById(userId);
    }




    @Override
    @Transactional(rollbackFor = PaymentException.class)
    public int save(User user) {
        if("张".equals(user.getName())) {
            throw new PaymentException("插入失败");
        }
        return userMapper.insert(user);
    }


    @Override
    public IPage<User> selectUserPage(Page<User> page, Integer age) {

        return userMapper.selectPageVo(page, age);
    }




}
