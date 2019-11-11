package com.example.mockitotest;


import org.mockito.Mockito;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class ExampleUnitTest {

    @DataProvider(name = "Authentication")

    public static Object[][] credentials() {

        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
    }

    @BeforeSuite
    public void setUp(){
        System.out.println("Setting up the system");
    }

    @Test()
    public void numberComparison(){
        assertEquals(20,20);
    }

    @Test(dataProvider = "Authentication")
    public void testDataProvider(String user, String password){
        System.out.println("Username is: " + user);
        System.out.println("Password is: " + password);
    }


    @Test
    public void testingMock(){
        TestClassForMock mockObject = Mockito.mock(TestClassForMock.class);
        Mockito.when(mockObject.add(10,20)).thenReturn(30);
        assertEquals(30, mockObject.add(10,20));
    }

    @AfterSuite
    public void tearDown(){
        System.out.println("Finishing stuff");
    }

    @Parameters("name")
    @Test()
    public void testParameter(String name){
        System.out.println("Parameter is: " + name);
    }


}