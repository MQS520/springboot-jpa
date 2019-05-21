package com.mqs.service;

import com.mqs.entity.Person;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonService {

    Person save(Person person);

    Person findById(Long id);

    List<Person> findAll();

    Page<Person> selectByPage(Integer pageNum, Integer pageSize);

    List<Person> findByName(String name);

}
