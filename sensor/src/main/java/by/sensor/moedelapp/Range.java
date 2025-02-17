package by.sensor.moedelapp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "range")
@Data
public class Range {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "range_id")
//    @JsonIgnore
    private Long range_id;

    @Min(value = 0, message = "Значение должно быть положительным")
    private Integer range_from;

    @Min(value = 0, message = "Значение должно быть положительным")
    private Integer range_to;

    public void validateRange() {
        if (range_from != null && range_to != null && range_from >= range_to) {
            throw new IllegalArgumentException("Значение 'from' должно быть меньше 'to'.");
        }
    }
}