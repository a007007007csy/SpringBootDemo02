package com.springboot.demo06.mapper;


import com.springboot.demo06.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

// @Mapper  /  @MapperScan扫描装配到容器中
@Mapper
@Repository
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
