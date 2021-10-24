package br.com.fatec.sp.tcc.orquestradormatricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrquestradorMatriculaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrquestradorMatriculaApplication.class, args);
	}

}
