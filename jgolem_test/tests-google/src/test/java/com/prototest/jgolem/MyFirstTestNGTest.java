//package com.prototest.jgolem;
//
//import org.testng.ITestResult;
//import org.testng.Reporter;
//import org.testng.annotations.Test;
//
//
//public class MyFirstTestNGTest extends TestBase {
//    @Test
//    public static void Test() {
////        System.out.println("Test Timeout min " + Config.Settings.RuntimeSettings.testTimeoutMin);
////        System.out.println("Launch Browser? " + Config.Settings.RuntimeSettings.launchBrowser);
////        System.out.println("Host IP? " + Config.Settings.RuntimeSettings.hostIP);
//
//
//
//        for(WebDriverBrowserManager.Browser browser : Config.Settings.RuntimeSettings.browsers) {
//            System.out.println("Browser: " + browser.toString());
//        }
//
//        boolean launchBrowser = Config.Settings.RuntimeSettings.launchBrowser;
//        System.out.println("Shall I launch the browser?" + launchBrowser);
//
//
//        GoogleHomePage.
//                OpenGoogle().
//                SearchFor("ProtoTest").
//                VerifyResult("ProtoTest « Beyond Bugs").
//                VerifyResultNotVisible("ProtoTest « Beyond Bugs").
//                //VerifyResult("Psdfsdf").
//                VerifyResultNotVisible("SDLFKJSDF").
//                GoToResult("ProtoTest « Beyond Bugs");
//    }
//
//    @Test
//    public void testLogin() {
//        System.out.println("Running Login google");
//        Reporter.log("Here is a Test Log that is supposed to be in the Report!");
//    }
//}
