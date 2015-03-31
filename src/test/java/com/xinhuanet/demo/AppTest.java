package com.xinhuanet.demo;

import com.alibaba.fastjson.JSON;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static UserNodeDao userNodeDao;

    @BeforeClass
    public static void setUpBeforeClass() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        userNodeDao = context.getBean("userNodeDao", UserNodeDao.class);
    }

    @Test
    public void testFindById() throws Exception {
        List<UserNode> users = userNodeDao.find();
        System.out.println(JSON.toJSONString(users));
    }
}
