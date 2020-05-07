package com.kodilla.first.individual.project.Logic;


import javafx.scene.image.ImageView;

public class ExtendedImageView {
    private ImageView imageView;
    private Boolean aBoolean;

    public ExtendedImageView() {
    }

    public ExtendedImageView(ImageView imageView, Boolean aBoolean) {
        this.imageView = imageView;
        this.aBoolean = aBoolean;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }
}
