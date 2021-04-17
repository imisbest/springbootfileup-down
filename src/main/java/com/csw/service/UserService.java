package com.csw.service;

import com.csw.entity.User;

/**
 * Created by Administrator on 2019/10/25.
 */
public interface UserService {

    User login(String username, String password);

}
