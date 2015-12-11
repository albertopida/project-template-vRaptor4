package br.com.caelum.vraptor.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.util.JPAUtil;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4229172530055003816L;
	//
	private final Result result;

	@Inject
	public ProdutoController(Result result) {
		this.result = result;
	}

	public ProdutoController() {
		this(null);
	}

	@Path("/")
	public void inicio() {
		System.out.println("Produto Controller início");
	}

	@Path("/produto/sobre")
	public void sobre() {
	}

	@Path("/produto/formulario")
	public void formulario() {

	}

	@Get("/produto/lista")
	public List<Produto> lista() {
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		
//		  result.include("produtoList", dao.lista());
		return dao.lista();
	}

	@Post("/produto/adiciona")
	public void adiciona(Produto produto) {
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();
		ProdutoDao dao = new ProdutoDao(em);
		dao.adiciona(produto);
		em.getTransaction().commit();

		result.include("mensagem", "Produto adicionado com sucesso!");

		result.redirectTo(this).lista();
	}

	@Path("/produto/remove")  
	public void remove(Produto produto) {
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();
		ProdutoDao dao = new ProdutoDao(em);
		dao.remove(produto);
		em.getTransaction().commit();

		//result.include("mensagem", "objeto excluido com sucesso");
		
		//result.redirectTo(this.lista());
	}
	
	@Get
	public void listaEmJson(){
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		result.use(Results.json()).from(dao.lista()).serialize();
	}
}