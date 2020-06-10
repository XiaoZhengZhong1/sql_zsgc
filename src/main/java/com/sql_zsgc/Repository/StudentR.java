
package com.sql_zsgc.Repository;

import com.sql_zsgc.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentR
        extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {

        @Query(nativeQuery = true,value = "SELECT * FROM STUDENT")
        List<Student> getAll();

        @Query(nativeQuery = true,value = "SELECT * FROM STUDENT WHERE STU_ID= :id")
        Student getOne(@Param("id") int id);


        @Query(nativeQuery = true,value = "select * from(select * from student t order by stu_id desc) where rownum=1")
        Student getLast();




}

