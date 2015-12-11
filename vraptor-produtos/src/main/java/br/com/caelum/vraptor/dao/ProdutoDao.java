package br.com.caelum.vraptor.dao;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.caelum.vraptor.model.Produto;

public class ProdutoDao {

	  final EntityManager em;

	    @Inject
	    public ProdutoDao(EntityManager em) {
	        this.em = em;
	    }

	    @Deprecated
	    ProdutoDao() {
	        this(null);
	    }

	    public void adiciona(Produto produto) {
	        em.getTransaction().begin();
	        em.persist(produto);
	        em.getTransaction().commit();
	    }

	    public void remove(Produto produto) {
	        em.getTransaction().begin();
	        em.remove(produto);
	        em.getTransaction().commit();
	    }

	    public void busca(Produto produto) {
	        em.find(Produto.class, produto.getId());
	    }

	    @SuppressWarnings("unchecked")
	    public List<Produto> lista() {
	        return em.createQuery("select p from Produto p").getResultList();
	    }
}