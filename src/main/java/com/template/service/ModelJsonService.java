package com.template.service;

import com.template.model.ModelJson;


/**
 * Created by {@author Artyr Pan}
 * Class for save input json, in object {@link ModelJson}
 */
public interface ModelJsonService {

    /**
     * @param json input map, for save on database
     * @return {@link ModelJson} of saved
     */
    ModelJson save(String json);

}
