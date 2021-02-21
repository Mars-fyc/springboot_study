package com.beichende.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Mybatis工具类
 * @author Mars
 * @creat 2020-09-06-14:21
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static{
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取sqlSession
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    //释放资源
    public static void releaseSqlSession(SqlSession session){
        if(session != null){
            try{
                session.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
