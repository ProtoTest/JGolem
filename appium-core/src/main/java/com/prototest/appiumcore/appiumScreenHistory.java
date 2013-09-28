package com.prototest.appiumcore;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Seth
 * Date: 9/27/13
 * Time: 10:22 PM
 * Used to store the history of the screens as they're being instansited
 * to assist with back button functionality
 */
public class appiumScreenHistory {
    public static class ScreenHistory{

        Vector<Object> PreviousScreens;

        public ScreenHistory(){
            PreviousScreens = new Vector<Object>();
        }

        public void addScreen(Object PreviousScreen){
            PreviousScreens.add(PreviousScreen);
        }

        public Object getLast(){
            return PreviousScreens.lastElement();
        }
    }
}
