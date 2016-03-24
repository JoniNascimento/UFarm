package br.com.unorte.ufarm.Activity;


import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TabHost;

import br.com.unorte.ufarm.R;

public class TabAtvRot extends FragmentActivity{

    Tab_AtvRotExpedicao tabExp;
    Tab_AtvRotOrganizacao tabOrg;

    private LinearLayout FragAtvRot;

    FragmentManager fm = getSupportFragmentManager();

    private RadioButton rbExpe, rbOrg;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_atv_rot);

        FragAtvRot = (LinearLayout) findViewById(R.id.fragAtvRot);
        rbExpe = (RadioButton) findViewById(R.id.rbExp);
        rbOrg = (RadioButton) findViewById(R.id.rbOrg);

    }




    public void mudarTelaAtvOp(View v) {

        if (rbExpe.isChecked()) {
            if (tabExp == null) {
                tabExp = new Tab_AtvRotExpedicao();

            }
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragAtvRot, tabExp, "Tab_AtvRotExpedicao");
            ft.commit();
        }
        if (rbOrg.isChecked()) {
            if (tabOrg == null) {
                tabOrg = new Tab_AtvRotOrganizacao();

            }
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragAtvRot, tabOrg, "Tab_AtvRotOrganizacao");
            ft.commit();
        }
    }
/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_tab_atv_rot, container, false);
     //   Spinner spi = (Spinner) v.findViewById(R.id.spinner1);
       // tv.setText(this.getTag() + " Content");
        return v;
    }*/
}
