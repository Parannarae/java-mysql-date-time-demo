package com.coway.dbTimeZoneDemo;

import java.time.Instant;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;

@Builder
@Data
public class TimeTable {

  @Id
  private Long id;
  @LastModifiedBy
  private LocalDateTime localDateTimeToDatetime;
  @LastModifiedBy
  private Instant instantToTimestamp;
  @LastModifiedBy
  private LocalDateTime localDateTimeToTimestamp;
  @LastModifiedBy
  private Instant instantToDatetime;
}
