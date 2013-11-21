package br.com.estevam.soa.estoque.servicos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import br.com.estevam.soa.estoque.modelos.Autor;

@WebService
public class AutoresService {

	public List<Autor> listarAutores() {
		Autor adrianoAlmeida = new Autor("Adriano Almeida", new Date());
		Autor pauloSilveira = new Autor("Paulo Silveira", new Date());
		Autor viniciusBaggio = new Autor("Vinicius Baggio", new Date());
		return new ArrayList<>(Arrays.asList(adrianoAlmeida, pauloSilveira, viniciusBaggio));
	}

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/autores", new AutoresService());
		System.out.println("Serviço iniciado");
	}

}
