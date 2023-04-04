package testdriver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.AppManager;

import java.util.ArrayList;

import model.Figures;
import model.Toy;

public class AppManagerTest {

    @BeforeEach
    public void setUp() {
        new AppManager();
    }

    @Test
    public void testPurchaseName() {
        ArrayList<Toy> toys = new ArrayList<>();
        toys.add(new Figures("0123456780", "Batman", "DC Comics", 19.99, 10, 5, "A"));
        toys.add(new Figures("0123456789", "Superman", "DC Comics", 19.99, 10, 5, "A"));
        toys.add(new Figures("0987654321", "Spider-Man", "Marvel Comics", 24.99, 15, 8, "A"));
        toys.add(new Figures("0897656453", "Captain America", "Marvel Comics", 24.99, 15, 8, "A"));

        ArrayList<Toy> result = AppManager.purchaseName("BatMan");

    
        Assertions.assertEquals(toys.get(0), result.get(0));
        Assertions.assertEquals(toys.get(1), result.get(1));
    }
}
