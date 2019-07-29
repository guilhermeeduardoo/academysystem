/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academysystem.bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectionFactory {
    public Connection getConnection(){
        try{
             return DriverManager.getConnection("jdbc:mysql://localhost:3306/academia","root", "");
        }catch(SQLException e){
         throw new RuntimeException(e);   
        }
    }
}
