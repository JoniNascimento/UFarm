package br.com.unorte.ufarm.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import br.com.unorte.ufarm.R;

public class PagFragPagamentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag_frag_pagamentos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pag_frag_pagamentos, menu);
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

/* TRECHO DE CODIGO PARA SER USADO PARA POPULAR COM DADOS DA TABELA
    DespesaReceitaDAO drDAO = new DespesaReceitaDAO(this);
    List<DespesaReceita> lista = drDAO.selectAll();

    for(DespesaReceita oDr1 : lista)
    {
        final LinearLayout linha = new LinearLayout(this);
        linha.setOrientation(0);

        final TextView colNome = new TextView(this);
        colNome.setWidth(150);
        colNome.setText(oDr1.getNome());

        final TextView colTipo = new TextView(this);
        colTipo.setWidth(150);
        colTipo.setText(oDr1.getTipoDespesaReceita().getNome());


        final TextView colValor = new TextView(this);
        if (oDr1.getDespesaReceita().equals("Receita"))
        {
            colValor.setText(String.format("%.2f", oDr1.getValor()));
        }
        else
        {
            colValor.setText("-"+String.format("%.2f", oDr1.getValor()));
        }

        linha.addView(colNome);
        linha.addView(colTipo);
        linha.addView(colValor);
        linearLayout.addView(linha);
    }*/
}
