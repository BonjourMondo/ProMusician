package com.promusician.mapper;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class ProSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory=null;
    //初始化创建SqlSessionFactory对象
    static {
        try {
            InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取SqlSession对象的静态方法
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    //获取SqlSessionFactory的静态方法
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}

