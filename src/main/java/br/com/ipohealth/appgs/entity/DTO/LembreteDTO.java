package br.com.ipohealth.appgs.entity.DTO;

import br.com.ipohealth.appgs.entity.Lembrete;
import br.com.ipohealth.appgs.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;

@Data
public class LembreteDTO {

    public LembreteDTO(){
    }

    public LembreteDTO(Lembrete lembrete){
        this.id = lembrete.getId();
        this.nm_lembrete = lembrete.getNm_lembrete();
        this.desc_lembrete = lembrete.getDesc_lembrete();
        this.data_lembrete = lembrete.getData_lembrete();
        this.status_lembrete = lembrete.isStatus_lembrete();
        this.usuario_id = lembrete.getUsuario() != null ? lembrete.getUsuario().getId() : null;
    }
    private Long id;

    @NotNull(message = "Nome nao pode ser nulo")
    @NotBlank(message = "Nome nao pode ser vazio")
    private String nm_lembrete;


    private String desc_lembrete;

    @NotNull(message = "Data nao pode ser nulo")
    @NotBlank(message = "Data nao pode ser vazio")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date data_lembrete;

    private boolean status_lembrete;

    private Long usuario_id;
    
}
