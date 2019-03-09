package com.template.dao.impl;

import com.template.dao.ModelJsonDao;
import com.template.dao.repository.ModelJsonRepository;
import com.template.model.ModelJson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelJsonDaoImpl implements ModelJsonDao {

    private ModelJsonRepository modelJsonRepository;

    @Override
    public String getByJsonIn(String string) {
        return modelJsonRepository.getByJsonIn(string);
    }

    @Override
    public List<ModelJson> getAll() {
        return modelJsonRepository.findAll();
    }

    @Override
    public ModelJson create(ModelJson modelJson) {
        return modelJsonRepository.save(modelJson);
    }

    @Override
    public void delete(Long id) {
        modelJsonRepository.deleteById(id);
    }
}
