package com.spring_boot_initializer.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class User {
	@NotBlank(message="O nome é obrigatório")
	private String nome;
	
	@Email(message="Email inválido!")
	@NotBlank(message="O email é obrigatório")
	private String email;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
