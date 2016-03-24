package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.Pgtos;

public class PgtosDao {
	
	private String banco;
	
	public PgtosDao(String banco){
		this.banco = banco;
	}
	
	
public boolean inserirPgtos(Pgtos pgto){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "INSERT INTO pgto VALUES(null,?,?,?,?,?,?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, pgto.getFormaPgto());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setInt(2, pgto.getPago());
			ppStm.setString(3, pgto.getValor());
			ppStm.setInt(4, pgto.getDesconto());
			ppStm.setString(5, pgto.getValorFinal());
			ppStm.setInt(6, pgto.getIdUser());
			ppStm.setString(7, pgto.getTipoUsuario());
			ppStm.setString(8, pgto.getToken());
			ppStm.setString(9, pgto.getIdPayer());
			
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o Pgtos 
			
	}
	
	public boolean AtualizarPgtos(Pgtos pgto){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = " UPDATE pgtos SET forma_pagto = ?, pago = ?, valor = ?, desconto = ?, " +
			               " valor_final = ?, id_user = ?, tipo_usuario = ?, token = ?, id_payer = ?  "; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, pgto.getFormaPgto());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setInt(2, pgto.getPago());
			ppStm.setString(3, pgto.getValor());
			ppStm.setInt(4, pgto.getDesconto());
			ppStm.setString(5, pgto.getValorFinal());
			ppStm.setInt(6, pgto.getIdUser());
			ppStm.setString(7, pgto.getTipoUsuario());
			ppStm.setString(8, pgto.getToken());
			ppStm.setString(9, pgto.getIdPayer());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o Pgtos 
			
	}
	
	
	public boolean excluirPgtos(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM tb_Pgtoss WHERE cod_Pgtoss = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, id);// Essa linha popula as variaves do delete "?" de acordo com seu tipo
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o Pgtos 
			
	}
	
	public Pgtos buscaPgtos(int id){
		Pgtos pgto = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o Pgtos 
		
			String query = "SELECT * FROM pgtos  WHERE id = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setInt(1, id);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				pgto = new Pgtos();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				pgto.setId(rSet.getInt(1));
				pgto.setFormaPgto(rSet.getInt(2));
				pgto.setPago(rSet.getInt(3));
				pgto.setValor(rSet.getString(4));
				pgto.setDesconto(rSet.getInt(5));
				pgto.setValorFinal(rSet.getString(6));
				pgto.setIdUser(rSet.getInt(7));
				pgto.setTipoUsuario(rSet.getString(8));
				pgto.setToken(rSet.getString(9));
				pgto.setIdPayer(rSet.getString(10));				
				//
			}
		
			conn.close();// fecha a conexão com o Pgtos
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return pgto;
	}
	
	
	public ArrayList<Pgtos> buscaTodosPgtos(){
		ArrayList<Pgtos> lista = new ArrayList<Pgtos>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o Pgtos 
			
			String query = "SELECT * FROM pgtos"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				Pgtos pgto = new Pgtos();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				pgto.setId(rSet.getInt(1));
				pgto.setFormaPgto(rSet.getInt(2));
				pgto.setPago(rSet.getInt(3));
				pgto.setValor(rSet.getString(4));
				pgto.setDesconto(rSet.getInt(5));
				pgto.setValorFinal(rSet.getString(6));
				pgto.setIdUser(rSet.getInt(7));
				pgto.setTipoUsuario(rSet.getString(8));
				pgto.setToken(rSet.getString(9));
				pgto.setIdPayer(rSet.getString(10));				
				//
				
				lista.add(pgto);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Pgtos
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

}
