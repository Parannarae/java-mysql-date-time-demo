package com.coway.dbTimeZoneDemo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DbTimeZoneDemoApplicationTests {

	@Autowired TimeTableRepository repository;

	@BeforeEach
	void beforeEach() {
		log.info("Current timezone: {}", TimeZone.getDefault());
	}

	@Test
	void testInsertingData() {
		log.info("Inserting a sample datum...");
		TimeTable tt = TimeTable.builder()
				.localDateTimeToDatetime(LocalDateTime.now())
				.instantToTimestamp(Instant.now())
				.localDateTimeToTimestamp(LocalDateTime.now())
				.instantToDatetime(Instant.now())
				.build();
		repository.save(tt);
	}

	@Test
	void testGetInsertedData() {
		log.info("Getting all data...");
		Iterable<TimeTable> timeTables = repository.findAllById(
				List.of(4L, 5L, 6L, 7L, 10L, 11L, 12L, 13L));
		String newlineDelimitedTimeTables = StreamSupport
				.stream(timeTables.spliterator(), false)
				.sorted(Comparator.comparing(TimeTable::getId))
				.map(TimeTable::toString)
				.collect(Collectors.joining("\n"));

		log.info("timeTables:\n{}", newlineDelimitedTimeTables);
	}
}
