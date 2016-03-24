package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.Assinaturas;


public class AssinaturasDao {
	private String banco;


public AssinaturasDao(String banco){
	this.banco = banco;
}
	
	public boolean inserirAssinatura(Assinaturas ass){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "INSERT INTO Assinaturas VALUES(null,?,?,?,?,?,?,?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, ass.getIdUser());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, ass.getData());
			ppStm.setString(3, ass.getTipoUsuario());
			ppStm.setString(4, ass.getProduto());
			ppStm.setString(5, ass.getCiclo());
			ppStm.setInt(6, ass.getQtdeLi());
			ppStm.setString(7, ass.getTotal());
			ppStm.setInt(8, ass.getQtdeProp());
			ppStm.setInt(9, ass.getFormaPgto());
			ppStm.setInt(10, ass.getPago());
			
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	public boolean AtualizarAssinatura(Assinaturas ass){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = " UPDATE assinaturas SET id_ass = ?, data = ?, tipo_usuario = ?, produto = ?, ciclo = ?,"+
						   " qtd_li = ?, total = ?, qtd_prop = ?, forma_pgto = ?, pago= ? "; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, ass.getIdUser());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, ass.getData());
			ppStm.setString(3, ass.getTipoUsuario());
			ppStm.setString(4, ass.getProduto());
			ppStm.setString(5, ass.getCiclo());
			ppStm.setInt(6, ass.getQtdeLi());
			ppStm.setString(7, ass.getTotal());
			ppStm.setInt(8, ass.getQtdeProp());
			ppStm.setInt(9, ass.getFormaPgto());
			ppStm.setInt(10, ass.getPago());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	
	public boolean excluirAssinatura(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM assinaturas WHERE id = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
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
	
	public Assinaturas buscaAssinaturas(int id){
		Assinaturas ass = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
		
			String query = "SELECT * FROM Assinaturas  WHERE id = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setInt(1, id);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				ass = new Assinaturas();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				ass.setId(rSet.getInt(1));
				ass.setIdUser(rSet.getInt(2));
				ass.setData(rSet.getString(3));
				ass.setTipoUsuario(rSet.getString(4));
				ass.setProduto(rSet.getString(5));
				ass.setCiclo(rSet.getString(6));
				ass.setQtdeLi(rSet.getInt(7));
				ass.setTotal(rSet.getString(8));
				ass.setQtdeProp(rSet.getInt(9));
				ass.setFormaPgto(rSet.getInt(10));
				ass.setPago(rSet.getInt(11));
				//
			}
		
			conn.close();// fecha a conexão com o Bd
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return ass;
	}
	
	
	public ArrayList<Assinaturas> buscaTodosAssinaturas(){
		ArrayList<Assinaturas> lista = new ArrayList<Assinaturas>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
			
			String query = "SELECT * FROM Assinaturas"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				Assinaturas ass = new Assinaturas();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				ass.setId(rSet.getInt(1));
				ass.setIdUser(rSet.getInt(2));
				ass.setData(rSet.getString(3));
				ass.setTipoUsuario(rSet.getString(4));
				ass.setProduto(rSet.getString(5));
				ass.setCiclo(rSet.getString(6));
				ass.setQtdeLi(rSet.getInt(7));
				ass.setTotal(rSet.getString(8));
				ass.setQtdeProp(rSet.getInt(9));
				ass.setFormaPgto(rSet.getInt(10));
				ass.setPago(rSet.getInt(11));
				//
				
				lista.add(ass);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Bd
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

}
