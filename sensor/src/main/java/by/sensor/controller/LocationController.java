package by.sensor.controller;

import by.sensor.moedelapp.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import by.sensor.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {


    private final LocationService locationService;


    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }


    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }


    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationService.createLocation(location);
    }


    @PutMapping("/{id}")
    public Location updateLocation(@PathVariable Long id, @RequestBody Location location) {
        location.setLocation_id(id);
        return locationService.updateLocation(location);
    }


    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }

}
