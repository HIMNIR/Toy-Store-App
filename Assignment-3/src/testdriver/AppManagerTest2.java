package testdriver;
import org.junit.Test;
import static org.junit.Assert.*;
import controller.AppManager;
public class AppManagerTest2 {

	   @Test
	    public void testInvalidSN() {
	        assertFalse(AppManager.inputSN(""));
	        assertFalse(AppManager.inputSN("1 346789"));
	        assertFalse(AppManager.inputSN("1234567"));
	        assertFalse(AppManager.inputSN("12345678900"));
	        assertFalse(AppManager.inputSN("123abc4567"));
	        assertFalse(AppManager.inputSN("123456789x"));
	        assertFalse(AppManager.inputSN("000000000100"));
	        assertFalse(AppManager.inputSN("98765432118888"));
	    }
	   @Test
	    public void testValidSN() {
	        assertTrue(AppManager.inputSN("1234567890"));
	        assertTrue(AppManager.inputSN("0000000000"));
	        assertTrue(AppManager.inputSN("9876543210"));
	    }
	    
	
	
}
