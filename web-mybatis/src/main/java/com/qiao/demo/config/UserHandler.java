package com.qiao.demo.config;


import com.qiao.demo.utils.ServletHelper;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @author: qiaolongjin
 * @date: 2019/9/19
 * @desc:
 */
@Component
public class UserHandler implements Serializable {
    

    public String getCurrentUserId() {
        HttpServletRequest request = ServletHelper.getRequest();
        final String userId = (String) request.getAttribute("userId");
        return userId;
    }

}
