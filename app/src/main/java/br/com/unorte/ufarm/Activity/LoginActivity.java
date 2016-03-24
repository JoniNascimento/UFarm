package br.com.unorte.ufarm.Activity;


import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import br.com.unorte.ufarm.R;
import br.com.unorte.ufarm.dao.BdsDao;
import br.com.unorte.ufarm.dao.PropriedadesDao;
import br.com.unorte.ufarm.dao.UfarmImoveisDao;
import br.com.unorte.ufarm.dao.UsuariosDao;
import br.com.unorte.ufarm.pojo.Bds;
import br.com.unorte.ufarm.pojo.Propriedades;
import br.com.unorte.ufarm.pojo.UfarmImoveis;
import br.com.unorte.ufarm.pojo.Usuarios;

public class LoginActivity extends ActionBarActivity {

	private Toolbar mToolbar;
	private Toolbar mToolbarBottom;

	private Drawer navigationDrawerLeft;

	private EditText edtUser;
	private EditText edtPass;
	private Button btnLogin;
	private String User;
	private String Pass;

	//cria os objetos e carrega com dados do banco
	UsuariosDao userDao = new UsuariosDao("unorteco_geral");
	BdsDao bdDao = new BdsDao("unorteco_geral");
	PropriedadesDao propDao ;
	UfarmImoveisDao imoveisDao;
	Bds bd = null;
	Propriedades prop = null;
	Usuarios user = null;
	ArrayList<Propriedades> listaProp = null;
	ArrayList<UfarmImoveis> listaImoveis = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		//mToolbar.setTitle("teste");
	    //mToolbar.setSubtitle("Joni");
		mToolbar.setLogo(R.drawable.ic_launcher);
		setSupportActionBar(mToolbar);




		
		// Em API maiores que 9, é necessário habilitar um ThreadPolicy
				// para liberar o acesso ao WebService externo
				if (android.os.Build.VERSION.SDK_INT > 9) {
					StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
					StrictMode.setThreadPolicy(policy);
				}

		edtUser = (EditText) findViewById(R.id.edtUser);
		edtPass = (EditText) findViewById(R.id.edtPass);




	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}

		
		return super.onOptionsItemSelected(item);
	}

	@SuppressLint("ShowToast")
	public void Logar(View v){

		User = edtUser.getText().toString();
		Pass = edtPass.getText().toString();
		
		/*Usuarios user = userDao.buscaUsuario(User.trim(), Pass.trim());
		if (user != null){
			bd = bdDao.buscaBds(user.getId());
		} 
		else{
			PropriedadesDao propDao = new PropriedadesDao();
			prop = propDao.buscaPropriedadeLogin(User.trim(), Pass.trim());	
			if (prop != null ){
				bd = bdDao.buscaBds(prop.getIdUser());
			}
		}*/
		///
		
		 if (User.trim().equals("")||Pass.trim().equals("")){
 			if (User.trim().equals("")){
 				edtUser.setError(getString(R.string.msgObrigatorio));

 			}
 			if (Pass.trim().equals("") ){
 				edtPass.setError(getString(R.string.msgObrigatorio));
 			}
        
 		}
		else{
			 new LoadingAsync().execute();
 		}

	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	public class LoadingAsync extends AsyncTask<Void ,Void ,String>{//Classe que permite realizar tarefas sincronas como uma thread

        private ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            progressDialog.setMessage("Aguarde! Verificando Login e Senha...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Void... params) {       	
        	
        	user = userDao.buscaUsuario(User.trim(), Pass.trim());
    		if (user != null){
    			bd = bdDao.buscaBds(user.getId());
				propDao = new PropriedadesDao(bd.getBd().toString());
				listaProp = propDao.buscaPropriedadeImovel(user.getId());
				//imoveisDao = new UfarmImoveisDao(bd.getBd().toString());
				//listaImoveis = imoveisDao.buscaUfarmImoveis()
    		} 
    		else{
    			
    			prop = propDao.buscaPropriedadeLogin(User.trim(), Pass.trim());	
    			if (prop != null ){
    				bd = bdDao.buscaBds(prop.getIdUser());
    			}
    		}
    		
			return "login";
        	
        }

        @Override
        protected void onPostExecute(String msg) {
            progressDialog.dismiss();
            

    			if (user!= null){ 
    			//if (User.trim().equals("sistema") && Pass.trim().equals("teste")){
    				Intent i = new Intent(LoginActivity.this,ListPropriedades.class);
    				ListPropriedades.listaProp = listaProp;
    				ListPropriedades.bd = bd.getBd().toString();
    				startActivity(i);
    				//ArrayList<Usuarios> lista = dao.buscaTodosUsuarios();
    				//if (lista != null) {
    				 // Log.d("Exemplo WS:", lista.toString());
    			//	}
    			
    				
    			}
    			else{
    			if (prop != null ){
    					//Intent i = new Intent(LoginActivity.this,PainelProdutivo.class);
					    Intent i = new Intent(LoginActivity.this,PainelProdutivo.class);
    					startActivity(i);

    				}
    				else{
    					Toast.makeText(LoginActivity.this, getString(R.string.msgLoginInvalido), Toast.LENGTH_LONG).show();

    				}
    			}
    		

          

        }
    }

}
