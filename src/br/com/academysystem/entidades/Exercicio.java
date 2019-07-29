/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academysystem.entidades;

/**
 *
 * @author guilh
 */
public class Exercicio {
    private int id;
    private String nomeExercicio;
    private String categoriaExercicio;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nomeExercicio
     */
    public String getNomeExercicio() {
        return nomeExercicio;
    }

    /**
     * @param nomeExercicio the nomeExercicio to set
     */
    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    /**
     * @return the categoriaExercicio
     */
    public String getCategoriaExercicio() {
        return categoriaExercicio;
    }

    /**
     * @param categoriaExercicio the categoriaExercicio to set
     */
    public void setCategoriaExercicio(String categoriaExercicio) {
        this.categoriaExercicio = categoriaExercicio;
    }
}
