
package com.sql_zsgc.control;

import com.sql_zsgc.Repository.SzygdlRepository;
import com.sql_zsgc.pojo.Szygdl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
//返回页面用controller注解和 @RequestMapping
@Controller
public class Zsgc2 {


    @Autowired
    private SzygdlRepository szygdlRepository;

    @RequestMapping("info")
    public String getinfo(Model model) {
        List<Szygdl> resultList = szygdlRepository.findAll();
        model.addAttribute("resultList",resultList);
        return "materialInfo";
    }

}

