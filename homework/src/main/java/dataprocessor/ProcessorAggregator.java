package dataprocessor;

import model.Measurement;

import java.util.*;

public class ProcessorAggregator implements Processor {



    @Override
    public Map<String, Double> process(List<Measurement> data) {
        //группирует выходящий список по name, при этом суммирует поля value
        Map<String, Double> returnMap = new TreeMap<String, Double>();

        for(var m : data){
          if(returnMap.containsKey(m.getName())){
            var value =  returnMap.get(m.getName());
            value = value + m.getValue();
              returnMap.put(m.getName(),value);
            }else  returnMap.put(m.getName(), m.getValue());
        }



        return returnMap;
    }




}