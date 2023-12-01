package br.com.ipohealth.appgs.controller;

import br.com.ipohealth.appgs.entity.DTO.LembreteDTO;
import br.com.ipohealth.appgs.service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lembrete")
public class LembreteController {

    private final LembreteService lembreteService;

    public LembreteController(@Autowired LembreteService lembreteService) {
        this.lembreteService = lembreteService;
    }

    @GetMapping
    public ResponseEntity<List<LembreteDTO>> getAlllembretes(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return ResponseEntity.ok().body(lembreteService.findAll(PageRequest.of(pageNumber, pageSize)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LembreteDTO> getlembreteById(@PathVariable Long id) {
        Optional<LembreteDTO> lembreteDTO = lembreteService.findById(id);

        if (lembreteDTO.isPresent()) {
            return ResponseEntity.ok().body(lembreteDTO.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<LembreteDTO> createlembrete(@RequestBody LembreteDTO lembreteDTO) {
        return ResponseEntity.ok(lembreteService.createlembrete(lembreteDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletelembreteById(@PathVariable Long id){
        lembreteService.deletelembrete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<LembreteDTO> updatelembrete(@RequestBody LembreteDTO lembreteDTO, @PathVariable Long id){
        return ResponseEntity.ok(lembreteService.atualizarlembrete(lembreteDTO, id));
    }
}