package br.com.unorte.ufarm.Activity;



import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import br.com.unorte.ufarm.R;
import br.com.unorte.ufarm.dao.UfarmProdutoServicoDao;
import br.com.unorte.ufarm.pojo.UfarmProdutoServico;

public class TabProduto extends FragmentActivity{
	
	public static String bd;
	public static int idProp;
	
	FragArrendamento fArrendamento ;
	FragEmpFinan fEmpFinanc;
	FragImplementosFerramentas fImplFerramentas;
	FragInsumos fInsumos;
	FragLocacoes fLocacoes;
	FragMantimento fMantimento;
	FragMaqEquip fMaqEquip;
	FragRebanho fRebanho;
	FragSeguro fSeguro;
	FragVeiculo fVeiculo;

	FragmentManager fm = getSupportFragmentManager();
	Spinner spiOperacao,spiProdServ;
	
	LinearLayout lProdServ;
	
	private List<String> operacao;
	private ArrayList<UfarmProdutoServico> prodServ ;
	

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_produto);
        
        lProdServ = (LinearLayout) findViewById(R.id.layoutProdServ);
       // spi2 = (Spinner) findViewById(R.id.spiProdServ);
        
        if (operacao == null){
    		operacao= new ArrayList<String>();
    		operacao.add("Selecione...");
    		operacao.add("Aquisição");
    		operacao.add("Pagamento");
    		operacao.add("Venda");
    		operacao.add("Recebimento");
    		
    	}   	
		
        //REcuperação do spinner
        spiOperacao = (Spinner) findViewById(R.id.spiOperacao);
        //adapter para pupular o spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getBaseContext(), R.layout.texto_personalizado, operacao);
        //CustomArrayAdapter<String> arrayAdapter = new CustomArrayAdapter<String>(getContext(), operacao);
		ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
		spinnerArrayAdapter.setDropDownViewResource(R.layout.texto_personalizado);
		spiOperacao.setAdapter(spinnerArrayAdapter);
		spiOperacao.setOnItemSelectedListener(SelecionaOperacao());
		
		 if (prodServ == null){
			 UfarmProdutoServicoDao prodServDao = new UfarmProdutoServicoDao(bd);
			 prodServ = prodServDao.buscaProdServ("aquisicao");
	    		/*prodServ= new ArrayList<String>();
	    		prodServ.add("Selecione.....");
	    		prodServ.add("Arrendamento");
	    		prodServ.add("Emprestimos e Financiamentos");
	    		prodServ.add("Implementos e Ferramentas");
	    		prodServ.add("Isumos");
	    		prodServ.add("Locação");
	    		prodServ.add("Mantimento");
	    		prodServ.add("Máquinas e Equipamentos");
	    		prodServ.add("Rebanhos");
	    		prodServ.add("Seguro");
	    		prodServ.add("Veiculo");*/
	    		
	    		
	    	}   	
			
	        //REcuperação do spinner
		    spiProdServ = (Spinner) findViewById(R.id.spiProdServ);
	        //adapter para pupular o spinner
	        ArrayAdapter<UfarmProdutoServico> arrayAdapter2 = new ArrayAdapter<UfarmProdutoServico>(getBaseContext(), R.layout.texto_personalizado, prodServ);
	        //CustomArrayAdapter<String> arrayAdapter = new CustomArrayAdapter<String>(getContext(), operacao);
			ArrayAdapter<UfarmProdutoServico> spinnerArrayAdapter2 = arrayAdapter2;
			spinnerArrayAdapter2.setDropDownViewResource(R.layout.texto_personalizado);
			spiProdServ.setAdapter(spinnerArrayAdapter2);
			spiProdServ.setOnItemSelectedListener(SelecionaProdServ());
			
	
	
	
	}
	public OnItemSelectedListener SelecionaOperacao(){
		return (new AdapterView.OnItemSelectedListener() {  
		    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {   
		        //String nsvNome = spi.getSelectedItem().toString();  
		           //// Log.w("Cliente",nsvNome);  
		    	switch (spiOperacao.getSelectedItemPosition()) {
				case 1:
					
					Log.w("Cliente",Integer.toString( spiOperacao.getSelectedItemPosition()));
					 lProdServ.setVisibility(view.VISIBLE);
						
					break;
				case 2:
					//spi2.setVisibility(view.INVISIBLE);
					lProdServ.setVisibility(view.INVISIBLE);
					Log.w("Cliente",Integer.toString( spiOperacao.getSelectedItemPosition()));
					break;
				case 3:
					lProdServ.setVisibility(view.INVISIBLE);
					Log.w("Cliente",Integer.toString( spiOperacao.getSelectedItemPosition()));
					break;
				case 4:
					lProdServ.setVisibility(view.INVISIBLE);
					Log.w("Cliente",Integer.toString( spiOperacao.getSelectedItemPosition()));
					break;

				
				}
		    	
		    }
		    	
		    	
		        public void onNothingSelected(AdapterView<?> adapterView) {  
		            return;  
		        }   
		});
	}
	
	public OnItemSelectedListener SelecionaProdServ(){
		return new OnItemSelectedListener() {
		    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
		        //String nsvNome = spi.getSelectedItem().toString();
		           //// Log.w("Cliente",nsvNome);
		    	switch (spiProdServ.getSelectedItemPosition()) {
				case 1:
					if (fArrendamento == null){
						fArrendamento = new FragArrendamento();
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fArrendamento,"FragArrendamento");
						ft.commit();
					}else{
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fArrendamento,"FragArrendamento");
						ft.commit();
					}
					fArrendamento.idProp = TabProduto.idProp;
					fArrendamento.bd = TabProduto.bd;
					break;
				case 2:
					if (fEmpFinanc == null){
						fEmpFinanc = new FragEmpFinan();
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fEmpFinanc,"FragEmpFinan");
						ft.commit();
					}else{
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fEmpFinanc,"FragEmpFinan");
						ft.commit();
					}
					fEmpFinanc.idProp = TabProduto.idProp;
					fEmpFinanc.bd = TabProduto.bd;
					Log.w("Cliente",Integer.toString( spiProdServ.getSelectedItemPosition()));
					break;
				case 3:
					if (fImplFerramentas == null){
						fImplFerramentas = new FragImplementosFerramentas();
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace( R.id.frameTabProd,fImplFerramentas,"FragImplementosFerramentas");
						ft.commit();
					}else{
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace( R.id.frameTabProd, fImplFerramentas,"FragImplementosFerramentas");
						ft.commit();
					}
					fImplFerramentas.idProp = TabProduto.idProp;
					fImplFerramentas.bd = TabProduto.bd;
					fImplFerramentas.info = "Implemento";

					Log.w("Cliente",Integer.toString( spiProdServ.getSelectedItemPosition()));
					break;
				case 4:
					if (fInsumos == null){
						fInsumos = new FragInsumos();
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fInsumos,"FragInsumos");
						ft.commit();
					}else{
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fInsumos,"FragInsumos");
						ft.commit();
					}
					fInsumos.idProp = TabProduto.idProp;
					fInsumos.bd = TabProduto.bd;

					Log.w("Cliente",Integer.toString( spiProdServ.getSelectedItemPosition()));
					break;
				case 5:
					if (fLocacoes == null){
						fLocacoes = new FragLocacoes();
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fLocacoes,"FragLocacoes");
						ft.commit();
					}else{
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fLocacoes,"FragLocacoes");
						ft.commit();
					}
					fLocacoes.idProp = TabProduto.idProp;
					fLocacoes.bd = TabProduto.bd;
					Log.w("Cliente",Integer.toString( spiProdServ.getSelectedItemPosition()));
					break;
				case 6:
					if (fMantimento == null){
						fMantimento = new FragMantimento();
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fMantimento,"FragMantimento");
						ft.commit();
					}else{
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fMantimento,"FragMantimento");
						ft.commit();
					}
					fMantimento.idProp = TabProduto.idProp;
					fMantimento.bd = TabProduto.bd;

					Log.w("Cliente",Integer.toString( spiProdServ.getSelectedItemPosition()));
					break;
				case 7:
					/*if (fMaqEquip == null){
						fMaqEquip = new FragMaqEquip();
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fMaqEquip,"FragMaqEquip");
						ft.commit();
					}else{
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fMaqEquip,"FragMaqEquip");
						ft.commit();
					}*/
					if (fImplFerramentas == null){
						fImplFerramentas = new FragImplementosFerramentas();
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace( R.id.frameTabProd,fImplFerramentas,"FragImplementosFerramentas");
						ft.commit();
					}else{
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace( R.id.frameTabProd, fImplFerramentas,"FragImplementosFerramentas");
						ft.commit();
					}
					fImplFerramentas.idProp = TabProduto.idProp;
					fImplFerramentas.bd = TabProduto.bd;
					fImplFerramentas.info = "Maquinas";



					Log.w("Cliente",Integer.toString( spiProdServ.getSelectedItemPosition()));
					break;
				case 8:
					/*if (fRebanho == null){
						fRebanho = new FragRebanho();
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fRebanho,"FragRebanho");
						ft.commit();
					}else{
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fRebanho,"FragRebanho");
						ft.commit();
					}
					*/
					if (fImplFerramentas == null){
						fImplFerramentas = new FragImplementosFerramentas();
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace( R.id.frameTabProd,fImplFerramentas,"FragImplementosFerramentas");
						ft.commit();
					}else{
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace( R.id.frameTabProd, fImplFerramentas,"FragImplementosFerramentas");
						ft.commit();
					}
					fImplFerramentas.idProp = TabProduto.idProp;
					fImplFerramentas.bd = TabProduto.bd;
					fImplFerramentas.info = "Rebanho";

					Log.w("Cliente",Integer.toString( spiProdServ.getSelectedItemPosition()));
					break;
				case 9:
					if (fSeguro == null){
						fSeguro = new FragSeguro();
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fSeguro,"FragSeguro");
						ft.commit();
					}else{
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fSeguro,"FragSeguro");
						ft.commit();
					}
					fSeguro.idProp = TabProduto.idProp;
					fSeguro.bd = TabProduto.bd;

					Log.w("Cliente",Integer.toString( spiProdServ.getSelectedItemPosition()));
					break;
				case 10:
					/*if (fVeiculo == null){
						fVeiculo = new FragVeiculo();
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fVeiculo,"FragVeiculo");
						ft.commit();
					}else{
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace(R.id.frameTabProd, fVeiculo,"FragVeiculo");
						ft.commit();
					}*/
					if (fImplFerramentas == null){
						fImplFerramentas = new FragImplementosFerramentas();
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace( R.id.frameTabProd,fImplFerramentas,"FragImplementosFerramentas");
						ft.commit();
					}else{
						FragmentTransaction ft =fm.beginTransaction();
						ft.replace( R.id.frameTabProd, fImplFerramentas,"FragImplementosFerramentas");
						ft.commit();
					}
					fImplFerramentas.idProp = TabProduto.idProp;
					fImplFerramentas.bd = TabProduto.bd;
					fImplFerramentas.info = "Veiculo";

					Log.w("Cliente",Integer.toString( spiProdServ.getSelectedItemPosition()));
					break;


				}

		    }


		        public void onNothingSelected(AdapterView<?> adapterView) {
		            return;
		        }
		    };
	}

				
		
		
	
		
		
	
/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    	
    	if (operacao == null){
    		operacao= new ArrayList<String>();
    		operacao.add("Aquisição");
    		operacao.add("Pagamento");
    		operacao.add("Venda");
    		operacao.add("Recebimento");
    		
    	}   	
		
        View v = inflater.inflate(R.layout.activity_tab_produto, container, false);
        //REcuperação do spinner
        Spinner spi = (Spinner) v.findViewById(R.id.spiOperacao);
        //adapter para pupular o spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(v.getContext(), R.layout.texto_personalizado, operacao);
        //CustomArrayAdapter<String> arrayAdapter = new CustomArrayAdapter<String>(getContext(), operacao);
		ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
		spinnerArrayAdapter.setDropDownViewResource(R.layout.texto_personalizado);
		spi.setAdapter(spinnerArrayAdapter);
		//spi.setOnItemClickListener(SelecionaOperacao());
		 //adapter para pupular o spinner
		
		
        return v;
    }*/

	
    
}
