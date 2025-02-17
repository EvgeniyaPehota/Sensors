package by.sensor.service;

import by.sensor.moedelapp.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.sensor.repository.TypeRepository;

import java.util.List;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }


    public Type getTypeById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }


    public Type createType(Type type) {
        return typeRepository.save(type);
    }


    public Type updateType(Type type) {
        return typeRepository.save(type);
    }


    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
