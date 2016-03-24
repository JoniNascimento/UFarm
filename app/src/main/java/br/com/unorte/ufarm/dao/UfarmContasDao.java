package br.com.unorte.ufarm.dao;

import android.util.Log;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.UfarmAquisicoes;
import br.com.unorte.ufarm.pojo.UfarmContas;

public class UfarmContasDao {
	
	private String banco;
	
	public UfarmContasDao(String banco){
		this.banco = banco;
	}
	
	
	public boolean inserirConta(UfarmContas contas){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "INSERT INTO ufarm_contas VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, contas.getIdProp());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setInt(2, contas.getIdAquisicao());
			ppStm.setInt(3, contas.getIdDespesa());
			ppStm.setString(4, contas.getDataAquisicao());
			ppStm.setString(5, contas.getDespesa());
			ppStm.setString(6, contas.getCategoria());
			ppStm.setString(7, contas.getFormaPagto());
			ppStm.setInt(8, contas.getNf());
			ppStm.setInt(9, contas.getQtdeParcelas());
			ppStm.setInt(10, contas.getParcela());
			ppStm.setString(11, contas.getValor());
			ppStm.setString(12, contas.getDataVencimento());
			ppStm.setInt(13, contas.getPago());
			ppStm.setString(14, contas.getDataPagto());					
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}


	public boolean inserirContasAquisicoes(UfarmAquisicoes Aquisicao){

		try {
			Connection conn = new ConectaSql().Connect(banco);

			String query = "INSERT INTO ufarm_contas VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL

			PreparedStatement ppStm = conn.prepareStatement(query.toString());//PRepara a query para rodar




			ppStm.setInt(1, Aquisicao.getIdProp());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setInt(2, Aquisicao.getId());
			ppStm.setInt(3, 0);
			ppStm.setInt(4, 0);
			ppStm.setDate(5, new java.sql.Date(Aquisicao.getData().getTime()));
			ppStm.setString(6, "");
			ppStm.setString(7, Aquisicao.getCategoria());
			ppStm.setString(8, "");
			ppStm.setInt(9, Aquisicao.getNf());
			ppStm.setInt(10, 0);
			ppStm.setInt(11, 0);
			ppStm.setString(12, Aquisicao.getValorTotal());
			ppStm.setString(13, "0000-00-00");
			ppStm.setInt(14, 0);
			ppStm.setString(15, "0000-00-00");

			ppStm.execute(); //Executa o comando

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD

	}
	
	public boolean AtualizarConta(UfarmContas contas){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = " UPDATE ufarm_contas SET id_prop = ?, id_aquisicao = ?, id_despesas = ?, data_aquisicao = ?, despesas = ?, categoria = ?, "+
						   " forma_pgto = ?, nf = ?, qtd_parcelas= ?, parcela = ?, valor = ?, data_vencimento = ?, pago = ?, data_pgto "; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, contas.getIdProp());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setInt(2, contas.getIdAquisicao());
			ppStm.setInt(3, contas.getIdDespesa());
			ppStm.setString(4, contas.getDataAquisicao());
			ppStm.setString(5, contas.getDespesa());
			ppStm.setString(6, contas.getCategoria());
			ppStm.setString(7, contas.getFormaPagto());
			ppStm.setInt(8, contas.getNf());
			ppStm.setInt(9, contas.getQtdeParcelas());
			ppStm.setInt(10, contas.getParcela());
			ppStm.setString(11, contas.getValor());
			ppStm.setString(12, contas.getDataVencimento());
			ppStm.setInt(13, contas.getPago());
			ppStm.setString(14, contas.getDataPagto());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	
	public boolean excluirConta(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM ufarm_contas WHERE id = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
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
	
	public UfarmContas buscaConta(int id){
		UfarmContas contas = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
		
			String query = "SELECT * FROM ufarm_contas  WHERE id = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setInt(1, id);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				contas = new UfarmContas();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				contas.setId(rSet.getInt(1));
				contas.setIdProp(rSet.getInt(2));
				contas.setIdAquisicao(rSet.getInt(3));
				contas.setIdDespesa(rSet.getInt(4));
				contas.setDataAquisicao(rSet.getString(5));
				contas.setDespesa(rSet.getString(6));
				contas.setCategoria(rSet.getString(7));
				contas.setFormaPagto(rSet.getString(8));
				contas.setNf(rSet.getInt(9));
				contas.setQtdeParcelas(rSet.getInt(10));
				contas.setParcela(rSet.getInt(11));
				contas.setValor(rSet.getString(12));
				contas.setDataVencimento(rSet.getString(13));
				contas.setPago(rSet.getInt(14));
				contas.setDataPagto(rSet.getString(15));
				//
			}
		
			conn.close();// fecha a conexão com o Bd
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return contas;
	}
	
	
	public ArrayList<UfarmContas> buscaTodosUfarmContas(){
		ArrayList<UfarmContas> lista = new ArrayList<UfarmContas>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
			
			String query = "SELECT * FROM ufarm_contas"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				UfarmContas contas = new UfarmContas();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				contas.setId(rSet.getInt(1));
				contas.setIdProp(rSet.getInt(2));
				contas.setIdAquisicao(rSet.getInt(3));
				contas.setIdDespesa(rSet.getInt(4));
				contas.setDataAquisicao(rSet.getString(5));
				contas.setDespesa(rSet.getString(6));
				contas.setCategoria(rSet.getString(7));
				contas.setFormaPagto(rSet.getString(8));
				contas.setNf(rSet.getInt(9));
				contas.setQtdeParcelas(rSet.getInt(10));
				contas.setParcela(rSet.getInt(11));
				contas.setValor(rSet.getString(12));
				contas.setDataVencimento(rSet.getString(13));
				contas.setPago(rSet.getInt(14));
				contas.setDataPagto(rSet.getString(15));
				//
				
				lista.add(contas);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Bd
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

}
