package Homework;

import java.util.List;
import java.util.Map;

public class Dictionary {
    private static Map<Integer, String> processor = Map.of(
            1, "Intel Core i3",
            2, "Intel Core i5",
            3, "Intel Core i7",
            4, "AMD Ryzen 5",
            5, "AMD Ryzen 7"
    );
    private static Map<Integer, String> manufacturer = Map.of(
            1, "Lenovo",
            2, "HP",
            3, "ASUS",
            4, "Acer",
            5, "Dell",
            6, "Apple"
    );
    private static Map<Integer, String> os = Map.of(
            1, "macOS",
            2, "Windows",
            3, "Linux",
            4, "DOS",
            5, "Без ОС"
    );
    private static Map<Integer, String> videoCard = Map.of(
            1, "AMD Radeon Graphics",
            2, "Intel Iris Xe Graphics",
            3, "Intel UHD Graphics",
            4, "NVIDIA GeForce RTX 3050",
            5, "NVIDIA GeForce RTX 3060"
    );
    private static Map<Integer, String> accessMemory = Map.of(
            1, "4 ГБ",
            2, "8 ГБ",
            3, "16 ГБ",
            4, "32 ГБ"
    );
    private static Map<Integer, String> volumeOfTheDrive = Map.of(
            1, "128 ГБ",
            2, "256 ГБ",
            3, "512 ГБ",
            4, "1 ТБ",
            5, "2 ТБ"
    );


    public static String getProcessor(int index) {
        return processor.get(index);
    }
    public static int getProcessorLen() {
        return processor.size();
    }

    public static String getManufacturer(int index) {
        return manufacturer.get(index);
    }
    public static int getManufacturerLen() {
        return manufacturer.size();
    }

    public static String getOs(int index) {
        return os.get(index);
    }
    public static int getOsLen() {
        return os.size();
    }

    public static String getVideoCard(int index) {
        return videoCard.get(index);
    }
    public static int getVideoCardLen() {
        return videoCard.size();
    }

    public static String getAccessMemory(int index) {
        return accessMemory.get(index);
    }
    public static int getAccessMemoryLen() {
        return accessMemory.size();
    }

    public static String getVolumeOfTheDrive(int index) {
        return volumeOfTheDrive.get(index);
    }
    public static int getVolumeOfTheDriveLen() {
        return volumeOfTheDrive.size();
    }
}
