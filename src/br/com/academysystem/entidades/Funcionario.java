/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academysystem.entidades;

import java.util.Calendar;


public class Funcionario extends Pessoa{
    private double salario;
    private Calendar dataDePagamento; 
    private Calendar dataDeAdimissao;
    /*
    Metudo NAO UTILIZADO
    public double calcularSalario(){
        double porcentagem=20;
        double resultado=0;
        resultado=(this.getSalario()*porcentagem)/100;
        this.setSalario(this.getSalario() + resultado);
        return this.getSalario();
        
    }*/
      public String getDados(){
        //criar o metodo para ser usado no polimorfismo//
        String menssagem = "Nome: "+this.getNome()+"\nSalario: "+this.getSalario();
        return menssagem;
        
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the dataDePagamento
     */
    public Calendar getDataDePagamento() {
        return dataDePagamento;
    }

    /**
     * @param dataDePagamento the dataDePagamento to set
     */
    public void setDataDePagamento(Calendar dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

    /**
     * @return the dataDeAdimissao
     */
    public Calendar getDataDeAdimissao() {
        return dataDeAdimissao;
    }

    /**
     * @param dataDeAdimissao the dataDeAdimissao to set
     */
    public void setDataDeAdimissao(Calendar dataDeAdimissao) {
        this.dataDeAdimissao = dataDeAdimissao;
    }
    
}
