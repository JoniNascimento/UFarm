package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.Anuncios;

public class AnunciosDao {
	private String banco;


	public AnunciosDao(String banco){
		this.banco = banco;
	}
	
	
	public boolean inserirAnuncio(Anuncios anuncio){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "INSERT INTO anuncios VALUES(null,?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, anuncio.getIdUser());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, anuncio.getTipoAnuncio());
			ppStm.setString(3, anuncio.getImagem());
			ppStm.setString(4, anuncio.getUrl());
			
			
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	public boolean AtualizarAnuncio(Anuncios anuncio){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = " UPDATE anuncios SET id_user = ?, tipo_anuncio = ?, imagem = ?, url = ? "; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, anuncio.getIdUser());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, anuncio.getTipoAnuncio());
			ppStm.setString(3, anuncio.getImagem());
			ppStm.setString(4, anuncio.getUrl());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	
	public boolean excluirAnuncio(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM anuncios WHERE id = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, id);// Essa linha popula as variaves do delete "?" de acordo com seu tipo
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	public Anuncios buscaAnuncios(int id){
		Anuncios anuncio = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
		
			String query = "SELECT * FROM anuncios  WHERE id = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setInt(1, id);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				anuncio = new Anuncios();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				anuncio.setId(rSet.getInt(1));
				anuncio.setIdUser(rSet.getInt(2));
				anuncio.setTipoAnuncio(rSet.getString(3));
				anuncio.setImagem(rSet.getString(4));
				anuncio.setUrl(rSet.getString(5));
				
				//
			}
		
			conn.close();// fecha a conexão com o Bd
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return anuncio;
	}
	
	
	public ArrayList<Anuncios> buscaTodosAnuncios(){
		ArrayList<Anuncios> lista = new ArrayList<Anuncios>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
			
			String query = "SELECT * FROM anuncios"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				Anuncios anuncio = new Anuncios();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				anuncio.setId(rSet.getInt(1));
				anuncio.setIdUser(rSet.getInt(2));
				anuncio.setTipoAnuncio(rSet.getString(3));
				anuncio.setImagem(rSet.getString(4));
				anuncio.setUrl(rSet.getString(5));
				//
				
				lista.add(anuncio);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Bd
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}


}
