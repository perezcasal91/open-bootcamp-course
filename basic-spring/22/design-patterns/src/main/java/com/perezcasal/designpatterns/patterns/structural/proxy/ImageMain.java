package com.perezcasal.designpatterns.patterns.structural.proxy;

public class ImageMain {
    public static void main(String[] args) {
        Image image = new ImageProxy("hello");
        image.show();
        System.out.println("=====");
        image.show();
    }
}

interface Image {
    void show();
}

class RealImage implements Image {
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }

    @Override
    public void show() {
        System.out.println("Showing image with name: " + fileName);
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk with name: " + fileName);
    }
}

class ImageProxy implements Image {
    private RealImage realImage;
    private final String fileName;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void show() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.show();
    }
}