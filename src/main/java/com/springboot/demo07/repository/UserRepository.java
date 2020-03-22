package com.springboot.demo07.repository;

import com.springboot.demo07.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成对数据库的操作
// <操作哪个，主键类型>
public interface UserRepository extends JpaRepository<User,Integer> {
}
