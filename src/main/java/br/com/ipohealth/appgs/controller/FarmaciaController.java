package br.com.ipohealth.appgs.controller;

import br.com.ipohealth.appgs.entity.DTO.FarmaciaDTO;
import br.com.ipohealth.appgs.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaController {

    private final FarmaciaService farmaciaService;

    public FarmaciaController(@Autowired FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    @GetMapping
    public ResponseEntity<List<FarmaciaDTO>> getAllFarmacias(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return ResponseEntity.ok().body(farmaciaService.findAll(PageRequest.of(pageNumber, pageSize)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<FarmaciaDTO> getFarmaciaById(@PathVariable Long id) {
        Optional<FarmaciaDTO> farmaciaDTO = farmaciaService.findById(id);

        if (farmaciaDTO.isPresent()) {
            return ResponseEntity.ok().body(farmaciaDTO.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<FarmaciaDTO> createFarmacia(@RequestBody FarmaciaDTO farmaciaDTO) {
        return ResponseEntity.ok(farmaciaService.createFarmacia(farmaciaDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmaciaById(@PathVariable Long id){
        farmaciaService.deleteFarmacia(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<FarmaciaDTO> updateFarmacia(@RequestBody FarmaciaDTO farmaciaDTO, @PathVariable Long id){
        return ResponseEntity.ok(farmaciaService.atualizarFarmacia(farmaciaDTO, id));
    }
}
