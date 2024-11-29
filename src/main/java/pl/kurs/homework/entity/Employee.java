package pl.kurs.homework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    @Enumerated(EnumType.STRING)
    private Position job_position;
    private Double salary;
    private Boolean fired;

    public Employee(String firstName, String lastName, Position position, Double salary) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.job_position = position;
        this.salary = salary;
        this.fired = false;
    }
}
