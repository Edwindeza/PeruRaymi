package pe.luisvertiz.peruraymi.presentation.adapter;

import android.graphics.PorterDuff;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import pe.luisvertiz.peruraymi.R;
import pe.luisvertiz.peruraymi.data.entity.Guide;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<Guide> mData;
    private float mBaseElevation;

    public CardPagerAdapter() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardItem(Guide item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.item_guide, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        CardView cvGuide =  view.findViewById(R.id.cvGuide);

      //  cvGuide.setBackgroundResource(R.drawable.walkthought_1_img2);

        if (mBaseElevation == 0) {
            mBaseElevation = cvGuide.getCardElevation();
        }

        cvGuide.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cvGuide);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(Guide item, View view) {
        ImageView ivGuide =  view.findViewById(R.id.ivGuide);
        TextView tvTitle=view.findViewById(R.id.tvTitle);
        TextView tvTheme=view.findViewById(R.id.tvTheme);
        TextView tvDescription=view.findViewById(R.id.tvDescription);

        ivGuide.setImageResource(item.getIdImage());
        tvTitle.setText(item.getTitle());
        tvTheme.setText(item.getTheme());
        tvDescription.setText(item.getDescription());




    }

}
