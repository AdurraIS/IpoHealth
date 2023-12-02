package br.com.ipohealth.appgs.service;

import br.com.ipohealth.appgs.entity.DTO.UsuarioDTO;
import br.com.ipohealth.appgs.entity.Lembrete;
import br.com.ipohealth.appgs.entity.Usuario;
import br.com.ipohealth.appgs.repository.LembreteRepository;
import br.com.ipohealth.appgs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    private LembreteRepository lembreteRepository;
    public UsuarioService(@Autowired UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable).getContent().stream().map(UsuarioDTO::new).toList();
    }

    public UsuarioDTO findByEmail(String email){
        Usuario usuario = usuarioRepository.findByEmailUsuario(email).orElseThrow(() ->
                new NoSuchElementException("usuario não encontrado com email: " + email));
        return new UsuarioDTO(usuario);
    }

    public Optional<UsuarioDTO> findById(Long id) {
        return usuarioRepository.findById(id).map(UsuarioDTO::new);
    }

    public UsuarioDTO createusuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();

        usuario.setId(usuarioDTO.getId());
        usuario.setNmusuario(usuarioDTO.getNmusuario());
        usuario.setEmailUsuario(usuarioDTO.getEmail_usuario());
        usuario.setSenha_usuario(usuarioDTO.getSenha_usuario());
        usuario.setIdade_usuario(usuarioDTO.getIdade_usuario());
        usuario.setLogra_usuario(usuarioDTO.getLogra_usuario());
        usuario.setCidade_usuario(usuarioDTO.getCidade_usuario());

        usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);

    }
    public void deleteusuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO atualizarusuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(usuarioDTO.getId()).orElseThrow(() ->
                new NoSuchElementException("usuario não encontrado com ID: " + usuarioDTO.getId()));

        usuario.setId(usuarioDTO.getId());
        usuario.setNmusuario(usuarioDTO.getNmusuario());
        usuario.setEmailUsuario(usuarioDTO.getEmail_usuario());
        usuario.setSenha_usuario(usuarioDTO.getSenha_usuario());
        usuario.setIdade_usuario(usuarioDTO.getIdade_usuario());
        usuario.setLogra_usuario(usuarioDTO.getLogra_usuario());
        usuario.setCidade_usuario(usuarioDTO.getCidade_usuario());
        usuarioRepository.save(usuario);

        return new UsuarioDTO(usuario);
    }
}
