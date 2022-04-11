package io.github.neoqf.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author LQF
 */
public class MyBatisUtils {

    private  static SqlSessionFactory factory = null;
    static {
        String config = "mybatis.xml";  // 与项目中的文件名一致
        try {
            InputStream in = Resources.getResourceAsStream(config);
            //创建SqlSessionFactory对象，使用SqlSessionFactoryBuild
            // 这种方式保证只创建一个
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取sqlSession方法
     * @return SqlSession
     */
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession = factory.openSession();  // 非自动提交事务
        }
        return sqlSession;
    }
}
