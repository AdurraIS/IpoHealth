package br.com.ipohealth.appgs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Entity
@Data
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_hospital")
    private Long id;

    private String nm_hospital;

    private boolean open_status_hospital;

    private Time open_hospital;

    private Time close_hospital;

    private String logradouro_hospital;

    private String cidade_hospital;

}
