package br.com.ipohealth.appgs.service;

import br.com.ipohealth.appgs.entity.DTO.HospitalDTO;
import br.com.ipohealth.appgs.entity.Hospital;
import br.com.ipohealth.appgs.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(@Autowired HospitalRepository hospitalRepository){
        this.hospitalRepository = hospitalRepository;
    }

    public List<HospitalDTO> findAll(Pageable pageable) {
        return hospitalRepository.findAll(pageable).getContent().stream().map(HospitalDTO::new).toList();
    }

    public Optional<HospitalDTO> findById(Long id) {
        return hospitalRepository.findById(id).map(HospitalDTO::new);
    }

    public HospitalDTO createhospital(HospitalDTO hospitalDTO){
        Hospital hospital = new Hospital();

        hospital.setId(hospitalDTO.getId());
        hospital.setNm_hospital(hospitalDTO.getNm_hospital());
        hospital.setOpen_hospital(hospitalDTO.getOpen_hospital());
        hospital.setClose_hospital(hospitalDTO.getClose_hospital());
        hospital.setLogradouro_hospital(hospitalDTO.getLogradouro_hospital());
        hospital.setCidade_hospital(hospitalDTO.getCidade_hospital());

        hospitalRepository.save(hospital);
        return new HospitalDTO(hospital);

    }
    @Scheduled(fixedRate = 60000)
    public void atualizarStatus() {
        LocalTime horarioAtual = LocalTime.now();
        System.out.println(horarioAtual);
        List<Hospital> list_hospital = hospitalRepository.findAll();
        for (Hospital hospital : list_hospital) {
            LocalTime openhospital = hospital.getOpen_hospital().toLocalTime();
            LocalTime closehospital = hospital.getClose_hospital().toLocalTime();
            if (horarioAtual.isAfter(openhospital) && horarioAtual.isBefore(closehospital)) {
                hospital.setOpen_status_hospital(true);
                System.out.println("hospital aberta");
            } else {
                hospital.setOpen_status_hospital(false);
                System.out.println("hospital fechada");
            }
            hospitalRepository.save(hospital);
        }
    }

    public void deletehospital(Long id){
        hospitalRepository.deleteById(id);
    }

    public HospitalDTO atualizarhospital(HospitalDTO hospitalDTO, Long id) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("hospital não encontrada com ID: " + hospitalDTO.getId()));

        hospital.setNm_hospital(hospitalDTO.getNm_hospital());
        hospital.setOpen_status_hospital(hospitalDTO.isOpen_status_hospital());
        hospital.setOpen_hospital(hospitalDTO.getOpen_hospital());
        hospital.setClose_hospital(hospitalDTO.getClose_hospital());
        hospital.setLogradouro_hospital(hospitalDTO.getLogradouro_hospital());
        hospital.setCidade_hospital(hospitalDTO.getCidade_hospital());
        hospitalRepository.save(hospital);

        return new HospitalDTO(hospital);
    }

}