package br.com.caelum.vraptor.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import br.com.caelum.vraptor.util.JPAUtil;

public class EntityManagerProducer {

	@Produces
	@RequestScoped
	public EntityManager criaEntityManager() {
		return JPAUtil.criaEntityManager();
	}
}