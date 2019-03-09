package com.template.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.template.dao.ModelJsonDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by {@author Artyr Pan}
 * Class for testing input json
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MainController {

    private ObjectMapper objectMapper;
    private ModelJsonDao modelJsonDao;

    @RequestMapping
    public String requestMock(@RequestBody String json) throws IOException {
        ObjectNode node = objectMapper.readValue(json, ObjectNode.class);
        return modelJsonDao.getByJsonIn(node.toString());
    }
}