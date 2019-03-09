package com.template.dao.repository;

import com.template.model.ModelJson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ModelJsonRepository extends JpaRepository<ModelJson, Long> {

    @Query("select mj.jsonOut from ModelJson mj where mj.jsonIn = ?1")
    String getByJsonIn(String jsonIn);

}
