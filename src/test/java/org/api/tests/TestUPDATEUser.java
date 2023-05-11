package org.api.tests;

import org.api.helpers.UserServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestUPDATEUser {

    private UserServiceHelper userServiceHelper;

    @BeforeClass
    public void init(){

        userServiceHelper = new UserServiceHelper();
    }

    @Test(priority = 4)
    public void testPatchUser(){

        String id = userServiceHelper.patchUser(9).jsonPath().getString("id");
        System.out.println(id);
        assertNotNull(id, "Updated");

    }
}
