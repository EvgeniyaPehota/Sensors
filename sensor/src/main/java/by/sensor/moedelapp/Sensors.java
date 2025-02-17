package by.sensor.moedelapp;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sensor")
@Getter
@Setter
public class Sensors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sensor_id;

    @NotBlank(message = "Поле не должно быть пустым.")
    @Size(min = 3, max = 30, message = "Длина поля должна быть от 3 до 30 символов.")
    @Column(name = "sensor_name",nullable = false, length = 30)
    private String sensor_name;


    @OneToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @OneToOne
    @JoinColumn(name = "range_id", nullable = false)
    @Embedded
    private Range range;

    @OneToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;  //делать списком

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    @Column(name = "sensor_description", nullable = false)
    private String sensor_description;


//


}