package by.sensor.service;

import by.sensor.moedelapp.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.sensor.repository.UnitRepository;

import java.util.List;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    @Autowired
    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }


    public Unit getUnitById(Long id) {
        return unitRepository.findById(id).orElse(null);
    }


    public Unit createUnit(Unit unit) {
        return unitRepository.save(unit);
    }


    public Unit updateUnit(Unit unit) {
        return unitRepository.save(unit);
    }


    public void deleteUnit(Long id) {
        unitRepository.deleteById(id);
    }
}
