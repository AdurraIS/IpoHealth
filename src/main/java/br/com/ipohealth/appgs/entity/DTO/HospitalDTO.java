package br.com.ipohealth.appgs.entity.DTO;

import br.com.ipohealth.appgs.entity.Hospital;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Time;

@Data
public class HospitalDTO {

    public HospitalDTO(){
    }

    public HospitalDTO(Hospital hospital){
        this.id = hospital.getId();
        this.nm_hospital = hospital.getNm_hospital();
        this.open_status_hospital = hospital.isOpen_status_hospital();
        this.open_hospital = hospital.getOpen_hospital();
        this.close_hospital = hospital.getClose_hospital();
        this.logradouro_hospital = hospital.getLogradouro_hospital();
        this.cidade_hospital = hospital.getCidade_hospital();
    }

    private Long id;

    @NotNull(message = "Nome nao pode ser nulo")
    @NotBlank(message = "Nome nao pode ser vazio")
    private String nm_hospital;


    private boolean open_status_hospital;

    @NotNull(message = "Horaria de abertura nao pode ser nulo")
    @NotBlank(message = "Horaria de abertura nao pode ser vazio")
    private Time open_hospital;

    @NotNull(message = "Horario de fechamento nao pode ser nulo")
    @NotBlank(message = "Horario de fechamento nao pode ser vazio")
    private Time close_hospital;

    @NotNull(message = "Logradouro nao pode ser nulo")
    @NotBlank(message = "Logradouro nao pode ser vazio")
    private String logradouro_hospital;

    @NotNull(message = "Cidade nao pode ser nulo")
    @NotBlank(message = "Cidade nao pode ser vazio")
    private String cidade_hospital;

}
