import java.util.List;

import business.concretes.VillaManager;
import dataAccess.concretes.InMemoryVillaDao;

public class Main {
    public static void main(String[] args) {

        VillaManager villaManager = new VillaManager(new InMemoryVillaDao());

        System.out.println("All villas:");
        printToConsole(villaManager.getAll());
        System.out.println("-----");

        System.out.println("Villas with pool:");
        printToConsole(villaManager.getAllByPool(false));
        System.out.println("-----");

        System.out.println("Villas with 7 rooms:");
        printToConsole(villaManager.getAllByRoomCount(7));
        System.out.println("-----");

        System.out.println("Villas with 2 salons:");
        printToConsole(villaManager.getAllBySalonCount(2));
        System.out.println("-----");

        System.out.println("Average villa square meters:");
        System.out.println(villaManager.averageSquareMeters());
        System.out.println("-----");

        System.out.println("Villas' total price:");
        System.out.println(villaManager.getTotalPrice());
        System.out.println("-----");

    }

    private static <T> void printToConsole(List<T> list) {
        for (T entity : list) {
            System.out.println(entity.toString());
        }
    }
}
