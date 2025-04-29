package com.agibank.hackathon.ems;

import com.agibank.hackathon.ems.controller.request.funcionario.ListarFuncionariosPendentesRequest;
import com.agibank.hackathon.ems.entity.Funcionario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.agibank.hackathon.ems.repository.FuncionarioRepository;
import java.util.List;

@SpringBootApplication
public class EmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

}
