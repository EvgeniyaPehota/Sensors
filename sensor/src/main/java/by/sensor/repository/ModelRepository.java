package by.sensor.repository;

import by.sensor.moedelapp.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository  extends JpaRepository<Model, Long> {
}
