package com.study.swagger.swaggerui.repository;

import com.study.swagger.swaggerui.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sxj
 * @date 2018-01-15 11:27
 */
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
