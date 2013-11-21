package br.com.estevam.soa.estoque.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import br.com.estevam.soa.estoque.modelos.Autor;

public class AdaptadorAutores extends XmlAdapter<String, Autor> {

	@Override
	public Autor unmarshal(String autor) throws Exception {
		return new Autor(autor, null);
	}

	@Override
	public String marshal(Autor autor) throws Exception {
		return autor.getNome();
	}

}
