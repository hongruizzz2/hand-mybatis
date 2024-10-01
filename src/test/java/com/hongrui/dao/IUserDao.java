package com.hongrui.dao;

import com.hongrui.po.User;

import java.util.stream.Stream;

/**
 * @author hongrui
 * @description
 * @date 2024-10-01 18:09
 */
public interface IUserDao {
    String queryUserInfoById(String uId);
}
