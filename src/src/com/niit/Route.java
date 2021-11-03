package com.niit;

public class Route
{
    String fromcity;
    String tocity;
    String distance;
    String time;
  //  String currency;
    String price;

    public Route(String fromcity, String tocity, String distance, String time, /*String currency,*/ String price) {
        this.fromcity = fromcity;
        this.tocity = tocity;
        this.distance = distance;
        this.time = time;
      //  this.currency = currency;
        this.price = price;
    }


    public String getFromcity() {
        return fromcity;
    }

    public void setFromcity(String fromcity) {
        this.fromcity = fromcity;
    }

    public String getTocity() {
        return tocity;
    }

    public void setTocity(String tocity) {
        this.tocity = tocity;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Route{" +
                "fromcity='" + fromcity + '\'' +
                ", tocity='" + tocity + '\'' +
                ", distance='" + distance + '\'' +
                ", time='" + time + '\'' +
                ", currency='" + /*currency */+ '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
