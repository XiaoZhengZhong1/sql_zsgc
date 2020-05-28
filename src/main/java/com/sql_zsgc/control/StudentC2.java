package com.sql_zsgc.control;

import com.sql_zsgc.Repository.StudentR;
import com.sql_zsgc.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class StudentC2 {
    @Autowired
    private StudentR studentR;

    //学生表首页
    @RequestMapping("StuInfo")
    public String getALL(Model model) {
        List<Student> resultList = studentR.getAll();
        model.addAttribute("resultList", resultList);
        return "StudentInfo";
    }

    //学生表编辑请求
    @RequestMapping("editorInfo")
    public String editorInfo(Model model,int id) {
        Student result = studentR.getOne(id);
        model.addAttribute("result",result);
        return "editorStu";
    }

    //学生表编辑后提交保存请求
    @RequestMapping("/editorCommit")
    public void editorCommit(Student student, HttpServletResponse response) throws IOException {
        if(student.getBirthday()==null) {
            int id = student.getStuId();
            Student result = studentR.getOne(id);
            student.setBirthday(result.getBirthday());
        }
        studentR.save(student);
        response.sendRedirect("/StuInfo");
    }

    //学生表根据id删除
    @RequestMapping("deleteById")
    public void deleteById(int id, String name, HttpServletResponse response) throws IOException {
        studentR.deleteById(id);
        response.sendRedirect("/StuInfo");
    }

    //学生表首页批量删除请求
    @RequestMapping("BatchDeleteById")
    public String BatchDeleteById(Model model){
        List<Student> resultList = studentR.findAll();
        model.addAttribute("resultList", resultList);
        return "deleteStu";
    }

    //批量删除请求
    @RequestMapping("batchedDelete")
    public void batchedDelete(int[] checkId,String name, HttpServletResponse response) throws IOException {
        for (int id : checkId){
            studentR.deleteById(id);
        }
        response.sendRedirect("/StuInfo");
    }

    //学生表首页新增请求
    @RequestMapping("add")
    public String addStu(Student student,Model model) {
        studentR.save(student);
        Student result = studentR.getLast();
        model.addAttribute("result",result);
        return "editorStu";


    }

}
