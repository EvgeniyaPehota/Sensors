package by.sensor.controller;

import by.sensor.moedelapp.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import by.sensor.service.RangeService;

import java.util.List;

@RestController
@RequestMapping("/range")
public class RangeController {


    private final RangeService rangeService;


    @Autowired
    public RangeController(RangeService rangeService) {
        this.rangeService = rangeService;
    }


    @GetMapping
    public List<Range> getAllRanges() {
        return rangeService.getAllRanges();
    }


    @GetMapping("/{id}")
    public Range getRangeById(@PathVariable Long id) {
        return rangeService.getRangeById(id);
    }


    @PostMapping
    public Range createRange(@RequestBody Range range) {
        return rangeService.createRange(range);
    }


    @PutMapping("/{id}")
    public Range updateRange(@PathVariable Long id, @RequestBody Range range) {
        range.setRange_id(id);
        return rangeService.updateRange(range);
    }


    @DeleteMapping("/{id}")
    public void deleteRange(@PathVariable Long id) {
        rangeService.deleteRange(id);
    }
}
