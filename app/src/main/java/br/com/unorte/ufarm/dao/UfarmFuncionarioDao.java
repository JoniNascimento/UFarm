package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.UfarmFuncionarios;

public class UfarmFuncionarioDao {
	
	private String banco;
	
	public UfarmFuncionarioDao(String banco){
		this.banco = banco;
	}
	
	
	public boolean inserirFuncionario(UfarmFuncionarios funcionario){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "INSERT INTO ufarm_funcionario VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, funcionario.getIdProp());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, funcionario.getNome());
			ppStm.setString(3, funcionario.getTel());
			ppStm.setString(4, funcionario.getCel());
			ppStm.setString(5, funcionario.getEmail());
			ppStm.setString(6, funcionario.getEndereco());
			ppStm.setInt(7, funcionario.getNumeroEndereco());
			ppStm.setString(8, funcionario.getCargo());
			ppStm.setString(9, funcionario.getQualificacoes());
			ppStm.setString(10, funcionario.getCtps());
			ppStm.setString(11, funcionario.getPis());
			ppStm.setString(12, funcionario.getTituloEleitor());
			ppStm.setString(13, funcionario.getDataNascimento());
			ppStm.setString(14, funcionario.getDataAdmissao());
			ppStm.setString(14, funcionario.getSalario());
			ppStm.setInt(15, funcionario.getComissao());
			ppStm.setInt(16, funcionario.getProdutividade());
			ppStm.setInt(17, funcionario.getFgts());
			ppStm.setInt(18, funcionario.getInss());
			ppStm.setInt(19, funcionario.getSalarioEducacao());
			ppStm.setInt(20, funcionario.getRisco1());
			ppStm.setInt(21, funcionario.getRisco2());
			ppStm.setInt(22, funcionario.getRisco3());
			ppStm.setInt(23, funcionario.getContrTerceiros());
			ppStm.setString(24, funcionario.getVt());
			ppStm.setString(25, funcionario.getVr());
			ppStm.setString(26, funcionario.getVa());
			ppStm.setString(27, funcionario.getTotalComplementos());
			ppStm.setString(28, funcionario.getTotalEncargos());
			ppStm.setString(29, funcionario.getTotalBeneficios());
			ppStm.setString(30, funcionario.getFolha());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	public boolean AtualizarFuncionario(UfarmFuncionarios funcionario){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = " UPDATE ufarm_funcionario SET id_prop = ?, nome = ?, tel = ?, cel = ?, email = ?, endereco = ?, numero = ?, cargo = ?, qualificacoes = ?  "+
						   " ctps = ?, pis = ?, titulo_eleitor= ?, dn = ?, da = ?, salario = ?, comissao = ?, produtividade = ?, fgts = ?, inss = ?, salario_educacao = ? "+
					       " risco1 = ?, risco1=?, risco3 = ?, contr_terceiros = ?, vt = ?, vr = ?, va = ?, total_complementos = ?, total_encargos = ?, total_beneficios = ? "+
						   " folha = ?  "; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, funcionario.getIdProp());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, funcionario.getNome());
			ppStm.setString(3, funcionario.getTel());
			ppStm.setString(4, funcionario.getCel());
			ppStm.setString(5, funcionario.getEmail());
			ppStm.setString(6, funcionario.getEndereco());
			ppStm.setInt(7, funcionario.getNumeroEndereco());
			ppStm.setString(8, funcionario.getCargo());
			ppStm.setString(9, funcionario.getQualificacoes());
			ppStm.setString(10, funcionario.getCtps());
			ppStm.setString(11, funcionario.getPis());
			ppStm.setString(12, funcionario.getTituloEleitor());
			ppStm.setString(13, funcionario.getDataNascimento());
			ppStm.setString(14, funcionario.getDataAdmissao());
			ppStm.setString(15, funcionario.getSalario());
			ppStm.setInt(16, funcionario.getComissao());
			ppStm.setInt(17, funcionario.getProdutividade());
			ppStm.setInt(18, funcionario.getFgts());
			ppStm.setInt(19, funcionario.getInss());
			ppStm.setInt(20, funcionario.getSalarioEducacao());
			ppStm.setInt(21, funcionario.getRisco1());
			ppStm.setInt(22, funcionario.getRisco2());
			ppStm.setInt(23, funcionario.getRisco3());
			ppStm.setInt(24, funcionario.getContrTerceiros());
			ppStm.setString(25, funcionario.getVt());
			ppStm.setString(26, funcionario.getVr());
			ppStm.setString(27, funcionario.getVa());
			ppStm.setString(28, funcionario.getTotalComplementos());
			ppStm.setString(29, funcionario.getTotalEncargos());
			ppStm.setString(30, funcionario.getTotalBeneficios());
			ppStm.setString(31, funcionario.getFolha());
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	
	public boolean excluirFuncionario(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM ufarm_funcionario WHERE id = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
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
	
	public UfarmFuncionarios buscaFuncionario(int id){
		UfarmFuncionarios funcionario = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
		
			String query = "SELECT * FROM ufarm_funcionario  WHERE id = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setInt(1, id);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				funcionario = new UfarmFuncionarios();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				funcionario.setId(rSet.getInt(1));
				funcionario.setIdProp(rSet.getInt(2));
				funcionario.setNome(rSet.getString(3));
				funcionario.setTel(rSet.getString(4));
				funcionario.setCel(rSet.getString(5));
				funcionario.setEmail(rSet.getString(6));
				funcionario.setEndereco(rSet.getString(7));
				funcionario.setNumeroEndereco(rSet.getInt(8));
				funcionario.setCargo(rSet.getString(9));
				funcionario.setQualificacoes(rSet.getString(10));
				funcionario.setCtps(rSet.getString(11));
				funcionario.setPis(rSet.getString(12));
				funcionario.setTituloEleitor(rSet.getString(13));
				funcionario.setDataNascimento(rSet.getString(14));
				funcionario.setDataAdmissao(rSet.getString(15));
				funcionario.setSalario(rSet.getString(16));
				funcionario.setComissao(rSet.getInt(17));
				funcionario.setProdutividade(rSet.getInt(18));
				funcionario.setFgts(rSet.getInt(19));
				funcionario.setInss(rSet.getInt(20));
				funcionario.setSalarioEducacao(rSet.getInt(21));
				funcionario.setRisco1(rSet.getInt(22));
				funcionario.setRisco2(rSet.getInt(23));
				funcionario.setRisco3(rSet.getInt(24));
				funcionario.setContrTerceiros(rSet.getInt(25));
				funcionario.setVt(rSet.getString(26));
				funcionario.setVr(rSet.getString(27));
				funcionario.setVa(rSet.getString(28));
				funcionario.setTotalComplementos(rSet.getString(29));
				funcionario.setTotalEncargos(rSet.getString(30));
				funcionario.setTotalBeneficios(rSet.getString(31));
				funcionario.setFolha(rSet.getString(32));
				
				//
			}
		
			conn.close();// fecha a conexão com o Bd
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return funcionario;
	}
	
	
	public ArrayList<UfarmFuncionarios> buscaTodosUfarmFuncionarios(){
		ArrayList<UfarmFuncionarios> lista = new ArrayList<UfarmFuncionarios>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
			
			String query = "SELECT * FROM ufarm_funcionario"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				UfarmFuncionarios funcionario = new UfarmFuncionarios();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				funcionario.setId(rSet.getInt(1));
				funcionario.setIdProp(rSet.getInt(2));
				funcionario.setNome(rSet.getString(3));
				funcionario.setTel(rSet.getString(4));
				funcionario.setCel(rSet.getString(5));
				funcionario.setEmail(rSet.getString(6));
				funcionario.setEndereco(rSet.getString(7));
				funcionario.setNumeroEndereco(rSet.getInt(8));
				funcionario.setCargo(rSet.getString(9));
				funcionario.setQualificacoes(rSet.getString(10));
				funcionario.setCtps(rSet.getString(11));
				funcionario.setPis(rSet.getString(12));
				funcionario.setTituloEleitor(rSet.getString(13));
				funcionario.setDataNascimento(rSet.getString(14));
				funcionario.setDataAdmissao(rSet.getString(15));
				funcionario.setSalario(rSet.getString(16));
				funcionario.setComissao(rSet.getInt(17));
				funcionario.setProdutividade(rSet.getInt(18));
				funcionario.setFgts(rSet.getInt(19));
				funcionario.setInss(rSet.getInt(20));
				funcionario.setSalarioEducacao(rSet.getInt(21));
				funcionario.setRisco1(rSet.getInt(22));
				funcionario.setRisco2(rSet.getInt(23));
				funcionario.setRisco3(rSet.getInt(24));
				funcionario.setContrTerceiros(rSet.getInt(25));
				funcionario.setVt(rSet.getString(26));
				funcionario.setVr(rSet.getString(27));
				funcionario.setVa(rSet.getString(28));
				funcionario.setTotalComplementos(rSet.getString(29));
				funcionario.setTotalEncargos(rSet.getString(30));
				funcionario.setTotalBeneficios(rSet.getString(31));
				funcionario.setFolha(rSet.getString(32));
				//
				
				lista.add(funcionario);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Bd
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

}
