package com.hongrui;

import com.hongrui.binding.MapperRegistry;
import com.hongrui.dao.IUserDao;
import com.hongrui.session.SqlSession;
import com.hongrui.session.SqlSessionFactory;
import com.hongrui.session.defaults.DefaultSqlSession;
import com.hongrui.session.defaults.DefaultSqlSessionFactory;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    private static final Logger log = LoggerFactory.getLogger(AppTest.class);

    public void test_MapperProxyFactory() {
        // 1.注册Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.hongrui.dao");

        // 2.从SqlSession工厂获取Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4.测试验证
        String result = userDao.queryUserName("10001");
        log.info("测试结果：{}", result);
    }
}
