package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.Bds;
import br.com.unorte.ufarm.pojo.UfarmImoveis;

public class UfarmImoveisDao {
	
	private String banco;
	
	public UfarmImoveisDao(String banco){
		this.banco = banco;
	}



	public boolean inserirImovel(UfarmImoveis imovel){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "INSERT INTO ufarm_imoveis VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, imovel.getIdProp());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, imovel.getDataCompra());
			ppStm.setInt(3, imovel.getTempoUso());
			ppStm.setString(4, imovel.getTempo());
			ppStm.setString(5, imovel.getTipoImovel());
			ppStm.setString(6, imovel.getPorteImovel());
			ppStm.setString(7, imovel.getEndereco());
			ppStm.setInt(8, imovel.getNumeroEndereco());
			ppStm.setString(9, imovel.getUf());
			ppStm.setString(10, imovel.getCidade());
			ppStm.setString(11, imovel.getDenominacao());
			ppStm.setInt(12, imovel.getCcir());
			ppStm.setInt(13, imovel.getMatricula());
			ppStm.setString(14, imovel.getUnMedida());
			ppStm.setString(15, imovel.getAreaTotal());
			ppStm.setString(16, imovel.getAreaArrendada());
			ppStm.setString(17, imovel.getAreaParceira());
			ppStm.setString(18, imovel.getAreaTotalGeral());
			ppStm.setString(19, imovel.getSedeBenfeitoria());
			ppStm.setString(20, imovel.getExtTotalCursos());
			ppStm.setString(21, imovel.getExtTotalRepresaveis());
			ppStm.setString(22, imovel.getAppNecessaria());
			ppStm.setString(23, imovel.getAppExistente());
			ppStm.setString(24, imovel.getStatusApp());
			ppStm.setString(25, imovel.getRoteiroAcesso());
			ppStm.setString(26, imovel.getCondicoesAcesso());
			ppStm.setString(27, imovel.getDistImovelCapital());
			ppStm.setString(28, imovel.getAtividadePrincipal());
			ppStm.setString(29, imovel.getAtividadeSecundaria());
			ppStm.setString(30, imovel.getOutraAtividade());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	public boolean AtualizarImovel(UfarmImoveis imovel){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			 String query = " UPDATE ufarm_imoveis SET idProp = ?,  dataCompra = ?,  tempoUso = ?,  tempo = ?,  tipoImovel = ?, "+
						   "  porteImovel = ?,  endereco = ?,  numeroEndereco = ?,  uf = ?,  cidade = ?,  denominacao = ?,  "+
						   "  ccir = ?,  matricula = ?,  unMedida = ?,  areaTotal = ?,  areaArrendada = ?,  areaParceira = ?,  "+
						   "  areaTotalGeral = ?,  sedeBenfeitoria = ?,  extTotalCursos = ?,  extTotalRepresaveis = ?,  "+
						   "  appNecessaria = ?,  appExistente = ?,  statusApp = ?,  roteiroAcesso = ?,  condicoesAcesso = ?,  "+
						   "  distImovelCapital = ?,  atividadePrincipal = ?,  atividadeSecundaria = ?,  outraAtividade = ? "; // Variavel simples  que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, imovel.getIdProp());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, imovel.getDataCompra());
			ppStm.setInt(3, imovel.getTempoUso());
			ppStm.setString(4, imovel.getTempo());
			ppStm.setString(5, imovel.getTipoImovel());
			ppStm.setString(6, imovel.getPorteImovel());
			ppStm.setString(7, imovel.getEndereco());
			ppStm.setInt(8, imovel.getNumeroEndereco());
			ppStm.setString(9, imovel.getUf());
			ppStm.setString(10, imovel.getCidade());
			ppStm.setString(11, imovel.getDenominacao());
			ppStm.setInt(12, imovel.getCcir());
			ppStm.setInt(13, imovel.getMatricula());
			ppStm.setString(14, imovel.getUnMedida());
			ppStm.setString(15, imovel.getAreaTotal());
			ppStm.setString(16, imovel.getAreaArrendada());
			ppStm.setString(17, imovel.getAreaParceira());
			ppStm.setString(18, imovel.getAreaTotalGeral());
			ppStm.setString(19, imovel.getSedeBenfeitoria());
			ppStm.setString(20, imovel.getExtTotalCursos());
			ppStm.setString(21, imovel.getExtTotalRepresaveis());
			ppStm.setString(22, imovel.getAppNecessaria());
			ppStm.setString(23, imovel.getAppExistente());
			ppStm.setString(24, imovel.getStatusApp());
			ppStm.setString(25, imovel.getRoteiroAcesso());
			ppStm.setString(26, imovel.getCondicoesAcesso());
			ppStm.setString(27, imovel.getDistImovelCapital());
			ppStm.setString(28, imovel.getAtividadePrincipal());
			ppStm.setString(29, imovel.getAtividadeSecundaria());
			ppStm.setString(30, imovel.getOutraAtividade());
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	
	public boolean excluirImovel(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM ufarm_imoveis WHERE id = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
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
	
	public UfarmImoveis buscaImovel(int id){
		UfarmImoveis imovel = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
		
			String query = "SELECT * FROM ufarm_imoveis  WHERE id_prop = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setInt(1, id);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				imovel = new UfarmImoveis();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do bancimovel.setTempo(rSet.getInt(1));o
				imovel.setId(rSet.getInt(1));
				imovel.setIdProp(rSet.getInt(2));
				imovel.setDataCompra(rSet.getString(3));
				imovel.setTempoUso(rSet.getInt(4));
				imovel.setTempo(rSet.getString(5));
				imovel.setTipoImovel(rSet.getString(6));
				imovel.setPorteImovel(rSet.getString(7));
				imovel.setEndereco(rSet.getString(8));
				imovel.setNumeroEndereco(rSet.getInt(9));
				imovel.setUf(rSet.getString(10));
				imovel.setCidade(rSet.getString(11));
				imovel.setDenominacao(rSet.getString(12));
				imovel.setCcir(rSet.getInt(13));
				imovel.setMatricula(rSet.getInt(14));
				imovel.setUnMedida(rSet.getString(15));
				imovel.setAreaTotal(rSet.getString(16));
				imovel.setAreaArrendada(rSet.getString(17));
				imovel.setAreaParceira(rSet.getString(18));
				imovel.setAreaTotalGeral(rSet.getString(19));
				imovel.setSedeBenfeitoria(rSet.getString(20));
				imovel.setExtTotalCursos(rSet.getString(21));
				imovel.setExtTotalRepresaveis(rSet.getString(22));
				imovel.setAppNecessaria(rSet.getString(23));
				imovel.setAppExistente(rSet.getString(24));
				imovel.setStatusApp(rSet.getString(25));
				imovel.setRoteiroAcesso(rSet.getString(26));
				imovel.setCondicoesAcesso(rSet.getString(27));
				imovel.setDistImovelCapital(rSet.getString(28));
				imovel.setAtividadePrincipal(rSet.getString(29));
				imovel.setAtividadeSecundaria(rSet.getString(30));
				imovel.setOutraAtividade(rSet.getString(31));
				//
			}
		
			conn.close();// fecha a conexão com o Bd
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return imovel;
	}
	
	
	public ArrayList<UfarmImoveis> buscaTodosUfarmImoveis(){
		ArrayList<UfarmImoveis> lista = new ArrayList<UfarmImoveis>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
			
			String query = "SELECT * FROM imovel"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				UfarmImoveis imovel = new UfarmImoveis();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				imovel.setId(rSet.getInt(1));
				imovel.setIdProp(rSet.getInt(2));
				imovel.setDataCompra(rSet.getString(3));
				imovel.setTempoUso(rSet.getInt(4));
				imovel.setTempo(rSet.getString(5));
				imovel.setTipoImovel(rSet.getString(6));
				imovel.setPorteImovel(rSet.getString(7));
				imovel.setEndereco(rSet.getString(8));
				imovel.setNumeroEndereco(rSet.getInt(9));
				imovel.setUf(rSet.getString(10));
				imovel.setCidade(rSet.getString(11));
				imovel.setDenominacao(rSet.getString(12));
				imovel.setCcir(rSet.getInt(13));
				imovel.setMatricula(rSet.getInt(14));
				imovel.setUnMedida(rSet.getString(15));
				imovel.setAreaTotal(rSet.getString(16));
				imovel.setAreaArrendada(rSet.getString(17));
				imovel.setAreaParceira(rSet.getString(18));
				imovel.setAreaTotalGeral(rSet.getString(19));
				imovel.setSedeBenfeitoria(rSet.getString(20));
				imovel.setExtTotalCursos(rSet.getString(21));
				imovel.setExtTotalRepresaveis(rSet.getString(22));
				imovel.setAppNecessaria(rSet.getString(23));
				imovel.setAppExistente(rSet.getString(24));
				imovel.setStatusApp(rSet.getString(25));
				imovel.setRoteiroAcesso(rSet.getString(26));
				imovel.setCondicoesAcesso(rSet.getString(27));
				imovel.setDistImovelCapital(rSet.getString(28));
				imovel.setAtividadePrincipal(rSet.getString(29));
				imovel.setAtividadeSecundaria(rSet.getString(30));
				imovel.setOutraAtividade(rSet.getString(31));
				//
				
				lista.add(imovel);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Bd
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

	public ArrayList<UfarmImoveis> buscaUfarmImoveis(int id){
		ArrayList<UfarmImoveis> lista = new ArrayList<UfarmImoveis>();

		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD

			String query = "SELECT * FROM imovel"; // Variavel simples String que recebe o nosso comando SQL

			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar

			ppStm.setInt(1, id);

			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query

			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){
				UfarmImoveis imovel = new UfarmImoveis();// cria um objeto para guardar as informações do banco

				//Esse Bloco popula o objeto com as informações vindas do banco
				imovel.setId(rSet.getInt(1));
				imovel.setIdProp(rSet.getInt(2));
				imovel.setDataCompra(rSet.getString(3));
				imovel.setTempoUso(rSet.getInt(4));
				imovel.setTempo(rSet.getString(5));
				imovel.setTipoImovel(rSet.getString(6));
				imovel.setPorteImovel(rSet.getString(7));
				imovel.setEndereco(rSet.getString(8));
				imovel.setNumeroEndereco(rSet.getInt(9));
				imovel.setUf(rSet.getString(10));
				imovel.setCidade(rSet.getString(11));
				imovel.setDenominacao(rSet.getString(12));
				imovel.setCcir(rSet.getInt(13));
				imovel.setMatricula(rSet.getInt(14));
				imovel.setUnMedida(rSet.getString(15));
				imovel.setAreaTotal(rSet.getString(16));
				imovel.setAreaArrendada(rSet.getString(17));
				imovel.setAreaParceira(rSet.getString(18));
				imovel.setAreaTotalGeral(rSet.getString(19));
				imovel.setSedeBenfeitoria(rSet.getString(20));
				imovel.setExtTotalCursos(rSet.getString(21));
				imovel.setExtTotalRepresaveis(rSet.getString(22));
				imovel.setAppNecessaria(rSet.getString(23));
				imovel.setAppExistente(rSet.getString(24));
				imovel.setStatusApp(rSet.getString(25));
				imovel.setRoteiroAcesso(rSet.getString(26));
				imovel.setCondicoesAcesso(rSet.getString(27));
				imovel.setDistImovelCapital(rSet.getString(28));
				imovel.setAtividadePrincipal(rSet.getString(29));
				imovel.setAtividadeSecundaria(rSet.getString(30));
				imovel.setOutraAtividade(rSet.getString(31));
				//

				lista.add(imovel);// Adiciona o objeto todo na lista
			}

			conn.close();// fecha a conexão com o Bd

		} catch (Exception e) {
			e.printStackTrace();
		}


		return lista;
	}

}
