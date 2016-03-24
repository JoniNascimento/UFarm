package br.com.unorte.ufarm.dao;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Vector;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import br.com.unorte.ufarm.pojo.Usuarios;

public class UsuariosDaoSoap {
	private String banco;
	
	public UsuariosDaoSoap(String banco){
	  this.banco = banco;	
	}
	
	
	
	public ArrayList<Usuarios> buscaTodosUsuarios(){
		
		final String NAMESPACE = "http://Dao.ExemploWS.JN.com.br";
		final String METHOD_NAME = "buscaTodosUsuarios";
		final String SOAP_ACTION = "urn:buscaTodosUsuarios";
		final String URL = "http://localhost:8080/ExemploWebService/services/UserDao?wsdl"; 
		final String URL2 = "http://192.168.25.19:8080/ExemploWebService/services/UserDao?wsdl";

		final String URL3 = "http://unorte.com.br:8080/ExemploWebService/services/UserDao?wsdl"; 
		
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		
		SoapObject soapUser = new SoapObject(NAMESPACE, METHOD_NAME);	
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
		
		envelope.implicitTypes = true;
		envelope.dotNet = true;
		
		// Adicionando a Requisição SOAP ao seu envelope
		envelope.setOutputSoapObject(soapUser);
	
		
		HttpTransportSE http = new HttpTransportSE(URL3);
		
			try {
				http.call(SOAP_ACTION, envelope);
				
				
				
				Vector<SoapObject> resposta = (Vector<SoapObject>) envelope.getResponse();
				//SoapObject resposta = (SoapObject) envelope.getResponse();
				
				//int count = resposta.getPropertyCount();
				//for (int i = 0; i < count; i++) {
					
				for (SoapObject soapObject : resposta){
					Usuarios user = new Usuarios();
					
					user.setId(Integer.parseInt(soapObject.getProperty("id").toString()));
					user.setUsuario(soapObject.getProperty("usuario").toString());
					user.setSenha(soapObject.getProperty("senha").toString());
					lista.add(user);
					
				}
				return lista;
			} catch (SocketTimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
				
			
		
		
		
	}
	
	public Usuarios buscaUsuario(String usuario,String senha){
		Usuarios user = null;
	
		final String NAMESPACE = "http://Dao.ExemploWS.JN.com.br";
		final String METHOD_NAME = "buscaTodosUsuarios";
		final String SOAP_ACTION = "urn:buscaTodosUsuarios";
		final String URL = "http://localhost:8080/ExemploWebService/services/UserDao?wsdl"; 
		final String URL2 = "http://192.168.25.19:8080/ExemploWebService/services/UserDao?wsdl";
		final String URL3 = "http://unorte.com.br:8080/ExemploWebService/services/UserDao?wsdl"; 
		
		
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		
		SoapObject soapUser = new SoapObject(NAMESPACE, METHOD_NAME);	
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
		
		envelope.implicitTypes = true;
		envelope.dotNet = true;
		
		// Adicionando a Requisição SOAP ao seu envelope
		envelope.setOutputSoapObject(soapUser);
	
		
		HttpTransportSE http = new HttpTransportSE(URL3);
		
			try {
				http.call(SOAP_ACTION, envelope);
				
				
				
				//SoapObject resposta = (SoapObject) envelope.getResponse();
				
				//int count = resposta.getPropertyCount();
				//for (int i = 0; i < count; i++) {
					
				SoapObject resposta = (SoapObject) envelope.getResponse();
					 user = new Usuarios();
					
					
					user.setId(Integer.parseInt(resposta.getProperty("id").toString()));
					user.setUsuario(resposta.getProperty("usuario").toString());
					user.setSenha(resposta.getProperty("senha").toString());
					lista.add(user);
					
				
				
			} catch (SocketTimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
	
		return user;
	}

}
