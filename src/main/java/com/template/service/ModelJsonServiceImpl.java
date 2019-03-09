package com.template.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.template.dao.ModelJsonDao;
import com.template.model.ModelJson;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ModelJsonServiceImpl implements ModelJsonService {

    private ObjectMapper objectMapper;
    private ModelJsonDao modelJsonDao;
    private static final String JSON_IN = "jsonIn";
    private static final String JSON_OUT = "jsonOut";
    private static final String JSON_ID = "id";


    @Override
    @SneakyThrows
    public ModelJson save(String json) {
        ModelJson modelJson = new ModelJson();
        ObjectNode objectNode = objectMapper.readValue(json, ObjectNode.class);
        String jsonIn = objectNode.get(JSON_IN).toString();
        log.info("jsonIn: {}", jsonIn);
        String jsonOut = objectNode.get(JSON_OUT).toString();
        log.info("jsonOut: {}", jsonOut);


        modelJson.setJsonIn(jsonIn);
        modelJson.setJsonOut(jsonOut);
        if(objectNode.get(JSON_ID) != null) {
            Long id = Long.valueOf(objectNode.get(JSON_ID).toString());
            log.info("id: {}", id);
            modelJson.setId(id);
        }
        return modelJsonDao.create(modelJson);
    }
}
