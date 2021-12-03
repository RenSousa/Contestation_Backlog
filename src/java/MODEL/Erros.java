/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.Date;

/**
 *
 * @author RENAN.SOUSA
 */
public class Erros {
    
    private String cod_erro;
    private String motivo;
    private String cod_erro_contingencia;
    private String tipo;
    private String login;
    private String msg;
    private Date data_alt;

    public String getCod_erro() {
        return cod_erro;
    }

    public void setCod_erro(String cod_erro) {
        this.cod_erro = cod_erro;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getCod_erro_contingencia() {
        return cod_erro_contingencia;
    }

    public void setCod_erro_contingencia(String cod_erro_contingencia) {
        this.cod_erro_contingencia = cod_erro_contingencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getData_alt() {
        return data_alt;
    }

    public void setData_alt(Date data_alt) {
        this.data_alt = data_alt;
    }

   
    
    
    
}
