package br.com.unorte.ufarm.Activity;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import br.com.unorte.ufarm.R;
import br.com.unorte.ufarm.recursos.Function;
import br.com.unorte.ufarm.recursos.MascaraData;
import br.com.unorte.ufarm.recursos.MascaraHora;
import br.com.unorte.ufarm.recursos.MascaraMonetaria;

public class Tab_ProducaoPecuaria extends FragmentActivity {

    EditText edtData;
    EditText edtExecutor;
    EditText edtHIni;
    EditText edtHFim;
    EditText edtDuracao;
    EditText edtAtv;
    EditText edtIdAnimal;
    EditText edtNLote;
    Spinner spiCatAnimal;
    Spinner spiRacaAnimal;
    EditText edtIdade;
    EditText edtPeso;
    EditText edtObs;
    Spinner spiStatus;
    Button btnGravar;
    Button btnLimpar;

    String[] ArrayCatAnimal;
    String[] ArrayRacaAnimal;
    String[] status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_producao_pecuaria);

        edtData = (EditText) findViewById(R.id.edtData);
        edtExecutor = (EditText) findViewById(R.id.edtExecutor);
        edtHIni = (EditText) findViewById(R.id.edtHIni);
        edtHFim = (EditText) findViewById(R.id.edtHFim);
        edtDuracao = (EditText) findViewById(R.id.edtDuracao);
        edtAtv = (EditText) findViewById(R.id.edtAtv);
        edtIdAnimal = (EditText) findViewById(R.id.edtIdAnimal);
        edtNLote = (EditText) findViewById(R.id.edtNLote);
        spiCatAnimal = (Spinner) findViewById(R.id.spiCatAnimal);
        spiRacaAnimal = (Spinner) findViewById(R.id.spiRacaAnimal);
        edtIdade = (EditText) findViewById(R.id.edtIdade);
        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtObs = (EditText) findViewById(R.id.edtObs);
        spiStatus = (Spinner) findViewById(R.id.spiStatus);
        btnGravar = (Button) findViewById(R.id.btnGravar);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);


        edtData.setOnKeyListener(new MascaraData());
        edtHIni.setOnKeyListener(new MascaraHora());
        edtHFim.setOnKeyListener(new MascaraHora());


        if (ArrayCatAnimal == null){

            ArrayCatAnimal = new String[0];
        }

        ArrayAdapter<String> arrayAdapterCatAnimal = new ArrayAdapter<String>(this, R.layout.texto_personalizado, ArrayCatAnimal);
        ArrayAdapter<String> spinnerArrayAdapterCatAnimal = arrayAdapterCatAnimal;
        spinnerArrayAdapterCatAnimal.setDropDownViewResource(R.layout.texto_personalizado);
        spiCatAnimal.setAdapter(spinnerArrayAdapterCatAnimal);

        if (ArrayRacaAnimal == null){
            ArrayRacaAnimal = new String[0];

        }


        ArrayAdapter<String> arrayAdapterRacaAnimal = new ArrayAdapter<String>(this, R.layout.texto_personalizado, ArrayRacaAnimal);
        ArrayAdapter<String> spinnerArrayAdapterRacaAnimal = arrayAdapterRacaAnimal;
        spinnerArrayAdapterRacaAnimal.setDropDownViewResource(R.layout.texto_personalizado);
        spiRacaAnimal.setAdapter(spinnerArrayAdapterRacaAnimal);


        if (status == null){
            status = getResources().getStringArray(R.array.ArrayStatus);
        }

        ArrayAdapter<String> arrayAdapterStatus = new ArrayAdapter<String>(this, R.layout.texto_personalizado, status);
        ArrayAdapter<String> spinnerArrayAdapterStatus = arrayAdapterStatus;
        spinnerArrayAdapterStatus.setDropDownViewResource(R.layout.texto_personalizado);
        spiStatus.setAdapter(spinnerArrayAdapterStatus);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab__producao_pecuaria, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Limpar(){
        edtData.setText("");
        edtExecutor.setText("");
        edtHIni.setText("");
        edtHFim.setText("");
        edtDuracao.setText("");
        edtAtv.setText("");
        edtIdAnimal.setText("");
        edtNLote.setText("");
        edtIdade.setText("");
        edtPeso.setText("");
        edtObs.setText("");

    }
}
