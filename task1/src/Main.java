import java.math.BigDecimal;
import java.util.List;

import business.concretes.HouseManager;
import business.concretes.PropertyManager;
import business.concretes.SummerHouseManager;
import business.concretes.VillaManager;
import dataAccess.concretes.InMemoryHouseDao;
import dataAccess.concretes.InMemoryPropertyDao;
import dataAccess.concretes.InMemorySummerHouseDao;
import dataAccess.concretes.InMemoryVillaDao;

public class Main {
    public static void main(String[] args) {

        // villaTest();
        // houseTest();
        // summerHouseTest();
        allPropertiesTest();
    }

    /**
     * @param <T>
     * @param list
     * Generic function for printing given list's items to console.
     */
    private static <T> void printToConsole(List<T> list) {
        for (T entity : list) {
            System.out.println(entity.toString());
        }
    }

    /**
     * Tests for villa entity.
     */
    static void villaTest() {

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
        System.out.println("--- Villa test end. ---");
    }

    /**
     * Tests for house entity.
     */
    static void houseTest() {

        HouseManager houseManager = new HouseManager(new InMemoryHouseDao());

        System.out.println("All houses:");
        printToConsole(houseManager.getAll());
        System.out.println("-----");

        System.out.println("Detached houses:");
        printToConsole(houseManager.getAllDetached(true));
        System.out.println("-----");

        System.out.println("Houses with 4 rooms:");
        printToConsole(houseManager.getAllByRoomCount(4));
        System.out.println("-----");

        System.out.println("Houses with 1 salon:");
        printToConsole(houseManager.getAllBySalonCount(1));
        System.out.println("-----");

        System.out.println("Average house square meters:");
        System.out.println(houseManager.averageSquareMeters());
        System.out.println("-----");

        System.out.println("Houses' total price:");
        System.out.println(houseManager.getTotalPrice());
        System.out.println("--- House test end. ---");

    }

    /**
     * Tests for summer house entity.
     */
    static void summerHouseTest() {

        SummerHouseManager summerHouseManager = new SummerHouseManager(new InMemorySummerHouseDao());

        System.out.println("All summer houses:");
        printToConsole(summerHouseManager.getAll());
        System.out.println("-----");

        System.out.println("Furnished summer houses:");
        printToConsole(summerHouseManager.getAllFurnished(true));
        System.out.println("-----");

        System.out.println("Summer houses with 4 rooms:");
        printToConsole(summerHouseManager.getAllByRoomCount(4));
        System.out.println("-----");

        System.out.println("Summer houses with 2 salons:");
        printToConsole(summerHouseManager.getAllBySalonCount(2));
        System.out.println("-----");

        System.out.println("Average summer houses square meters:");
        System.out.println(summerHouseManager.averageSquareMeters());
        System.out.println("-----");

        System.out.println("Summer houses' total price:");
        System.out.println(summerHouseManager.getTotalPrice());
        System.out.println("--- House test end. ---");

    }

    /**
     * Tests for all properties.
     */
    static void allPropertiesTest() {

        PropertyManager propertyManager = new PropertyManager(new InMemoryPropertyDao(), new InMemoryVillaDao(),
                new InMemoryHouseDao(), new InMemorySummerHouseDao());

        System.out.println("Total price of properties:");
        BigDecimal total = BigDecimal.valueOf(propertyManager.getTotalPrice());
        System.out.println(total.toPlainString());
        System.out.println("----");
        System.out.println("Average square meters of properties:");
        System.out.println(propertyManager.averageSquareMeters());
        System.out.println("----");
        System.out.println("Properties with 4 rooms:");
        printToConsole(propertyManager.getAllByRoomCount(4));
        System.out.println("----");
        System.out.println("Properties with 2 salons:");
        printToConsole(propertyManager.getAllBySalonCount(2));
        System.out.println("--- Properties test end. ---");
    }
}
