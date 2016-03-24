package br.com.unorte.ufarm.Activity;

import java.util.List;

import android.R.color;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomArrayAdapter<String> extends ArrayAdapter<String>
{
    public CustomArrayAdapter(Context ctx, List<String> operacao)
    {
        super(ctx, android.R.layout.simple_spinner_item, operacao);
    }

    //other constructors

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        View view = super.getView(position, convertView, parent);

        //we know that simple_spinner_item has android.R.id.text1 TextView:         

        /* if(isDroidX) {*/
            TextView text = (TextView)view.findViewById(android.R.id.text1);
            text.setTextColor(Color.BLACK);//choose your color :)  
            text.setBackgroundColor(Color.WHITE);
        /*}*/

        return view;

    }
}
