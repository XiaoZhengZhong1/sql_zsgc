
package com.sql_zsgc.control;

import com.sql_zsgc.Repository.SzygdlRepository;
import com.sql_zsgc.pojo.Szygdl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class Zsgc {


    @Autowired
    private SzygdlRepository szygdlRepository;

    @RequestMapping("info")
    public String getinfo(Model model) {
        List<Szygdl> resultList = szygdlRepository.findAll();
        model.addAttribute("resultList",resultList);
        return "materialInfo";
    }

    @GetMapping("getData")
    public List<Szygdl> getData() {
        List<Szygdl> all = szygdlRepository.findAll();
        return all;
    }

    @GetMapping("getOneData")
    public Szygdl getOneData() {
        List<Szygdl> all = szygdlRepository.findAll();
        Szygdl szygdl = all.get(0);
        return szygdl;
    }

}

