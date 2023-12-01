package br.com.ipohealth.appgs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_lembrete;

    private boolean status_lembrete;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
