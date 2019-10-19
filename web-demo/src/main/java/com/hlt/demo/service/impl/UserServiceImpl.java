package com.qiao.demo.service.impl;

 import com.qiao.demo.dao.UserRepository;
import com.qiao.demo.domain.User;
import com.qiao.demo.domain.UserDTO;
import com.qiao.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: qiaolongjin
 * @date: 2019/7/18
 * @desc: 接口实现层
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userDao;

    @Override
    public User getUser(int userId) {
        return userDao.getOne(userId);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userDao.saveAndFlush(user);
    }

    @Override
    @Transactional
    public void update(UserDTO dto) {
        userDao.updateUserById(dto.getName(), dto.getId());
    }
}
