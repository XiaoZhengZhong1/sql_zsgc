
package com.sql_zsgc.Repository;

import com.sql_zsgc.pojo.Szygdl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//自己写sql语句的格式
@Repository
public interface SzygdlRepository2
        extends JpaRepository<Szygdl, Integer> {


    //自己写sql的格式                                   表名           表id字段                :为占位符和?一样
    @Query(nativeQuery = true, value = "select * from szygdl where ppmaterial_barcoder_id= :id")
    Szygdl findMaterial(@Param("id") int id);
}

