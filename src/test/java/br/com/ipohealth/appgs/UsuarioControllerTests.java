package br.com.ipohealth.appgs;

import br.com.ipohealth.appgs.controller.UsuarioController;
import br.com.ipohealth.appgs.entity.DTO.UsuarioDTO;
import br.com.ipohealth.appgs.entity.Usuario;
import br.com.ipohealth.appgs.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UsuarioControllerTests {

    Usuario usuario = new Usuario("giva", "gio@gio.com","1234",19,"giva rua","cidade giovanni");
    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @Test
    void testGetAllusuarios() {
        MockitoAnnotations.initMocks(this);

        int pageSize = 10;
        int pageNumber = 1;



        when(usuarioService.findAll(PageRequest.of(pageNumber, pageSize)))
                .thenReturn(Collections.singletonList(new UsuarioDTO(usuario)));

        ResponseEntity<List<UsuarioDTO>> responseEntity = usuarioController.getAllusuarios(pageSize, pageNumber);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(1, responseEntity.getBody().size());
    }
    @Test
    void testGetusuarioById() {
        MockitoAnnotations.initMocks(this);

        Long userId = 1L;

        when(usuarioService.findById(userId))
                .thenReturn(Optional.of(new UsuarioDTO(usuario)));

        ResponseEntity<UsuarioDTO> responseEntity = usuarioController.getusuarioById(userId);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void testGetusuarioByIdNotFound() {
        MockitoAnnotations.initMocks(this);

        Long userId = 2L;

        when(usuarioService.findById(userId)).thenReturn(Optional.empty());

        ResponseEntity<UsuarioDTO> responseEntity = usuarioController.getusuarioById(userId);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
    @Test
    void testCreateusuario() {
        MockitoAnnotations.initMocks(this);

        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);

        when(usuarioService.createusuario(usuarioDTO)).thenReturn(usuarioDTO);

        ResponseEntity<UsuarioDTO> responseEntity = usuarioController.createusuario(usuarioDTO);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }
}

