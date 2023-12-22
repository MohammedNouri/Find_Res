package com.example.find_res;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.find_res.MyAdapter.MyAdapter;
import com.example.find_res.model.Magasin;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Magasin> magasins;
    private Spinner citySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        citySpinner = findViewById(R.id.citySpinner);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = findViewById(R.id.toll_menu);
        setSupportActionBar(toolbar);

        // Exemple de données pour le RecyclerView
        magasins = new ArrayList<>();

        //Declarer le Adapter et passer les données magasins
        magasins.add(new Magasin("Safi","Kenedy","Karam-Cham",065));
        magasins.add(new Magasin("Marrakech","Gueliz","Adresse",065));
        magasins.add(new Magasin("Tanger","fgkdkdr","jjnff",065));



        //setAdapter(adapter) a le recyclerView


        // Initialiser le Spinner

        Resources res = getResources();
        String[] cities = res.getStringArray(R.array.cities);
        ArrayAdapter adapter1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, cities);
        citySpinner.setAdapter(adapter1);
        // Ajouter un écouteur de sélection au Spinner
        citySpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Magasin> magasinList = new ArrayList<>();
                String itemSelect = parent.getItemAtPosition(position).toString();
                for (Magasin m : magasins) {
                    if (m.getVille().toString() ==itemSelect){
                        magasinList.add(m);
                    }
                }
                MyAdapter myAdapter = new MyAdapter(magasinList);
                recyclerView.setAdapter(myAdapter);
            }
        });


    }

    //Ajouter le menu a l'application
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.help) {
            Toast.makeText(this, "Option help selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.contact) {
            Toast.makeText(this, "Contact  selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}