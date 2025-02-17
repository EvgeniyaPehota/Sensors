package by.sensor.service;

import by.sensor.moedelapp.Sensors;
import by.sensor.moedelapp.dto.SensorsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.sensor.repository.SensorsRepository;

import java.util.List;

@Service
public class SensorsService {

    private final SensorsRepository sensorsRepository;

    public List<Sensors> searchSensors(String searchTerm) {
        return sensorsRepository.findByNameContainingOrModelContaining(searchTerm, searchTerm);
    }
    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

//    public List<Sensors> searchSensors(String searchTerm) {
//        return sensorsRepository.findByNameContainingOrModelContaining(searchTerm, searchTerm);
//    }

    public List<Sensors> getAllSensorss() {
        return sensorsRepository.findAll();
    }


    public Sensors getSensorsById(Long id) {
        return sensorsRepository.findById(id).orElse(null);
    }


    public Sensors createSensors(Sensors sensors) {
        return sensorsRepository.save(sensors);
    }


    public Sensors updateSensors(Long id, Sensors sensors) {
        return sensorsRepository.save(sensors);
    }


    public void deleteSensors(Long id) {
        sensorsRepository.deleteById(id);
    }
}
