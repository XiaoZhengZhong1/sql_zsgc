
package com.sql_zsgc.control;

import com.sql_zsgc.Repository.SzygdlRepository;
import com.sql_zsgc.pojo.Szygdl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


}

