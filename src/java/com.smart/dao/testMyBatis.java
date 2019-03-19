package com.smart.dao;

import com.smart.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class testMyBatis {

    public void testSqlSessionFactory() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        try {
            /**
             * Mapper接口，dao接口
             *
             * 两个绑定：
             * 1、Mapper接口与SQL映射文件的绑定，映射文件的namespace值必须指定成接口的全类名
             * 2、Mapper接口的方法与SQL映射文件的具体SQL语句的绑定 SQL语句的id值必须制定成接口的方法名
             *
             * Mapper接口开发的好处
             * 1、有更明确的类型
             * 2、接口本身：接口本身就是抽象，抽出了规范。
             */
            //获取MyBatis为Mapper接口生成的代理实现类
            UserMapper dao = session.getMapper(UserMapper.class);
            User user = dao.getUserById(2);
            System.out.println(user);
        }finally {
            session.close();
        }
    }
    }

