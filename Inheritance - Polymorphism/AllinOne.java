package sýnav;

public class AllinOne implements Item, Comparable<AllinOne> {
    private Laptop laptop;
    private Printer printer;
    private Monitor monitor;

    public AllinOne(Laptop laptop, Printer printer, Monitor monitor){
        this.laptop = laptop;
        this.printer = printer;
        this.monitor = monitor;
    }

    @Override
    public String getName() {
        return laptop.getName() + "/" + printer.getName() + "/" + monitor.getName() + " AllinOne";
    }

    @Override
    public double getPrice() {
        double min = 0;

        if (laptop.getPrice() < printer.getPrice() && laptop.getPrice() < monitor.getPrice()){
            return printer.getPrice() + monitor.getPrice();
        } else if (printer.getPrice() < laptop.getPrice() && printer.getPrice() < monitor.getPrice()){
            return laptop.getPrice() + monitor.getPrice();
        } else {
             return laptop.getPrice() + printer.getPrice();
        }
    }

    @Override
    public int compareTo(AllinOne o) {
        AllinOne argument = (AllinOne)o;

        if (this.getPrice() > argument.getPrice()){
            return 1;
        } else if(this.getPrice() == argument.getPrice()){
            return 0;
        } else{
            return -1;
        }
    }
}
