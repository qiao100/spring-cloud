package com.qiao.demo.service;

import com.qiao.demo.domain.User;
import com.qiao.demo.domain.UserDTO;

/**
 * @author: qiaolongjin
 * @date: 2019/7/18
 * @desc:UserService 接口层
 */
public interface UserService {


    User getUser(int userId);

    User save(User user);

    void update(UserDTO dto);
}
