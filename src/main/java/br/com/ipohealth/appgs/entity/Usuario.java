package br.com.ipohealth.appgs.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long id;

    private String nm_usuario;

    private String email_usuario;

    private String senha_usuario;

    private int idade_usuario;

    private String logra_usuario;

    private String cidade_usuario;


}
