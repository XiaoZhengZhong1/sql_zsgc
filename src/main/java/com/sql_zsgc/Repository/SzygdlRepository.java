
package com.sql_zsgc.Repository;

import com.sql_zsgc.pojo.Szygdl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SzygdlRepository
        extends JpaRepository<Szygdl, Integer>, JpaSpecificationExecutor<Szygdl> {
}

