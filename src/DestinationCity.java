/*
* https://leetcode.com/problems/destination-city/
* */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        String result = "";
        Set<String> startCities = new HashSet<>();
        Set<String> destCities = new HashSet<>();

        for(List<String> path : paths) {
            startCities.add(path.get(0));
            destCities.add(path.get(1));
        }

        for(String city : destCities) {
            if(!startCities.contains(city)) {
                result = city;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
