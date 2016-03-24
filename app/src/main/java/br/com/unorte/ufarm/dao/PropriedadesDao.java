package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.Propriedades;

public class PropriedadesDao {
	
	private String banco;
	
	public PropriedadesDao(String banco){
		this.banco = banco;
	}
	
	
	
	public boolean inserirPropriedade(Propriedades propriedade){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "INSERT INTO propriedades VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, propriedade.getIdAss());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setInt(2, propriedade.getIdUser());
			ppStm.setString(3, propriedade.getProp());
			ppStm.setString(4, propriedade.getDenominacao());
			ppStm.setString(5, propriedade.getUsuario());
			ppStm.setString(6, propriedade.getSenha());
			ppStm.setInt(7, propriedade.getCadastro());
			ppStm.setInt(8, propriedade.getRelatorios());
			ppStm.setInt(9, propriedade.getProducao());
			ppStm.setInt(10, propriedade.getContabil());
			ppStm.setInt(11, propriedade.getPainelProdutivo());
			ppStm.setInt(12, propriedade.getMapa());
			ppStm.setInt(13, propriedade.getGrafico());
			ppStm.setInt(14, propriedade.getPlanejamento());
			ppStm.setInt(15, propriedade.getChat());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	public boolean AtualizarPropriedade(Propriedades propriedade){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = " UPDATE propriedades SET id_ass = ?, id_user = ?, prop = ?, denominacao = ?, usuario = ?, senha = ?, cadastro = ?, "+
						   " relatorios = ?, producao = ?, contabil= ?, painel_produtivo = ?, mapa = ?, grafico = ?, planejamento = ?, chat = ? "; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, propriedade.getIdAss());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setInt(2, propriedade.getIdUser());
			ppStm.setString(3, propriedade.getProp());
			ppStm.setString(4, propriedade.getDenominacao());
			ppStm.setString(5, propriedade.getUsuario());
			ppStm.setString(6, propriedade.getSenha());
			ppStm.setInt(7, propriedade.getCadastro());
			ppStm.setInt(8, propriedade.getRelatorios());
			ppStm.setInt(9, propriedade.getProducao());
			ppStm.setInt(10, propriedade.getContabil());
			ppStm.setInt(11, propriedade.getPainelProdutivo());
			ppStm.setInt(12, propriedade.getMapa());
			ppStm.setInt(13, propriedade.getGrafico());
			ppStm.setInt(14, propriedade.getPlanejamento());
			ppStm.setInt(15, propriedade.getChat());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	
	public boolean excluirPropriedade(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM propriedades WHERE id = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
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
	
	public ArrayList<Propriedades> buscaPropriedade(int idUser){
		ArrayList<Propriedades> lista = new ArrayList<Propriedades>();
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
		
			String query = "SELECT * FROM propriedades  WHERE id_user = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setInt(1, idUser);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			
			while (rSet.next()){ 
				Propriedades propriedade = new Propriedades();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				propriedade.setId(rSet.getInt(1));
				propriedade.setIdAss(rSet.getInt(2));
				propriedade.setIdUser(rSet.getInt(3));
				propriedade.setProp(rSet.getString(4));
				propriedade.setDenominacao(rSet.getString(5));
				propriedade.setUsuario(rSet.getString(6));
				propriedade.setSenha(rSet.getString(7));
				propriedade.setCadastro(rSet.getInt(8));
				propriedade.setRelatorios(rSet.getInt(9));
				propriedade.setProducao(rSet.getInt(10));
				propriedade.setContabil(rSet.getInt(11));
				propriedade.setPainelProdutivo(rSet.getInt(12));
				propriedade.setMapa(rSet.getInt(13));
				propriedade.setGrafico(rSet.getInt(14));
				propriedade.setPlanejamento(rSet.getInt(15));
				propriedade.setChat(rSet.getInt(16));
				//
				
				lista.add(propriedade);
			}
		
			conn.close();// fecha a conexão com o Bd
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return lista;
	}


	public ArrayList<Propriedades> buscaPropriedadeImovel(int idUser){
		ArrayList<Propriedades> lista = new ArrayList<Propriedades>();

		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD

			String query = "    select  unorteco_geral.propriedades.*, "+banco+".ufarm_imoveis.denominacao as nomeImovel   "+
					       "      from unorteco_geral.propriedades    "+
						   " left join "+banco+".ufarm_imoveis on "+banco+".ufarm_imoveis.id_prop = unorteco_geral.propriedades.id "+
						   "     where unorteco_geral.propriedades.id_user = ?"+
						   " order by id    "	 ; // Variavel simples String que recebe o nosso comando SQL

			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar

			ppStm.setInt(1, idUser);

			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query


			while (rSet.next()){
				Propriedades propriedade = new Propriedades();// cria um objeto para guardar as informações do banco

				//Esse Bloco popula o objeto com as informações vindas do banco

				if (rSet.getString(17) != null){

					propriedade.setProp(rSet.getString(17));

				}else
				{

					propriedade.setProp(rSet.getString(4));
				}
				propriedade.setId(rSet.getInt(1));
				propriedade.setIdAss(rSet.getInt(2));
				propriedade.setIdUser(rSet.getInt(3));

				propriedade.setDenominacao(rSet.getString(5));
				propriedade.setUsuario(rSet.getString(6));
				propriedade.setSenha(rSet.getString(7));
				propriedade.setCadastro(rSet.getInt(8));
				propriedade.setRelatorios(rSet.getInt(9));
				propriedade.setProducao(rSet.getInt(10));
				propriedade.setContabil(rSet.getInt(11));
				propriedade.setPainelProdutivo(rSet.getInt(12));
				propriedade.setMapa(rSet.getInt(13));
				propriedade.setGrafico(rSet.getInt(14));
				propriedade.setPlanejamento(rSet.getInt(15));
				propriedade.setChat(rSet.getInt(16));
				//

				lista.add(propriedade);
			}

			conn.close();// fecha a conexão com o Bd

		} catch (Exception e) {
			e.printStackTrace();
		}


		return lista;
	}
	public Propriedades buscaPropriedadeLogin(String usuario, String senha){
		Propriedades propriedade = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
		
			String query = "SELECT * FROM propriedades  WHERE usuario = ? and senha =? "; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setString(1, usuario);
			ppStm.setString(2, senha);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				propriedade = new Propriedades();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				propriedade.setId(rSet.getInt(1));
				propriedade.setIdAss(rSet.getInt(2));
				propriedade.setIdUser(rSet.getInt(3));
				propriedade.setProp(rSet.getString(4));
				propriedade.setDenominacao(rSet.getString(5));
				propriedade.setUsuario(rSet.getString(6));
				propriedade.setSenha(rSet.getString(7));
				propriedade.setCadastro(rSet.getInt(8));
				propriedade.setRelatorios(rSet.getInt(9));
				propriedade.setProducao(rSet.getInt(10));
				propriedade.setContabil(rSet.getInt(11));
				propriedade.setPainelProdutivo(rSet.getInt(12));
				propriedade.setMapa(rSet.getInt(13));
				propriedade.setGrafico(rSet.getInt(14));
				propriedade.setPlanejamento(rSet.getInt(15));
				propriedade.setChat(rSet.getInt(16));
				//
			}
		
			conn.close();// fecha a conexão com o Bd
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return propriedade;
	}
	
	
	public ArrayList<Propriedades> buscaTodosPropriedades(){
		ArrayList<Propriedades> lista = new ArrayList<Propriedades>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
			
			String query = "SELECT * FROM propriedades"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				Propriedades propriedade = new Propriedades();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				//Esse Bloco popula o objeto com as informações vindas do banco
				propriedade.setId(rSet.getInt(1));
				propriedade.setIdAss(rSet.getInt(2));
				propriedade.setIdUser(rSet.getInt(3));
				propriedade.setProp(rSet.getString(4));
				propriedade.setDenominacao(rSet.getString(5));
				propriedade.setUsuario(rSet.getString(6));
				propriedade.setSenha(rSet.getString(7));
				propriedade.setCadastro(rSet.getInt(8));
				propriedade.setRelatorios(rSet.getInt(9));
				propriedade.setProducao(rSet.getInt(10));
				propriedade.setContabil(rSet.getInt(11));
				propriedade.setPainelProdutivo(rSet.getInt(12));
				propriedade.setMapa(rSet.getInt(13));
				propriedade.setGrafico(rSet.getInt(14));
				propriedade.setPlanejamento(rSet.getInt(15));
				propriedade.setChat(rSet.getInt(16));
				//
				
				lista.add(propriedade);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Bd
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

}
