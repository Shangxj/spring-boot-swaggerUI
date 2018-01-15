package com.study.swagger.swaggerui.service;

import com.study.swagger.swaggerui.model.Student;

import java.util.List;

/**
 * @author sxj
 * @date 2018-01-15 11:30
 */
public interface StudentService {

    /**
     * 查询所有学生
     * @return 所有学生
     */
    List<Student> findAll();

    /**
     * 添加学生
     * @param stu 学生
     * @return 学生
     */
    Student add(Student stu);

    /**
     * 查询学生信息
     * @param id id
     * @return 学生
     */
    Student findOne(Integer id);
    /**
     * 查询学生信息
     * @param id id
     * @return 学生
     */
    void deleteOne(Integer id);

    /**
     * 查询学生信息
     * @param stu 学生
     * @return 学生
     */
    Student updateOne(Student stu);
}
