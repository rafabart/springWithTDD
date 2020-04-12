package com.springWithTDD.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length = 80, nullable = false)
    private String name;

    @NonNull
    @Column(length = 11, nullable = false)
    private String cpf;

    @OneToMany(mappedBy = "customer")
    private List<Andress> andressList = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Phone> phoneList = new ArrayList<>();
}
