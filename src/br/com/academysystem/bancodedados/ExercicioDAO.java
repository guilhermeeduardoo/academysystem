/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academysystem.bancodedados;

import br.com.academysystem.entidades.Exercicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class ExercicioDAO {

    protected Connection conexao;

    public ExercicioDAO() {
        this.conexao = new ConectionFactory().getConnection();
    }

    public void adicionaExercicio(Exercicio exercicio) {
        String sql = "INSERT INTO `exercicio`(`nome_exercicio`, `categoria_exercicio`) VALUES (?,?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, exercicio.getNomeExercicio());
            stmt.setString(2, exercicio.getCategoriaExercicio());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "O exercicio :\n " + exercicio.getNomeExercicio() + " \nfoi adicionado! ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Exercicio> listarExercicio() {
        List<Exercicio> exercicios = new ArrayList<>();
        String sql = "select * from exercicio";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Exercicio exercicio = new Exercicio();
                exercicio.setId(rs.getInt("id_exercicio"));
                exercicio.setNomeExercicio(rs.getString("nome_exercicio"));
                exercicio.setCategoriaExercicio(rs.getString("categoria_exercicio"));
                exercicios.add(exercicio);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exercicios;
    }

    public void alterarCliente(Exercicio exercicio) {
        String sql = "UPDATE `exercicio` SET `nome_exercicio"
                + "`=?,`categoria_exercicio`=? WHERE id_exercicio=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, exercicio.getNomeExercicio());
            stmt.setString(2, exercicio.getCategoriaExercicio());
            stmt.setInt(3,exercicio.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "dados alterados");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public void excluirExercicio(Exercicio exercicio){
    String sql="DELETE FROM exercicio WHERE exercicio.id_exercicio = ?";
try{
    PreparedStatement stmt=conexao.prepareStatement(sql);
    stmt.setInt(1, exercicio.getId());
    stmt.execute();
    stmt.close();
    JOptionPane.showMessageDialog(null,"exercicio excluido");
}catch(SQLException e){
    throw new RuntimeException(e);
    }


    

    }
}
