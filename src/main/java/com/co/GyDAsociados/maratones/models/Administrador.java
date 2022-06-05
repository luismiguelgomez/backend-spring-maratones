package com.co.GyDAsociados.maratones.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "administrador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Administrador {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id", nullable = false)
    private Long adminId;

    @Column(name = "email", unique=true, length=100, nullable = false)
    private String email;

    @Column(name = "name", unique=true, length=100, nullable = false)
    private String name;

    @Column(name = "admin_password", unique=true, length=20, nullable = false)
    private String adminPassword;
}
