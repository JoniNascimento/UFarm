package br.com.unorte.ufarm.Activity;

import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.unorte.ufarm.R;
import br.com.unorte.ufarm.dao.UfarmAquisicaoDao;
import br.com.unorte.ufarm.dao.UfarmContasDao;
import br.com.unorte.ufarm.dao.UfarmFornecedoresDao;
import br.com.unorte.ufarm.pojo.UfarmAquisicoes;
import br.com.unorte.ufarm.pojo.UfarmFornecedores;
import br.com.unorte.ufarm.recursos.Function;
import br.com.unorte.ufarm.recursos.MascaraData;
import br.com.unorte.ufarm.recursos.MascaraMonetaria;

public class FragArrendamento extends Fragment {
    public static String bd;
    public static int idProp;

    String[] UnMedida;

    ArrayList<UfarmFornecedores> ListaFornecedores;
    UfarmFornecedoresDao ForneceodoresDao;
    Spinner spiFornecedores, spiUnMedida;
    EditText edtData;
    EditText edtContrato;
    EditText edtImpostos;
    EditText edtQtde;
    EditText edtArea;
    EditText edtVLUnitario;
    Button btnGravar;
    EditText edtDepreciacaoValor;
    EditText edtValorTotal;
    Button btnLimpar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.activity_frag_arrendamento, container, false);

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
        //spiProdServ.setOnItemSelectedListener(SelecionaProdServ());

        edtData = (EditText) v.findViewById(R.id.edtData);
        edtData.setOnKeyListener(new MascaraData());

        edtContrato = (EditText) v.findViewById(R.id.edtContrato);
        edtImpostos = (EditText) v.findViewById(R.id.edtImpostos);
        edtQtde = (EditText) v.findViewById(R.id.edtQuantidade);
        edtArea = (EditText) v.findViewById(R.id.edtArea);
        spiUnMedida = (Spinner) v.findViewById(R.id.spiUnMedida);
        edtVLUnitario = (EditText) v.findViewById(R.id.edtValorUn);
        btnGravar = (Button) v.findViewById(R.id.btnGravar);
        btnLimpar = (Button) v.findViewById(R.id.btnLimpar);
        edtDepreciacaoValor = (EditText) v.findViewById(R.id.edtDepreciacaoValor);
        edtValorTotal = (EditText) v.findViewById(R.id.edtVlTotal);
        //seto o valor como 1 para ter uma quantidade
        edtQtde.setText("1");

        //Popula o SpiUnidade de medida
        if (UnMedida == null) {
            UnMedida = getResources().getStringArray(R.array.ArrayUnMedida);


        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.texto_personalizado, UnMedida);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(R.layout.texto_personalizado);
        spiUnMedida.setAdapter(spinnerArrayAdapter);
        //Popula o SpiUnidade de medida

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravaArrendamento();

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
        edtArea.addTextChangedListener(new MascaraMonetaria(edtArea, false));

        return v;
    }

    public void gravaArrendamento() {
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
        ObjAquisicoes.setProdServico("Arrendamento");
        ObjAquisicoes.setFornecedor(spiFornecedores.getSelectedItem().toString());
        ObjAquisicoes.setContrato(edtContrato.getText().toString());
        ObjAquisicoes.setImposto(edtImpostos.getText().toString());
        ObjAquisicoes.setQtde(Integer.parseInt(edtQtde.getText().toString()));
        ObjAquisicoes.setArea(edtArea.getText().toString());
        ObjAquisicoes.setValorUn(edtVLUnitario.getText().toString().replaceAll("[R$]", ""));
        ObjAquisicoes.setUnMedida(spiUnMedida.getSelectedItem().toString());
        ObjAquisicoes.setValorTotal(edtValorTotal.getText().toString().replaceAll("[R$]", ""));

        if (AquiDao.inserirAquisicao(ObjAquisicoes)) {
            Toast.makeText(getView().getContext(), getString(R.string.msgSucesso), Toast.LENGTH_LONG).show();
            LimpaEdit();
        } else {
            Toast.makeText(getView().getContext(), getString(R.string.msgErroOperacao), Toast.LENGTH_LONG).show();
        }

    }

    public void LimpaEdit() {
        edtContrato.setText("");
        edtImpostos.setText("");
        edtQtde.setText("1");
        edtArea.setText("");
        edtVLUnitario.setText("");
        edtDepreciacaoValor.setText("");
        edtValorTotal.setText("");
        edtData.setText("");
    }
}
