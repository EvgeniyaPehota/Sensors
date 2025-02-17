package by.sensor.controller;

import by.sensor.moedelapp.*;
import by.sensor.moedelapp.dto.SensorsDto;
import by.sensor.moedelapp.dto.SensorsDto2;
import by.sensor.repository.*;
import by.sensor.service.SensorsService;
import by.sensor.utils.DtoMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    @Autowired
    private SensorsRepository sensorsRepository;
    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private RangeRepository rangeRepository;

    @Autowired
    private LocationRepository locationRepository;


    @Autowired
    private TypeRepository typeRepository;


    @Autowired
    private UnitRepository unitRepository;


    @Autowired
    private SensorsService sensorsService; // Сервис для работы с датчиками

    // Примерный метод для поиска датчиков
    @GetMapping("/search")
    public List<Sensors> searchSensors(@RequestParam String query) {
        // Логика поиска по полям "name" и "model"
        return sensorsRepository.findByNameContainingOrModelContaining(query, query);

    }


    @GetMapping
    public List<SensorsDto> getAllSensorss() {
        List<Sensors> sensorsList = sensorsService.getAllSensorss();
        // Преобразуем список датчиков в список DTO
        return sensorsList.stream()
                .map(DtoMapper::toSensorsDto) // Используем метод маппера Используя Java Stream API, вы применяете
                // метод map() для преобразования каждого объекта Sensors в объект SensorsDto с помощью вашего маппера DtoMapper.
                .collect(Collectors.toList()); // Собираем в список Сбор результата: С помощью collect(Collectors.toList())
        // вы собираете все преобразованные объекты SensorsDto в новый список.
        // return sensorsService.getAllSensorss();
    }

    // Получить датчик по ID
    @GetMapping("/{id}")
    public SensorsDto getSensorsById(@PathVariable Long id) {
        Sensors sensor = sensorsService.getSensorsById(id);
        List<Sensors> sensors= new ArrayList<>();
        return DtoMapper.toSensorsDto(sensor);

    }



    @PostMapping
    public ResponseEntity<Sensors> createSensors(@RequestBody SensorsDto2 sensorsDto2) {
        Model model = modelRepository.findById(sensorsDto2.getModel_id())
                .orElseThrow(() -> new RuntimeException("Model not found"));

        Range range = rangeRepository.findById(sensorsDto2.getRange_id())
                .orElseThrow(() -> new RuntimeException("rang not found"));

        Location location = locationRepository.findById(sensorsDto2.getLocation_id())
                .orElseThrow(() -> new RuntimeException("Location not found"));

        Type type = typeRepository.findById(sensorsDto2.getType_id())
                .orElseThrow(() -> new RuntimeException("Type not found"));

        Unit unit = unitRepository.findById(sensorsDto2.getUnit_id())
                .orElseThrow(() -> new RuntimeException("Model not found"));

        // Создание экземпляра Sensors из DTO
        Sensors sensors = new Sensors(); // Убедитесь, что у вас есть конструктор по умолчанию или используйте сеттеры
        sensors.setSensor_name(sensorsDto2.getSensor_name());
        sensors.setModel(model);
        sensors.setRange(range);
        sensors.setLocation(location);
        sensors.setType(type);
        sensors.setUnit(unit);

        // Установка описания
        sensors.setSensor_description(sensorsDto2.getSensor_description());
       // sensors.setSensor_description(sensors.getSensor_description());

        Sensors savedSensor = sensorsService.createSensors(sensors);
        return ResponseEntity.ok(savedSensor);
    }

    // Обновить существующий датчик
    @PutMapping("/{id}")
    public ResponseEntity<Sensors> updateSensors(@PathVariable Long id, @RequestBody SensorsDto2 sensorDetails) {

        // Находим существующий датчик по ID
        Sensors existingSensor = sensorsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor not found"));
Model model = modelRepository.findById(sensorDetails.getModel_id())
                .orElseThrow(() -> new RuntimeException("Model not found"));

        Range range = rangeRepository.findById(sensorDetails.getRange_id())
                .orElseThrow(() -> new RuntimeException("rang not found"));

        Location location = locationRepository.findById(sensorDetails.getLocation_id())
                .orElseThrow(() -> new RuntimeException("Location not found"));

        Type type = typeRepository.findById(sensorDetails.getType_id())
                .orElseThrow(() -> new RuntimeException("Type not found"));

        Unit unit = unitRepository.findById(sensorDetails.getUnit_id())
                .orElseThrow(() -> new RuntimeException("Model not found"));

        // Создание экземпляра Sensors из DTO
//        Sensors sensors = new Sensors(); // Убедитесь, что у вас есть конструктор по умолчанию или используйте сеттеры
        existingSensor.setSensor_name(sensorDetails.getSensor_name());
        existingSensor.setModel(model);
        existingSensor.setRange(range);
        existingSensor.setLocation(location);
        existingSensor.setType(type);
        existingSensor.setUnit(unit);

        // Установка описания
        existingSensor.setSensor_description(sensorDetails.getSensor_description());
        //sensors.setSensor_description(sensors.getSensor_description());

        Sensors updatedSensors = sensorsService.updateSensors(id, existingSensor);
        return ResponseEntity.ok(updatedSensors);

//                Sensors updatedSensors2 = sensorsService.updateSensors(id, sensorDetails);
//        if (updatedSensors != null) {
//            return ResponseEntity.ok(updatedSensors);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }

    // Удалить датчик
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensors(@PathVariable Long id) {
        // Находим существующий датчик по ID
        Sensors existingSensor = sensorsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor not found"));
        // Удаляем датчик из репозитория
        sensorsRepository.delete(existingSensor);
        // Возвращаем статус 204 No Content
        return ResponseEntity.noContent().build();
    }

}




