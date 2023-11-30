package br.com.ipohealth.appgs.entity.DTO;


import br.com.ipohealth.appgs.entity.Farmacia;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Time;

@Data
public class FarmaciaDTO {

    public FarmaciaDTO(){
    }

    public FarmaciaDTO(Farmacia farmacia){
        this.id = farmacia.getId();
        this.nm_farmacia = farmacia.getNm_farmacia();
        this.open_status_farmacia = farmacia.isOpen_status_farmacia();
        this.open_farmacia = farmacia.getOpen_farmacia();
        this.close_farmacia = farmacia.getClose_farmacia();
        this.logradouro_farmacia = farmacia.getLogradouro_farmacia();
        this.cidade_farmacia = farmacia.getCidade_farmacia();
    }

    private Long id;

    @NotNull(message = "Nome nao pode ser nulo")
    @NotBlank(message = "Nome nao pode ser vazio")
    private String nm_farmacia;


    private boolean open_status_farmacia;

    @NotNull(message = "Horaria de abertura nao pode ser nulo")
    @NotBlank(message = "Horaria de abertura nao pode ser vazio")
    private Time open_farmacia;

    @NotNull(message = "Horario de fechamento nao pode ser nulo")
    @NotBlank(message = "Horario de fechamento nao pode ser vazio")
    private Time close_farmacia;

    @NotNull(message = "Logradouro nao pode ser nulo")
    @NotBlank(message = "Logradouro nao pode ser vazio")
    private String logradouro_farmacia;

    @NotNull(message = "Cidade nao pode ser nulo")
    @NotBlank(message = "Cidade nao pode ser vazio")
    private String cidade_farmacia;

}
