package by.sensor.service;

import by.sensor.moedelapp.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.sensor.repository.ModelRepository;

import java.util.List;

@Service
public class ModelService {

    private final ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }


    public Model getModelById(Long id) {
        return modelRepository.findById(id).orElse(null);
    }


    public Model createModel(Model model) {
        return modelRepository.save(model);
    }


    public Model updateModel(Model model) {
        return modelRepository.save(model);
    }


    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }
}
