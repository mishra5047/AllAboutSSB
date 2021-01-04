package com.example.ssb.Adapters.HomeOptions;

import android.graphics.drawable.Drawable;

public class homeItem {
    int image;
    String text;

    public homeItem() {
    }

    public homeItem(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}
