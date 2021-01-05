package com.example.ssb.Adapters.HomeSlider;

public class SliderItem {

    String image, text, text_info;

    public SliderItem() {
    }

    public SliderItem(String image, String text, String text_info) {
        this.image = image;
        this.text = text;
        this.text_info = text_info;
    }

    public String getText_info() {
        return text_info;
    }

    public void setText_info(String text_info) {
        this.text_info = text_info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
