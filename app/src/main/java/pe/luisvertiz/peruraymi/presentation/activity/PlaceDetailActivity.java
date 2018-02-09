package pe.luisvertiz.peruraymi.presentation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import pe.luisvertiz.peruraymi.R;

public class PlaceDetailActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);
        toolbar=findViewById(R.id.toolbar);

        showToolbar("", true);
    }

    private void showToolbar(String title, boolean upButton) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return super.onSupportNavigateUp();
    }
}
