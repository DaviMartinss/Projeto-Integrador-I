/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pc
 */
public class moduloConexao {
    
    public static Connection conector(){
        
        java.sql.Connection conexao = null; 
        
        String driver = "com.mysql.cj.jdbc.Driver";  
        // armazenando infformações rederentes ao banco
        
        String url = "jdbc:mysql://localhost:3307/bd_pedemeia_2";          
        String user = "root";          
        String password = "sua_senha";
       
        // estabelecendo a conexão com o banco
        try{
   
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
                        
            return conexao;
        
        } catch(Exception e){
            System.out.println(e); 
            return null;
        }
        

    } 
}