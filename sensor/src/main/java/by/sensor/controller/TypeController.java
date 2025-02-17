package by.sensor.controller;

import by.sensor.moedelapp.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import by.sensor.service.TypeService;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {


    private final TypeService typeService;


    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }


    @GetMapping
    public List<Type> getAllTypes() {
        return typeService.getAllTypes();
    }


    @GetMapping("/{id}")
    public Type getTypeById(@PathVariable Long id) {
        return typeService.getTypeById(id);
    }


    @PostMapping
    public Type createType(@RequestBody Type type) {
        return typeService.createType(type);
    }


    @PutMapping("/{id}")
    public Type updateType(@PathVariable Long id, @RequestBody Type type) {
        type.setType_id(id);
        return typeService.updateType(type);
    }


    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable Long id) {
        typeService.deleteType(id);
    }
}
