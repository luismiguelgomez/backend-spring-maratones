package com.co.GyDAsociados.maratones.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "team")
@Getter
@Setter
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", nullable = false)
    private Long userId;

    @Column(name = "team_name", unique=true, length=100, nullable = false)
    private String email;

    @Column(name = "team_password", unique=true, length=20, nullable = false)
    private String teamPassword;

    public Team(Long userId) {
        super();
        this.userId = userId;
    }

    public Team() {}

    public Team(Long userId, String email, String teamPassword) {
        this.userId = userId;
        this.email = email;
        this.teamPassword = teamPassword;
    }
}