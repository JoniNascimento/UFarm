package br.com.unorte.ufarm.recursos;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.unorte.ufarm.R;
import br.com.unorte.ufarm.pojo.Propriedades;

public class AdapterListaProp extends ArrayAdapter<Propriedades> {
private Context context;
private ArrayList<Propriedades> lista;


	public AdapterListaProp(Context context, ArrayList<Propriedades> lista) {
	super(context, 0);
	this.context = context;
	this.lista = lista;
}

	@Override
	public int getCount() {
		return lista.size();
	}

	@Override
	public Propriedades getItem(int position) {
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		return lista.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Propriedades prop = lista.get(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.lista_prop, null);
		
		ImageView image = (ImageView) convertView.findViewById(R.id.image);
		image.setImageResource(R.drawable.arrow);
		
		TextView nome = (TextView) convertView.findViewById(R.id.txvNome);
		nome.setText(prop.getProp());
		
		
		
		return convertView;
	}

}
