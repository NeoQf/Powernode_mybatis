package io.github.neoqf;

import io.github.neoqf.dao.StudentDao;
import io.github.neoqf.dao.impl.StudentDaoImpl;
import io.github.neoqf.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMybatis {

    @Test
    public void testSelectStudents() {
        // io/github/neoqf/dao/StudentDao
        StudentDao dao = new StudentDaoImpl();
        /**
         * List<Student> studentList  = dao.selectStudents(); 的调用
         * 1.dao对象，类型是StudentDao，全限定名称是：io/github/neoqf/dao/StudentDao
         *      全限定名称与namespace是相同的
         *
         * 2.方法名称selectStudents，就是mapper文件中的id值
         *
         * 3.通过dao中方法的返回值也可以确定mybatis要调用的sqlSession的方法
         *      如果返回值是List，那么调用的是SqlSession.selectList()方法
         *      如果返回值是int或是非list的，那么就可按mapper文件中的标签是<insert>还是<update>
         *      就会去调用SqlSession的insert、update的方法
         *
         * mybatis的动态代理：mybatis根据dao的方法调用，获取执行sqk语句的信息。
         *      mybatis根据dao接口创建出一个dao接口的实现类，并创建这个类的对象，
         *      来完成sqlSession调用方法，访问数据库
         *
         */

        List<Student> studentList = dao.selectStudents();
        for (Student stu : studentList) {
            System.out.println(stu);
        }
    }

    @Test
    public void testInsertStudent() {
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(1005);
        student.setName("盾山");
        student.setEmail("dunshan@qq.com");
        student.setAge(21);
        int nums = dao.insertStudent(student);
        System.out.println("添加对象的数量 = " + nums);
    }
}
