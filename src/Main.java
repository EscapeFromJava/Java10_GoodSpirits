import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Tunnel> list = new ArrayList<>();
        list.add(new Tunnel(0.1,1.1,15));
        list.add(new Tunnel(0.1,1.2,5));
        list.add(new Tunnel(1.1,2.1,-5));
        list.add(new Tunnel(1.1,2.2,3));
        list.add(new Tunnel(1.2,2.1,10));
        list.add(new Tunnel(1.2,2.3,40));
        list.add(new Tunnel(2.1,3.1,1));
        list.add(new Tunnel(2.2,3.1,5));
        list.add(new Tunnel(2.2,3.2,-19));
        list.add(new Tunnel(2.3,3.1,-5));
        list.add(new Tunnel(2.3,3.2,-20));

        double start = 0.1;

        ArrayList<Tunnel> temp = new ArrayList<>();

        temp.forEach(x -> System.out.println(x));
    }



    private static void f1() {
        try {
            Scanner sc = new Scanner(new File("input.txt"));
            //Scanner temp = sc.tokens().filter(x -> !Objects.equals(x, "*")).toArray();
            ArrayList<Tunnel> list = new ArrayList<>();
            double lastPlanet = 0.1;
            double nextPlanet = lastPlanet + 1;
            while (sc.hasNext()) {
                    double maxLevel = sc.nextDouble();
                for (int i = 1; i < maxLevel; i++) {
                    //if (sc.next() == "*"){}
                    double numberPlanet = sc.nextDouble();
                    for (int j = 0; j < numberPlanet; j++) {
                        if (sc.nextDouble() == 0 && sc.nextDouble() == 1) {
                            nextPlanet = lastPlanet + 1.1;
                        }
                        list.add(new Tunnel(lastPlanet, nextPlanet, sc.nextDouble()));
                    }
                    if (sc.nextDouble() == 0 && sc.next().charAt(0) == '*'){
                        lastPlanet += 1;
                        nextPlanet = Math.ceil(nextPlanet) + 0.1;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Tunnel {
    double fromPlanet;
    double toPlanet;
    double cost;

    public Tunnel(double fromPlanet, double toPlanet, double cost) {
        this.fromPlanet = fromPlanet;
        this.toPlanet = toPlanet;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Tunnel{" +
                "fromPlanet=" + fromPlanet +
                ", toPlanet=" + toPlanet +
                ", cost=" + cost +
                '}';
    }
}
