package org.api.tests;

import org.api.helpers.UserServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestDELETEUser {

    private UserServiceHelper userServiceHelper;

    @BeforeClass
    public void init(){
        userServiceHelper = new UserServiceHelper();
    }

    @Test(priority = 5)
    public void testDeleteUser(){

        userServiceHelper.deleteUser(9);
    }

}
