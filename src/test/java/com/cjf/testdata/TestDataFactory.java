package com.cjf.testdata;

import org.testng.annotations.DataProvider;

/**
 * Created by Jeff on 2017/8/30.
 */
public class TestDataFactory {
    @DataProvider(name = "calc_test_data")
    public static Object[][] getCalcTestData(){
        Object[][] objs = new Object[][]{
                {10,20,30},
                {30,10,20},
                {30,30,60}
        };
        return objs;
    }
    @DataProvider(name = "login_test_data")
    public static Object[][] getLoginTestData(){
        Object[][] objs = new Object[][]{
                {"admin","ABBabb=123456"},
                {"admin","ABBabb_123456"},
                {"admin","ABBabb_023456"}
        };
        return objs;
    }
}
