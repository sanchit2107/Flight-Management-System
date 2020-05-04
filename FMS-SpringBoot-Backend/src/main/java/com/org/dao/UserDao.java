package com.org.dao;
import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import com.org.model.Users;;

public interface UserDao extends CrudRepository<Users, BigInteger>{

}