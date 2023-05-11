package org.api.tests;

import org.api.helpers.UserServiceHelper;
import org.api.model_pojo.Users;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TestAllRequestsMethods {

    private UserServiceHelper userServiceHelper;
    Users users = new Users();

    @BeforeClass
    public void init(){
        userServiceHelper = new UserServiceHelper();
    }

    @Test(priority = 1)
    public void GetAllUsers(){
        List<Users> usersList = userServiceHelper.getAllUsers();
        assertNotNull(usersList, "User List is not Empty");
        assertFalse(usersList.isEmpty(), "User List is not True");

    }

    @Test(priority = 2)
    public void GetSingleUser(){
        String id = userServiceHelper.getSingleUsers();
        assertNotNull(id, "User is not Empty");
        assertFalse(id.isEmpty(), "User is not True");

    }

    @Test(priority = 3)
    public void CreateUser(){

        String id = userServiceHelper.CreateUser().jsonPath().getString("id");
        System.out.println("You have created this ID :" +id);
        assertNotNull(id, "User id is not null");

    }

    @Test(priority = 4)
    public void UpdateUser(){

        String id = userServiceHelper.patchUser(10).jsonPath().getString("id");
        System.out.println(id);
        assertNotNull(id, "Updated");

    }

    @Test(priority = 5)
    public void DeleteUser(){

        userServiceHelper.deleteUser(10);
    }

}
