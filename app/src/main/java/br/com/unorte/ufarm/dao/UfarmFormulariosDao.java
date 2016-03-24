package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.UfarmFormularios;

public class UfarmFormulariosDao {
	
	private String banco;
	
	public UfarmFormulariosDao(String banco){
		this.banco = banco;
	}
	
	public boolean inserirFormulario(UfarmFormularios form){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "INSERT INTO ufarm_formularios VALUES(null,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setString(1, form.getItem());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, form.getLegenda());							
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	public boolean AtualizarFormulario(UfarmFormularios form){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = " UPDATE ufarm_formularios SET item = ?, legenda = ? "; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setString(1, form.getItem());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, form.getLegenda());	
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	
	public boolean excluirFormulario(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM ufarm_formularios WHERE id = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
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
	
	public UfarmFormularios buscaFormulario(int id){
		UfarmFormularios form = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
		
			String query = "SELECT * FROM ufarm_formularios  WHERE id = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setInt(1, id);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				form = new UfarmFormularios();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				form.setId(rSet.getInt(1));
				form.setItem(rSet.getString(2));
				form.setLegenda(rSet.getString(3));
				//
			}
		
			conn.close();// fecha a conexão com o Bd
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return form;
	}
	
	
	public ArrayList<UfarmFormularios> buscaTodosUfarmFormularios(){
		ArrayList<UfarmFormularios> lista = new ArrayList<UfarmFormularios>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
			
			String query = "SELECT * FROM ufarm_formularios "; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				UfarmFormularios form = new UfarmFormularios();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				form.setId(rSet.getInt(1));
				form.setItem(rSet.getString(2));
				form.setLegenda(rSet.getString(3));
				//
				
				lista.add(form);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Bd
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}
	public ArrayList<UfarmFormularios> buscaUfarmFormulariosLegenda(String legenda1,String legenda2,String legenda3,String legenda4,String legenda5){
		ArrayList<UfarmFormularios> lista = new ArrayList<UfarmFormularios>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
			
			String query = "SELECT * FROM ufarm_formularios where legenda in (?,?,?,?,?) order by item"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setString(1, legenda1);
			ppStm.setString(2, legenda2);
			ppStm.setString(3, legenda3);
			ppStm.setString(4, legenda4);
			ppStm.setString(5, legenda5);
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				UfarmFormularios form = new UfarmFormularios();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				form.setId(rSet.getInt(1));
				form.setItem(rSet.getString(2));
				form.setLegenda(rSet.getString(3));
				//
				
				lista.add(form);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Bd
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	
	
	

}
