
package com.sql_zsgc.control;

import com.sql_zsgc.Repository.SzygdlRepository;
import com.sql_zsgc.pojo.Szygdl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Zsgc {


    @Autowired
    private SzygdlRepository szygdlRepository;

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



    @GetMapping("getOneData2")
    public Szygdl getOneData2(int id) {
        Szygdl material = szygdlRepository.findMaterial(id);
        return material;
    }

}

