package br.com.unorte.ufarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.unorte.ufarm.Activity.ConectaSql;
import br.com.unorte.ufarm.pojo.Usuarios;

public class UsuariosDao {
	
	private String banco;
	
	public UsuariosDao(String banco){
		this.banco = banco;
	}
	
	public boolean inserirUsuario(Usuarios usuario){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "INSERT INTO usuarios VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, usuario.getPago());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, usuario.getDataCadastro());
			ppStm.setString(3, usuario.getNome());
			ppStm.setString(4, usuario.getEmail());
			ppStm.setString(5, usuario.getTel());
			ppStm.setString(6, usuario.getDoc());
			ppStm.setString(7, usuario.getTipoUser());
			ppStm.setString(8, usuario.getEmpresa());
			ppStm.setString(9, usuario.getRamoAtividade());
			ppStm.setString(10, usuario.getInstituicao());
			ppStm.setString(11, usuario.getCurso());
			ppStm.setInt(12, usuario.getRa());
			ppStm.setString(13, usuario.getUsuario());
			ppStm.setString(14, usuario.getSenha());
			ppStm.setString(15, usuario.getConhecimento());
			ppStm.setString(16, usuario.getRepresentante());
			ppStm.setInt(17, usuario.getMaisInfo());
			ppStm.setInt(18, usuario.getEmailInfo());
			ppStm.setString(19, usuario.getInteresse());
			ppStm.setInt(20, usuario.getOp1());
			ppStm.setInt(21, usuario.getOp2());
			ppStm.setInt(22, usuario.getOp3());
			ppStm.setInt(23, usuario.getOp4());
			ppStm.setInt(24, usuario.getOp5());
			ppStm.setInt(25, usuario.getOp6());
			ppStm.setString(26, usuario.getContrato());
			ppStm.setString(27, usuario.getTotal());
			ppStm.setString(28, usuario.getFormaPgto());			
			
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	public boolean AtualizarUsuario(Usuarios usuario){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = " UPDATE usuarios SET pago = ?, dataCadastro = ?, nome = ?, email = ?, tel = ?, doc = ?, "+
						   " tipoUser = ?, empresa = ?, ramoAtividade= ?, instituicao = ?, curso = ?, ra = ?, usuario = ?, "+
						   " senha = ?, conhecimento = ?, representante = ?, maisInfo = ?, emailInfo = ?, interesse = ?, "+
						   " op1 = ?, op2 = ?, op3 = ?, op4 = ?, op5= ?, op6 = ?, contrato = ?, total = ?, formaPgto = ? "; // Variavel simples String que recebe o nosso comando SQL
		    
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ppStm.setInt(1, usuario.getPago());// Essa linha popula as variaves do insert "?" de acordo com seu tipo
			ppStm.setString(2, usuario.getDataCadastro());
			ppStm.setString(3, usuario.getNome());
			ppStm.setString(4, usuario.getEmail());
			ppStm.setString(5, usuario.getTel());
			ppStm.setString(6, usuario.getDoc());
			ppStm.setString(7, usuario.getTipoUser());
			ppStm.setString(8, usuario.getEmpresa());
			ppStm.setString(9, usuario.getRamoAtividade());
			ppStm.setString(10, usuario.getInstituicao());
			ppStm.setString(11, usuario.getCurso());
			ppStm.setInt(12, usuario.getRa());
			ppStm.setString(13, usuario.getUsuario());
			ppStm.setString(14, usuario.getSenha());
			ppStm.setString(15, usuario.getConhecimento());
			ppStm.setString(16, usuario.getRepresentante());
			ppStm.setInt(17, usuario.getMaisInfo());
			ppStm.setInt(18, usuario.getEmailInfo());
			ppStm.setString(19, usuario.getInteresse());
			ppStm.setInt(20, usuario.getOp1());
			ppStm.setInt(21, usuario.getOp2());
			ppStm.setInt(22, usuario.getOp3());
			ppStm.setInt(23, usuario.getOp4());
			ppStm.setInt(24, usuario.getOp5());
			ppStm.setInt(25, usuario.getOp6());
			ppStm.setString(26, usuario.getContrato());
			ppStm.setString(27, usuario.getTotal());
			ppStm.setString(28, usuario.getFormaPgto());
			ppStm.executeUpdate(query); //Executa o comando
			
			return true;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}//Cria e abre a conexão com o BD 
			
	}
	
	
	public boolean excluirUsuario(int id){
		
		try {
			Connection conn = new ConectaSql().Connect(banco);
			
			String query = "DELETE FROM usuarios WHERE id = ?)"; // Variavel simples String que recebe o nosso comando SQL
		    
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
	
	public Usuarios buscaUsuario(String usuario,String senha){
		Usuarios user = null;
	
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
		
			String query = "SELECT * FROM usuarios  WHERE usuario = ? and senha = ?"; // Variavel simples String que recebe o nosso comando SQL
		
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
		
			ppStm.setString(1, usuario);
			ppStm.setString(2, senha);
		
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
		
			if (rSet.next()){
				user = new Usuarios();// cria um objeto para guardar as informações do banco
			
				//Esse Bloco popula o objeto com as informações vindas do banco
				user.setId(rSet.getInt(1));
				user.setPago(rSet.getInt(2));
				//user.setDataCadastro(rSet.getString(3));
				user.setNome(rSet.getString(4));
				user.setEmail(rSet.getString(5));
				user.setTel(rSet.getString(6));
				user.setDoc(rSet.getString(7));
				user.setTipoUser(rSet.getString(8));
				user.setEmpresa(rSet.getString(9));
				user.setRamoAtividade(rSet.getString(10));
				user.setInstituicao(rSet.getString(11));
				user.setCurso(rSet.getString(12));
				user.setRa(rSet.getInt(13));
				user.setUsuario(rSet.getString(14));
				user.setSenha(rSet.getString(15));
				user.setConhecimento(rSet.getString(16));
				user.setRepresentante(rSet.getString(17));
				user.setMaisInfo(rSet.getInt(18));
				user.setEmailInfo(rSet.getInt(19));
				user.setInteresse(rSet.getString(20));
				user.setOp1(rSet.getInt(21));
				user.setOp2(rSet.getInt(22));
				user.setOp3(rSet.getInt(23));
				user.setOp4(rSet.getInt(24));
				user.setOp5(rSet.getInt(25));
				user.setOp6(rSet.getInt(26));
				user.setContrato(rSet.getString(27));
				user.setTotal(rSet.getString(28));
				user.setFormaPgto(rSet.getString(29));
				//
			}
		
			conn.close();// fecha a conexão com o Bd
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		return user;
	}
	
	
	public ArrayList<Usuarios> buscaTodosUsuarios(){
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		
		try {
			Connection conn = new ConectaSql().Connect(banco);//Cria e abre a conexão com o BD 
			
			String query = "SELECT * FROM usuarios"; // Variavel simples String que recebe o nosso comando SQL
			
			PreparedStatement ppStm = conn.prepareStatement(query);//PRepara a query para rodar
			
			ResultSet rSet = ppStm.executeQuery();// O Result set recebe o resultado da query
			
			//O while roda e verifica ate quando for o final da query
			while (rSet.next()){ 
				Usuarios user = new Usuarios();// cria um objeto para guardar as informações do banco
				
				//Esse Bloco popula o objeto com as informações vindas do banco
				user.setId(rSet.getInt(1));
				user.setPago(rSet.getInt(2));
				//user.setDataCadastro(rSet.getString(3));
				user.setNome(rSet.getString(4));
				user.setEmail(rSet.getString(5));
				user.setTel(rSet.getString(6));
				user.setDoc(rSet.getString(7));
				user.setTipoUser(rSet.getString(8));
				user.setEmpresa(rSet.getString(9));
				user.setRamoAtividade(rSet.getString(10));
				user.setInstituicao(rSet.getString(11));
				user.setCurso(rSet.getString(12));
				user.setRa(rSet.getInt(13));
				user.setUsuario(rSet.getString(14));
				user.setSenha(rSet.getString(15));
				user.setConhecimento(rSet.getString(16));
				user.setRepresentante(rSet.getString(17));
				user.setMaisInfo(rSet.getInt(18));
				user.setEmailInfo(rSet.getInt(19));
				user.setInteresse(rSet.getString(20));
				user.setOp1(rSet.getInt(21));
				user.setOp2(rSet.getInt(22));
				user.setOp3(rSet.getInt(23));
				user.setOp4(rSet.getInt(24));
				user.setOp5(rSet.getInt(25));
				user.setOp6(rSet.getInt(26));
				user.setContrato(rSet.getString(27));
				user.setTotal(rSet.getString(28));
				user.setFormaPgto(rSet.getString(29));
				//
				
				lista.add(user);// Adiciona o objeto todo na lista 
			}
			
			conn.close();// fecha a conexão com o Bd
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

}






 