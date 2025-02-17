package by.sensor.moedelapp;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "model")
@Getter
@Setter
public class Model {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="model_id")
    private Long model_id;

    @NotBlank(message = "Поле не должно быть пустым.")
    @Size(max = 15, message = "Длина поля не должна превышать 15 символов.")
    @Column(name = "model_name",nullable = false, length = 15)
    private String model_name;






}