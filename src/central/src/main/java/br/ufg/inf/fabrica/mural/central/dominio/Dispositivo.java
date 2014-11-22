/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.fabrica.mural.central.dominio;

import java.util.List;

/**
 *
 * @author Alexandre
 */
public class Dispositivo {

    private List<String> listaNotificacao;
    private String identificadorGCM;
    private Usuario usuario;
    private boolean habilitado;

    public Dispositivo(String identificadorGCM, Usuario usuario) {
        this.identificadorGCM = identificadorGCM;
        this.usuario = usuario;
        habilitado = false;
    }

    public String habilitarDispositivo() {
        habilitado = true;
        return "Dispositivo Habilitado";
    }

    public boolean validarDispositivo(String identificador) {
        boolean validacao;
        if (identificador.equals(identificadorGCM)) {
            validacao = true;
        } else {
            validacao = false;
        }

        return validacao;
    }

    public void associarDispositivoAoUsuario(Usuario usuario, String identificador) {
        this.usuario = usuario;
        this.identificadorGCM = identificador;
    }

    public void dessociarDispositivoAoUsuario(Usuario usuario, String identificador) {
       
    }
}
