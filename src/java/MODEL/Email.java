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
public class Email {
    
    private Contestacao contestacao;
    private Date data_envio;
    private Date data_recebimento;
    private String data_envio_s;
    private String data_receb_s;

    public String getData_envio_s() {
        return data_envio_s;
    }

    public void setData_envio_s(String data_envio_s) {
        this.data_envio_s = data_envio_s;
    }

    public String getData_receb_s() {
        return data_receb_s;
    }

    public void setData_receb_s(String data_receb_s) {
        this.data_receb_s = data_receb_s;
    }
    
    public Contestacao getContestacao() {
        return contestacao;
    }

    public void setContestacao(Contestacao contestacao) {
        this.contestacao = contestacao;
    }

    public Date getData_envio() {
        return data_envio;
    }

    public void setData_envio(Date data_envio) {
        this.data_envio = data_envio;
    }

    public Date getData_recebimento() {
        return data_recebimento;
    }

    public void setData_recebimento(Date data_recebimento) {
        this.data_recebimento = data_recebimento;
    }
    
    
    
}
