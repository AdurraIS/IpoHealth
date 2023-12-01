package br.com.ipohealth.appgs.controller;

import br.com.ipohealth.appgs.entity.DTO.UsuarioDTO;
import br.com.ipohealth.appgs.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(@Autowired UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllusuarios(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return ResponseEntity.ok().body(usuarioService.findAll(PageRequest.of(pageNumber, pageSize)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getusuarioById(@PathVariable Long id) {
        Optional<UsuarioDTO> usuarioDTO = usuarioService.findById(id);

        if (usuarioDTO.isPresent()) {
            return ResponseEntity.ok().body(usuarioDTO.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioDTO> createusuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.createusuario(usuarioDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteusuarioById(@PathVariable Long id){
        usuarioService.deleteusuario(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateusuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Long id){
        return ResponseEntity.ok(usuarioService.atualizarusuario(usuarioDTO, id));
    }
}