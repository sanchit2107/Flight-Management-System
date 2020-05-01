package com.org.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Schedule;
import com.org.model.ScheduleId;

@Repository
public interface ScheduleDao extends CrudRepository<Schedule, ScheduleId> {

}
