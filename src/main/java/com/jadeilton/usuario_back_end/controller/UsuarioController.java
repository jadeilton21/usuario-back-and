package com.jadeilton.usuario_back_end.controller;



import com.jadeilton.usuario_back_end.business.UsuarioService;
import com.jadeilton.usuario_back_end.business.dto.EnderecoDTO;
import com.jadeilton.usuario_back_end.business.dto.TelefoneDTO;
import com.jadeilton.usuario_back_end.business.dto.UsuarioDTO;
frastructure.exceptions.ResourceNotFoundException;

import com.jadeilton.usuario_back_end.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {




    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    @PostMapping
    public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioDTO usuarioDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getSenha())
        );
        return "Bearer: " + jwtUtil.generateToken(authentication.getName());

    }
    @GetMapping


        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));

    }
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable String email) {
        usuarioService.deletarEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizaDadosUsuario(@RequestBody UsuarioDTO dto,
                                                           @RequestHeader("Authorization") String token) {

        return ResponseEntity.ok(usuarioService.atualizaDadosUsuari(token, dto));
    }


    @PutMapping("/endereco")
    public ResponseEntity<EnderecoDTO> atualizarEndereco(@RequestBody EnderecoDTO dto, @RequestParam("id") Long id){

        return ResponseEntity.ok(usuarioService.atualizaEndereco(id, dto));

    }



    @PutMapping("/telefone")
    public ResponseEntity<TelefoneDTO> atualizarTelefone(@RequestBody TelefoneDTO dto, @RequestParam("id") Long id){

        return ResponseEntity.ok(usuarioService.atualizaTelefone(id, dto));

    }

}
