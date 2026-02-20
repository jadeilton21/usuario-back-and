package com.jadeilton.usuario_back_end.business.converter;


import com.jadeilton.usuario_back_end.business.dto.EnderecoDTO;
import com.jadeilton.usuario_back_end.business.dto.TelefoneDTO;
import com.jadeilton.usuario_back_end.business.dto.UsuarioDTO;
import com.jadeilton.usuario_back_end.infrastructure.entity.Endereco;
import com.jadeilton.usuario_back_end.infrastructure.entity.Telefone;
import com.jadeilton.usuario_back_end.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {



    public Usuario paraUsuario(UsuarioDTO usuarioDTO){
        return Usuario.builder()

                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .endereco(paraLIstaEndereco(usuarioDTO.getEnderecos()))
                .telefone(paraListaTelefone(usuarioDTO.getTelefone()))


                .build();


    }


    public List<Endereco> paraLIstaEndereco(List<EnderecoDTO> enderecoDTOS){
        return enderecoDTOS.stream().map(this::paraEndereco).toList();
    }



    public Endereco paraEndereco(EnderecoDTO enderecoDTO){
        return Endereco.builder()


                .logradouro(enderecoDTO.getLogradouro())
                .cep(enderecoDTO.getCep())
                .uf(enderecoDTO.getUf())
                .cidade(enderecoDTO.getCidade())
                .bairro(enderecoDTO.getBairro())
                .complemento(enderecoDTO.getComplemento())
                .estado(enderecoDTO.getEstado())


                .build();

    }
    public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefone).toList();
    }



    public Telefone paraTelefone(TelefoneDTO telefoneDTO){
        return Telefone.builder()


                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())

                .build();
    }













    public UsuarioDTO paraUsuarioDTO(Usuario usuarioDTO){
        return UsuarioDTO.builder()

                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraLIstaEnderecoDTO(usuarioDTO.getEndereco()))
                .telefone(paraListaTelefoneDTO(usuarioDTO.getTelefone()))


                .build();


    }


    public List<EnderecoDTO> paraLIstaEnderecoDTO(List<Endereco> enderecoDTOS){
        return enderecoDTOS.stream().map(this::paraEnderecoDTO).toList();
    }



    public EnderecoDTO paraEnderecoDTO(Endereco enderecoDTO){
        return EnderecoDTO.builder()


                .logradouro(enderecoDTO.getLogradouro())
                .cep(enderecoDTO.getCep())
                .uf(enderecoDTO.getUf())
                .cidade(enderecoDTO.getCidade())
                .bairro(enderecoDTO.getBairro())
                .complemento(enderecoDTO.getComplemento())
                .estado(enderecoDTO.getEstado())


                .build();

    }
    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefoneDTO).toList();
    }



    public TelefoneDTO paraTelefoneDTO(Telefone telefoneDTO){
        return TelefoneDTO.builder()


                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())

                .build();
    }
}
