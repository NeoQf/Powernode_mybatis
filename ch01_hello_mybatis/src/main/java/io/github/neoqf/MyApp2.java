package io.github.neoqf;

import io.github.neoqf.domain.Student;
import io.github.neoqf.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author LQF
 */
public class MyApp2 {

    public static void main(String[] args) throws IOException {
        //5.【重要】获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //6.【重要】指定要执行的sql语句的标识。  sql映射文件中的namespace + "." + 标签的id值
        String sqlId = "io.github.neoqf.dao.StudentDao.selectStudents";
        //7. 【重要】执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8.输出结果
        for(Student stu : studentList){
            System.out.println("查询的学生="+stu);
        }
        //9.关闭SqlSession对象
        sqlSession.close();

    }
}
