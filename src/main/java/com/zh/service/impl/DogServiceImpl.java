package com.zh.service.impl;

import com.zh.dao.primarydatasource.entity.Dog;
import com.zh.dao.primarydatasource.repository.DogRepository;
import com.zh.service.DogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * DogServiceImpl
 *
 * @author zhanghang
 * @Description
 * @date 2018/9/11/9:42
 */
@Service
public class DogServiceImpl implements DogService {
    @Resource
    private DogRepository dogRepository;
    @Override
    public Dog findById(int id) {
        return dogRepository.findById(id);
    }

    @Override
    public void insertOne(Dog dog) {
        dogRepository.save(dog);
    }


    @Override
    @Transactional(transactionManager = "primaryTransactionManager")
    public void insertAny(Dog dog) {
        dogRepository.save(dog);
        dog.setId(dog.getId()+1).setName(dog.getName()+1);
        dogRepository.save(dog);
       /* if (1==1){
            throw new RuntimeException();
        }*/
    }
}
