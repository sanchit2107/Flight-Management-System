package com.org.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.org.model.Airport;

@Repository
public interface AirportDao extends CrudRepository<Airport, String> {

}
