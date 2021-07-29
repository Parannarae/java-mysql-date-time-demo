package com.coway.dbTimeZoneDemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableRepository extends CrudRepository<TimeTable, Long> {

}
