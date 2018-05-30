package com.me.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.me.demo.entity.SUser;

/**
 * 数据访问接口，继承CrudRepository
 * 
 * @author ljh
 *
 */
@Repository
public interface SUserRepository extends JpaRepository<SUser, Integer> {

    @Query("select u from SUser u where u.email=?1 and u.password=?2")
    SUser login(String email, String password);

    /**
     * 通过邮箱和密码查找用户
     * @param email
     * @param password
     * @return
     */
    SUser findByEmailAndPassword(String email, String password);

    /**
     * 通过邮箱查找用户
     * @param email
     * @return
     */
    SUser findUserByEmail(String email);
    
    /**
     * 通过邮箱查找用户
     * @param name
     * @return
     */
    SUser findUserByName(String name);

}
