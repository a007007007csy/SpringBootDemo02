package com.springboot.demo08cache.controller;

import com.springboot.demo08cache.bean.Department;
import com.springboot.demo08cache.mapper.DepartmentMapper;
import com.springboot.demo08cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return deptService.getDeptById(id);
        //return deptService.getDeptById2(id);
    }
}
