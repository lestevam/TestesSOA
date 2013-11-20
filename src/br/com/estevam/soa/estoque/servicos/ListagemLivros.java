package br.com.estevam.soa.estoque.servicos;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.estevam.soa.estoque.daos.LivroDAO;
import br.com.estevam.soa.estoque.modelos.Livro;

@WebService
public class ListagemLivros {
	
	@WebResult(name="livro")
	public List<Livro> listarLivros(){
		LivroDAO livroDAO = obterDAO();
		return livroDAO.listarLivros();
	}
	
	@RequestWrapper(className="br.com.estevam.estoque.servicos.jaxws.ListarLivrosPaginacao", localName="listarLivrosPaginacao")
	@ResponseWrapper(className="br.com.estevam.estoque.servicos.jaxws.ListarLivrosPaginacaoResponse", localName="listarLivrosPaginacaoResponse")
	@WebResult(name="livro")
	@WebMethod(operationName="listarLivrosPaginacao")
	public List<Livro> listarLivros(Integer numeroDaPagina, Integer tamanhoDaPagina)
	{
		LivroDAO livroDAO = obterDAO();
		return livroDAO.listarLivros(numeroDaPagina, tamanhoDaPagina);
	}

	
	private LivroDAO obterDAO(){
		return new LivroDAO();
	}
	
	public static void main(String[] args){
		Endpoint.publish("http://localhost:8080/livros", new ListagemLivros());
		System.out.println("Serviço inializado!");
		
	}

}
