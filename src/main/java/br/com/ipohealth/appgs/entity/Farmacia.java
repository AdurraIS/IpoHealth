package br.com.ipohealth.appgs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Entity
@Data
public class Farmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_farmacia")
    private Long id;

    private String nm_farmacia;

    private boolean open_status_farmacia;

    private Time open_farmacia;

    private Time close_farmacia;

    private String logradouro_farmacia;

    private String cidade_farmacia;
}
