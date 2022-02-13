package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapBuilder {

    public static Map<String, String> reqParam(List<String> mapItems){
        Map<String, String> reqMap = new HashMap<>();
        if (mapItems != null){
        for (int i = 0; i < mapItems.size() - 1; i+=2){
            reqMap.put(mapItems.get(i), mapItems.get(i + 1));
        }}
        else {
            reqMap.put("","");
        }
        return reqMap;
    }
}
