package br.com.unorte.ufarm.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
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

import java.io.Serializable;
import java.util.ArrayList;

import br.com.unorte.ufarm.R;
import br.com.unorte.ufarm.dao.UfarmAquisicaoDao;
import br.com.unorte.ufarm.dao.UfarmFornecedoresDao;
import br.com.unorte.ufarm.pojo.UfarmAquisicoes;
import br.com.unorte.ufarm.pojo.UfarmFornecedores;
import br.com.unorte.ufarm.recursos.Function;
import br.com.unorte.ufarm.recursos.MascaraData;

public class FragImplementosFerramentas extends Fragment{

    public static  final int RESULTADO = 1;

    public static String bd;
    public static String info;
    public static int idProp;

    EditText edtData;
    EditText edtQtde;
    EditText edtNFscal;
    EditText edtSerieNf;
    EditText edtParcelaLote;
    EditText edtCFOP;
    EditText edtImposto;
    EditText edtFrete;
    EditText edtDesconto;
    Spinner spiFornecedor;
    Button btnGravar;
    Button btnLimpar;
    Button btnPreencInfo;

    UfarmFornecedoresDao ForneceodoresDao;
    ArrayList<UfarmFornecedores> ListaFornecedores;
    ArrayList<UfarmAquisicoes> lista;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
 	
		
        View v = inflater.inflate(R.layout.activity_frag_implementos_ferramentas, container, false);
       
		edtData = (EditText) v.findViewById(R.id.edtData);
        edtData.setOnKeyListener(new MascaraData());
        edtQtde = (EditText) v.findViewById(R.id.edtQtde);

        edtNFscal = (EditText) v.findViewById(R.id.edtNumNotaFiscal);
        edtSerieNf = (EditText) v.findViewById(R.id.edtSerieNotaF);
        edtParcelaLote = (EditText) v.findViewById(R.id.edtParcelaLote);
        edtCFOP = (EditText) v.findViewById(R.id.edtCFOP);
        edtImposto = (EditText) v.findViewById(R.id.edtImposto);
        edtFrete = (EditText) v.findViewById(R.id.edtFrete);
        edtDesconto = (EditText) v.findViewById(R.id.edtDesconto);
        spiFornecedor = (Spinner) v.findViewById(R.id.spiFornecedor);
        btnGravar = (Button) v.findViewById(R.id.btnGravar);
        btnLimpar = (Button) v.findViewById(R.id.btnLimpar);
        btnPreencInfo = (Button) v.findViewById(R.id.btnPreencherInfo);


        ForneceodoresDao = new UfarmFornecedoresDao(bd);
        ListaFornecedores = ForneceodoresDao.buscaTodosFornecedores();
        //adapter para pupular o spinner
        ArrayAdapter<UfarmFornecedores> ArrayAdapter = new ArrayAdapter<UfarmFornecedores>(v.getContext(), R.layout.texto_personalizado, ListaFornecedores);
        ArrayAdapter<UfarmFornecedores> spinnerArrayAdapter2 = ArrayAdapter;
        spinnerArrayAdapter2.setDropDownViewResource(R.layout.texto_personalizado);
        spiFornecedor.setAdapter(spinnerArrayAdapter2);

        lista = new ArrayList<UfarmAquisicoes>();

        btnPreencInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qtde = Integer.parseInt(edtQtde.getText().toString());

                UfarmAquisicoes aquisicoes = new UfarmAquisicoes();
                aquisicoes.setData(new Function().converteData(edtData.getText().toString()));
                aquisicoes.setQtde(Integer.parseInt(edtQtde.getText().toString()));
                aquisicoes.setNf(Integer.parseInt(edtNFscal.getText().toString()));
                aquisicoes.setSerie(Integer.parseInt(edtSerieNf.getText().toString()));
                aquisicoes.setParcelaLote(Integer.parseInt(edtParcelaLote.getText().toString()));
                aquisicoes.setCfop(edtCFOP.getText().toString());
                aquisicoes.setImposto(edtImposto.getText().toString());
                aquisicoes.setFrete(edtFrete.getText().toString());
                aquisicoes.setDesconto(edtDesconto.getText().toString());
                aquisicoes.setFornecedor(spiFornecedor.getSelectedItem().toString());

                int i = 0;

                for ( i = 0; i < qtde;i++){
                    Intent intent = null;

                    if (info.trim().toString().equals("Implemento")){
                        intent = new Intent(v.getContext(), ActivityInfoImpleFerram.class);
                    }
                    if (info.trim().toString().equals("Rebanho")){
                        intent = new Intent(v.getContext(), ActivityInfoRebanho.class);
                    }
                    if (info.trim().toString().equals("Maquinas")){
                        intent = new Intent(v.getContext(), ActivityInfoMaqEquip.class);
                    }
                    if (info.trim().toString().equals("Veiculo")){
                        intent = new Intent(v.getContext(), ActivityInfoMaqEquip.class);
                        ActivityInfoMaqEquip.VEICULO = true;
                    }


                    //startActivity(i);
                    intent.putExtra("Aquisicao", aquisicoes);

                    FragImplementosFerramentas.this.startActivityForResult(intent, 3);

                    Log.w("teste resume", "2");
                }
            }
        });

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravaAquisicao();
            }
        });


        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.w("teste result", "chegou aqui!!!");
        getActivity();
        UfarmAquisicoes Aqui ;
        Aqui = (UfarmAquisicoes) intent.getSerializableExtra("Aqui");

        lista.add(Aqui);
    };

    public void gravaAquisicao() {
        UfarmAquisicoes ObjAquisicoes = null;
        UfarmAquisicaoDao AquiDao = null;
        if (ObjAquisicoes == null) {
            ObjAquisicoes = new UfarmAquisicoes();
        }
        if (AquiDao == null) {
            AquiDao = new UfarmAquisicaoDao(bd);
        }

        boolean resultado = true;

        for (int i = 0; i < lista.size(); i++) {

            resultado = true;
            try {

                ObjAquisicoes = lista.get(i);
                AquiDao.inserirAquisicao(ObjAquisicoes);

            } catch (Exception e) {
                resultado = false;
            }

        }
        if (resultado) {
            Toast.makeText(getView().getContext(), getString(R.string.msgSucesso), Toast.LENGTH_LONG).show();
            LimpaEdit();
        } else {
            Toast.makeText(getView().getContext(), getString(R.string.msgErroOperacao), Toast.LENGTH_LONG).show();
        }

    }

    public void LimpaEdit() {

        edtData.setText("");
        edtData.setText("");
        edtQtde .setText("1");
        edtNFscal.setText("");
        edtSerieNf.setText("");
        edtParcelaLote.setText("");
        edtCFOP.setText("");
        edtImposto.setText("");
        edtFrete.setText("");
        edtDesconto.setText("");

    }
}
