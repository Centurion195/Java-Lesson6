package Homework;

import java.util.ArrayList;
import java.util.List;

public class Laptop {
//    private static int defaultIndex = 1;
//    private static List<Integer> laptopID = new ArrayList<>();

    private int id;
    private double price;
    private String accessMemory;
    private String processor;
    private double diagonalOfTheScreen;
    private String manufacturer;
    private String volumeOfTheDrive;
    private String os;
    private String videoCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAccessMemory() {
        return accessMemory;
    }

    public void setAccessMemory(String randomAccessMemory) {
        this.accessMemory = randomAccessMemory;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public double getDiagonalOfTheScreen() {
        return diagonalOfTheScreen;
    }

    public void setDiagonalOfTheScreen(double diagonalOfTheScreen) {
        this.diagonalOfTheScreen = diagonalOfTheScreen;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getVolumeOfTheDrive() {
        return volumeOfTheDrive;
    }

    public void setVolumeOfTheDrive(String volumeOfTheDrive) {
        this.volumeOfTheDrive = volumeOfTheDrive;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }
//    public Laptop() {
//        if (!laptopID.contains(defaultIndex)) {
//            laptopID.add(defaultIndex);
//            id = defaultIndex;
//            defaultIndex++;
//        }
//    }

    @Override
    public String toString() {
        return String.format("ID: %d\n" +
                        "Цена: %.2f₽\n" +
                "Оперативная память: %s\n" +
                "Процессор: %s\n" +
                "Диагнональ экрана: %.1f\"\n" +
                "Производитель: %s\n" +
                "Объем накопителя: %s\n" +
                "Операционная система: %s\n" +
                "Видеокарта: %s\n",
                id, price, accessMemory, processor, diagonalOfTheScreen, manufacturer, volumeOfTheDrive, os, videoCard);
    }
}
