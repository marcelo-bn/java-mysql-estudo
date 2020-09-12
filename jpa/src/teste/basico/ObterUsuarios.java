package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import modelo.basico.Usuario;

public class ObterUsuarios {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("estudo-jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		query.setMaxResults(3);
		
		
		List<Usuario> usuarios = query.getResultList();
		
		for(Usuario u : usuarios) {
			System.out.println("ID: " + u.getId() + ", Nome: " + u.getNome());
		}
		
		em.close();
		emf.close();
	}
}
