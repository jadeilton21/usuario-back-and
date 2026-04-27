package com.jadeilton.usuario_back_end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UsuarioBackEndApplication {







	public static void main(String[] args) {



		SpringApplication.run(UsuarioBackEndApplication.class, args);
	}

}
