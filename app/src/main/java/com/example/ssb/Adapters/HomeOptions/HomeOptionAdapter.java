package com.example.ssb.Adapters.HomeOptions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ssb.R;

import java.util.ArrayList;

public class HomeOptionAdapter extends RecyclerView.Adapter<HomeOptionAdapter.ViewHolder> {
    Context context;
    ArrayList<homeItem> list;

    public HomeOptionAdapter(Context context, ArrayList<homeItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_option, null);
        return new HomeOptionAdapter.ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        homeItem item = list.get(position);

        holder.imageView.setBackgroundResource(item.getImage());
        holder.textView.setText(item.getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);

        }
    }
}

