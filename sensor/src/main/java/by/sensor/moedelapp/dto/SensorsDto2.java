package by.sensor.moedelapp.dto;

import by.sensor.moedelapp.Range;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorsDto2 {

    private String sensor_name;
    private Long model_id;
    private Long range_id;
    private Long location_id;
    private Long type_id;
    private Long unit_id;


    private String sensor_description;


}
