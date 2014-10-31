package com.prototest.jgolem;

import com.prototest.jgolem.web.WebBrowserTestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class GooglePageTest extends WebBrowserTestBase {
    private Logger logger = LogManager.getLogger(getClass());

    @Test
    public void googleSearchTest() {
        GoogleHomePage.OpenGoogle()
                .SearchFor("ProtoTest")
                .VerifyResult("ProtoTest");
    }

    @Test
    public void makeLotsOfStatements() {
        for (int i = 0; i < 5000; i++) {
            if (i % 3 == 0)
                logger.warn("warning! " + i);

            else if (i % 5 == 0) {
                logger.error("error will robinson" + i);
            } else {
                logger.info("hiasdfasdfasdfasdfasdfasdf" + i);

            }
        }
    }
    @Test
    public void makeLotsOfStatements2() {
        for (int i = 0; i < 5000; i++) {
            if (i % 3 == 0)
                logger.warn("warning! " + i);

            else if (i % 5 == 0) {
                logger.error("error will robinson" + i);
            } else {
                logger.info("hiasdfasdfasdfasdfasdfasdf" + i);

            }
        }
    }
}
