import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class LaptopShop {
    private final ArrayList<Laptop> Catalog = new ArrayList<>();

    public boolean isInCatalog(Laptop l)
    {
        long id = l.getID();
        for(Laptop laptop: Catalog)
        {
            if(laptop.getID() == id)
                return true;
        }
        return false;
    }

    public boolean tryAddLaptop(Laptop laptop)
    {
        if(!isInCatalog(laptop))
        {
            Catalog.add(laptop);
            return false;
        }
        else return true;
    }

    public ArrayList<Laptop> getCatalog() {
        return Catalog;
    }

    public ArrayList<Laptop> filter(Map<String, String> criteria)
    {
        ArrayList<Laptop> suitable = new ArrayList<>();
        for(Laptop l: Catalog)
        {
            if(
                ((Integer.parseInt(criteria.get("RAM")) == l.getRAM() &&
                    Objects.equals(criteria.get("ExactlyRAM"), "Y")) ||
                (Integer.parseInt(criteria.get("RAM")) <= l.getRAM() &&
                    Objects.equals(criteria.get("ExactlyRAM"), "N"))) &&

                ((Integer.parseInt(criteria.get("SSD")) == l.getROM() &&
                    Objects.equals(criteria.get("ExactlySSD"), "Y")) ||
                (Integer.parseInt(criteria.get("SSD")) <= l.getROM() &&
                    Objects.equals(criteria.get("ExactlySSD"), "N"))) &&

                ((Float.parseFloat(criteria.get("Price")) == l.getPrice() &&
                    Objects.equals(criteria.get("ExactlyPrice"), "Y")) ||
                (Float.parseFloat(criteria.get("Price")) <= l.getPrice() &&
                    Objects.equals(criteria.get("ExactlyPrice"), "N"))) &&

                (!Objects.equals(criteria.get("CompareName"), "N") &&
                    Objects.equals(criteria.get("Name"), l.getName()) || Objects.equals(criteria.get("CompareName"), "N")) &&

                (!Objects.equals(criteria.get("CompareCPU"), "N") &&
                    Objects.equals(criteria.get("CPU"), l.getCpu()) || Objects.equals(criteria.get("CompareCPU"), "N")) &&

                (!Objects.equals(criteria.get("CompareGPU"), "N") &&
                    Objects.equals(criteria.get("GPU"), l.getGpu()) || Objects.equals(criteria.get("CompareGPU"), "N"))
            )
            {
                suitable.add(l);
            }
        }
        return suitable;
    }

    public String getByName(String name)
    {
        for(Laptop l: Catalog) {
            if(Objects.equals(l.getName(), name))
                return l.toString();
        }
        return "&not_found&";
    }

    public String getByID(long id)
    {
        for(Laptop l: Catalog) {
            if(l.getID() == id)
                return l.toString();
        }
        return "&not_found&";
    }

}
