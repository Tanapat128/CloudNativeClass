/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.ac.kmutt.sit.MyFirstService.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TANAPATCHOOCHOT
 */
public class UserTest {

    User user;
    static String message = "No, It's equal";

    public UserTest() {
    }

    @Before
    public void setUp() {
        user = new User(3, "Cara");
    }

    @Test
    public void getId() {
        Assert.assertEquals(message, 3, user.getId());
    }

    @Test
    public void getUsername() {
        Assert.assertEquals(message, "Cara", user.getUsername());
    }
}
