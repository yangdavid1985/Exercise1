package edu.matc.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David on 1/26/17.
 */
public class UserTest {
    User user;

    @Test
    public void calculateAge() throws Exception {
        user = new User("test", "user", "6", "1985-09-08");
        // goal is make calculate() works

        int age = user.calculateAge();

        assertEquals("age calculation failed", 31, age);

    }

}