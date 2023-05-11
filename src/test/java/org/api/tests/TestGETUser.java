package org.api.tests;

import org.api.helpers.UserServiceHelper;
import org.api.model_pojo.Users;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.List;

public class TestGETUser {

    private UserServiceHelper userServiceHelper;

    @BeforeClass
    public void init(){
        userServiceHelper = new UserServiceHelper();
    }

    @Test(priority = 1)
    public void testGetAllUsers(){
        List<Users> usersList = userServiceHelper.getAllUsers();
        assertNotNull(usersList, "User List is not Empty");
        assertFalse(usersList.isEmpty(), "User List is not True");

    }


}
