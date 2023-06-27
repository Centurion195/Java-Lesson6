package Homework;

import java.util.*;

public class Main {
    private static List<Laptop> laptopList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        importDB();
        System.out.println("Магазин ноутбуков");
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Просмотр всего каталога");
            System.out.println("2. Поиск по параметрам");
            System.out.println("3. Выход");
            System.out.print("\nВыбор: ");
            int command = scanner.nextInt();
            if (command == 3) {
                break;
            } else if (command == 1) {
                System.out.println();
                for (int i = 0; i < laptopList.size(); i++) {
                    System.out.println(laptopList.get(i));
                }

            } else if (command == 2) {
                find();
                continue;
            } else {
                System.out.println("Неверный ввод! Повторите попытку!");
                continue;
            }
        }
        scanner.close();
        System.out.println("Конец программы!");
    }
    private static void importDB() {
        // Имитация базы данных
        int numberOfPositions = 15;
        Random random = new Random();
        double price;
        String accessMemory;
        String processor;
        double diagonalOfTheScreen;
        String manufacturer;
        String volumeOfTheDrive;
        String os;
        String videoCard;
        for (int i = 0; i < numberOfPositions; i++) {
            price = random.nextDouble(12_000, 60_000);
            accessMemory = Dictionary.getAccessMemory(random.nextInt(1, Dictionary.getAccessMemoryLen()+1));
            processor = Dictionary.getProcessor(random.nextInt(1, Dictionary.getProcessorLen()+1));
            diagonalOfTheScreen = random.nextDouble(10.1, 18);
            manufacturer = Dictionary.getManufacturer(random.nextInt(1, Dictionary.getManufacturerLen()+1));
            volumeOfTheDrive = Dictionary.getVolumeOfTheDrive(random.nextInt(1, Dictionary.getVolumeOfTheDriveLen()+1));
            if (manufacturer.equals("Apple")) {
                os = Dictionary.getOs(1);
            } else {
                os = Dictionary.getOs(random.nextInt(2, Dictionary.getOsLen()+1));
            }
            videoCard = Dictionary.getVideoCard(random.nextInt(1, Dictionary.getVideoCardLen()+1));

            laptopList.add(new Laptop());
            laptopList.get(i).setPrice(price);
            laptopList.get(i).setAccessMemory(accessMemory);
            laptopList.get(i).setProcessor(processor);
            laptopList.get(i).setDiagonalOfTheScreen(diagonalOfTheScreen);
            laptopList.get(i).setManufacturer(manufacturer);
            laptopList.get(i).setVolumeOfTheDrive(volumeOfTheDrive);
            laptopList.get(i).setOs(os);
            laptopList.get(i).setVideoCard(videoCard);
            laptopList.get(i).setId(i+1);
        }
    }
    private static void find() {
        int all_items = 8;
        int[] parametersInt;
        while (true) {
            System.out.println("\nВыберите параметры для фильтра: ");
            System.out.println("0. Назад");
            System.out.println("1. Цена");
            System.out.println("2. Оперативная память");
            System.out.println("3. Процессор");
            System.out.println("4. Диагональ экрана");
            System.out.println("5. Производитель");
            System.out.println("6. Объем накопителя");
            System.out.println("7. Операционная система");
            System.out.println("8. Видеокарта");
            System.out.print("\nВведите номера через пробел: ");
            String[] parameters = scanner.nextLine().split(" ");
            parametersInt = new int[parameters.length];

            try {
                for (int i = 0; i < parametersInt.length; i++) {
                    parametersInt[i] = Integer.parseInt(parameters[i]);
                }
                for (int i = 0; i < parametersInt.length; i++) {
                    if (parametersInt[i] >= all_items+1)
                        throw new Exception("Ошибка! (" + parametersInt[i] + ") Не найден пукт меню!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Пожалуйста, введите числа!");
                continue;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        Set<Integer> foundID = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for (int i = 0; i < parametersInt.length; i++) {
            if (parametersInt[i] == 1) {
                System.out.println("Установите диапазон цены:");
                System.out.print("От: ");
                int minPrice = scanner.nextInt();
                System.out.print("До: ");
                int maxPrice = scanner.nextInt();
                for (int j = 0; j < laptopList.size(); j++) {
                    if (laptopList.get(j).getPrice() > minPrice && laptopList.get(j).getPrice() < maxPrice) {
                        if (i == 0) {
                            intersection.add(laptopList.get(j).getId());
                        } else {
                            foundID.add(laptopList.get(j).getId());
                        }
                    }
                }
                if (i != 0) {
                    intersection.retainAll(foundID);
                    foundID.clear();
                }
            }
            if (parametersInt[i] == 2) {
                System.out.println("Выберите объем оперативной памяти:");
                for (int j = 1; j <= Dictionary.getAccessMemoryLen(); j++) {
                    System.out.printf("%d. %s\n", j, Dictionary.getAccessMemory(j));
                }
                System.out.print("Выбор: ");
                int choice = scanner.nextInt();
                for (int j = 0; j < laptopList.size(); j++) {
                    if (laptopList.get(j).getAccessMemory().equals(Dictionary.getAccessMemory(choice))) {
                        if (i == 0) {
                            intersection.add(laptopList.get(j).getId());
                        } else {
                            foundID.add(laptopList.get(j).getId());
                        }
                    }
                }
                if (i != 0) {
                    intersection.retainAll(foundID);
                    foundID.clear();
                }
            }
            if (parametersInt[i] == 3) {
                System.out.println("Выберите процессор:");
                for (int j = 1; j <= Dictionary.getProcessorLen(); j++) {
                    System.out.printf("%d. %s\n", j, Dictionary.getProcessor(j));
                }
                System.out.print("Выбор: ");
                int choice = scanner.nextInt();
                for (int j = 0; j < laptopList.size(); j++) {
                    if (laptopList.get(j).getProcessor().equals(Dictionary.getProcessor(choice))) {
                        if (i == 0) {
                            intersection.add(laptopList.get(j).getId());
                        } else {
                            foundID.add(laptopList.get(j).getId());
                        }
                    }
                }
                if (i != 0) {
                    intersection.retainAll(foundID);
                    foundID.clear();
                }
            }
            if (parametersInt[i] == 4) {
                System.out.println("Установите диапазон диагонали экрана:");
                System.out.print("От: ");
                double minDiagonal = scanner.nextDouble();
                System.out.print("До: ");
                double maxDiagonal = scanner.nextDouble();
                for (int j = 0; j < laptopList.size(); j++) {
                    if (laptopList.get(j).getDiagonalOfTheScreen() > minDiagonal &&
                            laptopList.get(j).getDiagonalOfTheScreen() < maxDiagonal) {
                        if (i == 0) {
                            intersection.add(laptopList.get(j).getId());
                        } else {
                            foundID.add(laptopList.get(j).getId());
                        }
                    }
                }
                if (i != 0) {
                    intersection.retainAll(foundID);
                    foundID.clear();
                }
            }
            if (parametersInt[i] == 5) {
                System.out.println("Выберите производителя:");
                for (int j = 1; j <= Dictionary.getManufacturerLen(); j++) {
                    System.out.printf("%d. %s\n", j, Dictionary.getManufacturer(j));
                }
                System.out.print("Выбор: ");
                int choice = scanner.nextInt();
                for (int j = 0; j < laptopList.size(); j++) {
                    if (laptopList.get(j).getManufacturer().equals(Dictionary.getManufacturer(choice))) {
                        if (i == 0) {
                            intersection.add(laptopList.get(j).getId());
                        } else {
                            foundID.add(laptopList.get(j).getId());
                        }
                    }
                }
                if (i != 0) {
                    intersection.retainAll(foundID);
                    foundID.clear();
                }
            }
            if (parametersInt[i] == 6) {
                System.out.println("Выберите объем накопителя:");
                for (int j = 1; j <= Dictionary.getVolumeOfTheDriveLen(); j++) {
                    System.out.printf("%d. %s\n", j, Dictionary.getVolumeOfTheDrive(j));
                }
                System.out.print("Выбор: ");
                int choice = scanner.nextInt();
                for (int j = 0; j < laptopList.size(); j++) {
                    if (laptopList.get(j).getVolumeOfTheDrive().equals(Dictionary.getVolumeOfTheDrive(choice))) {
                        if (i == 0) {
                            intersection.add(laptopList.get(j).getId());
                        } else {
                            foundID.add(laptopList.get(j).getId());
                        }
                    }
                }
                if (i != 0) {
                    intersection.retainAll(foundID);
                    foundID.clear();
                }
            }
            if (parametersInt[i] == 7) {
                System.out.println("Выберите операционную систему:");
                for (int j = 1; j <= Dictionary.getOsLen(); j++) {
                    System.out.printf("%d. %s\n", j, Dictionary.getOs(j));
                }
                System.out.print("Выбор: ");
                int choice = scanner.nextInt();
                for (int j = 0; j < laptopList.size(); j++) {
                    if (laptopList.get(j).getOs().equals(Dictionary.getOs(choice))) {
                        if (i == 0) {
                            intersection.add(laptopList.get(j).getId());
                        } else {
                            foundID.add(laptopList.get(j).getId());
                        }
                    }
                }
                if (i != 0) {
                    intersection.retainAll(foundID);
                    foundID.clear();
                }
            }
            if (parametersInt[i] == 8) {
                System.out.println("Выберите видеокарту:");
                for (int j = 1; j <= Dictionary.getVideoCardLen(); j++) {
                    System.out.printf("%d. %s\n", j, Dictionary.getVideoCard(j));
                }
                System.out.print("Выбор: ");
                int choice = scanner.nextInt();
                for (int j = 0; j < laptopList.size(); j++) {
                    if (laptopList.get(j).getVideoCard().equals(Dictionary.getVideoCard(choice))) {
                        if (i == 0) {
                            intersection.add(laptopList.get(j).getId());
                        } else {
                            foundID.add(laptopList.get(j).getId());
                        }
                    }
                }
                if (i != 0) {
                    intersection.retainAll(foundID);
                    foundID.clear();
                }
            }
        }
        System.out.println();
        for (Integer s : intersection) {
            int is = 0;
            if (s != null) {
                is = Integer.parseInt(s.toString());
            }
            System.out.println(laptopList.get(is-1));
        }

    }
}
