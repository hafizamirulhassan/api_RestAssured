package org.api.tests;

import org.api.helpers.UserServiceHelper;
import org.api.model_pojo.Users;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestPOSTUser {


    private UserServiceHelper userServiceHelper;

    @BeforeClass
    public void init(){
        userServiceHelper = new UserServiceHelper();
    }

    @Test(priority = 3)
    public void testCreateUser(){

        String id = userServiceHelper.CreateUser().jsonPath().getString("id");
        System.out.println("You have created this ID :" +id);
        assertNotNull(id, "User id is not null");

    }

}
