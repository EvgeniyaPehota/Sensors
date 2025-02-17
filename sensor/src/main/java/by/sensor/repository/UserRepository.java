package by.sensor.repository;

import by.sensor.moedelapp.Location;
import by.sensor.moedelapp.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}