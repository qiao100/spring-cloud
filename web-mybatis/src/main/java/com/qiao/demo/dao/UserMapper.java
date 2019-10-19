package com.qiao.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiao.demo.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: qiaolongjin
 * @date: 2019/7/31
 * @desc:
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * <p>
     * 查询 : 根据年龄大小状态查询用户列表，分页显示
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param age 年龄
     * @return 分页对象
     */
    IPage<User> selectPageVo(Page page, @Param("age") Integer age);

}
