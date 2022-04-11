package io.github.neoqf;

import io.github.neoqf.dao.StudentDao;
import io.github.neoqf.domain.Student;
import io.github.neoqf.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {

    @Test
    public void testSelectStudents() {
        /**
         * 使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口.class)
         * getMapper能够获取dao接口对应的实现类对象。
         */
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //com.sun.proxy.$Proxy2 : jdk的动态代理
        System.out.println("dao=" + dao.getClass().getName());        // 调用dao的方法，执行数据库操作
        List<Student> students = dao.selectStudents();
        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }
    }

    @Test
    public void testInsertStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(1005);
        student.setName("盾山");
        student.setEmail("dunshan@qq.com");
        int nums = dao.insertStudent(student);
        System.out.println("添加对象的数量：" + nums);
    }
}
