/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.ac.kmutt.sit.MyFirstService.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TANAPATCHOOCHOT
 */
public class UserControllerTest {

    UserController userControl;
//    array user for testing
    static User allUser[] = {new User(1, "Adam"), new User(2, "Bobby"), new User(3, "Cara"), new User(4, "Danny"),
        new User(5, "Emily")};

    @Before
    public void setUp() {
        //assign allUser[] to userController
        userControl = new UserController(allUser);
    }

    @Test
    public void getUser() {
        User actuals;
        User expects;
        //Test loop for 5 users
        for (int userID = 1; userID <= 5; userID++) {
            expects = allUser[userID - 1];
            actuals = userControl.getUser(String.valueOf(userID));
            assertEquals("getUser Fails in UserID: " + (userID + 1), expects, actuals);
        }
    }

    @Test
    public void getAllUser() {
        assertArrayEquals("getAllUser Fails", allUser, userControl.getAllUser());
    }
}
