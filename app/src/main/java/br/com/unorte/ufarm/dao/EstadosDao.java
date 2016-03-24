package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.Estados;

public class EstadosDao {
	
	private String banco;
	
	public EstadosDao(String banco){
		this.banco = banco;
	}
	
	
	public boolean inserirEstado(Estados estado){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "INSERT INTO tb_estados VALUES(null,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setString(1, estado.getSigla());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, estado.getNome());
			
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o Estado 
			
	}
	
	public boolean AtualizarEstado(Estados estado){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = " UPDATE tb_estados SET sigla = ?, nome = ?"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setString(1, estado.getSigla());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, estado.getNome());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o Estado 
			
	}
	
	
	public boolean excluirEstado(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM tb_estados WHERE cod_estados = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, id);// Essa linha popula as variaves do delete "?" de acordo com seu tipo
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o Estado 
			
	}
	
	public Estados buscaEstados(int id){
		Estados estado = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o Estado 
		
			String query = "SELECT * FROM tb_Estados  WHERE cod_estados = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setInt(1, id);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				estado = new Estados();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				estado.setCodEstados(rSet.getInt(1));
				estado.setSigla(rSet.getString(2));
				estado.setNome(rSet.getString(3));
				
				
				//
			}
		
			conn.close();// fecha a conexão com o Estado
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return estado;
	}
	
	
	public ArrayList<Estados> buscaTodosEstados(){
		ArrayList<Estados> lista = new ArrayList<Estados>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o Estado 
			
			String query = "SELECT * FROM tb_Estados"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				Estados estado = new Estados();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				estado.setCodEstados(rSet.getInt(1));
				estado.setSigla(rSet.getString(2));
				estado.setNome(rSet.getString(3));
				//
				
				lista.add(estado);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Estado
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

}
