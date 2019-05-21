package com.mqs.dao;

import com.mqs.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {


    @Query(value = "select * from person where name like %:name%", nativeQuery = true)
    List<Person> findName(@Param("name") String name);

}
