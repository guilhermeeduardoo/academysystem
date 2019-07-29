/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academysystem.bancodedados;

import br.com.academysystem.entidades.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class FuncionarioDAO {

    private Connection conexao = null;

    public FuncionarioDAO() {
        this.conexao = new ConectionFactory().getConnection();
    }

    public void adicionaFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO `funcionarios`( `nome`, `cpf`, `dataDeNascimento`, "
                + "`sexo`, `peso`, `telefone`, `tipoSanguineo`, `salario`, "
                + "`dataDePagamento`, `dataDeAdmissao`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setDate(3, new Date(funcionario.getDataDeNascimento().getTimeInMillis()));
            stmt.setString(4, funcionario.getSexo());
            stmt.setDouble(5, funcionario.getPeso());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setString(7, funcionario.getTipoSanguineo());
            stmt.setDouble(8, funcionario.getSalario());
            stmt.setDate(9, new Date(funcionario.getDataDePagamento().getTimeInMillis()));
            stmt.setDate(10, new Date(funcionario.getDataDeAdimissao().getTimeInMillis()));
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Funcionario:\n" + funcionario.getDados() + "\nfoi Adicionado!");

        } catch (SQLException e) {

        }
    }

    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setId(rs.getInt("id"));
                funcionario.setPeso(rs.getDouble("peso"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setTipoSanguineo(rs.getString("tipoSanguineo"));
                funcionario.setSalario(rs.getDouble("salario"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataDeNascimento"));
                funcionario.setDataDeNascimento(data);
                Calendar data2 = Calendar.getInstance();
                data.setTime(rs.getDate("dataDeAdmissao"));
                funcionario.setDataDeAdimissao(data2);
                Calendar data3 = Calendar.getInstance();
                data.setTime(rs.getDate("dataDePagamento"));
                funcionario.setDataDePagamento(data3);
                funcionarios.add(funcionario);
            }

        } catch (Exception e) {
        }
        return funcionarios;
    }

    public void alteraFuncionario(Funcionario funcionario) {
        String sql = "UPDATE `funcionarios` SET `nome`=?,`cpf`=?,"
                + "`dataDeNascimento`=?,`sexo`=?,`peso`=?,`telefone`=?,"
                + "`tipoSanguineo`=?,`salario`=?,`dataDePagamento`=?,"
                + "`dataDeAdmissao`=? WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setDate(3, new Date(funcionario.getDataDeNascimento().getTimeInMillis()));
            stmt.setString(4, funcionario.getSexo());
            stmt.setDouble(5, funcionario.getPeso());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setString(7, funcionario.getTipoSanguineo());
            stmt.setDouble(8, funcionario.getSalario());
            stmt.setDate(9, new Date(funcionario.getDataDePagamento().getTimeInMillis()));
            stmt.setDate(10, new Date(funcionario.getDataDeAdimissao().getTimeInMillis()));
            stmt.setInt(11, funcionario.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "dados alterados");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirFuncionario(Funcionario funcionario) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "funcionario excluido");
        } catch (SQLException e) {

        }

    }
     public List<Funcionario> buscarFuncionarios(String nome) {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios where nome like ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%"+nome+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setId(rs.getInt("id"));
                funcionario.setPeso(rs.getDouble("peso"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setTipoSanguineo(rs.getString("tipoSanguineo"));
                funcionario.setSalario(rs.getDouble("salario"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataDeNascimento"));
                funcionario.setDataDeNascimento(data);
                Calendar data2 = Calendar.getInstance();
                data.setTime(rs.getDate("dataDeAdmissao"));
                funcionario.setDataDeAdimissao(data2);
                Calendar data3 = Calendar.getInstance();
                data.setTime(rs.getDate("dataDePagamento"));
                funcionario.setDataDePagamento(data3);
                funcionarios.add(funcionario);
            }

        } catch (Exception e) {
        }
        return funcionarios;
    }
    
}
