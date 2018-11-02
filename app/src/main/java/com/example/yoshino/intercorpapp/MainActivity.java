package com.example.yoshino.intercorpapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LinearLayout liner;

    private ViewPagerAdapter adapter;

    private RecyclerView myrecyclerView;
    private List<Contact> lstContact;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liner =findViewById(R.id.list_post);

        myrecyclerView = findViewById(R.id.list_search);

        lstContact = new ArrayList<>();
        String fl ="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, " +
                "   ";
        lstContact.add(new Contact("Investigación Presupuestal","Estudio",R.drawable.f1,"18",fl));
        lstContact.add(new Contact("Implementación de Grupo Electrogeno","Proyecto",R.drawable.f1,"120",fl));
        lstContact.add(new Contact("Sistema Comercial","Proyecto",R.drawable.f1,"11",fl));
        lstContact.add(new Contact("Automatización de Adquisiciones","Proyecto",R.drawable.f1,"8",fl));
        lstContact.add(new Contact("Transición a la ciencia de datos","Articulo",R.drawable.f1,"5",fl));
        lstContact.add(new Contact("Ayuda sobre java","Foro",R.drawable.f1,"8",fl));



//        lstContact.add(new Contact("Ytalo","999123456",R.drawable.cpu,R.drawable.d3));
//        lstContact.add(new Contact("Pedro","999123456",R.drawable.cpu,R.drawable.d4));
//        lstContact.add(new Contact("Loreso","999123456",R.drawable.cpu,R.drawable.d3));
//        lstContact.add(new Contact("Pablo","999123456",R.drawable.cpu,R.drawable.d4));
//        lstContact.add(new Contact("Juancho","999123456",R.drawable.cpu,R.drawable.d3));
//        lstContact.add(new Contact("Franco","999123456",R.drawable.cpu,R.drawable.d4));

        recyclerViewAdapter = new RecyclerViewAdapter(this,lstContact);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(this  ));
        myrecyclerView.setAdapter(recyclerViewAdapter);




        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpaper_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());


        adapter.addFragment(new PostActivityFragment(),"");
        adapter.addFragment(new UserActivityFragment(),"");
        adapter.addFragment(new RankingActivityFragment(),"");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.reunioncolor);
        tabLayout.getTabAt(1).setIcon(R.drawable.conferencia);
        tabLayout.getTabAt(2).setIcon(R.drawable.logro);





        viewPager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {

                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

                    @Override
                    public void onPageSelected(int position) {
                        switch (position) {
                            case 0:
                                tabLayout.getTabAt(0).setIcon(R.drawable.reunioncolor);
                                tabLayout.getTabAt(1).setIcon(R.drawable.conferencia);
                                tabLayout.getTabAt(2).setIcon(R.drawable.logro);
                                break;
                            case 1:
                                tabLayout.getTabAt(0).setIcon(R.drawable.reunion);
                                tabLayout.getTabAt(1).setIcon(R.drawable.conferenciacolor);
                                tabLayout.getTabAt(2).setIcon(R.drawable.logro);
                                break;
                            case 2:
                                tabLayout.getTabAt(0).setIcon(R.drawable.reunion);
                                tabLayout.getTabAt(1).setIcon(R.drawable.conferencia);
                                tabLayout.getTabAt(2).setIcon(R.drawable.logrocolor);
                                break;
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }
                }
        );
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        //MenuItem searchReturn = menu.findItem(R.id.);

        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerViewAdapter.getFilter().filter(newText);
                return false;
            }
        });


        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                liner.setVisibility(View.VISIBLE);
                tabLayout.setVisibility(View.GONE);
                viewPager.setVisibility(View.GONE);
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                liner.setVisibility(View.GONE);
                tabLayout.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                return false;
            }
        });



        return true;
    }
}
