package br.com.estevam.soa.estoque.modelos;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.estevam.soa.estoque.adaptadores.AdaptadorAutores;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(EBook.class)
public class Livro {
	
	public Livro(){}
	
	public Livro(Integer anoDePublicacao, List<Autor> autores, String editora, String nome, String resumo){
		super();
		this.anoDePublicacao = anoDePublicacao;
		this.autores = autores;
		this.editora = editora;
		this.nome = nome;
		this.resumo = resumo;
	}
	
	private Date dataDeCriacao = new Date();
	private String nome;
	@XmlElementWrapper(name="autores")
	@XmlElement(name="autor")
	@XmlJavaTypeAdapter(value = AdaptadorAutores.class)
	private List<Autor> autores;
	private String editora;
	private Integer anoDePublicacao;
	private String resumo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public Integer getAnoDePublicacao() {
		return anoDePublicacao;
	}
	public void setAnoDePublicacao(Integer anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}
	
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

}
