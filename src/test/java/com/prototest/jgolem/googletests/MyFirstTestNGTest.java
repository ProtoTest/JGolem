package com.prototest.jgolem.googletests;

import com.prototest.jgolem.pageobjects.google.GoogleHomePage;
import com.prototest.jgolem.framework.TestBase;
import org.testng.annotations.Test;

public class MyFirstTestNGTest extends TestBase {
    @Test
    public static void Test() {

        GoogleHomePage.
                OpenGoogle().
                SearchFor("ProtoTest").
                VerifyResult("ProtoTest « Beyond Bugs").
                GoToResult("ProtoTest « Beyond Bugs");
    }

    @Test
    public void testLogin() {
        System.out.println("Running Login google");
    }
}
