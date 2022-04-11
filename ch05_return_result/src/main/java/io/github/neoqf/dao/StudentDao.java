package io.github.neoqf.dao;

import io.github.neoqf.domain.Student;
import io.github.neoqf.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {


    Student selectStudentById(@Param("studentId") Integer id);


    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);


}