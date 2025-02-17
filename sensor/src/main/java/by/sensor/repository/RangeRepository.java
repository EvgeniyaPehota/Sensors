package by.sensor.repository;

import by.sensor.moedelapp.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RangeRepository  extends JpaRepository<Range, Long> {
}
