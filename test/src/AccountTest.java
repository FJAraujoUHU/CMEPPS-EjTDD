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

    /**
     * Declaración de las cuentas para probar T0014 *
     * Iniciadas aquí porque JUnit se niega a ejecutar @BeforeClass
     */
    private static Account account12345 = new Account(50);
    private static Account account67890 = new Account(0);

    public AccountTest() {
    }

    @BeforeClass
    public static void setUpClass() {   //*** No se ejecuta por alguna razón ***//
        System.out.println("setUpClass");
        account12345 = new Account(50);
        account67890 = new Account(0);

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
     * Test para comprobar el correcto funcionamiento de getBalance
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        double expResult = 50;
        Account instance = new Account(expResult);
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test para comprobar reintegros normales.
     */
    @Test
    public void testWithdrawOK() {
        System.out.println("withdraw ok");
        double amount = 200.0;
        Account instance = new Account(2500);
        boolean result = instance.withdraw(amount);
        assertTrue(result);
    }

    /**
     * Test para comprobar que rechace reintegros sin fondos.
     */
    @Test
    public void testWithdrawOverdraft() {
        System.out.println("withdraw overdraft");
        double amount = 200.0;
        Account instance = new Account(-350);
        boolean result = instance.withdraw(amount);
        assertFalse(result);
    }

    /**
     * Test para comprobar que rechace reintegros negativos.
     */
    @Test
    public void testWithdrawNegative() {
        System.out.println("withdraw negative amount");
        double amount = -200.0;
        Account instance = new Account(2500);
        boolean result = instance.withdraw(amount);
        assertFalse(result);
    }

    /**
     * Test para comprobar ingresos normales.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit normal amount");
        double amount = 150;
        Account instance = new Account(50);
        instance.deposit(amount);
        assertEquals(instance.getBalance(), 200, 0.0);
    }

    /**
     * Test para comprobar que rechace ingresos negativos.
     */
    @Test
    public void testDepositNegative() {
        System.out.println("deposit negative amount");
        double amount = -150;
        Account instance = new Account(50);

        boolean exceptionThrown = false;
        try {
            instance.deposit(amount);
        } catch (IllegalArgumentException ex) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void testT0014() {
        //12345 empieza con 50
        //67890 empieza con 0
        if (!account12345.withdraw(200))                                        // 12345 = -150
        {
            fail("account 12345 has blocked a legitimate withdrawal.");
        }
        if (!account67890.withdraw(350))                                        // 67890 = -350
        {
            fail("account 67890 has blocked a legitimate withdrawal.");
        }
        account12345.deposit(100);                                              // 12345 = -50
        if (account67890.withdraw(200))                                         // falla
        {
            fail("account 67890 has allowed an illegal withdrawal.");
        }
        if (!account67890.withdraw(150))                                        // 67890 = -500
        {
            fail("account 67890 has blocked a legitimate withdrawal.");
        }
        if (!account12345.withdraw(200))                                        // 12345 = -250
        {
            fail("account 12345 has blocked a legitimate withdrawal.");
        }
        account67890.deposit(50);                                               // 67890 = -450
        if (account67890.withdraw(100))                                         // falla
        {
            fail("account 67890 has allowed an illegal withdraw.");
        }
        assertEquals(account12345.getBalance(), -250.0, 0.0);
        assertEquals(account67890.getBalance(), -450.0, 0.0);
    }

}
