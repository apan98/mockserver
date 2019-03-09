package com.template.dao;

import com.template.model.ModelJson;

import java.util.List;

public interface ModelJsonDao {

    String getByJsonIn(String string);

    List<ModelJson> getAll();

    ModelJson create(ModelJson modelJson);

    void delete(Long id);

}
