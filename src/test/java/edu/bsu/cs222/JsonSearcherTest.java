package edu.bsu.cs222;


import org.junit.Assert;
import org.junit.Test;
import edu.bsu.cs222.JsonSearcher;

public class JsonSearcherTest {
    @Test
    public void JsonSearcherTesting(){
       JsonSearcher array= new JsonSearcher();
       Assert.assertEquals(5,array.JsonSearch().size());



    }

}
