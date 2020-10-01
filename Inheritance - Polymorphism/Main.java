package sýnav;

public class Main {

    public static void main(String[] args){
        Laptop mac = new Laptop("Apple MacBook Pro", 2000.00);
        Laptop dell = new Laptop("Dell XPS", 1500.00);
        Printer canon = new Printer("Canon LBP6310", 150.75);
        Printer hp = new Printer("HP Deskjet 5820", 120.00);
        Monitor thunder = new Monitor("Apple ThunderBolt", 1800.00);
        Monitor dellCurve = new Monitor("Dell Curve GT", 900.00);

        AllinOne aio1 = new AllinOne(mac, canon, thunder);
        System.out.println("It should print Apple MacBook Pro/Canon LBP6310/Apple ThunderBolt AllinOne " +
                "and it prints: " + aio1.getName());
        System.out.println("It should print 3800.00 and it prints: " + aio1.getPrice());

        AllinOne aio2 = new AllinOne(dell, hp, dellCurve);
        System.out.println("It should print Dell XPS/HP Deskjet 5820/Dell Curve GT AllionOne " +
                "and it prints: " + aio2.getName());
        System.out.println("It should print 2400.00 and it prints: " + aio2.getPrice());

        System.out.println("It should print 1 and it prints: " + aio1.compareTo(aio2));
    }

}
