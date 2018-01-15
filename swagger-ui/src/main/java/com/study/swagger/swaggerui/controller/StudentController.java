package com.study.swagger.swaggerui.controller;

import com.study.swagger.swaggerui.model.Student;
import com.study.swagger.swaggerui.service.StudentService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sxj
 * @date 2018-01-15 11:36
 */
@RestController
@Slf4j
@Api(value = "学生",tags = "学生增删改查")
public class StudentController {

    @Resource
    private StudentService studentService;

    @ApiOperation(value = "获取所有学生信息",notes = "无条件，简单查询所有学生")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    @GetMapping("students")
    public List<Student> findAll(){
        List<Student> stus = studentService.findAll();
        log.info("学生信息为："+stus.toString());
        return stus;
    }

    @ApiOperation(value = "添加学生信息",notes = "输入姓名和年龄")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query",name = "name",dataType = "String",value = "姓名",required = true),
            @ApiImplicitParam(paramType = "query",name = "age",dataType = "int",value = "年龄",required = true)})
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    @PostMapping("student")
    public Student add( @RequestParam(value = "name") String name,
                       @RequestParam(value = "age") Integer age){
        log.info("name={},age={}",name,age);
        Student student = new Student(name, age);
        return studentService.add(student);
    }




    @ApiOperation(value = "查询学生信息",notes = "通过学生id")
    @ApiImplicitParam(paramType = "path",name = "id",dataType = "int",required = true,value = "学号")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    @GetMapping("student/{id}")
    public Student findOne(@PathVariable(value = "id") Integer id){
        return studentService.findOne(id);
    }



    @ApiOperation(value = "删除学生",notes = "通过学生id")
    @ApiImplicitParam(paramType = "path",name = "id",dataType = "int",required = true,value = "学号")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    @DeleteMapping("student/{id}")
    public void deleteOne(@PathVariable(value = "id") Integer id){
         studentService.deleteOne(id);
    }



    @ApiOperation(value = "修改学生",notes = "修改学生信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query",name = "id",dataType = "int",required = true,value = "学号"),
            @ApiImplicitParam(paramType = "query",name = "name",dataType = "string",required = true,value = "姓名"),
            @ApiImplicitParam(paramType = "query",name = "age",dataType = "int",required = true,value = "年龄")})
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    @PutMapping("student")
    public Student updateOne(@RequestParam(value = "id") Integer id,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "age") Integer age){
        Student student = new Student(id, name, age);
        log.info("更新的学生信息为：{}",student.toString());
        return  studentService.updateOne(student);
    }


}
