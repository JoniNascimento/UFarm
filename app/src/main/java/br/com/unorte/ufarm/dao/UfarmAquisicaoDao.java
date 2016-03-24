package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.util.Log;
import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.UfarmAquisicoes;

public class UfarmAquisicaoDao {
	
	private String banco;
	
	public UfarmAquisicaoDao(String banco){
		this.banco = banco;
	}
	
public boolean inserirAquisicao(UfarmAquisicoes aquisicao){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
		/*	String query = 	 "INSERT INTO ufarm_aquisicoes (id_prop,data,tipo,prod_servico,categoria,sub_categoria,fornecedor,contrato,cliente,sacas,massa,rpa,nf,		"+
							 "serie,parcela_lote,cfop,impostos,frete,desconto,funcionario,funcao,qtd,area,valor_un,depreciacao,valor_total,quitado,vendido,abatido,			"+
							 "data_venda,valor_venda,negociacao_pgto,negociacao_recebimento,un_medida,benfeitoria,comprimento,id_recurso,modelo,ano,potencia,tipo_pecuaria,	"+
							 "raca,sexo,utilidade,marca_rebanho,local_marca,peso,altura,dn,lote,brinco,vacinacao,sanidade,nome_animal,nome_pai,raca_pai,nome_mae,raca_mae)  "+
							 "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
		    
		    
			String query = 	 "INSERT INTO ufarm_aquisicoes (id, id_prop, data, fornecedor, contrato, impostos, qtd, area, valor_un)  "+
					 "VALUES(null, ?, null, ?, ?, ?, ?, ?, ?)"; // Variavel simples String que recebe o nosso comando SQL*/
			
			String query = 	 "INSERT INTO ufarm_aquisicoes VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL
			
			
			PreparedStatement ppStm = conn.prepareStatement(query.toString());//PRepara a query para rodar
			
			
			
			ppStm.setInt(1, aquisicao.getIdProp());// Essa linha popula as variaves do insert "?" de acordo com seu tipo

            ppStm.setDate(2, new java.sql.Date(aquisicao.getData().getTime()));

			ppStm.setString(3, aquisicao.getTipo());
			ppStm.setString(4, aquisicao.getProdServico());
			ppStm.setString(5, aquisicao.getCategoria());
			ppStm.setString(6, aquisicao.getSubCategoria());
			ppStm.setString(7, aquisicao.getFornecedor());
			ppStm.setString(8, aquisicao.getContrato());
			ppStm.setString(9, aquisicao.getCliente());
			ppStm.setString(10, aquisicao.getSacas());
			ppStm.setString(11, aquisicao.getMassa());
			ppStm.setString(12, aquisicao.getRpa());
			ppStm.setInt(13, aquisicao.getNf());
			ppStm.setInt(14, aquisicao.getSerie());
			ppStm.setInt(15, aquisicao.getParcelaLote());
			ppStm.setString(16, aquisicao.getCfop());
			ppStm.setString(17, aquisicao.getImposto());
			ppStm.setString(18, aquisicao.getFrete());
			ppStm.setString(19, aquisicao.getDesconto());
			ppStm.setInt(20, aquisicao.getFuncionario());
			ppStm.setString(21, aquisicao.getFuncao());
			ppStm.setInt(22, aquisicao.getQtde());
			ppStm.setString(23, aquisicao.getArea());
			ppStm.setString(24, aquisicao.getValorUn());
			ppStm.setString(25, aquisicao.getDepreciacao());
			ppStm.setString(26, aquisicao.getValorTotal());
			ppStm.setInt(27, aquisicao.getQuitado());
			ppStm.setInt(28, aquisicao.getVendido());
			ppStm.setInt(29, aquisicao.getAbatido());
			ppStm.setString(30, aquisicao.getDataVenda());
			ppStm.setString(31, aquisicao.getValorVenda());
			ppStm.setInt(32, aquisicao.getNegociacaoPagto());
			ppStm.setInt(33, aquisicao.getNegociacaoRecebimento());
			ppStm.setString(34, aquisicao.getUnMedida());
			ppStm.setString(35, aquisicao.getBenfeitoria());
			ppStm.setString(36, aquisicao.getComprimento());
			ppStm.setInt(37, aquisicao.getIdRecurso());
			ppStm.setString(38, aquisicao.getModelo());
			ppStm.setInt(39, aquisicao.getAno());
			ppStm.setString(40, aquisicao.getPotencia());
			ppStm.setString(41, aquisicao.getTipoPecuaria());
			ppStm.setString(42, aquisicao.getRaca());
			ppStm.setString(43, aquisicao.getSexo());
			ppStm.setString(44, aquisicao.getUtilidade());
			ppStm.setString(45, aquisicao.getMarcaRebanho());
			ppStm.setString(46, aquisicao.getLocalMarca());
			ppStm.setString(47, aquisicao.getPeso());
			ppStm.setString(48, aquisicao.getAltura());
			ppStm.setString(49, aquisicao.getDataNascimento());
			ppStm.setInt(50, aquisicao.getLote());
			ppStm.setString(51, aquisicao.getBrinco());
			ppStm.setString(52, aquisicao.getVacinacao());
			ppStm.setString(53, aquisicao.getSanitade());
			ppStm.setString(54, aquisicao.getNomeAnimal());
			ppStm.setString(55, aquisicao.getNomePai());
			ppStm.setString(56, aquisicao.getRacaPai());
			ppStm.setString(57, aquisicao.getNomeMae());
			ppStm.setString(58, aquisicao.getRacaMae());			
			
			//ppStm.executeUpdate(query.toString()); //Executa o comando
			ppStm.execute();

			
			conn.close();
			//Insere as informações na tabela contas também afim de futuramente fazer os pagamentos
			UfarmContasDao ContasDao = new UfarmContasDao(banco);
			if (!ContasDao.inserirContasAquisicoes(aquisicao)){
              return false;
            }else {
                return true;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.d("erro", e.getMessage());
			return false;
		}//Cria e abre a conexão com o BD

	}
	
	public boolean AtualizarAquisicao(UfarmAquisicoes aquisicao){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			 String query = " UPDATE aquisicaos  Set idProp = ?,  data = ?,  tipo = ?,  prodServico = ?,  categoria = ?,  "+
					 " subCategoria = ?,  fornecedor = ?,  contrato = ?,  cliente = ?,  sacas = ?,  massa = ?,  "+
					 " rpa = ?,  nf = ?,  serie = ?,  parcelaLote, = ?  cfop = ?,  imposto= ? ,  frete = ?,  desconto = ?,  "+
					 " funcionario = ?,  funcao = ?,  qtde = ?,  area = ?,  valorUn = ?,  depreciacao = ?,  "+
					 " valorTotal = ?,  quitado = ?,  vendido = ?,  dataVenda = ?,  valorVenda = ?,  negociacaoPagto = ?, "+
					 " negociacaoRecebimento = ?,  unMedida = ?,  benfeitoria = ?,  comprimento = ?,  idRecurso = ?,  "+
					 " modelo = ?,  ano = ?,  potencia = ?,  tipoPecuaria = ?,  raca = ?,  sexo = ?,  utilidade = ?,  "+
					 " marcaRebanho = ?,  localMarca = ?,  peso = ?,  altura = ?,  dataNascimento = ?,  lote = ?,  "+
					 " brinco = ?,  vacinacao = ?,  sanitade = ?,  nomePai = ?,  racaPai = ?,  nomeMae = ?,  racaMae = ? "; // Variavel simples  que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, aquisicao.getIdProp());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			//ppStm.setString(2, aquisicao.getData());
			ppStm.setString(3, aquisicao.getTipo());
			ppStm.setString(4, aquisicao.getProdServico());
			ppStm.setString(5, aquisicao.getCategoria());
			ppStm.setString(6, aquisicao.getSubCategoria());
			ppStm.setString(7, aquisicao.getFornecedor());
			ppStm.setString(8, aquisicao.getContrato());
			ppStm.setString(9, aquisicao.getCliente());
			ppStm.setString(10, aquisicao.getSacas());
			ppStm.setString(11, aquisicao.getMassa());
			ppStm.setString(12, aquisicao.getRpa());
			ppStm.setInt(13, aquisicao.getNf());
			ppStm.setInt(14, aquisicao.getSerie());
			ppStm.setInt(15, aquisicao.getParcelaLote());
			ppStm.setString(16, aquisicao.getCfop());
			ppStm.setString(17, aquisicao.getImposto());
			ppStm.setString(18, aquisicao.getFrete());
			ppStm.setString(19, aquisicao.getDesconto());
			ppStm.setInt(20, aquisicao.getFuncionario());
			ppStm.setString(21, aquisicao.getFuncao());
			ppStm.setInt(22, aquisicao.getQtde());
			ppStm.setString(23, aquisicao.getArea());
			ppStm.setString(24, aquisicao.getValorUn());
			ppStm.setString(25, aquisicao.getDepreciacao());
			ppStm.setString(26, aquisicao.getValorTotal());
			ppStm.setInt(27, aquisicao.getQuitado());
			ppStm.setInt(28, aquisicao.getVendido());
			ppStm.setString(29, aquisicao.getDataVenda());
			ppStm.setString(30, aquisicao.getValorVenda());
			ppStm.setInt(31, aquisicao.getNegociacaoPagto());
			ppStm.setInt(32, aquisicao.getNegociacaoRecebimento());
			ppStm.setString(33, aquisicao.getUnMedida());
			ppStm.setString(34, aquisicao.getBenfeitoria());
			ppStm.setString(35, aquisicao.getComprimento());
			ppStm.setInt(36, aquisicao.getIdRecurso());
			ppStm.setString(37, aquisicao.getModelo());
			ppStm.setInt(38, aquisicao.getAno());
			ppStm.setString(39, aquisicao.getPotencia());
			ppStm.setString(40, aquisicao.getTipoPecuaria());
			ppStm.setString(41, aquisicao.getRaca());
			ppStm.setString(42, aquisicao.getSexo());
			ppStm.setString(43, aquisicao.getUtilidade());
			ppStm.setString(44, aquisicao.getMarcaRebanho());
			ppStm.setString(45, aquisicao.getLocalMarca());
			ppStm.setString(46, aquisicao.getPeso());
			ppStm.setString(47, aquisicao.getAltura());
			ppStm.setString(48, aquisicao.getDataNascimento());
			ppStm.setInt(49, aquisicao.getLote());
			ppStm.setString(50, aquisicao.getBrinco());
			ppStm.setString(51, aquisicao.getVacinacao());
			ppStm.setString(52, aquisicao.getSanitade());
			ppStm.setString(53, aquisicao.getNomePai());
			ppStm.setString(54, aquisicao.getRacaPai());
			ppStm.setString(55, aquisicao.getNomeMae());
			ppStm.setString(56, aquisicao.getRacaMae());
			
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	
	public boolean excluirAquisicao(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM aquisicaos WHERE id = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
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
	
	public UfarmAquisicoes buscaAquisicao(int id){
		UfarmAquisicoes aquisicao = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
		
			String query = "SELECT * FROM aquisicaos  WHERE id = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setInt(1, id);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				aquisicao = new UfarmAquisicoes();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				aquisicao.setId(rSet.getInt(1));
				aquisicao.setIdProp(rSet.getInt(2));
				//aquisicao.setData(rSet.getString(3));
				aquisicao.setTipo(rSet.getString(4));
				aquisicao.setProdServico(rSet.getString(5));
				aquisicao.setCategoria(rSet.getString(6));
				aquisicao.setSubCategoria(rSet.getString(7));
				aquisicao.setFornecedor(rSet.getString(8));
				aquisicao.setContrato(rSet.getString(9));
				aquisicao.setCliente(rSet.getString(10));
				aquisicao.setSacas(rSet.getString(11));
			    aquisicao.setMassa(rSet.getString(12));
				aquisicao.setRpa(rSet.getString(13));
				aquisicao.setNf(rSet.getInt(14));
				aquisicao.setSerie(rSet.getInt(15));
				aquisicao.setParcelaLote(rSet.getInt(16));
				aquisicao.setCfop(rSet.getString(17));
				aquisicao.setImposto(rSet.getString(18));
				aquisicao.setFrete(rSet.getString(19));
				aquisicao.setDesconto(rSet.getString(20));
				aquisicao.setFuncionario(rSet.getInt(21));
				aquisicao.setFuncao(rSet.getString(22));
				aquisicao.setQtde(rSet.getInt(23));
			    aquisicao.setArea(rSet.getString(24));
				aquisicao.setValorUn(rSet.getString(25));
				aquisicao.setDepreciacao(rSet.getString(26));
				aquisicao.setValorTotal(rSet.getString(27));
				aquisicao.setQuitado(rSet.getInt(28));
				aquisicao.setVendido(rSet.getInt(29));
				aquisicao.setDataVenda(rSet.getString(30));
				aquisicao.setValorVenda(rSet.getString(31));
				aquisicao.setNegociacaoPagto(rSet.getInt(32));
				aquisicao.setNegociacaoRecebimento(rSet.getInt(33));
			    aquisicao.setUnMedida(rSet.getString(34));
				aquisicao.setBenfeitoria(rSet.getString(35));
				aquisicao.setComprimento(rSet.getString(36));
				aquisicao.setIdRecurso(rSet.getInt(37));
				aquisicao.setModelo(rSet.getString(38));
				aquisicao.setAno(rSet.getInt(39));
				aquisicao.setPotencia(rSet.getString(40));
				aquisicao.setTipoPecuaria(rSet.getString(41));
				aquisicao.setRaca(rSet.getString(42));
				aquisicao.setSexo(rSet.getString(43));
				aquisicao.setUtilidade(rSet.getString(44));
				aquisicao.setMarcaRebanho(rSet.getString(45));
				aquisicao.setLocalMarca(rSet.getString(46));
				aquisicao.setPeso(rSet.getString(47));
				aquisicao.setAltura(rSet.getString(48));
				aquisicao.setDataNascimento(rSet.getString(49));
				aquisicao.setLote(rSet.getInt(50));
				aquisicao.setBrinco(rSet.getString(51));
				aquisicao.setVacinacao(rSet.getString(52));
				aquisicao.setSanitade(rSet.getString(53));
				aquisicao.setNomePai(rSet.getString(54));
				aquisicao.setRacaPai(rSet.getString(55));
			    aquisicao.setNomeMae(rSet.getString(56));
				aquisicao.setRacaMae(rSet.getString(57));
				//
			}
		
			conn.close();// fecha a conexão com o Bd
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return aquisicao;
	}
	
	
	public ArrayList<UfarmAquisicoes> buscaTodosUfarmAquisicoes(){
		ArrayList<UfarmAquisicoes> lista = new ArrayList<UfarmAquisicoes>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
			
			String query = "SELECT * FROM aquisicaos"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				UfarmAquisicoes aquisicao = new UfarmAquisicoes();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				aquisicao.setId(rSet.getInt(1));
				aquisicao.setIdProp(rSet.getInt(2));
				//aquisicao.setData(rSet.getString(3));
				aquisicao.setTipo(rSet.getString(4));
				aquisicao.setProdServico(rSet.getString(5));
				aquisicao.setCategoria(rSet.getString(6));
				aquisicao.setSubCategoria(rSet.getString(7));
				aquisicao.setFornecedor(rSet.getString(8));
				aquisicao.setContrato(rSet.getString(9));
				aquisicao.setCliente(rSet.getString(10));
				aquisicao.setSacas(rSet.getString(11));
			    aquisicao.setMassa(rSet.getString(12));
				aquisicao.setRpa(rSet.getString(13));
				aquisicao.setNf(rSet.getInt(14));
				aquisicao.setSerie(rSet.getInt(15));
				aquisicao.setParcelaLote(rSet.getInt(16));
				aquisicao.setCfop(rSet.getString(17));
				aquisicao.setImposto(rSet.getString(18));
				aquisicao.setFrete(rSet.getString(19));
				aquisicao.setDesconto(rSet.getString(20));
				aquisicao.setFuncionario(rSet.getInt(21));
				aquisicao.setFuncao(rSet.getString(22));
				aquisicao.setQtde(rSet.getInt(23));
			    aquisicao.setArea(rSet.getString(24));
				aquisicao.setValorUn(rSet.getString(25));
				aquisicao.setDepreciacao(rSet.getString(26));
				aquisicao.setValorTotal(rSet.getString(27));
				aquisicao.setQuitado(rSet.getInt(28));
				aquisicao.setVendido(rSet.getInt(29));
				aquisicao.setDataVenda(rSet.getString(30));
				aquisicao.setValorVenda(rSet.getString(31));
				aquisicao.setNegociacaoPagto(rSet.getInt(32));
				aquisicao.setNegociacaoRecebimento(rSet.getInt(33));
			    aquisicao.setUnMedida(rSet.getString(34));
				aquisicao.setBenfeitoria(rSet.getString(35));
				aquisicao.setComprimento(rSet.getString(36));
				aquisicao.setIdRecurso(rSet.getInt(37));
				aquisicao.setModelo(rSet.getString(38));
				aquisicao.setAno(rSet.getInt(39));
				aquisicao.setPotencia(rSet.getString(40));
				aquisicao.setTipoPecuaria(rSet.getString(41));
				aquisicao.setRaca(rSet.getString(42));
				aquisicao.setSexo(rSet.getString(43));
				aquisicao.setUtilidade(rSet.getString(44));
				aquisicao.setMarcaRebanho(rSet.getString(45));
				aquisicao.setLocalMarca(rSet.getString(46));
				aquisicao.setPeso(rSet.getString(47));
				aquisicao.setAltura(rSet.getString(48));
				aquisicao.setDataNascimento(rSet.getString(49));
				aquisicao.setLote(rSet.getInt(50));
				aquisicao.setBrinco(rSet.getString(51));
				aquisicao.setVacinacao(rSet.getString(52));
				aquisicao.setSanitade(rSet.getString(53));
				aquisicao.setNomePai(rSet.getString(54));
				aquisicao.setRacaPai(rSet.getString(55));
			    aquisicao.setNomeMae(rSet.getString(56));
				aquisicao.setRacaMae(rSet.getString(57));
				//
				
				lista.add(aquisicao);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Bd
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}


}
