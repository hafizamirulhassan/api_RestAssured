package org.api.tests;

import org.api.helpers.UserServiceHelper;
import org.api.model_pojo.Users;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestGETSINGLEUser {

    private UserServiceHelper userServiceHelper;

    @BeforeClass
    public void init(){
        userServiceHelper = new UserServiceHelper();
    }

    @Test(priority = 2)
    public void testGetSingleUsers(){
         String id = userServiceHelper.getSingleUsers();
        assertNotNull(id, "User List is not Empty");
        assertFalse(id.isEmpty(), "User List is not True");

    }
    
}
