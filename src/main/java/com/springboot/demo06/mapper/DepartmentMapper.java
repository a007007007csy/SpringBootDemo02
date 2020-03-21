package com.springboot.demo06.mapper;

import com.springboot.demo06.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


// 指定这是一个操作数据库的mapper
@Mapper
@Repository
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values (#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
