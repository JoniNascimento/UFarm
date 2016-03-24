package br.com.unorte.ufarm.Activity;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import br.com.unorte.ufarm.R;

public class FrameProdServ extends Fragment {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
 	
		
        View v = inflater.inflate(R.layout.activity_frame_prod_serv, container, false);
       
		
		
        return v;
    }
}
