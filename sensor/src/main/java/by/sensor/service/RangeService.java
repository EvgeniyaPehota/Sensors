package by.sensor.service;

import by.sensor.moedelapp.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.sensor.repository.RangeRepository;

import java.util.List;

@Service
public class RangeService {

    private final RangeRepository rangeRepository;

    @Autowired
    public RangeService(RangeRepository rangeRepository) {
        this.rangeRepository = rangeRepository;
    }

    public List<Range> getAllRanges() {
        return rangeRepository.findAll();
    }


    public Range getRangeById(Long id) {
        return rangeRepository.findById(id).orElse(null);
    }


    public Range createRange(Range range) {
        return rangeRepository.save(range);
    }


    public Range updateRange(Range range) {
        return rangeRepository.save(range);
    }


    public void deleteRange(Long id) {
        rangeRepository.deleteById(id);
    }
}
