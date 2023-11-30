package br.com.ipohealth.appgs.service;

import br.com.ipohealth.appgs.entity.DTO.FarmaciaDTO;
import br.com.ipohealth.appgs.entity.Farmacia;
import br.com.ipohealth.appgs.repository.FarmaciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FarmaciaService {

    private final FarmaciaRepository farmaciaRepository;

    public FarmaciaService(@Autowired FarmaciaRepository farmaciaRepository){
        this.farmaciaRepository = farmaciaRepository;
    }

    public List<FarmaciaDTO> findAll(Pageable pageable) {
        return farmaciaRepository.findAll(pageable).getContent().stream().map(FarmaciaDTO::new).toList();
    }

    public Optional<FarmaciaDTO> findById(Long id) {
        return farmaciaRepository.findById(id).map(FarmaciaDTO::new);
    }

    public FarmaciaDTO createFarmacia(FarmaciaDTO farmaciaDTO){
        Farmacia farmacia = new Farmacia();

        farmacia.setId(farmaciaDTO.getId());
        farmacia.setNm_farmacia(farmaciaDTO.getNm_farmacia());
        farmacia.setOpen_farmacia(farmaciaDTO.getOpen_farmacia());
        farmacia.setClose_farmacia(farmaciaDTO.getClose_farmacia());
        farmacia.setLogradouro_farmacia(farmaciaDTO.getLogradouro_farmacia());
        farmacia.setCidade_farmacia(farmaciaDTO.getCidade_farmacia());

        farmaciaRepository.save(farmacia);
        return new FarmaciaDTO(farmacia);

    }
    @Scheduled(fixedRate = 60000)
    public void atualizarStatus() {
        Time horarioAtual = new Time(System.currentTimeMillis());

        List<Farmacia> list_farmacia = farmaciaRepository.findAll();
        for (Farmacia farmacia : list_farmacia) {

            if (horarioAtual.after(farmacia.getOpen_farmacia()) && horarioAtual.before(farmacia.getClose_farmacia())) {
                farmacia.setOpen_status_farmacia(true);
            } else {
                farmacia.setOpen_status_farmacia(false);
            }
            farmaciaRepository.save(farmacia);
        }
    }

    public void deleteFarmacia(Long id){
        farmaciaRepository.deleteById(id);
    }

    public FarmaciaDTO atualizarFarmacia(FarmaciaDTO farmaciaDTO, Long id) {
        Farmacia f = farmaciaRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Farmacia não encontrada com ID: " + farmaciaDTO.getId()));

        f.setNm_farmacia(farmaciaDTO.getNm_farmacia());
        f.setOpen_status_farmacia(farmaciaDTO.isOpen_status_farmacia());
        f.setOpen_farmacia(farmaciaDTO.getOpen_farmacia());
        f.setClose_farmacia(farmaciaDTO.getClose_farmacia());
        f.setLogradouro_farmacia(farmaciaDTO.getLogradouro_farmacia());
        f.setCidade_farmacia(farmaciaDTO.getCidade_farmacia());
        farmaciaRepository.save(f);

        return new FarmaciaDTO(f);
    }

}
