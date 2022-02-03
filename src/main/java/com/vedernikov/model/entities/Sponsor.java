package com.vedernikov.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sponsor")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "start_of_contract")
    private String startOfContract;
    @Column(name = "end_of_contract")
    private String endOfContract;

    public Sponsor(Integer id, String name, String startOfContract, String endOfContract) {
        this.id = id;
        this.name = name;
        this.startOfContract = startOfContract;
        this.endOfContract = endOfContract;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startOfContract='" + startOfContract + '\'' +
                ", endOfContract='" + endOfContract + '\'' +
                '}';
    }
}
