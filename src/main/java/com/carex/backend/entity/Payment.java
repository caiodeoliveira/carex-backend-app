package com.carex.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PAYMENTS")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
