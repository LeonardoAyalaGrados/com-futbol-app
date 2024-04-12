package com.futboll.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "posicion")
public class Posicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_posicion")
    private Long idPosicion;
    @Enumerated(EnumType.STRING)
    private Nombre nombre;

    public enum Nombre{
        ARQUERO,
        DEFENSA,
        MEDIOCAMPISTA,
        DELANTERO,
        EXTREMO
    }
}