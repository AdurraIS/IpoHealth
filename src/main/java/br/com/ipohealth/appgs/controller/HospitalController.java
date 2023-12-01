package br.com.ipohealth.appgs.controller;

import br.com.ipohealth.appgs.entity.DTO.HospitalDTO;
import br.com.ipohealth.appgs.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(@Autowired HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping
    public ResponseEntity<List<HospitalDTO>> getAllhospitals(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return ResponseEntity.ok().body(hospitalService.findAll(PageRequest.of(pageNumber, pageSize)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<HospitalDTO> gethospitalById(@PathVariable Long id) {
        Optional<HospitalDTO> hospitalDTO = hospitalService.findById(id);

        if (hospitalDTO.isPresent()) {
            return ResponseEntity.ok().body(hospitalDTO.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<HospitalDTO> createhospital(@RequestBody HospitalDTO hospitalDTO) {
        return ResponseEntity.ok(hospitalService.createhospital(hospitalDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletehospitalById(@PathVariable Long id){
        hospitalService.deletehospital(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<HospitalDTO> updatehospital(@RequestBody HospitalDTO hospitalDTO, @PathVariable Long id){
        return ResponseEntity.ok(hospitalService.atualizarhospital(hospitalDTO, id));
    }
}
