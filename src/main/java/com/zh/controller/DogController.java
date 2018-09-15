package com.zh.controller;

import com.zh.dao.primarydatasource.entity.Dog;
import com.zh.service.DogService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * DogController
 *
 * @author zhanghang
 * @Description
 * @date 2018/9/11/9:38
 */
@RestController
public class DogController {

    @Resource
    private DogService dogService;



    @PostMapping("/dog")
    public ModelMap insert(@RequestBody Dog dog){
        dogService.insertOne(dog);
        return getSuccess();
    }

    @PostMapping("/dogs")
    public ModelMap insertAny(@RequestBody Dog dog){
        dogService.insertAny(dog);
        return getSuccess();
    }



    @GetMapping("/dog/{id}")
    public Dog findDog(@PathVariable int id){
        return dogService.findById(id);
    }

    private ModelMap getSuccess() {
        return new ModelMap(){{
            put("code",200);
            put("msg",true);
        }};

    }


}
