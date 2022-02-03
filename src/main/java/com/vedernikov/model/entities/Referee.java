package com.vedernikov.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "referee")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Referee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Match_id")
    private Integer matchId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private Integer age;
    @Column(name = "nationality")
    private String nationality;

    public Referee(Integer id, Integer matchId, String name, String surname, Integer age, String nationality) {
        this.id = id;
        this.matchId = matchId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Referee{" +
                "id=" + id +
                ", matchId=" + matchId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
