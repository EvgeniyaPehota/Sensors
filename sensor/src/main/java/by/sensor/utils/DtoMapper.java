package by.sensor.utils;

import by.sensor.moedelapp.Range;
import by.sensor.moedelapp.Sensors;
import by.sensor.moedelapp.dto.SensorsDto;

import java.util.List;

public class DtoMapper {
    public static SensorsDto toSensorsDto(Sensors sensor) {
        SensorsDto sensorsDto = new SensorsDto();
        sensorsDto.setName(sensor.getSensor_name());
        sensorsDto.setModel(sensor.getModel().getModel_name());
        sensorsDto.setRange(sensor.getRange());
        sensorsDto.setType(sensor.getType().getType_name());
        sensorsDto.setUnit(sensor.getUnit().getUnit_name());
        sensorsDto.setLocation(sensor.getLocation().getLocation_name());
        sensorsDto.setSensor_description(sensor.getSensor_description());
        return sensorsDto;
    }
}
