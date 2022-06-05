package com.co.GyDAsociados.maratones.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long userId;

    @Column(name = "email", unique=true, length=100, nullable = false)
    private String email;

    @Column(name = "name", unique=true, length=100, nullable = false)
    private String name;

    @Column(name = "programming_language", unique=true, length=10, nullable = false)
    private String programmingLanguaje;

    @Column(name = "fecha_creacion", unique=true, length=10, nullable = false)
    private String fechaCreacion;

    @Column(name = "fecha_actualizacion", unique=true, length=10, nullable = false)
    private String fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
}
