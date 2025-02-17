package by.sensor.moedelapp.dto;

import by.sensor.moedelapp.Range;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorsDto {

    private String name;
    private String model;
    private Range range;
    private String type;
    private String unit;
    private String location;

    private String sensor_description;


}
