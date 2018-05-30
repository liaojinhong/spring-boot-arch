package com.me.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.demo.entity.SRole;

/**
 * 数据访问接口，继承CrudRepository
 * 
 * @author ljh
 *
 */
@Repository
public interface SRoleRepository extends JpaRepository<SRole,Integer> {



}