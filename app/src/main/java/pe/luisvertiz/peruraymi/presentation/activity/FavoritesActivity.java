package pe.luisvertiz.peruraymi.presentation.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.luisvertiz.peruraymi.R;
import pe.luisvertiz.peruraymi.data.entity.Place;
import pe.luisvertiz.peruraymi.presentation.adapter.PlaceAdapter;
import pe.luisvertiz.peruraymi.presentation.adapter.RecyclerItemTouchHelper;

public class FavoritesActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {
    private RecyclerView rvPlaces;
    private List<Place> places;
    private PlaceAdapter adapter;
    private CoordinatorLayout coordinatorLayout;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        toolbar=findViewById(R.id.toolbar);
        rvPlaces=findViewById(R.id.rvPlaces);
        coordinatorLayout=findViewById(R.id.coordinatorLayout);
        showToolbar("Favoritos", false);

        places=new ArrayList<>();
        adapter=new PlaceAdapter(this, places);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        rvPlaces.setLayoutManager(layoutManager);
        rvPlaces.setItemAnimator(new DefaultItemAnimator());
        rvPlaces.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvPlaces.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback= new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(rvPlaces);

        preparePlaces();

    }

    private void preparePlaces() {
        List<Place> list=new ArrayList<>();
        list.add(new Place(0, "Bar El Tayta", "Av. Larco 437, Miraflores", 5));
        list.add(new Place(0, "Bar El Tayta", "Av. Larco 437, Miraflores", 5));
        list.add(new Place(0, "Bar El Tayta", "Av. Larco 437, Miraflores", 5));
        list.add(new Place(0, "Bar El Tayta", "Av. Larco 437, Miraflores", 5));
        list.add(new Place(0, "Bar El Tayta", "Av. Larco 437, Miraflores", 5));

       places.clear();
        places.addAll(list);
        adapter.notifyDataSetChanged();
    }

    private void showToolbar(String title, boolean upButton) {
        setSupportActionBar(toolbar);
        TextView tvTitle=toolbar.findViewById(R.id.tvTitle);
        tvTitle.setText(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if(viewHolder instanceof PlaceAdapter.PlaceViewHolder){
            String name=places.get(viewHolder.getAdapterPosition()).getName();

            final Place deletedPlace=places.get(viewHolder.getAdapterPosition());
            final int deletedIndex=viewHolder.getAdapterPosition();

            adapter.removeItem(viewHolder.getAdapterPosition());

            Snackbar snackbar=Snackbar.make(coordinatorLayout, name + " ha sido borrado", Snackbar.LENGTH_LONG);
            snackbar.setAction("REHACER", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.restoreItem(deletedPlace, deletedIndex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemMenu: launchActivity(getApplicationContext(), MenuActivity.class); finish(); break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void launchActivity(Context from, Class to) {
        Intent intent=new Intent(from, to);
        startActivity(intent);

    }
}
