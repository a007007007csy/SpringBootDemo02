package com.springboot.demo08cache.service;

import com.springboot.demo08cache.bean.Department;
import com.springboot.demo08cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DeptService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    CacheManager cacheManager;

    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id) {
        System.out.println("查询部门" + id);
        Department deptById = departmentMapper.getDeptById(id);
        return deptById;
    }

    // 使用缓存管理器得到缓存，进行api调用
    public Department getDeptById2(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentMapper.getDeptById(id);

        //获取某个缓存，对缓存进行增删改操作
        Cache dept = cacheManager.getCache("dept");
        dept.put("dept:1",department);

        return department;
    }
}
