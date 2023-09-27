import java.util.*;

public class LaptopShopOut {
    static Map<String, String> getFilterCriteria()
    {
        Scanner in = new Scanner(System.in);
        String input;
        Map<String, String> criteria = new HashMap<>();
        System.out.println("Введите фильтры для поиска подходящего ноутбука " +
                "(для любого значения просто нажмите Enter) ");

        System.out.print("Введите название нотбука: ");
        input = in.nextLine();
        if(Objects.equals(input, "")) {
            criteria.put("CompareName", "N");
        } else { criteria.put("Name", input); }

        System.out.print("Введите емкость оперативной памяти " +
                "(+ в конце означает, что введена минимальная вместительность): ");
        input = in.nextLine();
        if(Objects.equals(input, "")) {
            criteria.put("RAM", "0");
            criteria.put("ExactlyRAM", "N");
        } else if (input.endsWith("+")) {
            criteria.put("RAM", input.substring(0, input.length() - 1));
            criteria.put("ExactlyRAM", "N");
        } else {
            criteria.put("RAM", input);
            criteria.put("ExactlyRAM", "Y");
        }

        System.out.print("Введите емкость постоянной памяти " +
                "(+ в конце означает, что введена минимальная вместительность): ");
        input = in.nextLine();
        if(Objects.equals(input, "")) {
            criteria.put("SSD", "0");
            criteria.put("ExactlySSD", "N");
        } else if (input.endsWith("+")) {
            criteria.put("SSD", input.substring(0, input.length() - 1));
            criteria.put("ExactlySSD", "N");
        } else {
            criteria.put("SSD", input);
            criteria.put("ExactlySSD", "Y");
        }

        System.out.print("Введите цену " +
                "(+ в конце означает, что введена минимальная стоимость): ");
        input = in.nextLine();
        if(Objects.equals(input, "")) {
            criteria.put("Price", "0");
            criteria.put("ExactlyPrice", "N");
        } else if (input.endsWith("+")) {
            criteria.put("Price", input.substring(0, input.length() - 1));
            criteria.put("ExactlyPrice", "N");
        } else {
            criteria.put("Price", input);
            criteria.put("ExactlyPrice", "Y");
        }

        System.out.print("Введите требуемый процессор: ");
        input = in.nextLine();
        if(Objects.equals(input, "")) {
            criteria.put("CompareCPU", "N");
        } else { criteria.put("CPU", input); }

        System.out.print("Введите требуемую видеокарту: ");
        input = in.nextLine();
        if(Objects.equals(input, "")) {
            criteria.put("CompareGPU", "N");
        } else { criteria.put("GPU", input); }

        System.out.println();

        return criteria;
    }


    public static void listCatalog(ArrayList<Laptop> catalog)
    {
        Scanner in = new Scanner(System.in);
        int pages = catalog.size()/3;
        if (catalog.size()%3!=0) pages += 1;
        for(int i = 1; i < catalog.size()+1; i++)
        {
            System.out.println(catalog.get(i-1));
            if(i%3==0 && catalog.size()>3)
            {
                System.out.printf("Показана %d страница из %d. Дальше? %n",
                        i/3, pages);
                String choice = in.nextLine();
                if(!(Objects.equals(choice, "Y") || Objects.equals(choice, "Д") ||
                   Objects.equals(choice, "y") || Objects.equals(choice, "д") ||
                   Objects.equals(choice, ""))) return;
            }
        }
        System.out.printf("Показана %d страница из %d. %n",
                pages, pages);
    }
}
