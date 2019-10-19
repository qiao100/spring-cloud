package com.qiao.demo.dao;

import com.qiao.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: qiaolongjin
 * @date: 2019/7/17
 * @desc: dao层
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    @Modifying(clearAutomatically = true)
    @Query(value = "update user set name = ?1  where  id = ?2",nativeQuery = true)
    int updateUserById(@Param("name") String name, @Param("id") Integer id);


}
