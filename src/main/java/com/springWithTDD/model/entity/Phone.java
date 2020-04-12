package com.springWithTDD.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "phone")
@NoArgsConstructor
@RequiredArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length = 2, nullable = false)
    private String ddd;

    @NonNull
    @Column(length = 9, nullable = false)
    private String number;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "id_customer")
    private Customer customer;
}
