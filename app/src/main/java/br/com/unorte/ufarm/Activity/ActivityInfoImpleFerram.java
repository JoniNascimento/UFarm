package br.com.unorte.ufarm.Activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.unorte.ufarm.R;
import br.com.unorte.ufarm.dao.UfarmFormulariosDao;
import br.com.unorte.ufarm.dao.UfarmFornecedoresDao;
import br.com.unorte.ufarm.pojo.UfarmAquisicoes;
import br.com.unorte.ufarm.pojo.UfarmFormularios;
import br.com.unorte.ufarm.pojo.UfarmFornecedores;
import br.com.unorte.ufarm.recursos.MascaraMonetaria;

public class ActivityInfoImpleFerram extends Activity implements Serializable {

	public static String bd;


	UfarmAquisicoes Aqui;

	Spinner  spiRecurso;
	EditText edtIdentRec;
	Spinner  spiMarca;
	EditText edtModelo;
	Spinner  spiPotencia;
	EditText edtAno;
	EditText edtValor;
	UfarmFormulariosDao FormulariosDao;
	ArrayList<UfarmFormularios> ListaRecurso;
	ArrayList<UfarmFormularios> ListaMarca;
	ArrayList<String> ListaPotencia;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frag_info_imple_ferram);

		spiRecurso = (Spinner) findViewById(R.id.spiRecurso);
		edtIdentRec = (EditText) findViewById(R.id.edtIdentRec);
		spiMarca = (Spinner) findViewById(R.id.spiMarca);
		edtModelo = (EditText) findViewById(R.id.edtModelo);
		spiPotencia = (Spinner) findViewById(R.id.spiPotencia);
		edtAno = (EditText) findViewById(R.id.edtAno);
		edtValor = (EditText) findViewById(R.id.edtValor);

		Intent intent = getIntent();
		Aqui = (UfarmAquisicoes)intent.getSerializableExtra("Aquisicao");

		FormulariosDao = new UfarmFormulariosDao(bd);
		ListaRecurso = FormulariosDao.buscaUfarmFormulariosLegenda("C25", "", "", "", "");
		//adapter para pupular o spinner
		ArrayAdapter<UfarmFormularios> ArrayAdapterRecurso = new ArrayAdapter<UfarmFormularios>(getBaseContext(), R.layout.texto_personalizado, ListaRecurso);
		//CustomArrayAdapter<String> arrayAdapter = new CustomArrayAdapter<String>(getContext(), operacao);
		ArrayAdapter<UfarmFormularios> spinnerArrayAdapterRecurso = ArrayAdapterRecurso;
		spinnerArrayAdapterRecurso.setDropDownViewResource(R.layout.texto_personalizado);
		spiRecurso.setAdapter(spinnerArrayAdapterRecurso);


		ListaMarca = FormulariosDao.buscaUfarmFormulariosLegenda("C26", "", "", "", "");
		//adapter para pupular o spinner
		ArrayAdapter<UfarmFormularios> ArrayAdapterMarca = new ArrayAdapter<UfarmFormularios>(getBaseContext(), R.layout.texto_personalizado, ListaMarca);
		//CustomArrayAdapter<String> arrayAdapter = new CustomArrayAdapter<String>(getContext(), operacao);
		ArrayAdapter<UfarmFormularios> spinnerArrayAdapterMarca = ArrayAdapterMarca;
		spinnerArrayAdapterMarca.setDropDownViewResource(R.layout.texto_personalizado);
		spiMarca.setAdapter(spinnerArrayAdapterMarca);

		ListaPotencia = new ArrayList<String>();
		ListaPotencia.add("Selecione...");

		for (int i = 0; i < 241; i++){
			ListaPotencia.add( Integer.toString(50 + i) + " cc");
		}
		ArrayAdapter<String> ArrayAdapterPotencia = new ArrayAdapter<String>(getBaseContext(), R.layout.texto_personalizado, ListaPotencia);
		//CustomArrayAdapter<String> arrayAdapter = new CustomArrayAdapter<String>(getContext(), operacao);
		ArrayAdapter<String> spinnerArrayAdapterPotencia = ArrayAdapterPotencia;
		spinnerArrayAdapterPotencia.setDropDownViewResource(R.layout.texto_personalizado);
		spiPotencia.setAdapter(spinnerArrayAdapterPotencia);

		//Muda a mascara para valor
		edtValor.addTextChangedListener( new MascaraMonetaria(edtValor,true));
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.frag_info_imple_ferram, menu);
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

	public void GravaObj(View v){
		Aqui.setIdRecurso((int) spiRecurso.getSelectedItemId());
		Aqui.setIdRecurso(Integer.parseInt(edtIdentRec.getText().toString()));
		Aqui.setMarcaRebanho(spiMarca.getSelectedItem().toString());
		Aqui.setModelo(edtModelo.getText().toString());
		Aqui.setPotencia(spiPotencia.getSelectedItem().toString());
		Aqui.setAno(Integer.parseInt(edtAno.getText().toString()));
		Aqui.setValorTotal(edtValor.getText().toString());

		Intent i = new Intent();//new Intent(ActivityInfoImpleFerram.this, FragImplementosFerramentas.class);
		i.putExtra("Aqui",Aqui);
		setResult(RESULT_OK,i);
		ActivityInfoImpleFerram.this.finish();
	}
}
