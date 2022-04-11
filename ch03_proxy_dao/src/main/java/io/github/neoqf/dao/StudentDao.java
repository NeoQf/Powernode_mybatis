package io.github.neoqf.dao;

import io.github.neoqf.domain.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectStudents();

    int insertStudent(Student student);
}