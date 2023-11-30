package br.com.ipohealth.appgs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_medicamento")
    private Long id;

    private String nm_medicamento;

    private BigDecimal preco_medicamento;

    private String descr_medicamento;

}
