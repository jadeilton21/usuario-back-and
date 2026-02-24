package com.jadeilton.usuario_back_end.business.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TelefoneDTO {


    private Long id;
    private String numero;
    private String ddd;
}
