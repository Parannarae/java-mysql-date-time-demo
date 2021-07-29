package com.coway.dbTimeZoneDemo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DbTimeZoneDemoApplicationTests {

	@Autowired TimeTableRepository repository;

	@Test
	void contextLoads() {
		log.info("Current timezone: {}", TimeZone.getDefault());

		log.info("Inserting a sample datum...");
		TimeTable tt = TimeTable.builder()
				.localDateTimeToDatetime(LocalDateTime.now())
				.instantToTimestamp(Instant.now())
				.localDateTimeToTimestamp(LocalDateTime.now())
				.instantToDatetime(Instant.now())
				.build();
		repository.save(tt);
	}

}
