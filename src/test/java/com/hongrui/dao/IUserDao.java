package com.hongrui.dao;

import com.hongrui.po.User;


/**
 * @author hongrui
 * @description
 * @date 2024-10-01 18:09
 */
public interface IUserDao {
    User queryUserInfoById(Integer uId);
}
