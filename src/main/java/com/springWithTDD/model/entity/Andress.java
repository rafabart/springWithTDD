package com.springWithTDD.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "andress")
@NoArgsConstructor
@AllArgsConstructor
public class Andress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private Integer number;

    private  String complement;

    private String district;

    private String city;

    private String state;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "id_customer")
    private Customer customer;
}
