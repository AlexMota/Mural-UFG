package br.ufg.inf.fabrica.mural.central.persistencia;

import javax.persistence.PersistenceException;

import br.ufg.inf.fabrica.mural.central.dominio.Dispositivo;
import br.ufg.inf.fabrica.mural.central.dominio.Usuario;

/**
 * 
 *
 */
public interface DispositivoDao {

	/**
	 * TODO: Isso é ORM, portanto deve-se salvar um Objeto.
	 * 
	 * @Override public void salvar(String identificador);
	 */

	/**
	 * Salvar o dispositivo
	 * 
	 * @param dispositivo
	 */
	public void salvar(Dispositivo dispositivo);

	/**
	 * Remover identificador associado com qualquer dispositivo dos registros
	 * 
	 * @param identificador
	 */
	public void desassociar(String identificador);

	/**
	 * Asssociar o {@link Usuario} a um identificador
	 * 
	 * @param usuario
	 * @param identificador
	 */
	public void associar(Usuario usuario, String identificador);
}
