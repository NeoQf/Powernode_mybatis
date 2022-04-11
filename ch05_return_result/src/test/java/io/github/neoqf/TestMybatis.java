package io.github.neoqf;

import io.github.neoqf.dao.StudentDao;
import io.github.neoqf.domain.Student;
import io.github.neoqf.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {

    @Test
    public void testSelectStudentById() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = dao.selectStudentById(1002);
        System.out.println(student);
    }
}
