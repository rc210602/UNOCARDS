/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of checkId method, of class Player.
     */
    @Test
    public void testCheckId() {
        System.out.println("checkId");
        String name = "";
        boolean expResult = false;
        boolean result = Player.checkId(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    @Test
    public void testCheckIdGood() {
        System.out.println("checkId good");
        String name = "rahul";
        boolean expResult = true;
        boolean result = Player.checkId(name);
        assertEquals(expResult, result);
    }

    /**
     * A test that gives the checkId() a bad password and expects a bad result
     */
    @Test
    public void testCheckIdBad() {
        System.out.println("checkId bad");
        String name = "";
        boolean expResult = false;
        boolean result = Player.checkId(name);
        assertEquals(expResult, result);

    }

    /**
     * A test that checks that when we give a user id of exactly length 3, we
     * see a pass.
     *
     * @Test
     */
    public void testCheckIdBoundary() {
        System.out.println("checkId boundary");
        String name = "rah";
        boolean expResult = true;
        boolean result = Player.checkId(name);
        assertEquals(expResult, result);

    }


    
    /**
     * Test of checkUnique method, of class Player.
     */
    @Test
    public void testCheckUnique() {
        System.out.println("checkUnique");
        String player1 = "vassu";
        String player2 = "rahul";
        boolean expResult = true;
        boolean result = Player.checkUnique(player1, player2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCheckUniqueGood() {
        System.out.println("checkUnique good");
        String name = "rahul$";
        boolean expResult = true;
        boolean result = Player.checkChar(name);
        assertEquals(expResult, result);

    }

    /**
     * A test that gives the checkUnique() a bad id and expects a bad result
     */
    @Test
    public void testCheckUniqueBad() {
        System.out.println("checkUnique bad");
        String name = "";
        boolean expResult = false;
        boolean result = Player.checkChar(name);
        assertEquals(expResult, result);
    }

    
    
   /**
     * Test of setPlayerID method, of class Player.
     */
    @Test
    public void testSetPlayerID() {
        System.out.println("setPlayerID");
        String givenID = "";
        
        //Player instance = new Player();
        //instance.setPlayerID(givenID);
        boolean expResult = false;
        boolean result = Player.checkChar(givenID);
        assertEquals(expResult, result);
    }

   
    
    /**
     * Test of checkChar method, of class Player.
     */
    @Test
    public void testCheckChar() {
        System.out.println("checkChar");
        String name = "";
        boolean expResult = false;
        boolean result = Player.checkChar(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Checks that the checkChar() method will return true on a valid value
     */
    @Test
    public void testCheckCharGood() {
        System.out.println("checkChar good");
        String name = "rahul$";
        boolean expResult = true;
        boolean result = Player.checkChar(name);
        assertEquals(expResult, result);

    }

    /**
     * A test that gives the checkChar() a bad id and expects a bad result
     */
    @Test
    public void testCheckCharBad() {
        System.out.println("checkChar bad");
        String name = "";
        boolean expResult = false;
        boolean result = Player.checkChar(name);
        assertEquals(expResult, result);
    }

    /**
     * A method that checks that id contains at least one special character
     */
    @Test
    public void testCheckCharBoundary() {
        System.out.println("checkChar boundary");
        String name = "rah$";
        boolean expResult = true;
        boolean result = Player.checkChar(name);
        assertEquals(expResult, result);
    }
    
}
