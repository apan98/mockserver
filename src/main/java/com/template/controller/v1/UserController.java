package com.template.controller.v1;

import com.template.controller.RestConstant;
import com.template.dao.UserDao;
import com.template.domain.model.User;
import com.template.domain.pojo.UserSearch;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(RestConstant.V1 + "/users")
@AllArgsConstructor
public class UserController {

    private static final String USER = "/{id}";
    private static final String SEARCH = "/search";

    private UserDao userDao;

    @Secured(RestConstant.ROLE_ADMIN)
    @RequestMapping(method = RequestMethod.POST)
    void create(@RequestBody User user) {
        userDao.create(user);
    }

    @Secured(RestConstant.ROLE_ADMIN)
    @RequestMapping(method = RequestMethod.PUT)
    void update(@RequestBody User user) {
        userDao.update(user);
    }

    @Secured(RestConstant.ROLE_ADMIN)
    @RequestMapping(value = USER, method = RequestMethod.GET)
    ResponseEntity<User> getById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity(userDao.getById(id), HttpStatus.OK);
    }

    @Secured(RestConstant.ROLE_ADMIN)
    @RequestMapping(value = SEARCH, method = RequestMethod.POST)
    ResponseEntity<User> getAll(@RequestBody UserSearch userSearch) {
        HttpHeaders headers = new HttpHeaders();
        if(userSearch.getPage() > 0 && userSearch.getSize() > 0) {
            headers.add(RestConstant.TOTAL_COUNT, userDao.getCount(userSearch).toString());
        }
        return new ResponseEntity(userDao.getAll(userSearch), headers, HttpStatus.OK);
    }
}