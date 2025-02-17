package by.sensor.controller;

import by.sensor.moedelapp.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import by.sensor.service.ModelService;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {


    private final ModelService modelService;


    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }


    @GetMapping
    public List<Model> getAllModels() {
        return modelService.getAllModels();
    }


    @GetMapping("/{id}")
    public Model getModelById(@PathVariable Long id) {
        return modelService.getModelById(id);
    }


    @PostMapping
    public Model createModel(@RequestBody Model model) {
        return modelService.createModel(model);
    }


    @PutMapping("/{id}")
    public Model updateModel(@PathVariable Long id, @RequestBody Model model) {
        model.setModel_id(id);
        return modelService.updateModel(model);
    }


    @DeleteMapping("/{id}")
    public void deleteModel(@PathVariable Long id) {
        modelService.deleteModel(id);
    }
}