package by.sensor;

import by.sensor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SensorApplication {

	private final LocationService locationService;
	private final ModelService modelService;
	private final RangeService rangeService;
	private final SensorsService sensorsService;
	private final UnitService unitService;

	@Autowired
	public SensorApplication(LocationService locationService, ModelService modelService, RangeService rangeService,
				SensorsService sensorsService, UnitService unitService) {
		this.locationService = locationService;
		this.modelService = modelService;
		this.rangeService = rangeService;
		this.sensorsService = sensorsService;
		this.unitService = unitService;
	}

    public static void main(String[] args) {
		SpringApplication.run(SensorApplication.class, args);
	}

}
