package com.coway.dbTimeZoneDemo;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DbTimeZoneDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbTimeZoneDemoApplication.class, args);
	}

	@PostConstruct
	public void init() {
		// Change the application time zone
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

}
