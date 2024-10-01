package com.hongrui;

import com.hongrui.Dao.IUserDao;
import com.hongrui.binding.MapperProxyFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    private static final Logger log = LoggerFactory.getLogger(AppTest.class);

    public void test_MapperProxyFactory() {
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);
        Map<String,String> sqlSession = new HashMap<String,String>();
        sqlSession.put("com.hongrui.Dao.IUserDao", "模拟执行 Mapper.xml 中的SQL语句，操作：查询用户名称");
        sqlSession.put("com.hongrui.Dao.IUserDao", "模拟执行 Mapper.xml 中的SQL语句，操作：查询用户年龄");
        IUserDao userDao = factory.newInstance(sqlSession);
        String result = userDao.queryUserName("1");
        String age = userDao.queryUserAge("1");
        log.info("测试结果: {}", result);
        log.info("测试结果：{}", age);
    }
}
