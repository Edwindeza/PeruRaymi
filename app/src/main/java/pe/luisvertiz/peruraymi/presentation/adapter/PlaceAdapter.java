package pe.luisvertiz.peruraymi.presentation.adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import pe.luisvertiz.peruraymi.R;
import pe.luisvertiz.peruraymi.data.entity.Place;
import pe.luisvertiz.peruraymi.presentation.activity.PlaceDetailActivity;

/**
 * Created by Luis on 14/01/2018.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>{
    private Context context;
    private List<Place> list;

    public PlaceAdapter(Context context, List<Place> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);
        return new PlaceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        Place place=list.get(position);
        holder.tvName.setText(place.getName());
        holder.tvAddress.setText(place.getAdress());

        holder.cvPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, PlaceDetailActivity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void removeItem(int position){
        list.remove(position);
        // dont call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

    public void restoreItem(Place place, int position){
        list.add(position, place);

        notifyItemInserted(position);

    }


    public class PlaceViewHolder extends RecyclerView.ViewHolder{
        private CardView cvPlace;
        public TextView tvName;
        public TextView tvAddress;
        public ImageView ivPlace;
        public RelativeLayout viewBackground;
        public RelativeLayout viewForeground;


        public PlaceViewHolder(View itemView) {
            super(itemView);
            cvPlace=itemView.findViewById(R.id.cvPlace);
            tvName=itemView.findViewById(R.id.tvName);
            tvAddress=itemView.findViewById(R.id.tvAddress);
            ivPlace=itemView.findViewById(R.id.ivPlace);
            viewBackground=itemView.findViewById(R.id.view_background);
            viewForeground=itemView.findViewById(R.id.view_foreground);

        }
    }

}
