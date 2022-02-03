package com.vedernikov.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "main_coach")
@NoArgsConstructor

@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class MainCoach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "surname", length = 45)
    private String surname;
    @Column(name = "age")
    private Integer age;
    @Column(name="salary_for_season_in_euros")
    private Integer salary;
    @Column(name = "start_of_contract")
    private String startOfContract;
    @Column(name = "end_of_contract")
    private String endOfContract;
    @Column(name = "nationality", length = 45)
    private String nationality;

    public MainCoach(Integer id, String name, String surname, Integer age, Integer salary, String startOfContract,
                     String endOfContract, String nationality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.startOfContract = startOfContract;
        this.endOfContract = endOfContract;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "MainCoach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", startOfContract='" + startOfContract + '\'' +
                ", endOfContract='" + endOfContract + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
