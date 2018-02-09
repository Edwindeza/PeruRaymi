package pe.luisvertiz.peruraymi.presentation.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import pe.luisvertiz.peruraymi.R;

public class SignUpActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private AppCompatButton btnCrear;
    private TextView tvWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        toolbar=findViewById(R.id.toolbar);
        btnCrear=findViewById(R.id.btnCrear);
        tvWeb=findViewById(R.id.tvWeb);
        showToolbar("Crear Cuenta", true);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpActivity.this, GuideActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tvWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.web)));
                startActivity(browserIntent);
            }
        });
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
        return super.onSupportNavigateUp();
    }
}
