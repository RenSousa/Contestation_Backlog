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
public class Contestacao {
    
    private String tipo;
    private String natureza;
    private String num_ocorrencia;
    private String descricao;
    private int qtd_itens;
    private double valor_contestado;
    private String login_abertura;
    private String nrc;
    private String nome_cliente;
    private String tipo_pessoa;
    private String cpf_cnpj;
    private Date data_abertura;
    private String posto_de_apoio;
    private String equipe;
    private int canais_criticos;
    private String status_cliente;
    private String vencimento_fatura;
    private float saldo_balance;
    private String modo_pagamento;
    private String msg;
   
    private User user;
    
    private Date data_alteracao;
    
    private Email email;
    private String resultado;
    
    private Conveniado conveniado;

    private int front;
    private String loja;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String getNum_ocorrencia() {
        return num_ocorrencia;
    }

    public void setNum_ocorrencia(String num_ocorrencia) {
        this.num_ocorrencia = num_ocorrencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd_itens() {
        return qtd_itens;
    }

    public void setQtd_itens(int qtd_itens) {
        this.qtd_itens = qtd_itens;
    }

    public double getValor_contestado() {
        return valor_contestado;
    }

    public void setValor_contestado(double valor_contestado) {
        this.valor_contestado = valor_contestado;
    }

    public String getLogin_abertura() {
        return login_abertura;
    }

    public void setLogin_abertura(String login_abertura) {
        this.login_abertura = login_abertura;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(String tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public Date getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public String getPosto_de_apoio() {
        return posto_de_apoio;
    }

    public void setPosto_de_apoio(String posto_de_apoio) {
        this.posto_de_apoio = posto_de_apoio;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public int getCanais_criticos() {
        return canais_criticos;
    }

    public void setCanais_criticos(int canais_criticos) {
        this.canais_criticos = canais_criticos;
    }

    public String getStatus_cliente() {
        return status_cliente;
    }

    public void setStatus_cliente(String status_cliente) {
        this.status_cliente = status_cliente;
    }

    public String getVencimento_fatura() {
        return vencimento_fatura;
    }

    public void setVencimento_fatura(String vencimento_fatura) {
        this.vencimento_fatura = vencimento_fatura;
    }

    public float getSaldo_balance() {
        return saldo_balance;
    }

    public void setSaldo_balance(float saldo_balance) {
        this.saldo_balance = saldo_balance;
    }

    public String getModo_pagamento() {
        return modo_pagamento;
    }

    public void setModo_pagamento(String modo_pagamento) {
        this.modo_pagamento = modo_pagamento;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getData_alteracao() {
        return data_alteracao;
    }

    public void setData_alteracao(Date data_alteracao) {
        this.data_alteracao = data_alteracao;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Conveniado getConveniado() {
        return conveniado;
    }

    public void setConveniado(Conveniado conveniado) {
        this.conveniado = conveniado;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }
    

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }
    
    
    
}
