package com.mqs.service.impl;

import com.mqs.dao.PersonRepository;
import com.mqs.entity.Person;
import com.mqs.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        // 传入的Person对象:若无id主键,为新增;若有id主键,为修改
        return personRepository.save(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person findById(Long id) {
        // get()方式若根据id查询没有查到,会抛出异常,使用orElse(),可以给一个默认返回值,当查询不到时,返回null
//        return personRepository.findById(id).get();
        return personRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findAll() {
        //排序 根据id,倒序
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return personRepository.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Person> selectByPage(Integer pageNum, Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        return personRepository.findAll(pageable);
    }

    @Override
    public List<Person> findByName(String name) {
        return personRepository.findName(name);
    }
}
