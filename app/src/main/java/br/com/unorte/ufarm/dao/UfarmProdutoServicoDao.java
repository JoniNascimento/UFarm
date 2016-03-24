package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.UfarmProdutoServico;
import br.com.unorte.ufarm.pojo.Usuarios;

public class UfarmProdutoServicoDao {

	private String banco;

	public UfarmProdutoServicoDao(String banco){
		this.banco = banco;
	}
	

	public ArrayList<UfarmProdutoServico> buscaProdServ(String WhereProdServ){
		ArrayList<UfarmProdutoServico> lista = new ArrayList<UfarmProdutoServico>() ;
		UfarmProdutoServico objProdServ = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
		
			String query = "SELECT * FROM ufarm_produtos_servicos  WHERE " + WhereProdServ + " = 1 order by produto_servico"  ; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar

		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query


				objProdServ = new UfarmProdutoServico();// cria um objeto para guardar as informações do banco

				objProdServ.setId(0);
				objProdServ.setProdutoServico("Selcione...");
				lista.add(objProdServ);


			while (rSet.next()) {
				objProdServ = new UfarmProdutoServico();// cria um objeto para guardar as informações do banco

				//Esse Bloco popula o objeto com as informações vindas do banco
				objProdServ.setId(rSet.getInt(1));
				objProdServ.setProdutoServico(rSet.getString(7));
				objProdServ.setCategoria(rSet.getString(8));
				objProdServ.setSubCategoria(rSet.getString(9));
				//

					lista.add(objProdServ);
				}

		
			conn.close();// fecha a conexão com o Bd
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return lista;
	}
	
	


}






 