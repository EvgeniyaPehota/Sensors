package by.sensor.moedelapp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "type")
@Getter
@Setter
public class Type {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long type_id;

    private String type_name;


}
