import at.campus02.sqa.CustomQueue;
import at.campus02.sqa.Input;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.junit.Assert.assertEquals;
import org.mockito.Captor;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class TestInput {

    private CustomQueue customQueue;
    private PrintWriter output;

    @Before
    public void setup(){
        customQueue = new CustomQueue();
        output = mock(PrintWriter.class);
    }
    @Test
    public void testNextItemEmptyQueue(){
        Scanner scanner = new Scanner("");
        Input inputHelper = new Input(scanner, output);

        //when
        inputHelper.nextItem(customQueue);

        //then
        verify(output, times(1)).println("Queue is empty");
    }

    @Test
    public void testHandleNext(){
        Scanner scanner = new Scanner("n\nn\nq\n");
        Input input = new Input(scanner, output);
        customQueue.push("one");
        customQueue.push("two");
        output.flush();

        //when
        input.handle(customQueue, scanner);

        //then
        ArgumentCaptor<String> capture = ArgumentCaptor.forClass(String.class);
        verify(output, atLeast(2)).println(capture.capture());
        List<String> result = capture.getAllValues();
        Assert.assertEquals("> one", result.get(0));
        Assert.assertEquals("> two", result.get(1));
    }
    @Test
    public void testHandleAddingNewItems(){
        //given
        // given
        customQueue.push("one");
        Scanner scanner = new Scanner("two\nthree\nn\nn\nn\nq");
        Input input = new Input(scanner, output);
        // when
        input.handle(customQueue, scanner);
        // then
        ArgumentCaptor<String> printed = ArgumentCaptor.forClass(String.class);
        verify(output, times(3)).println(printed.capture());
        List<String> result = printed.getAllValues();
        assertEquals("> one", result.get(0));
        assertEquals("> two", result.get(1));
        assertEquals("> three", result.get(2));
    }
}
