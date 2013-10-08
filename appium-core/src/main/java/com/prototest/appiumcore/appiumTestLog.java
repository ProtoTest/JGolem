package com.prototest.appiumcore;


import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sethurban
 * Date: 10/7/13
 * Time: 4:48 PM
 * This will be used to write test logs
 */
public class appiumTestLog {
    public static class logger{
        private List<String> Results = new ArrayList<String>();

        public void AddLog(String log){
            Results.add(log);
        }

        public void printResults(){
            for(int i = 0; i < Results.size(); i++){
                System.out.println(Results.get(i));
            }
        }


    }
}
