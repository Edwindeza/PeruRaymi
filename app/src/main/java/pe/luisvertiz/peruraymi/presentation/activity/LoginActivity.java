package pe.luisvertiz.peruraymi.presentation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import pe.luisvertiz.peruraymi.R;

public class LoginActivity extends AppCompatActivity {
    private AppCompatButton btnIngresar;
    private TextView tvCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnIngresar=findViewById(R.id.btnIngresar);
        tvCreateAccount=findViewById(R.id.tvCreateAccount);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, GuideActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
