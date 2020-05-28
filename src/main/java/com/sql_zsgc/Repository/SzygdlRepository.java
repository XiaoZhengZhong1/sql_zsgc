
package com.sql_zsgc.Repository;

import com.sql_zsgc.pojo.Szygdl;
import org.hibernate.query.criteria.internal.ListJoinImplementor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SzygdlRepository
        extends JpaRepository<Szygdl, Integer>, JpaSpecificationExecutor<Szygdl> {

    List<Szygdl> findAllByOrderByPpmaterialBarcoderId();

    List<Szygdl> findAllBySerialNo(String serialNo);

    //自己写sql的格式                                   表名           表id字段                :为占位符和?一样
    @Query(nativeQuery = true, value = "select * from szygdl where ppmaterial_barcoder_id= :id")
    Szygdl findMaterial(@Param("id") int id);

    @Query(nativeQuery = true,value = "select * from(select * from szygdl t order by ppmaterial_barcoder_id desc) where rownum=1")
    Szygdl getLast();
}

