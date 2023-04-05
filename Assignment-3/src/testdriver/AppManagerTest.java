package testdriver;

import org.junit.Test;

import controller.AppManager;

import static org.junit.Assert.*;

public class AppManagerTest {
    
    @Test
    public void testLoadFile() {
        AppManager.loadFile();
        assertFalse(AppManager.arrList.isEmpty());
    }
}
