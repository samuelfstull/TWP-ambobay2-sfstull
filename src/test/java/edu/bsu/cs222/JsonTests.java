package edu.bsu.cs222;


import org.junit.Assert;
import org.junit.Test;

public class JsonTests {
    @Test
    public void JsonParsingTest(){
       JsonSearcher array= new JsonSearcher();
       array.JsonSearch();
       Assert.assertEquals(5,array.finalValuesHM.size());



    }

}
