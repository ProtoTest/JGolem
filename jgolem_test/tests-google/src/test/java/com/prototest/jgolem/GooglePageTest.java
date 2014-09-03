package com.prototest.jgolem;

import com.prototest.jgolem.web.WebBrowserTestBase;
import org.testng.annotations.Test;

public class GooglePageTest extends WebBrowserTestBase {

    @Test
    public void googleSearchTest() {
        GoogleHomePage.OpenGoogle()
                .SearchFor("ProtoTest")
                .VerifyResult("ProtoTest");
    }
}
