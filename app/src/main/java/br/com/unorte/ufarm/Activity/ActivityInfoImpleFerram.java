package br.com.unorte.ufarm.Activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.Serializable;

import br.com.unorte.ufarm.R;
import br.com.unorte.ufarm.pojo.UfarmAquisicoes;

public class ActivityInfoImpleFerram extends Activity implements Serializable {

	UfarmAquisicoes Aqui;

	Spinner  spiRecurso;
	EditText edtIdentRec;
	Spinner  spiMarca;
	EditText edtModelo;
	Spinner  spiPotencia;
	EditText edtAno;
	EditText edtValor;

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
		//Aqui.setIdRecurso((int) spiRecurso.getSelectedItemId());
		Aqui.setIdRecurso(Integer.parseInt(edtIdentRec.getText().toString()));
		//Aqui.setMarcaRebanho(spiMarca.getSelectedItem().toString());
		//Aqui.setModelo(edtModelo.getText().toString());
		//Aqui.setPotencia(spiPotencia.getSelectedItem().toString());
		//Aqui.setAno(Integer.parseInt(edtAno.getText().toString()));
		//Aqui.setValorTotal(edtValor.getText().toString());

		Intent i = new Intent();//new Intent(ActivityInfoImpleFerram.this, FragImplementosFerramentas.class);
		i.putExtra("Aqui",Aqui);
		setResult(RESULT_OK,i);
		ActivityInfoImpleFerram.this.finish();
	}
}
