package br.com.unorte.ufarm.Activity;

import android.app.Activity;
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
import android.widget.Spinner;

import br.com.unorte.ufarm.R;
import br.com.unorte.ufarm.recursos.Function;
import br.com.unorte.ufarm.recursos.MascaraData;
import br.com.unorte.ufarm.recursos.MascaraHora;
import br.com.unorte.ufarm.recursos.MascaraMonetaria;

public class Tab_ProducaoAgriFloresta extends FragmentActivity {

    EditText edtData;
    EditText edtExecutor;
    EditText edtHIni;
    EditText edtHFim;
    EditText edtDuracao;
    EditText edtAtv;
    EditText edtLocal;
    EditText edtQtde;
    Spinner spiUnMedida;
    EditText edtRecurso;
    EditText edtDetalhe;
    EditText edtVlUn;
    EditText edtVlTotal;
    Spinner spiStatus;
    Button btnGravar;
    Button btnLimpar;

    String[] UnMedida;
    String[] status;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_producao_agri_floresta);

        edtData = (EditText) findViewById(R.id.edtData);
        edtExecutor= (EditText) findViewById(R.id.edtExecutor);
        edtHIni= (EditText) findViewById(R.id.edtHIni);
        edtHFim= (EditText) findViewById(R.id.edtHFim);
        edtDuracao= (EditText) findViewById(R.id.edtDuracao);
        edtAtv= (EditText) findViewById(R.id.edtAtv);
        edtLocal= (EditText) findViewById(R.id.edtLocal);
        edtQtde= (EditText) findViewById(R.id.edtQtde);
        spiUnMedida= (Spinner) findViewById(R.id.spiUnMedida);
        edtRecurso= (EditText) findViewById(R.id.edtRecurso);
        edtDetalhe= (EditText) findViewById(R.id.edtDetalhe);
        edtVlUn= (EditText) findViewById(R.id.edtVlUn);
        edtVlTotal= (EditText) findViewById(R.id.edtVlTotal);
        spiStatus= (Spinner) findViewById(R.id.spiStatus);
        btnGravar= (Button) findViewById(R.id.btnGravar);
        btnLimpar= (Button) findViewById(R.id.btnLimpar);

        edtData.setOnKeyListener(new MascaraData());
        edtHIni.setOnKeyListener(new MascaraHora());
        edtHFim.setOnKeyListener(new MascaraHora());

        edtQtde.setText("1");

        edtVlUn.addTextChangedListener(new MascaraMonetaria(edtVlUn, true));
        edtVlTotal.addTextChangedListener( new MascaraMonetaria(edtVlTotal,true));
        edtVlUn.addTextChangedListener(new TextWatcher() {


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double Aux, VLTotal;
                if ((!edtVlUn.getText().toString().trim().isEmpty()) && (!edtQtde.getText().toString().trim().isEmpty())) {
                    Aux = Function.stringMonetarioToDouble(edtVlUn.getText().toString());
                    VLTotal = Double.parseDouble(edtQtde.getText().toString()) * Aux;
                    edtVlTotal.setText(Double.toString(VLTotal));

                    //edtValorTotal.setText(getString(R.string.txvReal) + Double.toString(VLTotal));
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        if (UnMedida == null) {
            UnMedida = getResources().getStringArray(R.array.ArrayUnMedida);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.texto_personalizado, UnMedida);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(R.layout.texto_personalizado);
        spiUnMedida.setAdapter(spinnerArrayAdapter);


        if (status == null){
            status = getResources().getStringArray(R.array.ArrayStatus);
        }

        ArrayAdapter<String> arrayAdapterStatus = new ArrayAdapter<String>(this, R.layout.texto_personalizado, status);
        ArrayAdapter<String> spinnerArrayAdapterStatus = arrayAdapterStatus;
        spinnerArrayAdapterStatus.setDropDownViewResource(R.layout.texto_personalizado);
        spiStatus.setAdapter(spinnerArrayAdapterStatus);



    }


    public void Limpar(){
        edtData.setText("");
        edtExecutor.setText("");
        edtHIni.setText("");
        edtHFim.setText("");
        edtDuracao.setText("");
        edtAtv.setText("");
        edtLocal.setText("");
        edtQtde.setText("1");
        edtRecurso.setText("");
        edtDetalhe.setText("");
        edtVlUn.setText("");
        edtVlTotal.setText("");

    }


}
