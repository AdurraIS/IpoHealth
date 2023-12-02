package br.com.ipohealth.appgs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Controller;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long id;

    public Usuario(String nmusuario, String email_usuario, String senha_usuario, int idade_usuario, String logra_usuario, String cidade_usuario) {
        this.nmusuario = nmusuario;
        this.emailUsuario = emailUsuario;
        this.senha_usuario = senha_usuario;
        this.idade_usuario = idade_usuario;
        this.logra_usuario = logra_usuario;
        this.cidade_usuario = cidade_usuario;
    }

    private String nmusuario;

    @Column(unique = true)
    private String emailUsuario;

    private String senha_usuario;

    private int idade_usuario;

    private String logra_usuario;

    private String cidade_usuario;

    @JsonIgnore
    @OneToMany(mappedBy="usuario")
    private List<Lembrete> lembretes;

}
