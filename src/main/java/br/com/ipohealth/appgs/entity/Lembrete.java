package br.com.ipohealth.appgs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lembrete")
    private Long id;

    private String nm_lembrete;

    private String desc_lembrete;

    private Date data_lembrete;

    private boolean status_lembrete;
}
