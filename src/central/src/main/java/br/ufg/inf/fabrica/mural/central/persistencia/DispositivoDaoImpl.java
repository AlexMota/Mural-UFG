package br.ufg.inf.fabrica.mural.central.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufg.inf.fabrica.mural.central.dominio.Dispositivo;
import br.ufg.inf.fabrica.mural.central.dominio.Usuario;

public class DispositivoDaoImpl implements DispositivoDao {

	/**
	 * Método utilizado para obter o entity manager.
	 * 
	 * @return EntityManager
	 */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		try {
			// Obtém o factory a partir da unidade de persistência.
			factory = Persistence.createEntityManagerFactory("");
			// Cria um entity manager.
			entityManager = factory.createEntityManager();
			// Fecha o factory para liberar os recursos utilizado.
		} finally {
			factory.close();
		}
		return entityManager;
	}

	/**
	 * TODO: Isso é ORM, portanto deve-se salvar um Objeto.
	 * 
	 * @Override public void salvar(String identificador) { // TODO: Isso é ORM,
	 *           portanto deve-se salvar um Objeto. }
	 */

	@Override
	public void salvar(Dispositivo dispositivo) {
		EntityManager entityManager = getEntityManager();
		try {
			// Inicia uma transação com o banco de dados.
			entityManager.getTransaction().begin();
			// Verifica se o dispositivo ainda não está salvo no banco de dados.
			if (dispositivo.getIdentificador() == null) {
				// Salva os dados do dispositivo.
				entityManager.persist(dispositivo);
			} else {
				// Atualiza os dados do dispositivo.
				dispositivo = entityManager.merge(dispositivo);
			}
			// Finaliza a transação.
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void desassociar(String identificador) {
		EntityManager entityManager = getEntityManager();
		try {
			// Inicia uma transação com o banco de dados.
			entityManager.getTransaction().begin();
			// Consulta o dispositivo na base de dados através do seu
			// identificador.
			Dispositivo dispositivo = entityManager.find(Dispositivo.class,
					identificador);
			// Remove o dispositivo da base de dados.
			entityManager.remove(dispositivo);
			// Finaliza a transação.
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void associar(Usuario usuario, String identificador) {
		EntityManager entityManager = getEntityManager();
		Dispositivo dispositivo = null;
		try {
			// Consulta uma pessoa pelo seu ID.
			dispositivo = entityManager.find(Dispositivo.class, identificador);
			// Associa usuário ao dispositivo
			dispositivo.setUsuario(usuario);
			// Salvar dispositivo
			salvar(dispositivo);
		} finally {
			entityManager.close();
		}
	}

}
