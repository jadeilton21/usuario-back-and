package com.jadeilton.usuario_back_end.business;


import com.jadeilton.usuario_back_end.business.converter.UsuarioConverter;
import com.jadeilton.usuario_back_end.business.dto.UsuarioDTO;
import com.jadeilton.usuario_back_end.infrastructure.entity.Usuario;
import com.jadeilton.usuario_back_end.infrastructure.exceptions.ConflictException;
import com.jadeilton.usuario_back_end.infrastructure.exceptions.ResourceNotFoundException;
import com.jadeilton.usuario_back_end.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;


    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        emailExiste(usuarioDTO.getEmail());
        usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(
                usuarioRepository.save(usuario)
        );
    }



    public void emailExiste(String email) {

        try {
            boolean existe = verificaEmailExistente(email);
            if (existe) {
                throw new ConflictException("Email já Cadastrado" + email);
            }
        } catch (ConflictException e) {
            throw new ConflictException("Esse email já existe", e.getCause());
        }
    }


    public boolean verificaEmailExistente(String email) {
        return usuarioRepository.existsByEmail(email);
    }
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email não encontrado" + email)
        );
    }



    public void deletarEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }

}
