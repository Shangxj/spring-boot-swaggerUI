package com.study.swagger.swaggerui.service;

import com.study.swagger.swaggerui.model.Student;
import com.study.swagger.swaggerui.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sxj
 * @date 2018-01-15 11:32
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student add(Student stu) {
        log.info("添加学生信息为",stu.toString());
        return studentRepository.save(stu);
    }

    @Override
    public Student findOne(Integer id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void deleteOne(Integer id) {
         studentRepository.delete(id);
    }

    @Override
    public Student updateOne(Student stu) {
        return studentRepository.save(stu);
    }
}
