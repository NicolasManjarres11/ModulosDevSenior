CREATE TABLE SENSOR_DATA (
    ID SERIAL PRIMARY KEY,
    sensor_name VARCHAR(255),
    temperature DOUBLE,
    timestamp TIMESTAMP
);