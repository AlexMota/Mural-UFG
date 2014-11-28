package br.ufg.inf.fabrica.mural.central.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 
 *
 */
@Entity
@Table(name = "DISPOSITIVO")
public class Dispositivo {

	/**
	 * TODO: identificadorGCM -> fora de escopo, pois o (GCM) denota a
	 * utilização da plataforma do Google, e caso o sistema migre para o da
	 * Amazon, outra plataforma o nome gera contradição.
	 */
	@Id
	@Column(nullable = false, name = "identificador_gcm")
	private String identificador;

	@Column(nullable = true, name = "usuario")
	private Usuario usuario;

	@Column(nullable = true, name = "lista_notificacao")
	private String listaNotificacao;

	public Dispositivo(String identificador) {
		this.identificador = identificador;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getListaNotificacao() {
		return listaNotificacao;
	}

	public void setListaNotificacao(String listaNotificacao) {
		this.listaNotificacao = listaNotificacao;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * 
	 * @param usuario
	 * @param identificador
	 */
	public void associarDispositivoAoUsuario(Usuario usuario,
			String identificador) {
		this.usuario = usuario;
		this.identificador = identificador;
	}

	/**
	 * 
	 * TODO: Fora de escopo
	 * 
	 * 
	 * public Dispositivo Dispositivo(String identificadorGCM, Usuario usuario)
	 * {
	 * 
	 * return null;
	 * 
	 * }
	 * 
	 * public String habilitarDispositivo(String identificador) { return null; }
	 * 
	 * public boolean validarDispositivo(String identificador) { return false; }
	 * 
	 * public void desassociarDispositivoAoUsuario(Usuario usuario, String
	 * identificador) { }
	 * 
	 * public boolean verificarUsuarioNotificacaoDirigida() { return false; }
	 */
}
