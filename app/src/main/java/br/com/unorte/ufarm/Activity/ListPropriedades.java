package br.com.unorte.ufarm.Activity;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import br.com.unorte.ufarm.R;
import br.com.unorte.ufarm.pojo.Propriedades;
import br.com.unorte.ufarm.recursos.AdapterListaProp;

public class ListPropriedades extends Activity {
	
	public static String bd;
	public static ArrayList<Propriedades> listaProp = null ;
    ListView lista ;
	private Toolbar mToolbar;
    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_propriedades);
		lista = (ListView) findViewById(R.id.listaProp);
		
		//ArrayAdapter<Propriedades> adProp = new ArrayAdapter<Propriedades>(this, android.R.layout.simple_list_item_1,listaProp );
		AdapterListaProp adProp = new AdapterListaProp(this, listaProp);
		lista.setAdapter(adProp);
		lista.setOnItemClickListener(Selecionar());

		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		mToolbar.setTitle(getTitle().toString());
		//mToolbar.setSubtitle("Joni");
		mToolbar.setLogo(R.drawable.ic_launcher);
		
	}
	
	public OnItemClickListener Selecionar(){
		return (new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {	
				
				 Intent i = new Intent(getBaseContext(), PainelProdutivo.class);
				 PainelProdutivo.idProp = listaProp.get(position).getId();
				 PainelProdutivo.propriedade =listaProp.get(position).getProp();
				 PainelProdutivo.bd = ListPropriedades.bd;
				 startActivity(i);	
				 
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_propriedades, menu);
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
	
	public void PainelProdutivo(View v){
	  Intent i = new Intent(ListPropriedades.this, PainelProdutivo.class);
	  startActivity(i);
	}
}
