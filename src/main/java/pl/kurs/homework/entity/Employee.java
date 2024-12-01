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
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(name = "job_position")
    private Position jobPosition;
    private Double salary;
    private Boolean fired;

    public Employee(String firstName, String lastName, Position position, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobPosition = position;
        this.salary = salary;
        this.fired = false;
    }
}
