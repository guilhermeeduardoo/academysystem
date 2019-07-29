/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academysystem.entidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Cliente extends Pessoa {
    private Calendar dataDeCadastro;
    private Calendar dataDeVencimento;
    private double valorDamensalidade;
      public String getDados(){
        //criar o metodo para ser usado no polimorfismo//
          SimpleDateFormat dataCadastro = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dataVencimento = new SimpleDateFormat("dd/MM/yyyy");
        String menssagem = "Nome: "+this.getNome()+"\nData de Cadastro: "
                +dataCadastro.format(this.getDataDeCadastro().getTime())+"\nData de Vencimento: "
                +dataVencimento.format(this.getDataDeVencimento().getTime());
        return menssagem;
        
    }

    /**
     * @return the dataDeCadastro
     */
    public Calendar getDataDeCadastro() {
        return dataDeCadastro;
    }

    /**
     * @param dataDeCadastro the dataDeCadastro to set
     */
    public void setDataDeCadastro(Calendar dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    /**
     * @return the dataDeVencimento
     */
    public Calendar getDataDeVencimento() {
        return dataDeVencimento;
    }

    /**
     * @param dataDeVencimento the dataDeVencimento to set
     */
    public void setDataDeVencimento(Calendar dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    /**
     * @return the valorDamensalidade
     */
    public double getValorDamensalidade() {
        return valorDamensalidade;
    }

    /**
     * @param valorDamensalidade the valorDamensalidade to set
     */
    public void setValorDamensalidade(double valorDamensalidade) {
        this.valorDamensalidade = valorDamensalidade;
    }
    
    
}
