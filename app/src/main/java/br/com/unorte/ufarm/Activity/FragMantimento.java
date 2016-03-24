package br.com.unorte.ufarm.Activity;

import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.unorte.ufarm.R;
import br.com.unorte.ufarm.dao.UfarmAquisicaoDao;
import br.com.unorte.ufarm.dao.UfarmFormulariosDao;
import br.com.unorte.ufarm.dao.UfarmFornecedoresDao;
import br.com.unorte.ufarm.pojo.UfarmAquisicoes;
import br.com.unorte.ufarm.pojo.UfarmFormularios;
import br.com.unorte.ufarm.pojo.UfarmFornecedores;
import br.com.unorte.ufarm.recursos.Function;
import br.com.unorte.ufarm.recursos.MascaraData;
import br.com.unorte.ufarm.recursos.MascaraMonetaria;

public class FragMantimento extends Fragment {

    public static String bd;
    public static int idProp;

    ArrayList<UfarmFornecedores> ListaFornecedores;
    UfarmFornecedoresDao ForneceodoresDao;
    UfarmFormulariosDao FormulariosDao;
    Spinner spiFornecedores;
    EditText edtData;
    EditText edtNNotaFiscal;
    EditText edtSerieNota;
    EditText edtParcelaLote;
    EditText edtCFOP;
    EditText edtImpostos;
    EditText edtFrete;
    EditText edtDesconto;
    EditText edtVLUnitario;
    EditText edtQtde;
    EditText edtValorTotal;
    Button btnGravar;
    Button btnLimpar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_frag_mantimento, container, false);

        ForneceodoresDao = new UfarmFornecedoresDao(bd);
        ListaFornecedores = ForneceodoresDao.buscaTodosFornecedores();

        //REcuperação do spinner
        spiFornecedores = (Spinner) v.findViewById(R.id.spiFornecedor);
        //adapter para pupular o spinner
        ArrayAdapter<UfarmFornecedores> ArrayAdapter = new ArrayAdapter<UfarmFornecedores>(v.getContext(), R.layout.texto_personalizado, ListaFornecedores);
        //CustomArrayAdapter<String> arrayAdapter = new CustomArrayAdapter<String>(getContext(), operacao);
        ArrayAdapter<UfarmFornecedores> spinnerArrayAdapter2 = ArrayAdapter;
        spinnerArrayAdapter2.setDropDownViewResource(R.layout.texto_personalizado);
        spiFornecedores.setAdapter(spinnerArrayAdapter2);


        FormulariosDao = new UfarmFormulariosDao(bd);

        edtData = (EditText) v.findViewById(R.id.edtData);
        edtData.setOnKeyListener(new MascaraData());

        edtNNotaFiscal = (EditText) v.findViewById(R.id.edtNumNotaFiscal);
        edtSerieNota = (EditText) v.findViewById(R.id.edtSerieNotaF);
        edtParcelaLote = (EditText) v.findViewById(R.id.edtParcelLote);
        edtCFOP = (EditText) v.findViewById(R.id.edtCFOP);
        edtImpostos = (EditText) v.findViewById(R.id.edtImpostos);
        edtFrete = (EditText) v.findViewById(R.id.edtFrete);
        edtDesconto = (EditText) v.findViewById(R.id.edtDescontos);
        edtVLUnitario = (EditText) v.findViewById(R.id.edtValorUn);
        edtQtde = (EditText) v.findViewById(R.id.edtQuantidade);
        edtValorTotal = (EditText) v.findViewById(R.id.edtVlTotal);
        btnGravar = (Button) v.findViewById(R.id.btnGravar);
        btnLimpar = (Button) v.findViewById(R.id.btnLimpar);

        btnGravar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GravaMantimento();

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LimpaEdit();
            }
        });

        //trecho que adiciona mascara ao Edit
        edtVLUnitario.addTextChangedListener(new MascaraMonetaria(edtVLUnitario, true));
        edtValorTotal.addTextChangedListener(new MascaraMonetaria(edtValorTotal, true));
        edtFrete.addTextChangedListener(new MascaraMonetaria(edtFrete, true));
        edtDesconto.addTextChangedListener(new MascaraMonetaria(edtDesconto, true));
        edtImpostos.addTextChangedListener(new MascaraMonetaria(edtImpostos, true));
        edtVLUnitario.addTextChangedListener(new TextWatcher() {


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double Aux, VLTotal;
                if ((!edtVLUnitario.getText().toString().trim().isEmpty()) && (!edtQtde.getText().toString().trim().isEmpty())) {
                    Aux = Function.stringMonetarioToDouble(edtVLUnitario.getText().toString());
                    VLTotal = Double.parseDouble(edtQtde.getText().toString()) * Aux;
                    edtValorTotal.setText(Double.toString(VLTotal));

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


        return v;
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


    public void GravaMantimento() {

        UfarmAquisicoes ObjAquisicoes = null;
        UfarmAquisicaoDao AquiDao = null;
        if (ObjAquisicoes == null) {
            ObjAquisicoes = new UfarmAquisicoes();
        }
        if (AquiDao == null) {
            AquiDao = new UfarmAquisicaoDao(bd);

        }

        ObjAquisicoes.setIdProp(idProp);
        ObjAquisicoes.setData(new Function().converteData(edtData.getText().toString()));
        ObjAquisicoes.setProdServico("Mantimento");
        ObjAquisicoes.setFornecedor(spiFornecedores.getSelectedItem().toString());
        ObjAquisicoes.setNf(Integer.parseInt(edtNNotaFiscal.getText().toString()));
        ObjAquisicoes.setSerie(Integer.parseInt(edtSerieNota.getText().toString()));
        ObjAquisicoes.setParcelaLote(Integer.parseInt(edtParcelaLote.getText().toString()));
        ObjAquisicoes.setCfop(edtCFOP.getText().toString());
        ObjAquisicoes.setImposto(edtImpostos.getText().toString().replaceAll("[R$]", ""));
        ObjAquisicoes.setFrete(edtFrete.getText().toString().replaceAll("[R$]", ""));
        ObjAquisicoes.setDesconto(edtDesconto.getText().toString().replaceAll("[R$]", ""));
        ObjAquisicoes.setQtde(Integer.parseInt(edtQtde.getText().toString()));
        ObjAquisicoes.setValorUn(edtVLUnitario.getText().toString().replaceAll("[R$]", ""));
        ObjAquisicoes.setValorTotal(edtValorTotal.getText().toString().replaceAll("[R$]", ""));

        if (AquiDao.inserirAquisicao(ObjAquisicoes)) {
            Toast.makeText(getView().getContext(), getString(R.string.msgSucesso), Toast.LENGTH_LONG).show();
            LimpaEdit();
        } else {
            Toast.makeText(getView().getContext(), getString(R.string.msgErroOperacao), Toast.LENGTH_LONG).show();
        }
    }

    public void LimpaEdit() {

        edtNNotaFiscal.setText("");
        edtSerieNota.setText("");
        edtParcelaLote.setText("");
        edtCFOP.setText("");
        edtImpostos.setText("");
        edtFrete.setText("");
        edtDesconto.setText("");
        edtVLUnitario.setText("");
        edtQtde.setText("1");
        edtValorTotal.setText("");
        edtData.setText("");


    }

}