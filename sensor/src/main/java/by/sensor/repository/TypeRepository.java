package by.sensor.repository;

import by.sensor.moedelapp.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TypeRepository  extends JpaRepository<Type, Long> {
    List<Type> findAll();
}
