package com.mqs.controller;

import com.mqs.entity.Person;
import com.mqs.service.PersonService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonService personService;

    /**
     * 新增或修改
     * @param person
     * @return
     */
    @ApiOperation(value = "新增或修改", notes = "sssssss")
    @ApiImplicitParam(name = "person", value = "person实体类", required = true, dataType = "Person")
    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    @ResponseBody
    public Person addPerson(@RequestBody Person person){
        return personService.save(person);
    }

    /**
     *  根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectOne", method = RequestMethod.POST)
    @ResponseBody
    public Person selectOne(@RequestParam("id") Long id){
        return personService.findById(id);
    }

    /**
     *  查询所有
     * @return
     */
    @RequestMapping(value = "/selectAll", method = RequestMethod.POST)
    @ResponseBody
    public List<Person> selectAll(){
        return personService.findAll();
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/selectByPage", method = RequestMethod.POST)
    @ResponseBody
    public Page<Person> selectByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        return personService.selectByPage(pageNum, pageSize);
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.POST)
    @ResponseBody
    public List<Person> findByName(@RequestParam String name){
        System.out.println(name + "-------------------------");
        logger.info(name);
        return personService.findByName(name);
    }


}
