package com.niit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.function.Consumer;
public class RoutePlanner {

    public List<Route> readandplanning(String filename)

    {
        List<Route> list =new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line= br.readLine())!=null)
            {
                String arr[]=line.split(",");
                list.add(new Route(arr[0],arr[1],arr[2],arr[3],arr[4] ));
            }
        }
        catch (IOException e)
        {e.printStackTrace();}
        return list;

    }

    public void viewRecords(List<Route> routeinfoformat)
    {
        String format ="%-20s %-20s %-25s %-15s %-20s";
        System.out.println(String.format(format,"FROM","DESTINATION","DISTANCE","TIME","AIRFARE"));
        Consumer<Route> consumer = route->System.out.format("\n"+format,route.getFromcity(),route.getTocity(),route.getDistance(),route.getTime(),route.getPrice());
        routeinfoformat.forEach(consumer);

    }
    public  List<Route> showFromSourece(List<Route>routeinfo,String source)
    {
        List<Route> list1= routeinfo.stream().filter(route -> route.getFromcity().equalsIgnoreCase(source)).collect(Collectors.toList());

        return  list1;

    }
   public  List<Route> sortDirectFlights(List<Route> routeinfo1, String source)
    {
        return routeinfo1.stream().filter(route -> route.getFromcity().equalsIgnoreCase(source))
                .sorted((D, D1) -> D.getTocity().compareToIgnoreCase(D1.getTocity())).collect(Collectors.toList());
    }
    public List<Route> showAllIndirectFlights(List<Route> routeList, String sourceCity, String destinationCity)
    {

        for(Route route:routeList)
        {
            String temp=route.getTocity().trim();
            if(route.getFromcity().equalsIgnoreCase(sourceCity) && !temp.equalsIgnoreCase(destinationCity))
            {
                routeList.stream().filter(f->f.getFromcity().equalsIgnoreCase(temp) && f.getTocity().trim().equalsIgnoreCase(destinationCity))
                        .forEach(f -> System.out.format("\n\n%-20s %-20s %-20s %-20s %s\n%-20s %-20s %-20s %-20s %s",
                                route.getFromcity(), route.getTocity(), route.getDistance(), route.getTime(), route.getPrice(),
                                f.getFromcity(), f.getTocity(), f.getDistance(), f.getTime(), f.getPrice()));
                showAllIndirectFlights(routeList,temp,destinationCity);
            }
        }
        return routeList;
    }


}


