package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.Cidades;

public class CidadesDao {
	
	private String banco;
	
	public CidadesDao (String banco){
		this.banco = banco;
	}
	
	
	public boolean inserirCidade(Cidades cidade){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "INSERT INTO tb_cidades VALUES(?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, cidade.getCodEstados());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setInt(2, cidade.getCodCidades());
			ppStm.setString(3, cidade.getNomeCidade());	
			ppStm.setString(4, cidade.getCep());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o cidade 
			
	}
	
	public boolean AtualizarCidade(Cidades cidade){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = " UPDATE tb_cidades SET estados_codigo_estados = ?, cod_cidades = ?, nome = ?, cep = ? "; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, cidade.getCodEstados());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setInt(2, cidade.getCodCidades());
			ppStm.setString(3, cidade.getNomeCidade());	
			ppStm.setString(4, cidade.getCep());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o cidade 
			
	}
	
	
	public boolean excluircidade(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM tb_cidades WHERE id = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, id);// Essa linha popula as variaves do delete "?" de acordo com seu tipo
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o cidade 
			
	}
	
	public Cidades buscacidades(int id){
		Cidades cidade = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o cidade 
		
			String query = "SELECT * FROM tb_cidades  WHERE id = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setInt(1, id);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				cidade = new Cidades();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				cidade.setCodEstados(rSet.getInt(1));
				cidade.setCodCidades(rSet.getInt(2));
				cidade.setNomeCidade(rSet.getString(3));
				cidade.setCep(rSet.getString(4));
				
				
				//
			}
		
			conn.close();// fecha a conexão com o cidade
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return cidade;
	}
	
	
	public ArrayList<Cidades> buscaTodoscidades(){
		ArrayList<Cidades> lista = new ArrayList<Cidades>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o cidade 
			
			String query = "SELECT * FROM tb_cidades"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				Cidades cidade = new Cidades();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				cidade.setCodEstados(rSet.getInt(1));
				cidade.setCodCidades(rSet.getInt(2));
				cidade.setNomeCidade(rSet.getString(3));
				cidade.setCep(rSet.getString(4));
				//
				
				lista.add(cidade);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o cidade
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

}
