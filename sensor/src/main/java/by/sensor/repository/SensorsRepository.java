package by.sensor.repository;

import by.sensor.moedelapp.Sensors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SensorsRepository  extends JpaRepository<Sensors, Long> {
    List<Sensors> findByNameContainingOrModelContaining(String name, String model);
}