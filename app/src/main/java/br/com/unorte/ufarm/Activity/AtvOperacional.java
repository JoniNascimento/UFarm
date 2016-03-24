package br.com.unorte.ufarm.Activity;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import br.com.unorte.ufarm.R;

public class AtvOperacional extends FragmentActivity {



    private Toolbar mToolbar;
    private Toolbar mToolbarBottom;

    private Drawer navigationDrawerLeft;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mActivityesList;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_operacional);

        mToolbar = (Toolbar) findViewById(R.id.toolbaratv);
        mToolbar.setTitle(getTitle().toString());
        //mToolbar.setSubtitle("Joni");
        mToolbar.setLogo(R.drawable.ic_launcher);
        //setSupportActionBar(mToolbar);

        mActivityesList = getResources().getStringArray(R.array.ArrayNavigDrawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mActivityesList));
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    //Toast.makeText(PainelProdutivo.this, "Selecionou o i tem 1", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AtvOperacional.this, PainelProdutivo.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    //Toast.makeText(PainelProdutivo.this, "Selecionou o i tem 2", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AtvOperacional.this, AtvOperacional.class);
                    startActivity(intent);
                    finish();
                }
                if (i == 2) {
                    //Toast.makeText(PainelProdutivo.this, "Selecionou o i tem 3", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AtvOperacional.this, Producao.class);
                    startActivity(intent);
                }
                AtvOperacional.this.finish();


            }
        });
        // Set the list's click listener
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                mToolbar,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close) {


        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mToolbar.setNavigationIcon(R.drawable.ic_drawer);

        if (savedInstanceState == null) {


            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(1, true);
            setTitle(mActivityesList[1]);
            mDrawerLayout.closeDrawer(mDrawerList);

        }


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

}
