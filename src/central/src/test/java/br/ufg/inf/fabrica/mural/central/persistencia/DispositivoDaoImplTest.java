/**
 * 
 */
package br.ufg.inf.fabrica.mural.central.persistencia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufg.inf.fabrica.mural.central.dominio.Dispositivo;
import br.ufg.inf.fabrica.mural.central.dominio.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class DispositivoDaoImplTest {
	
	@Mock
	DispositivoDaoImpl mockDispositivoDao;
	
	@Test
	public void testSalvar() {
		String identificador = "IdMock01";
		
		Dispositivo dispositivo = new Dispositivo(identificador);

		Mockito.doNothing().when(mockDispositivoDao).salvar(dispositivo);		
	}
	
	@Test
	public void testDesassociar() {
		String identificador = "IdMock02";
		
		Mockito.doNothing().when(mockDispositivoDao).desassociar(identificador);	
	}
	
	@Test
	public void testAssociar() {
		Usuario usuario = new Usuario();
		String identificador = "IdMock03";
		
		Mockito.doNothing().when(mockDispositivoDao).associar(usuario, identificador);
	}
}
