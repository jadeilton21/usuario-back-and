package com.jadeilton.usuario_back_end.business;


import com.jadeilton.usuario_back_end.business.converter.UsuarioConverter;
import com.jadeilton.usuario_back_end.business.dto.UsuarioDTO;
import com.jadeilton.usuario_back_end.infrastructure.entity.Usuario;
import com.jadeilton.usuario_back_end.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;


    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){

        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(
                usuarioRepository.save(usuario)
        );
    }

}
