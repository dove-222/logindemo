package com.smart.entity;

import com.smart.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class testMyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    /**
     * MyBatis 小结：
     * 两个重要的配置文件
     * 1、mybatis-config.xml :全局配置文件,数据库连接信息，引入SQL映射文件
     * 2、UserMapper.xml,xml: SQL映射文件，配置增删改查的SQL语句的映射
     *
     * 两个重要的对象
     * SqlSessionFactory :SqlSession的工厂对象
     * SqlSession: java程序与数据库的会话对象，可以理解为对connection的封装
     *
     */
    @Test
    public void testSqlSessionFactory() throws Exception{


        SqlSession session = getSqlSessionFactory().openSession();

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

    @Test
    public void testCRUD() throws Exception{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sqlSession = sqlSessionFactory.openSession(true);  设置true 自动提交commit

        try {
            //获取Mapper接口的代理实现类对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            //查询
        /*    User user = mapper.getUserById(1);
            System.out.println(user);*/

            //添加
            User user = new User(null,"201827","3211111",22);
            mapper.addUser(user);


            //更新
            /*User user = new User(6,"郭子轩","970126",25);
            mapper.updateUser(user);*/

            /*Boolean result = mapper.deleteUserById(2);

            System.out.println(result);*/
            sqlSession.commit();
            System.out.println(user.getId());
        }finally {
            sqlSession.close();
        }

    }

    @Test
    public void testParameter()throws Exception{
        SqlSessionFactory ssf = getSqlSessionFactory();
        SqlSession session = ssf.openSession();

        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            //User user = mapper.getUserByIdAndUsername(10,"201827");
            Map<String,Object> map = new HashMap<>();
            map.put("id",10);
            map.put("username","201827");

            User user = mapper.getUserByMap(map);
            session.commit();
            System.out.println(user);
        }finally {
            session.close();
        }
    }

}