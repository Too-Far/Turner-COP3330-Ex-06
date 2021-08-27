package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class App
{
    public static void compileInfo(Map<String, Integer> info)
    {
            System.out.println("You have " + info.get("yearsRemaining") +" years left until you can retire. \n" +
                    "It's " +info.get("currentYear") +", " + "So you can retire in " + info.get("yearToRetire") +".");
    }

    public static void calculateYears(Map<String, Integer> input, int currentYear)
    {
        int yearsRemaining = input.get("retireAge") - input.get("currentAge");
        int yearToRetire = currentYear + yearsRemaining;
        input.put("currentYear", currentYear);
        input.put("yearsRemaining", yearsRemaining);
        input.put("yearToRetire", yearToRetire);
        compileInfo(input);
    }

    public static Map<String, Integer> getInput()
            throws IOException
    {
        Map<String, Integer> info = new HashMap<>();
        System.out.println("What is your current age? ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        info.put("currentAge", Integer.parseInt(reader.readLine()));

        System.out.println("What age would you like to retire? ");
        info.put("retireAge", Integer.parseInt(reader.readLine()));

        return info;
    }
    public static void main( String[] args ) throws IOException {
        Map<String, Integer> input = getInput();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        calculateYears(input, currentYear);
    }
}
