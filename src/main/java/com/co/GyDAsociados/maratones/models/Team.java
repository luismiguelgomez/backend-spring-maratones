package com.co.GyDAsociados.maratones.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import javax.persistence.*;

@Entity
@Table(name = "Team")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", nullable = false)
    private VarcharTypeDescriptor TeamId;
    @Column(name = "team_name" , nullable = false)
    private String TeamName;
    @Column(name = "size", nullable = false)
    private int Size;
    @Column(name = "team_password", nullable = false)
    private String TeamPassword;

}
