package com.sql_zsgc.control;

import com.sql_zsgc.Repository.StudentR;
import com.sql_zsgc.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentC {
    @Autowired
    private StudentR studentR;

    @GetMapping("getAll")
    public List<Student> getALL() {
        List<Student> all = studentR.findAll();
        return all;

    }

    @GetMapping("getOne")
    public Student getOne(int id){
        Student one = studentR.getOne(id);
        return one;
    }

    @GetMapping("saveOne")
    public void saveOne(Student student){
         studentR.save(student);

    }

}
