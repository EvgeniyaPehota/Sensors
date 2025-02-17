package by.sensor.service;

import by.sensor.moedelapp.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.sensor.repository.LocationRepository;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }


    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }


    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }


    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }


    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
