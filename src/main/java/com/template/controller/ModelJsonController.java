package com.template.controller;

import com.template.dao.ModelJsonDao;
import com.template.model.ModelJson;
import com.template.service.ModelJsonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/json")
public class ModelJsonController {

    private ModelJsonDao modelJsonDao;
    private ModelJsonService modelJsonService;

    @PostMapping
    public Object create(@RequestBody String json) {
        return modelJsonService.save(json);
    }

    @GetMapping
    public List<ModelJson> getAll() {
        return modelJsonDao.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        modelJsonDao.delete(id);
    }

}