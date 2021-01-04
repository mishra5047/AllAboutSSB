package com.example.ssb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.ViewHolder> {
    private Context context;
    private List<SliderItem> mSliderItems;

    public SliderAdapter(Context context, List<SliderItem> mSliderItems) {
        this.context = context;
        this.mSliderItems = mSliderItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        SliderItem item = mSliderItems.get(position);

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
    public int getCount() {
        return mSliderItems.size();
    }

    public static class ViewHolder extends SliderViewAdapter.ViewHolder {
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

