package br.com.unorte.ufarm.Activity;




import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import br.com.unorte.ufarm.R;



public class PainelProdutivo extends TabActivity {
	public static String bd;
	public static int idProp;
	public static String propriedade;
	
	TextView resultado;

	private Toolbar mToolbar;

	private Drawer navigationDrawerLeft;

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private String[] mActivityesList;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_painel_produtivo);

		mToolbar = (Toolbar) findViewById(R.id.toolbarpp);
		mToolbar.setTitle(getTitle().toString());
		//mToolbar.setSubtitle("Joni");
		mToolbar.setLogo(R.drawable.ic_launcher);

		//resultado = (TextView) findViewById(R.id.txtVResultado);
		//resultado.setText("A propriedade escolhida foi: ID:" +Integer.toString(idProp) +" Propriedade: "+ propriedade );
		TabHost tabhost = (TabHost) findViewById(android.R.id.tabhost);
		//tabhost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);


		TabHost.TabSpec tab1 = tabhost.newTabSpec("Tab 1");
		//TabHost.TabSpec tab2 = tabhost.newTabSpec("Tab 2");
		TabHost.TabSpec tab3 = tabhost.newTabSpec("Tab 3");


		//Aqui cria e carrega uma tab para adicionar ao taabhost
		tab1.setIndicator("Produto");
		//tab1.setIndicator("", getResources().getDrawable(R.drawable.buidl));
		tab1.setContent(new Intent(this, TabProduto.class));
		TabProduto.idProp = PainelProdutivo.idProp;
		TabProduto.bd = PainelProdutivo.bd;

		//tab2.setIndicator("Atividade Operacional");
		//tab1.setIndicator("", getResources().getDrawable(R.drawable.build2));
		//tab2.setContent(new Intent(this, TabAtvAdm.class));

		tab3.setIndicator("Atividade Rotineira");
		//tab3.setIndicator("", getResources().getDrawable(R.id.icon));
		tab3.setContent(new Intent(this, TabAtvRot.class));

		//Aqui adiciona a tab no tab host
		tabhost.addTab(tab1);
		//tabhost.addTab(tab2);
		tabhost.addTab(tab3);

		/*tabhost.addTab( tabhost.newTabSpec("tab1").setIndicator("Produto", null), TabProduto.class, null);
		tabhost.addTab( tabhost.newTabSpec("tab2").setIndicator("Serviço", null), TabServico.class, null);
		tabhost.addTab( tabhost.newTabSpec("tab3").setIndicator("Atividade Rotineira", null), TabAtvRot.class, null);*/


		//Nesse trecho eu localizo o texteView do tab e manipulo cor tamanho etc....
	    for(int i=0;i<tabhost.getTabWidget().getChildCount();i++)
	    {
	        TextView tv = (TextView) tabhost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
	        tv.setTextColor(Color.parseColor("#000000"));
	    }



		mActivityesList = getResources().getStringArray(R.array.ArrayNavigDrawer);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerList.setAdapter(new ArrayAdapter<String>(this,R.layout.drawer_list_item, mActivityesList));
        mDrawerList.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    //Toast.makeText(PainelProdutivo.this, "Selecionou o i tem 1", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PainelProdutivo.this, PainelProdutivo.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    //Toast.makeText(PainelProdutivo.this, "Selecionou o i tem 2", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PainelProdutivo.this, AtvOperacional.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    //Toast.makeText(PainelProdutivo.this, "Selecionou o i tem 3", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PainelProdutivo.this, Producao.class);
                    startActivity(intent);
                }
                PainelProdutivo.this.finish();


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
            mDrawerList.setItemChecked(0, true);
            setTitle(mActivityesList[0]);
            mDrawerLayout.closeDrawer(mDrawerList);

        }

        //noinspection ConstantConditions

        //getActionBar().setDisplayHomeAsUpEnabled(true);
        //getActionBar().setHomeButtonEnabled(true);


		/*navigationDrawerLeft = new DrawerBuilder()
				.withActivity(this)
				.addDrawerItems(
						new PrimaryDrawerItem().withName(R.string.drawerAtvAdm),
						new DividerDrawerItem(),
						new PrimaryDrawerItem().withName(R.string.drawerAtvOp),
						new DividerDrawerItem(),
						new PrimaryDrawerItem().withName(R.string.drawerProducao),
						new DividerDrawerItem())
				.withToolbar(mToolbar)
				.withActionBarDrawerToggleAnimated(true)
                .withSelectedItem(0)
				.withDisplayBelowStatusBar(true)
				.withDrawerGravity(Gravity.LEFT)
				.withSavedInstance(savedInstanceState)
				.withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
					@Override
					public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {

						if (i == 0) {
							//Toast.makeText(PainelProdutivo.this, "Selecionou o i tem 1", Toast.LENGTH_SHORT).show();
							Intent intent = new Intent(PainelProdutivo.this, PainelProdutivo.class);
							startActivity(intent);
						}
						if (i == 2) {
							//Toast.makeText(PainelProdutivo.this, "Selecionou o i tem 2", Toast.LENGTH_SHORT).show();
							Intent intent = new Intent(PainelProdutivo.this, AtvOperacional.class);
							startActivity(intent);
							finish();
						}
						if (i == 4) {
							//Toast.makeText(PainelProdutivo.this, "Selecionou o i tem 3", Toast.LENGTH_SHORT).show();
							Intent intent = new Intent(PainelProdutivo.this, Producao.class);
							startActivity(intent);
						}
						PainelProdutivo.this.finish();
						return false;
					}
				})
				.build();*/

		/*navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName(R.string.drawerAtvAdm));
		navigationDrawerLeft.addItem(new DividerDrawerItem());
		navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName(R.string.drawerAtvOp));
		navigationDrawerLeft.addItem(new DividerDrawerItem());
		navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName(R.string.drawerProducao));
		navigationDrawerLeft.addItem(new DividerDrawerItem());*/





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
/*

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.painel_produtivo, menu);
		setTitle(propriedade);
		setTitleColor(Color.BLUE);
		return true;
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
	}*/
}
