import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop(32, "Dell Inspiron 7577", new ArrayList<>(List.of(1000,500)),
                new ArrayList<>(List.of(500)), "Intel i5-4600M", "NVIDIA RTX 4070",
                2000.05f, 26478);

        Laptop laptop2 = new Laptop(32, "Dell Inspiron 7555", new ArrayList<>(List.of(500,500)),
                new ArrayList<>(List.of(1000)), "Intel i7-620M", "NVIDIA RTX 3070",
                1750.50f, 93266);

        Laptop laptop3 = new Laptop(16, "Dell Inspiron 7355", new ArrayList<>(List.of(500,500)),
                new ArrayList<>(List.of(500)), "Intel i5-7400", "NVIDIA RTX 2060",
                1500f, 11952);

        Laptop laptop4 = new Laptop(16, "Dell Inspiron 7000", new ArrayList<>(List.of(500)),
                new ArrayList<>(List.of(500)), "Intel i5-2500", "NVIDIA RTX 2060",
                1205f, 73905);

        Laptop laptop5 = new Laptop(16, "Dell Inspiron 3555", new ArrayList<>(List.of(500,500)),
                new ArrayList<>(), "Intel i5-2400Q", "NVIDIA GTX 1060 6GB",
                1000f, 50005);

        Laptop laptop6 = new Laptop(8, "Dell Inspiron 3500", new ArrayList<>(List.of(500)),
                new ArrayList<>(), "Intel i3-2102", "NVIDIA GTX 1060 3GB",
                700f, 65811);

        Laptop laptop7 = new Laptop(8, "Dell Inspiron 3300", new ArrayList<>(List.of(500)),
                new ArrayList<>(), "Intel i3-2100", "integrated",
                500f, 88254);


        LaptopShop shop = new LaptopShop();

        if(shop.tryAddLaptop(laptop1)) System.out.println("Ошибка во время добавления ноутбука " + laptop1.getID());
        if(shop.tryAddLaptop(laptop2)) System.out.println("Ошибка во время добавления ноутбука " + laptop2.getID());
        if(shop.tryAddLaptop(laptop3)) System.out.println("Ошибка во время добавления ноутбука " + laptop3.getID());
        if(shop.tryAddLaptop(laptop4)) System.out.println("Ошибка во время добавления ноутбука " + laptop4.getID());
        if(shop.tryAddLaptop(laptop5)) System.out.println("Ошибка во время добавления ноутбука " + laptop5.getID());
        // Ошибка здесь сделана для демонстрации невозможности добавить один и тот же ноутбук
        // (не одну и ту же модель), т. к. его ID уже в каталоге
        if(shop.tryAddLaptop(laptop5)) System.out.println("Ошибка во время добавления ноутбука " + laptop5.getID());
        if(shop.tryAddLaptop(laptop6)) System.out.println("Ошибка во время добавления ноутбука " + laptop6.getID());
        if(shop.tryAddLaptop(laptop7)) System.out.println("Ошибка во время добавления ноутбука " + laptop7.getID());

        System.out.println();

        while(true)
        {
            System.out.println("\n\t\t\tМЕНЮ\t\t\t\n");

            System.out.println("Выберите опцию: ");
            System.out.println("\t1. Просмотреть весь каталог ");
            System.out.println("\t2. Просмотреть каталог по фильтрам");
            System.out.println("\t3. Получить ноутбук по названию ");
            System.out.println("\t4. Получить ноутбук по ID ");
            System.out.println("\t5. Выход ");

            System.out.print("Ввод: ");

            Scanner in = new Scanner(System.in);
            int choice = in.nextInt(); in.nextLine();

            switch (choice) {
                case 1 -> LaptopShopOut.listCatalog(shop.getCatalog());
                case 2 -> LaptopShopOut.listCatalog(shop.filter(LaptopShopOut.getFilterCriteria()));
                case 3 -> {
                    System.out.print("Введите название модели: ");
                    String input = in.nextLine();
                    String name_result = shop.getByName(input);
                    if (Objects.equals(name_result, "&not_found&")) {
                        System.out.println("Не найдено! ");
                    } else {
                        System.out.println(name_result);
                    }
                }
                case 4 -> {
                    System.out.print("Введите ID модели: ");
                    String input = in.nextLine();
                    String id_result = shop.getByID(Integer.parseInt(input));
                    if (Objects.equals(id_result, "&not_found&")) {
                        System.out.println("Не найдено! ");
                    } else {
                        System.out.println(id_result);
                    }
                }
                case 5 -> {
                    return;
                }
                default -> System.out.print("Комманда не распознана! ");
            }
        }
    }
}