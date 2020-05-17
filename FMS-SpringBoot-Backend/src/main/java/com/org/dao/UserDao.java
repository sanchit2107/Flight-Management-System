package com.org.dao;

import org.springframework.data.repository.CrudRepository;
import com.org.model.Users;;

public interface UserDao extends CrudRepository<Users, Integer>{

}