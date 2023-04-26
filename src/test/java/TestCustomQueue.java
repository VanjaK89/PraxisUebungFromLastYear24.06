import at.campus02.sqa.CustomQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Currency;

public class TestCustomQueue {

    @Test
    public void testPushBadString(){
        CustomQueue customQueue = new CustomQueue();

        boolean result =  customQueue.push(" ");
        boolean result1 = customQueue.push("something!");

        Assert.assertFalse(result);
        Assert.assertFalse(result1);
    }

    @Test
    public void testPushRightString(){
        CustomQueue customQueue = new CustomQueue();

        boolean result = customQueue.push("string");

        Assert.assertTrue(result);
    }

    @Test
    public  void  testPopString(){
        CustomQueue customQueue = new CustomQueue();

        boolean result = customQueue.push("one");

        Assert.assertEquals("one", customQueue.pop());
    }

    @Test
    public void testAnEmptyQueue(){
        CustomQueue customQueue = new CustomQueue();

        //customQueue.pop();
        Assert.assertNull(customQueue.pop());
    }




}
