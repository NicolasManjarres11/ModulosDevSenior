package com.devsenior.nmanja.reactive.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("SENSOR_DATA")
public class SensorData {
    
    @Id
    private Long id;


    private String sensorName;
    private Double temperature;
    private LocalDateTime timestamp;



}
