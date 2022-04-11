package io.github.neoqf.dao;

import io.github.neoqf.domain.Student;
import io.github.neoqf.vo.QueryParam;

import java.util.List;

public interface StudentDao {

    /**
     * 一个简单类型的参数
     *      简单类型：mybatis把Java数据类型和String都叫做简单类型
     * @param id
     * @return
     */
    public Student selectStudentById(Integer id);

    /**
     * 多个参数，使用Java对象作为接口方法中的参数
     * @param param
     * @return
     */
    List<Student> selectMutilObject(QueryParam param);
}