package com.prototest.jgolem.core.logging.internal;


import org.apache.commons.io.FileUtils;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;
import org.uncommons.reportng.HTMLReporter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * Created by SethUrban on 10/1/14.
 * Used to build pretty HTML logs from the TestNG log files.
 * TODO Would like to make some of these options configurable
 */
public class HTMLogger extends HTMLReporter {
    private Date rightNow;
    private SimpleDateFormat dateFormat;

    public HTMLogger(){
        rightNow = new Date();
        dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectoryName) {

        File outputDirectory = new File(outputDirectoryName, dateFormat.format(rightNow));
        outputDirectory.mkdir();
        outputDirectoryName = outputDirectory.toString();

        System.out.println("HTMLReport : " + new File(outputDirectoryName).getAbsolutePath() + "\\html\\index.html");


        try {
            FileUtils.copyDirectoryToDirectory(new File("Screenshots"), new File(outputDirectoryName));
        } catch (IOException e) {
            throw new RuntimeException("Couldn't copy screenshots", e);
        }


        super.generateReport(xmlSuites, suites, outputDirectoryName);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
