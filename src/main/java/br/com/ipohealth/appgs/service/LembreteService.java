package br.com.ipohealth.appgs.service;

import br.com.ipohealth.appgs.entity.DTO.LembreteDTO;
import br.com.ipohealth.appgs.entity.Lembrete;
import br.com.ipohealth.appgs.entity.Usuario;
import br.com.ipohealth.appgs.repository.LembreteRepository;
import br.com.ipohealth.appgs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LembreteService {

    private final LembreteRepository lembreteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public LembreteService(@Autowired LembreteRepository lembreteRepository){
        this.lembreteRepository = lembreteRepository;
    }

    public List<LembreteDTO> findAll(Pageable pageable) {
        return lembreteRepository.findAll(pageable).getContent().stream().map(LembreteDTO::new).toList();
    }

    public Optional<LembreteDTO> findById(Long id) {
        return lembreteRepository.findById(id).map(LembreteDTO::new);
    }

    public LembreteDTO createlembrete(LembreteDTO lembreteDTO){
        Lembrete lembrete = new Lembrete();
        Usuario usuario = usuarioRepository.findById(lembreteDTO.getUsuario_id()).orElseThrow(() ->
                new NoSuchElementException("Usuario não encontrado com ID: " + lembreteDTO.getUsuario_id()));

        List<Lembrete> lembretes = usuario.getLembretes();

        lembrete.setId(lembreteDTO.getId());
        lembrete.setNm_lembrete(lembreteDTO.getNm_lembrete());
        lembrete.setDesc_lembrete(lembreteDTO.getDesc_lembrete());
        lembrete.setData_lembrete(lembreteDTO.getData_lembrete());
        lembrete.setStatus_lembrete(lembreteDTO.isStatus_lembrete());
        lembrete.setUsuario(usuario);
        lembretes.add(lembrete);
        usuario.setLembretes(lembretes);
        usuarioRepository.save(usuario);
        lembreteRepository.save(lembrete);


        return new LembreteDTO(lembrete);

    }
    public void deletelembrete(Long id){
        lembreteRepository.deleteById(id);
    }

    public LembreteDTO atualizarlembrete(LembreteDTO lembreteDTO, Long id) {
        Lembrete lembrete = lembreteRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("lembrete não encontrado com ID: " + lembreteDTO.getId()));

        lembrete.setId(lembreteDTO.getId());
        lembrete.setNm_lembrete(lembreteDTO.getNm_lembrete());
        lembrete.setDesc_lembrete(lembreteDTO.getDesc_lembrete());
        lembrete.setData_lembrete(lembreteDTO.getData_lembrete());
        lembrete.setStatus_lembrete(lembreteDTO.isStatus_lembrete());
        lembreteRepository.save(lembrete);

        return new LembreteDTO(lembrete);
    }
}