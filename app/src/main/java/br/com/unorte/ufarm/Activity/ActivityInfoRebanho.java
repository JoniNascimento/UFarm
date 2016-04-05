package br.com.unorte.ufarm.Activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import br.com.unorte.ufarm.R;
import br.com.unorte.ufarm.dao.UfarmFormulariosDao;
import br.com.unorte.ufarm.pojo.UfarmAquisicoes;
import br.com.unorte.ufarm.pojo.UfarmFormularios;
import br.com.unorte.ufarm.recursos.MascaraData;

public class ActivityInfoRebanho extends Activity {

	public static String bd;
	UfarmAquisicoes Aqui;

	UfarmFormulariosDao FormulariosDao;

	ArrayList<UfarmFormularios> ListaTipoRebanho, ListaUtAnimal;

	Spinner spiTipoRebanho;
	Spinner spiTipoPec;
	Spinner spiUtAnimal;
	Spinner spiSexo;
	EditText edtPeso;
	EditText edtAltura;
	EditText edtDN;
	EditText edtNLote;
	EditText edtNBrinco;
	EditText edtMarcaRegRebanho;
	EditText edtLocalMarca;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frag_info_rebanho);

		Intent intent = getIntent();
		Aqui = (UfarmAquisicoes)intent.getSerializableExtra("Aquisicao");


		spiTipoRebanho = (Spinner) findViewById(R.id.spiTipoRebanho);
		spiTipoPec = (Spinner) findViewById(R.id.spiTipoPec);
		spiUtAnimal = (Spinner) findViewById(R.id.spiUtAnimal);
		spiSexo = (Spinner) findViewById(R.id.spiSexo);
		edtPeso = (EditText) findViewById(R.id.edtPeso);
		edtAltura = (EditText) findViewById(R.id.edtAltura);
		edtDN = (EditText) findViewById(R.id.edtDN);
		edtDN.setOnKeyListener(new MascaraData());
		edtNLote = (EditText) findViewById(R.id.edtNLote);
		edtNBrinco = (EditText) findViewById(R.id.edtNBrinco);
		edtMarcaRegRebanho = (EditText) findViewById(R.id.edtMarcaRegRebanho);
		edtLocalMarca = (EditText) findViewById(R.id.edtLocalMarca);

		FormulariosDao = new UfarmFormulariosDao(bd);

        ListaTipoRebanho = FormulariosDao.buscaUfarmFormulariosLegenda("C63","","","","");
		ArrayAdapter<UfarmFormularios> ArrayAdapterTipoRebanho = new ArrayAdapter<UfarmFormularios>(getBaseContext(), R.layout.texto_personalizado, ListaTipoRebanho);
		ArrayAdapter<UfarmFormularios> spinnerArrayAdapterTipoRebanho = ArrayAdapterTipoRebanho;
		spinnerArrayAdapterTipoRebanho.setDropDownViewResource(R.layout.texto_personalizado);
		spiTipoRebanho.setAdapter(spinnerArrayAdapterTipoRebanho);

		ArrayAdapter<String> ArrayAdapterTipoPec = new ArrayAdapter<String>(getBaseContext(), R.layout.texto_personalizado, getResources().getStringArray(R.array.ArrayTipoPec));
		ArrayAdapter<String> spinnerArrayAdapterTipoPec = ArrayAdapterTipoPec;
		spinnerArrayAdapterTipoPec.setDropDownViewResource(R.layout.texto_personalizado);
		spiTipoPec.setAdapter(spinnerArrayAdapterTipoPec);

		ListaUtAnimal = FormulariosDao.buscaUfarmFormulariosLegenda("C62","","","","");
		ArrayAdapter<UfarmFormularios> ArrayAdapterUtAnimal = new ArrayAdapter<UfarmFormularios>(getBaseContext(), R.layout.texto_personalizado, ListaUtAnimal);
		ArrayAdapter<UfarmFormularios> spinnerArrayAdapterUtAnimal = ArrayAdapterUtAnimal;
		spinnerArrayAdapterUtAnimal.setDropDownViewResource(R.layout.texto_personalizado);
		spiUtAnimal.setAdapter(spinnerArrayAdapterUtAnimal);

		ArrayAdapter<String> ArrayAdapterSexo = new ArrayAdapter<String>(getBaseContext(), R.layout.texto_personalizado, getResources().getStringArray(R.array.ArraySexo));
		ArrayAdapter<String> spinnerArrayAdapterSexo = ArrayAdapterSexo;
		spinnerArrayAdapterSexo.setDropDownViewResource(R.layout.texto_personalizado);
		spiSexo.setAdapter(spinnerArrayAdapterSexo);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.frag_info_rebanho, menu);
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
		Aqui.setTipo(spiTipoRebanho.getSelectedItem().toString());
		Aqui.setTipoPecuaria(spiTipoPec.getSelectedItem().toString());
		Aqui.setUtilidade(spiUtAnimal.getSelectedItem().toString());
		Aqui.setSexo(spiSexo.getSelectedItem().toString());
		Aqui.setPeso(edtPeso.getText().toString());
		Aqui.setAltura(edtAltura.getText().toString());
		Aqui.setDataNascimento(edtDN.getText().toString());
		Aqui.setLote(Integer.parseInt(edtNLote.getText().toString()));
		Aqui.setBrinco(edtNBrinco.getText().toString());
		Aqui.setMarcaRebanho(edtMarcaRegRebanho.getText().toString());
		Aqui.setLocalMarca(edtLocalMarca.getText().toString());

		Intent i = new Intent();//new Intent(ActivityInfoImpleFerram.this, FragImplementosFerramentas.class);
		i.putExtra("Aqui",Aqui);
		setResult(RESULT_OK,i);
		ActivityInfoRebanho.this.finish();
	}
}
