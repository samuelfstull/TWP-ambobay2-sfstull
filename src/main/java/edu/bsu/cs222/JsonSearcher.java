package edu.bsu.cs222;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.print.DocFlavor;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class JsonSearcher {
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> timestamps = new ArrayList<String>();
    public JsonArray JsonSearch(){
        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        JsonArray outputfile = null;// holds the revision
        ArrayList<String> exitEntries= new ArrayList<String>();//final array with all the revisions in it
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json") ;
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        for(Map.Entry<String,JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            outputfile = entryObject.getAsJsonArray("revisions");//gets us to revsions level
            for (JsonElement listOfRevisions : outputfile){
                for(Map.Entry<String, JsonElement> oneRevision: listOfRevisions.getAsJsonObject().entrySet()) {//gets us a list of all revision information.
                   String testObject = oneRevision.getValue().getAsString();
                    exitEntries.add(testObject);
                }
            }
        }



        ArraySeparator(exitEntries);
        System.out.println(exitEntries);
        System.out.println();
        System.out.println(names);
        System.out.println();
        System.out.println(timestamps);
        return outputfile;
    }


    public void ArraySeparator(ArrayList<String> array){
        int counter=0;

        while(counter < array.size()) {
            if (array.get(counter).equals(""))
            {
                array.remove(counter);
            }

                if (counter % 2 == 0) {
                    timestamps.add(array.get(counter));

                } else {
                    names.add(array.get(counter));
                }

           counter++;
       }
    }

}//main end
