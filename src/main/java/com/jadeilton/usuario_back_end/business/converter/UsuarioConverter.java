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



    public EnderecoDTO paraEnderecoDTO(Endereco endereco){
        return EnderecoDTO.builder()

                .id(endereco.getId())
                .logradouro(endereco.getLogradouro())
                .cep(endereco.getCep())
                .uf(endereco.getUf())
                .cidade(endereco.getCidade())
                .bairro(endereco.getBairro())
                .complemento(endereco.getComplemento())
                .estado(endereco.getEstado())


                .build();

    }
    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefoneDTO).toList();
    }



    public TelefoneDTO paraTelefoneDTO(Telefone telefone){
        return TelefoneDTO.builder()

                .id(telefone.getId())
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())

                .build();
    }

    public Usuario updateUsuario(UsuarioDTO usuarioDTO, Usuario entity) {


        return Usuario.builder()

                .nome(usuarioDTO.getNome() != null ? usuarioDTO.getNome() : entity.getNome())
                .id(entity.getId())
                .senha(usuarioDTO.getSenha() != null ? usuarioDTO.getSenha() : entity.getSenha())
                .email(usuarioDTO.getEmail() != null ? usuarioDTO.getEmail() : entity.getEmail())
                .endereco(entity.getEndereco())
                .telefone(entity.getTelefone())
                .build();




    }



    public Endereco updateEndereco(EnderecoDTO dto, Endereco entity){

        return Endereco.builder()


                .id(entity.getId())
                .numero(dto.getNumero() != null ? dto.getNumero() : entity.getNumero())
                .cep(dto.getCep() != null ? dto.getCep() : entity.getCep())
                .cidade(dto.getCidade() != null ? dto.getCidade() : entity.getCidade())
                .uf(dto.getUf() != null? dto.getUf() : entity.getUf())
                .estado(dto.getEstado() != null ? dto.getEstado() : entity.getEstado())
                .logradouro(dto.getLogradouro() != null ? dto.getLogradouro() : entity.getLogradouro())
                .build();

    }
    public Telefone updateTelefone(TelefoneDTO dto, Telefone entity){
        return Telefone.builder()

                .id(entity.getId())
                .numero(dto.getNumero() != null ? dto.getNumero() : entity.getNumero())
                .ddd(dto.getDdd() != null? dto.getDdd() : entity.getDdd() )
                .build();
    }


    public Endereco paraEnderecoEntity(EnderecoDTO dto, Long idUsuario) {

        return Endereco.builder()
                .estado(dto.getEstado())
                .cep(dto.getCep())
                .logradouro(dto.getLogradouro())
                .cidade(dto.getCidade())
                .complemento(dto.getComplemento())
                .uf(dto.getUf())
                .bairro(dto.getBairro())
                .usuario_id(idUsuario)
                .build();
    }



    public Telefone paraTelefone(TelefoneDTO dto, Long idUsuario) {


        return Telefone.builder()

                .numero(dto.getNumero())
                .ddd(dto.getDdd())
                .usuario_id(idUsuario)
                .build();
    }



}
