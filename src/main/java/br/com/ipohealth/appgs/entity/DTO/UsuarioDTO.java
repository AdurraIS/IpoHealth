package br.com.ipohealth.appgs.entity.DTO;

import br.com.ipohealth.appgs.entity.Lembrete;
import br.com.ipohealth.appgs.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UsuarioDTO {
    public UsuarioDTO(){
    }

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nm_usuario = usuario.getNm_usuario();
        this.email_usuario = usuario.getEmail_usuario();
        this.senha_usuario = usuario.getSenha_usuario();
        this.idade_usuario = usuario.getIdade_usuario();
        this.logra_usuario = usuario.getLogra_usuario();
        this.cidade_usuario = usuario.getCidade_usuario();
        this.lembretes = usuario.getLembretes();
    }


    private Long id;

    @NotNull(message = "Nome nao pode ser nulo")
    @NotBlank(message = "Nome nao pode ser vazio")
    private String nm_usuario;

    @NotNull(message = "Email nao pode ser nulo")
    @NotBlank(message = "Email nao pode ser vazio")
    private String email_usuario;

    @NotNull(message = "Senha nao pode ser nulo")
    @NotBlank(message = "Senha nao pode ser vazio")
    private String senha_usuario;

    private int idade_usuario;

    @NotNull(message = "Logradouro nao pode ser nulo")
    @NotBlank(message = "Logradouro nao pode ser vazio")
    private String logra_usuario;

    @NotNull(message = "Cidade nao pode ser nulo")
    @NotBlank(message = "Cidade nao pode ser vazio")
    private String cidade_usuario;

    List<Lembrete> lembretes;
}
