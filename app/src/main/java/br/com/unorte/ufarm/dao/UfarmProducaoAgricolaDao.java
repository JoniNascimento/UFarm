package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.UfarmProducaoAgricola;

public class UfarmProducaoAgricolaDao {
	
	private String banco;
	
	public UfarmProducaoAgricolaDao(String banco){
		this.banco = banco;
	}
	
	public boolean inserirProducaoAgricola(UfarmProducaoAgricola producaoAgricola){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "INSERT INTO ufarm_producao_agricola VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, producaoAgricola.getIdProp());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, producaoAgricola.getTipoCultura());
			ppStm.setString(3, producaoAgricola.getCultura());
			ppStm.setString(4, producaoAgricola.getUnMedida());
			ppStm.setString(5, producaoAgricola.getAreaPlantada());
			ppStm.setString(6, producaoAgricola.getDataPlantacao());
			ppStm.setString(7, producaoAgricola.getAreaColhida());
			ppStm.setString(8, producaoAgricola.getDataColheita());
			ppStm.setString(9, producaoAgricola.getSaldo());
			ppStm.setString(10, producaoAgricola.getQtdeColhida());
			ppStm.setString(11, producaoAgricola.getUnMedidaColhida());
			ppStm.setString(12, producaoAgricola.getValorUn());
			ppStm.setString(13, producaoAgricola.getValorTotal());
			ppStm.setInt(14, producaoAgricola.getVendido());
			ppStm.setString(15, producaoAgricola.getDataVenda());
			ppStm.setString(16, producaoAgricola.getValorVenda());
			ppStm.setInt(17, producaoAgricola.getNegociacaoRecebimento());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	public boolean AtualizarProducaoAgricola(UfarmProducaoAgricola producaoAgricola){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			 String query = " UPDATE ufarm_producao_agricola SET  idProp = ?,  tipoCultura = ?,  cultura = ?,  unMedida = ?,  "+
						   "  areaPlantada = ?,  dataPlantacao = ?,  areaColhida = ?,  dataColheita = ?,  saldo = ?,  "+
						   "  qtdeColhida = ?,  unMedidaColhida = ?,  valorUn = ?,  valorTotal = ?,  vendido = ?,  "+
			               "  dataVenda = ?,  valorVenda = ?,  negociacaoRecebimento = ?"; // Variavel simples  que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, producaoAgricola.getIdProp());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, producaoAgricola.getTipoCultura());
			ppStm.setString(3, producaoAgricola.getCultura());
			ppStm.setString(4, producaoAgricola.getUnMedida());
			ppStm.setString(5, producaoAgricola.getAreaPlantada());
			ppStm.setString(6, producaoAgricola.getDataPlantacao());
			ppStm.setString(7, producaoAgricola.getAreaColhida());
			ppStm.setString(8, producaoAgricola.getDataColheita());
			ppStm.setString(9, producaoAgricola.getSaldo());
			ppStm.setString(10, producaoAgricola.getQtdeColhida());
			ppStm.setString(11, producaoAgricola.getUnMedidaColhida());
			ppStm.setString(12, producaoAgricola.getValorUn());
			ppStm.setString(13, producaoAgricola.getValorTotal());
			ppStm.setInt(14, producaoAgricola.getVendido());
			ppStm.setString(15, producaoAgricola.getDataVenda());
			ppStm.setString(16, producaoAgricola.getValorVenda());
			ppStm.setInt(17, producaoAgricola.getNegociacaoRecebimento());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	
	public boolean excluirProducaoAgricola(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM ufarm_producao_agricola WHERE id = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
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
	
	public UfarmProducaoAgricola buscaProducaoAgricola(int id){
		UfarmProducaoAgricola producaoAgricola = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
		
			String query = "SELECT * FROM ufarm_producao_agricola  WHERE id = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setInt(1, id);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				producaoAgricola = new UfarmProducaoAgricola();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				producaoAgricola.setId(rSet.getInt(1));
				producaoAgricola.setIdProp(rSet.getInt(2));
				producaoAgricola.setTipoCultura(rSet.getString(3));
				producaoAgricola.setCultura(rSet.getString(4));
				producaoAgricola.setUnMedida(rSet.getString(5));
				producaoAgricola.setAreaPlantada(rSet.getString(6));
				producaoAgricola.setDataPlantacao(rSet.getString(7));
				producaoAgricola.setAreaColhida(rSet.getString(8));
				producaoAgricola.setDataColheita(rSet.getString(9));
				producaoAgricola.setSaldo(rSet.getString(10));
				producaoAgricola.setQtdeColhida(rSet.getString(11));
			    producaoAgricola.setUnMedidaColhida(rSet.getString(12));
				producaoAgricola.setValorUn(rSet.getString(13));
				producaoAgricola.setValorTotal(rSet.getString(14));
				producaoAgricola.setVendido(rSet.getInt(15));
				producaoAgricola.setDataVenda(rSet.getString(16));
				producaoAgricola.setValorVenda(rSet.getString(17));
				producaoAgricola.setNegociacaoRecebimento(rSet.getInt(18));
				//
			}
		
			conn.close();// fecha a conexão com o Bd
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return producaoAgricola;
	}
	
	
	public ArrayList<UfarmProducaoAgricola> buscaTodosUfarmProducaoAgricola(){
		ArrayList<UfarmProducaoAgricola> lista = new ArrayList<UfarmProducaoAgricola>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
			
			String query = "SELECT * FROM ufarm_producao_agricola"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				UfarmProducaoAgricola producaoAgricola = new UfarmProducaoAgricola();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				producaoAgricola.setId(rSet.getInt(1));
				producaoAgricola.setIdProp(rSet.getInt(2));
				producaoAgricola.setTipoCultura(rSet.getString(3));
				producaoAgricola.setCultura(rSet.getString(4));
				producaoAgricola.setUnMedida(rSet.getString(5));
				producaoAgricola.setAreaPlantada(rSet.getString(6));
				producaoAgricola.setDataPlantacao(rSet.getString(7));
				producaoAgricola.setAreaColhida(rSet.getString(8));
				producaoAgricola.setDataColheita(rSet.getString(9));
				producaoAgricola.setSaldo(rSet.getString(10));
				producaoAgricola.setQtdeColhida(rSet.getString(11));
			    producaoAgricola.setUnMedidaColhida(rSet.getString(12));
				producaoAgricola.setValorUn(rSet.getString(13));
				producaoAgricola.setValorTotal(rSet.getString(14));
				producaoAgricola.setVendido(rSet.getInt(15));
				producaoAgricola.setDataVenda(rSet.getString(16));
				producaoAgricola.setValorVenda(rSet.getString(17));
				producaoAgricola.setNegociacaoRecebimento(rSet.getInt(18));
				//
				
				lista.add(producaoAgricola);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Bd
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

}
