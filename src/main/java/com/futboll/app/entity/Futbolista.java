package com.futboll.app.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "futbolista")
public class Futbolista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_futbolista")
    private Long idFutbolista;
    private String nombres;
    private String apellidos;

    @Temporal(TemporalType.DATE)
    private Date fechaNacido;
    private String Caracteristicas;

    @ManyToOne
    @JoinColumn(name = "id_posicion")
    private Posicion posicion;
}
