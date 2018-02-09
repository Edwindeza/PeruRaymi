package pe.luisvertiz.peruraymi.presentation.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pe.luisvertiz.peruraymi.R;
import pe.luisvertiz.peruraymi.data.entity.Guide;
import pe.luisvertiz.peruraymi.presentation.adapter.CardPagerAdapter;
import pe.luisvertiz.peruraymi.presentation.adapter.ShadowTransformer;

public class GuideActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private TextView tvExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        tvExit=findViewById(R.id.tvExit);
        mViewPager = findViewById(R.id.viewPager);
        mCardAdapter = new CardPagerAdapter();

        mCardAdapter.addCardItem(new Guide(R.drawable.walkthought_1_img1, "La historia está cerca de ti", "En HISTORIA", ""));
        mCardAdapter.addCardItem(new Guide(R.drawable.walkthought_2_img1, "Disfruta de shows, comida y fiestas peruanas", "En LUGARES", ""));
        mCardAdapter.addCardItem(new Guide(R.drawable.walkthought_3_img1, "La cultura y diversión te puede encontrar", "El MAPA", ""));
        mCardAdapter.addCardItem(new Guide(R.drawable.walkthought_4_img1, "La cultura y diversión te puede encontrar", "En FAVORITOS", ""));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mCardShadowTransformer.enableScaling(true);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(4);

        tvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuideActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
