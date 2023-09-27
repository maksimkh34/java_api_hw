import java.util.ArrayList;


// Laptop Specifications:
//      RAM:   2GB, 4GB, 8GB, 16GB, 32GB
//      SSD:   250GB, 500GB, 1TB
//      M.2:   500GB, 1TB
//      CPU:    any
//      GPU:    any
public class Laptop {
    //  SPECIFICATIONS
    private final Integer ram;
    private final String name;
    private final ArrayList<Integer> SSD;
    private final ArrayList<Integer> M2;
    private final String cpu;
    private final String gpu;
    private final long id;

    private final float price;

    Laptop(int _ram, String _name, ArrayList<Integer> _SSD, ArrayList<Integer> _M2,
           String _cpu, String _gpu, float _price, long _id)
    {
        this.ram = _ram;
        this.name = _name;
        this.SSD = _SSD;
        this.M2 = _M2;
        this.cpu = _cpu;
        this.gpu = _gpu;
        this.price = _price;
        this.id = _id;
    }

    public int getRAM()
    {
        return ram;
    }

    public float getPrice()
    {
        return price;
    }

    public long getID() {
        return id;
    }

    public int getSSDCapacity()
    {
        int result = 0;
        for(Integer ssd : SSD)
        {
            result += ssd;
        }
        return result;
    }

    public int getM2Capacity()
    {
        int result = 0;
        for(Integer ssd : M2)
        {
            result += ssd;
        }
        return result;
    }

    public int getROM()
    {
        return getM2Capacity()+getSSDCapacity();
    }

    public String getCpu()
    {
        return cpu;
    }

    public String getGpu()
    {
        return gpu;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return String.format("""
                \nLaptop %s:
                \tRAM:\t\t%dGB
                \tTotal SSD/M2
                \tCapacity:\t%dGB
                \tCPU:\t\t%s
                \tGPU:\t\t%s

                \tPrice:\t\t%s$
                """,
                name, ram, getM2Capacity()+getSSDCapacity(), cpu, gpu, String.format("%.2f", price));
    }
}
