package br.com.estevam.soa.estoque.modelos;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.ws.http.HTTPException;

public class Autor {

	private String nome;
	
	@XmlTransient
	private Date dataNascimento;
	
	public Autor(){
	}
	
	public Autor(String nome, Date dataNascimento){
		super();
		this.setNome(nome);
		this.setDataNascimento(dataNascimento);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@XmlElementWrapper(name="refs")
	@XmlElement(name="ref")
	public List<URL> getRefs() throws HTTPException, IOException{
		return new ArrayList<>(Arrays.asList(new URL("http://www.estevam.com.br")));
	}
}
