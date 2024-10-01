package com.hongrui;

import com.hongrui.binding.MapperRegistry;
import com.hongrui.dao.IUserDao;
import com.hongrui.io.Resources;
import com.hongrui.po.User;
import com.hongrui.session.SqlSession;
import com.hongrui.session.SqlSessionFactory;
import com.hongrui.session.SqlSessionFactoryBuilder;
import com.hongrui.session.defaults.DefaultSqlSession;
import com.hongrui.session.defaults.DefaultSqlSessionFactory;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    private static final Logger log = LoggerFactory.getLogger(AppTest.class);

    public void test_MapperProxyFactory() throws IOException {
        // 1. 从sqlsessionfactory中获取sqlsession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2.获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String result = userDao.queryUserInfoById("10001");
        log.info("测试结果：{}", result);
    }
}
