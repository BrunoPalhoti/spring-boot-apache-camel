package com.brq.camel.models;

public class UsuarioModel {
	private int 	   id;
	private String 	   name;
	private String 	   email;
	private static int geradorId = 0;
	
	public UsuarioModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioModel(String nome, String email) {
		super();
		this.id 	= geradorId++;
		this.name 	= nome;
		this.email 	= email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
