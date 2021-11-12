package src;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Francisco Javier Araujo Mendoza
 */
public class AccountTest extends TestCase {

    public AccountTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getBalance method, of class Account.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        Account instance = null;
        double expResult = 0.0;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of withdraw method, of class Account.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        double amount = 0.0;
        Account instance = null;
        boolean expResult = false;
        boolean result = instance.withdraw(amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deposit method, of class Account.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        double amount = 0.0;
        Account instance = null;
        instance.deposit(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
