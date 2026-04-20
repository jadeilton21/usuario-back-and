package com.jadeilton.usuario_back_end.controller;


import com.jadeilton.usuario_back_end.business.UsuarioService;
import com.jadeilton.usuario_back_end.business.dto.EnderecoDTO;
import com.jadeilton.usuario_back_end.business.dto.TelefoneDTO;
import com.jadeilton.usuario_back_end.business.dto.UsuarioDTO;
import com.jadeilton.usuario_back_end.infrastructure.security.JwtUtil;
import com.jadeilton.usuario_back_end.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor

@Tag(name = "Tarefas",description = "Cadastro Tarefas de Usuários")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class UsuarioController {


    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
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
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorEmail(@RequestParam("email") String email) {

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
    public ResponseEntity<EnderecoDTO> atualizaEndereco(@RequestBody EnderecoDTO dto,
                                                        @RequestParam("id") Long id) {

        return ResponseEntity.ok(usuarioService.atualizaEndereco(id, dto));



    }
    @PutMapping("/telefone")
    public ResponseEntity<TelefoneDTO> atualizaTelefone(@RequestBody TelefoneDTO dto,
                                                        @RequestParam("id") Long id) {

        return ResponseEntity.ok(usuarioService.atualizaTelefone(id, dto));



    }


    @PostMapping("/endereco")
    public ResponseEntity<EnderecoDTO> cadastroEndereco(@RequestBody EnderecoDTO dto, @RequestHeader ("Authorization") String token) {
        return ResponseEntity.ok(usuarioService.cadastraEndereco(token,dto));

    }

    @PostMapping("/telefone")
    public ResponseEntity<TelefoneDTO> cadastroTelefone(@RequestBody TelefoneDTO dto, @RequestHeader("Authorization") String token) {



        return ResponseEntity.ok(usuarioService.cadastraTelefone(token,dto));
    }

}

