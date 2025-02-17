package by.sensor.moedelapp;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "location")
@Getter
@Setter
public class Location {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long location_id;

    @NotBlank(message = "Поле не должно быть пустым.")
    @Size(max = 15, message = "Длина поля не должна превышать 40 символов.")
    @Column(name = "location_name",nullable = false, length = 15)
    private String location_name;


}
