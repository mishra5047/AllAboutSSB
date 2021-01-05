package com.example.ssb.Adapters.CardStack;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ssb.Adapters.HomeSlider.SliderItem;
import com.example.ssb.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {
    ArrayList<SliderItem> stackItems;
    Context context;

    public CardStackAdapter(ArrayList<SliderItem> stackItems, Context context) {
        this.stackItems = stackItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        SliderItem item = stackItems.get(position);

        Picasso.get().load(item.getImage()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                viewHolder.image.setBackground(new BitmapDrawable(context.getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });

        viewHolder.txtBottom.setText(item.getText());
        viewHolder.txtInfo.setText(item.getText_info());
    }

    @Override
    public int getItemCount() {

        return stackItems.size();

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView txtBottom;
        TextView txtInfo;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgBackground);
            txtBottom = itemView.findViewById(R.id.txtBottom);
            txtInfo = itemView.findViewById(R.id.txtBottom_data);
        }
    }
}
