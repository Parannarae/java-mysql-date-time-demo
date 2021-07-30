CREATE TABLE time_table (
	id INT AUTO_INCREMENT PRIMARY KEY,
	local_date_time_to_datetime DATETIME(6),
	instant_to_timestamp TIMESTAMP(6),
	local_date_time_to_timestamp TIMESTAMP(6),
	instant_to_datetime DATETIME(6)
);