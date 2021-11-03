package com.niit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Route_Main {

    public static void main(String []args) throws IOException
    {

        List<Route> routeplist = new ArrayList<>();
        RoutePlanner rplanner = new RoutePlanner();
        String filename = "D:\\fullstack\\c4s7_project1-route-planner\\src\\main\\resources\\routes.csv";

        routeplist = rplanner.readandplanning(filename);
        //Task1
        rplanner.viewRecords(routeplist);

        //Task2 Displaying Direct Flights
        System.out.println("\n\n------------------------------------------------Direct Flight------------------------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Source City : ");
        String source= scan.nextLine();

        List<Route> rdirect = rplanner.showFromSourece(routeplist,source);
        rplanner.viewRecords(rdirect);

        //Task3 Displaying Sort Flights
        System.out.println("\n\n------------------------------------------------Sorted Direct Flight------------------------------------------------------");

        List<Route> rsort = rplanner.sortDirectFlights(routeplist,source);
        rplanner.viewRecords(rsort);

        //Task4
        System.out.println("\n\n------------------------------------------------All route Connection------------------------------------------------------");
        System.out.println("Enter the source City : ");
        String scity= scan.nextLine();
        System.out.println("Enter the Destination City : ");
        String dcity= scan.nextLine();

        List<Route> rall = new ArrayList<>();
        rall= rplanner.showAllIndirectFlights(routeplist, scity, dcity);

    }
}
