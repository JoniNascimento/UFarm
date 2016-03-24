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
import br.com.unorte.ufarm.dao.UfarmFornecedoresDao;
import br.com.unorte.ufarm.pojo.UfarmAquisicoes;
import br.com.unorte.ufarm.pojo.UfarmFornecedores;
import br.com.unorte.ufarm.recursos.Function;
import br.com.unorte.ufarm.recursos.MascaraData;
import br.com.unorte.ufarm.recursos.MascaraMonetaria;

public class FragEmpFinan extends Fragment {
	
	public static String bd;
	public static int idProp;
	
	ArrayList<UfarmFornecedores> ListaFornecedores;
	UfarmFornecedoresDao ForneceodoresDao;
	Spinner spiFornecedores;
	EditText edtData;
	EditText edtContrato;
	EditText edtQtde;
	EditText edtVLUnitario;
	Button btnGravar;
	Button btnLipmar;
	EditText edtValorTotal;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) { 	
		
        View v = inflater.inflate(R.layout.activity_frag_emp_finan, container, false);

		edtData = (EditText) v.findViewById(R.id.edtData);
		edtData.setOnKeyListener(new MascaraData());


		edtContrato = (EditText) v.findViewById(R.id.edtContrato);
    	edtQtde = (EditText) v.findViewById(R.id.edtQtd);
    	edtVLUnitario = (EditText) v.findViewById(R.id.edtValorUn);
    	btnGravar = (Button) v.findViewById(R.id.btnGravar);
		btnLipmar = (Button) v.findViewById(R.id.btnLimpar);
    	edtValorTotal = (EditText) v.findViewById(R.id.edtValorTotal);
        
       
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
		
		edtVLUnitario.addTextChangedListener(new MascaraMonetaria(edtVLUnitario, true));
		edtVLUnitario.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				Double Aux, VlTotal;
				Aux =  Function.stringMonetarioToDouble(edtVLUnitario.getText().toString());
				VlTotal = Double.parseDouble(edtQtde.getText().toString()) * Aux; 
				edtValorTotal.setText(Double.toString(VlTotal));
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
		edtValorTotal.addTextChangedListener(new MascaraMonetaria(edtValorTotal, true));
		
		btnGravar.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				GravaEmpFinanc();
				
			}
		});
		btnLipmar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				LimpaEdit();
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
	
	public void GravaEmpFinanc(){
		
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
		ObjAquisicoes.setProdServico("Emprestimo e Financiamento");
		ObjAquisicoes.setFornecedor(spiFornecedores.getSelectedItem().toString());
		ObjAquisicoes.setContrato(edtContrato.getText().toString());
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
	public void LimpaEdit(){
		edtContrato.setText("");
		edtQtde.setText("1");
		edtVLUnitario.setText("");
		edtValorTotal.setText("");
		edtData.setText("");
	}
	
}
