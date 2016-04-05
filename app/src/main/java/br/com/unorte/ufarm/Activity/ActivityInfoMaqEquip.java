package br.com.unorte.ufarm.Activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

import br.com.unorte.ufarm.R;
import br.com.unorte.ufarm.dao.UfarmFormulariosDao;
import br.com.unorte.ufarm.pojo.UfarmAquisicoes;
import br.com.unorte.ufarm.pojo.UfarmFormularios;
import br.com.unorte.ufarm.recursos.MascaraMonetaria;

public class ActivityInfoMaqEquip extends Activity {

	public static boolean VEICULO = false;
	private LinearLayout layoutTipo;
	public static String bd;


	UfarmAquisicoes Aqui;
	Spinner spiRecurso;
	Spinner spiTipo;
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
		setContentView(R.layout.activity_frag_info_maq_equip);
		layoutTipo = (LinearLayout) findViewById(R.id.LayouTipoVeiculo);
		if (VEICULO) {
			layoutTipo.setVisibility(View.INVISIBLE);
		}

		Intent intent = getIntent();
		Aqui = (UfarmAquisicoes)intent.getSerializableExtra("Aquisicao");



		spiRecurso = (Spinner) findViewById(R.id.spiRecurso);
		edtIdentRec = (EditText) findViewById(R.id.edtIdentRec);
		spiMarca = (Spinner) findViewById(R.id.spiMarca);
		edtModelo = (EditText) findViewById(R.id.edtModelo);
		spiPotencia = (Spinner) findViewById(R.id.spiPotencia);
		edtAno = (EditText) findViewById(R.id.edtAno);
		edtValor = (EditText) findViewById(R.id.edtValor);

		if (!VEICULO) {
			spiTipo = (Spinner) findViewById(R.id.spiTipo);
			ArrayAdapter<String> ArrayAdapterTipo = new ArrayAdapter<String>(getBaseContext(), R.layout.texto_personalizado, getResources().getStringArray(R.array.ArrayTipoMaquinaEquip));
			//CustomArrayAdapter<String> arrayAdapter = new CustomArrayAdapter<String>(getContext(), operacao);
			ArrayAdapter<String> spinnerArrayAdapterTipo = ArrayAdapterTipo;
			spinnerArrayAdapterTipo.setDropDownViewResource(R.layout.texto_personalizado);
			spiTipo.setAdapter(spinnerArrayAdapterTipo);
            spiTipo.setOnItemSelectedListener(SelecionaTipo());
		}


		FormulariosDao = new UfarmFormulariosDao(bd);
		if (VEICULO) {
            ListaRecurso = FormulariosDao.buscaUfarmFormulariosLegenda("C23", "", "", "", "");
            ArrayAdapter<UfarmFormularios> ArrayAdapterRecurso = new ArrayAdapter<UfarmFormularios>(getBaseContext(), R.layout.texto_personalizado, ListaRecurso);
            //CustomArrayAdapter<String> arrayAdapter = new CustomArrayAdapter<String>(getContext(), operacao);
            ArrayAdapter<UfarmFormularios> spinnerArrayAdapterRecurso = ArrayAdapterRecurso;
            spinnerArrayAdapterRecurso.setDropDownViewResource(R.layout.texto_personalizado);
            spiRecurso.setAdapter(spinnerArrayAdapterRecurso);

        }




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
		getMenuInflater().inflate(R.menu.frag_info_maq_equip, menu);
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


    public AdapterView.OnItemSelectedListener SelecionaTipo(){
        return (new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //String nsvNome = spi.getSelectedItem().toString();
                //// Log.w("Cliente",nsvNome);
                switch (spiTipo.getSelectedItemPosition()) {
                    case 0:
                        ListaRecurso = FormulariosDao.buscaUfarmFormulariosLegenda("C23", "", "", "", "");
                        break;
                    case 1:
                        ListaRecurso = FormulariosDao.buscaUfarmFormulariosLegenda("C24", "", "", "", "");
                        break;


                }
                ArrayAdapter<UfarmFormularios> ArrayAdapterRecurso = new ArrayAdapter<UfarmFormularios>(getBaseContext(), R.layout.texto_personalizado, ListaRecurso);
                //CustomArrayAdapter<String> arrayAdapter = new CustomArrayAdapter<String>(getContext(), operacao);
                ArrayAdapter<UfarmFormularios> spinnerArrayAdapterRecurso = ArrayAdapterRecurso;
                spinnerArrayAdapterRecurso.setDropDownViewResource(R.layout.texto_personalizado);
                spiRecurso.setAdapter(spinnerArrayAdapterRecurso);

            }


            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }




	public void GravaObj(View v){

		if(!VEICULO) {
			Aqui.setTipo(spiTipo.getSelectedItem().toString());
		}
		Aqui.setCategoria(spiRecurso.getSelectedItem().toString());
		Aqui.setIdRecurso(Integer.parseInt(edtIdentRec.getText().toString()));
		Aqui.setSubCategoria(spiMarca.getSelectedItem().toString());
		Aqui.setModelo(edtModelo.getText().toString());
		Aqui.setPotencia(spiPotencia.getSelectedItem().toString());
		Aqui.setAno(Integer.parseInt(edtAno.getText().toString()));
		Aqui.setValorTotal(edtValor.getText().toString());

		Intent i = new Intent();//new Intent(ActivityInfoImpleFerram.this, FragImplementosFerramentas.class);
		i.putExtra("Aqui",Aqui);
		setResult(RESULT_OK,i);
		ActivityInfoMaqEquip.this.finish();
	}
}
