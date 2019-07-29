/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academysystem.bancodedados;

import br.com.academysystem.entidades.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;


public class ClienteDAO {
    protected Connection conexao;
    
    public ClienteDAO(){
        this.conexao=new ConectionFactory().getConnection();
    }

   
    public void adicionaCliente(Cliente cliente){
        String sql="insert into clientes(nome,cpf,dataDeNascimento,"
                + "sexo,peso,telefone,tipoSanguineo,dataDeCadastro,"
                + "dataDeVencimento,valorMensalidade)values(?,?,?,?,"
                + "?,?,?,?,?,?)";
     try{
         PreparedStatement stmt=conexao.prepareStatement(sql);
         stmt.setString(1, cliente.getNome());
         stmt.setString(2, cliente.getCpf());
         stmt.setDate(3, new Date(cliente.getDataDeNascimento().getTimeInMillis()));
         stmt.setString(4,cliente.getSexo());
         stmt.setDouble(5,cliente.getPeso());
         stmt.setString(6,cliente.getTelefone());
         stmt.setString(7,cliente.getTipoSanguineo());
         stmt.setDate(8, new Date(cliente.getDataDeCadastro().getTimeInMillis()));
         stmt.setDate(9,new Date(cliente.getDataDeVencimento().getTimeInMillis()));
         stmt.setDouble(10,cliente.getValorDamensalidade());
         stmt.execute();
         stmt.close();
         JOptionPane.showMessageDialog(null,"O cliente :\n "+cliente.getDados()+ " \nfoi adicionado! " );
     } catch(SQLException e){
         throw new RuntimeException(e);
     } 
    }
   public List<Cliente> listarCliente (){
       List<Cliente> clientes =new ArrayList<>();
       String sql="select * from clientes";
       try{
           PreparedStatement stmt=conexao.prepareStatement(sql);
           ResultSet rs=stmt.executeQuery();
           while(rs.next()){
               Cliente cliente=new Cliente();
               cliente.setNome(rs.getString("nome"));
               cliente.setCpf(rs.getString("cpf"));
               cliente.setId(rs.getInt("id"));
               cliente.setPeso(rs.getDouble("peso"));
               cliente.setSexo(rs.getString("sexo"));
               cliente.setTelefone(rs.getString("telefone"));
               cliente.setTipoSanguineo(rs.getString("tipoSanguineo"));
               cliente.setValorDamensalidade(rs.getDouble("valorMensalidade"));
               Calendar data=Calendar.getInstance();
               data.setTime(rs.getDate("dataDeNascimento"));
               cliente.setDataDeNascimento(data);
               Calendar data2=Calendar.getInstance();
               data.setTime(rs.getDate("dataDeCadastro"));
               cliente.setDataDeCadastro(data2);
               Calendar data3=Calendar.getInstance();
               data.setTime(rs.getDate("dataDeVencimento"));
               cliente.setDataDeVencimento(data3);
               clientes.add(cliente);
           }
       }catch(SQLException e){
           throw new RuntimeException(e);
       }
       return clientes; 
   } 
    public void alterarCliente (Cliente cliente){
        String sql="UPDATE clientes SET nome = ?, cpf = ?, dataDeNascimento = ? "
                + ",sexo = ?, peso = ?, telefone = ?, "
                + "tipoSanguineo = ?, dataDeCadastro = ? ,"
                + "dataDeVencimento = ?, valorMensalidade = ?"
                + " WHERE id = ?";
     try{
         PreparedStatement stmt=conexao.prepareStatement(sql);
         stmt.setString(1, cliente.getNome());
         stmt.setString(2, cliente.getCpf());
         stmt.setDate(3, new Date(cliente.getDataDeNascimento().getTimeInMillis()));
         stmt.setString(4,cliente.getSexo());
         stmt.setDouble(5,cliente.getPeso());
         stmt.setString(6,cliente.getTelefone());
         stmt.setString(7,cliente.getTipoSanguineo());
         stmt.setDate(8, new Date(cliente.getDataDeCadastro().getTimeInMillis()));
         stmt.setDate(9,new Date(cliente.getDataDeVencimento().getTimeInMillis()));
         stmt.setDouble(10,cliente.getValorDamensalidade());
         stmt.setInt(11,cliente.getId());
         stmt.execute();
         stmt.close();
         JOptionPane.showMessageDialog(null,"dados alterados");
     } catch(SQLException e){
         throw new RuntimeException(e);
     } 
    }
    public void excluirCliente(Cliente cliente){
    String sql="DELETE FROM clientes WHERE clientes.id = ?";
try{
    PreparedStatement stmt=conexao.prepareStatement(sql);
    stmt.setInt(1, cliente.getId());
    stmt.execute();
    stmt.close();
    JOptionPane.showMessageDialog(null,"cliente excluido");
}catch(SQLException e){
    
    }


    

    }
    public List<Cliente> buscaCliente (String nome){
       List<Cliente> clientes =new ArrayList<>();
       String sql="select * from clientes where nome like ?";
       try{
           PreparedStatement stmt=conexao.prepareStatement(sql);
           stmt.setString(1,"%"+nome+"%");
           ResultSet rs=stmt.executeQuery();
           while(rs.next()){
               Cliente cliente=new Cliente();
               cliente.setNome(rs.getString("nome"));
               cliente.setCpf(rs.getString("cpf"));
               cliente.setId(rs.getInt("id"));
               cliente.setPeso(rs.getDouble("peso"));
               cliente.setSexo(rs.getString("sexo"));
               cliente.setTelefone(rs.getString("telefone"));
               cliente.setTipoSanguineo(rs.getString("tipoSanguineo"));
               cliente.setValorDamensalidade(rs.getDouble("valorMensalidade"));
               Calendar data=Calendar.getInstance();
               data.setTime(rs.getDate("dataDeNascimento"));
               cliente.setDataDeNascimento(data);
               Calendar data2=Calendar.getInstance();
               data.setTime(rs.getDate("dataDeCadastro"));
               cliente.setDataDeCadastro(data2);
               Calendar data3=Calendar.getInstance();
               data.setTime(rs.getDate("dataDeVencimento"));
               cliente.setDataDeVencimento(data3);
               clientes.add(cliente);
           }
       }catch(SQLException e){
           throw new RuntimeException(e);
       }
       return clientes; 
   }
}
