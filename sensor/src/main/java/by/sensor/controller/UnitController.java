package by.sensor.controller;

import by.sensor.moedelapp.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import by.sensor.service.UnitService;

import java.util.List;

@RestController
@RequestMapping("/unit")
public class UnitController {


    private final UnitService unitService;


    @Autowired
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }


    @GetMapping
    public List<Unit> getAllUnits() {
        return unitService.getAllUnits();
    }


    @GetMapping("/{id}")
    public Unit getUnitById(@PathVariable Long id) {
        return unitService.getUnitById(id);
    }


    @PostMapping
    public Unit createUnit(@RequestBody Unit unit) {
        return unitService.createUnit(unit);
    }


    @PutMapping("/{id}")
    public Unit updateUnit(@PathVariable Long id, @RequestBody Unit unit) {
        unit.setUnit_id(id);
        return unitService.updateUnit(unit);
    }


    @DeleteMapping("/{id}")
    public void deleteUnit(@PathVariable Long id) {
        unitService.deleteUnit(id);
    }
}
