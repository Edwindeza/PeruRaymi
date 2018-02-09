package pe.luisvertiz.peruraymi.presentation.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import pe.luisvertiz.peruraymi.R;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView cvHistory;
    private CardView cvPlaces;
    private CardView cvMap;
    private CardView cvFavorites;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        cvHistory=findViewById(R.id.cvHistory);
        cvPlaces=findViewById(R.id.cvPlaces);
        cvMap=findViewById(R.id.cvMap);
        cvFavorites=findViewById(R.id.cvFavorites);

        cvHistory.setOnClickListener(this);
        cvPlaces.setOnClickListener(this);
        cvMap.setOnClickListener(this);
        cvFavorites.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cvHistory:  launchActivity(MenuActivity.this, HistoryActivity.class); break;
            case R.id.cvPlaces: launchActivity(MenuActivity.this, PlacesActivity.class); break;
            case R.id.cvMap: launchActivity(MenuActivity.this, MapsActivity.class); break;
            case R.id.cvFavorites: launchActivity(MenuActivity.this, FavoritesActivity.class); break;
        }

    }

    private void launchActivity(Context from, Class to) {
        Intent intent=new Intent(from, to);
        startActivity(intent);

    }
}
