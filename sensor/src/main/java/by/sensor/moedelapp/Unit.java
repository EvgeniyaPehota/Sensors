package by.sensor.moedelapp;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "unit")
@Getter
@Setter
public class Unit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private Long unit_id;

    private String unit_name;


}
