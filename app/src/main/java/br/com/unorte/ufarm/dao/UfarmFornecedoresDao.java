package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.UfarmFornecedores;


public class UfarmFornecedoresDao {
	private String banco;
	
public UfarmFornecedoresDao(String banco){
	
	this.banco = banco;
	
}
	
	
public boolean inserirFornecedor(UfarmFornecedores fornecedor){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "INSERT INTO ufarm_fornecedores VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, fornecedor.getIdPropriedade());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, fornecedor.getNome());
			ppStm.setString(3, fornecedor.getNome());
			ppStm.setString(4, fornecedor.getRazaoSocial());
			ppStm.setString(5, fornecedor.getCnpj());
			ppStm.setString(6, fornecedor.getRamo());
			ppStm.setString(7, fornecedor.getTel());
			ppStm.setString(8, fornecedor.getCel());
			ppStm.setString(9, fornecedor.getEndereco());
			ppStm.setInt(10, fornecedor.getNumeroEndereco());
			ppStm.setString(11, fornecedor.getFornecedorDe());
			ppStm.setNString(12, fornecedor.getObs());
		
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	public boolean AtualizarUsuario(UfarmFornecedores fornecedor){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = " UPDATE ufarm_fornecedores SET id_prop = ?,  nome = ?, razaosocial = ?, cnpj = ?, ramo = ?, "+
						   " tel = ?, cel = ?, endereco= ?, numero = ?, fornecedorde = ?, obs = ?"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, fornecedor.getIdPropriedade());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, fornecedor.getNome());
			ppStm.setString(3, fornecedor.getNome());
			ppStm.setString(4, fornecedor.getRazaoSocial());
			ppStm.setString(5, fornecedor.getCnpj());
			ppStm.setString(6, fornecedor.getRamo());
			ppStm.setString(7, fornecedor.getTel());
			ppStm.setString(8, fornecedor.getCel());
			ppStm.setString(9, fornecedor.getEndereco());
			ppStm.setInt(10, fornecedor.getNumeroEndereco());
			ppStm.setString(11, fornecedor.getFornecedorDe());
			ppStm.setNString(12, fornecedor.getObs());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	
	public boolean excluirFornecedor(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM ufarm_fornecedores WHERE id = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
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
	
	public UfarmFornecedores buscaFornecedor(int id){
		UfarmFornecedores fornecedor = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
		
			String query = "SELECT * FROM ufarm_fornecedores  WHERE id = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setInt(1, id);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				fornecedor = new UfarmFornecedores();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				fornecedor.setId(rSet.getInt(1));
				fornecedor.setIdPropriedade(rSet.getInt(2));
				fornecedor.setNome(rSet.getString(3));
				fornecedor.setRazaoSocial(rSet.getString(4));
				fornecedor.setCnpj(rSet.getString(5));
				fornecedor.setRamo(rSet.getString(6));
				fornecedor.setTel(rSet.getString(7));
				fornecedor.setCel(rSet.getString(8));
				fornecedor.setEndereco(rSet.getString(9));
				fornecedor.setNumeroEndereco(rSet.getInt(10));
				fornecedor.setFornecedorDe(rSet.getString(11));
				fornecedor.setObs(rSet.getString(12));
			}
		
			conn.close();// fecha a conexão com o Bd
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return fornecedor;
	}
	
	
	public ArrayList<UfarmFornecedores> buscaTodosFornecedores(){
		ArrayList<UfarmFornecedores> lista = new ArrayList<UfarmFornecedores>(); 
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
			
			String query = "SELECT * FROM ufarm_fornecedores"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				UfarmFornecedores fornecedor = new UfarmFornecedores();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				fornecedor.setId(rSet.getInt(1));
				fornecedor.setIdPropriedade(rSet.getInt(2));
				fornecedor.setNome(rSet.getString(3));
				fornecedor.setRazaoSocial(rSet.getString(4));
				fornecedor.setCnpj(rSet.getString(5));
				fornecedor.setRamo(rSet.getString(6));
				fornecedor.setTel(rSet.getString(7));
				fornecedor.setCel(rSet.getString(8));
				fornecedor.setEndereco(rSet.getString(9));
				fornecedor.setNumeroEndereco(rSet.getInt(10));
				fornecedor.setFornecedorDe(rSet.getString(11));
				fornecedor.setObs(rSet.getString(12));
				//
				
				lista.add(fornecedor);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Bd
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}


}
