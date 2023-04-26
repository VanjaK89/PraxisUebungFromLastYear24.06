package at.campus02.sqa;

import java.io.PrintWriter;
import java.util.Scanner;

public class Input {
    private final Scanner scanner;
    private final PrintWriter out;


    public Input(Scanner scanner, PrintWriter out) {
        this.scanner = scanner;
        this.out = out;
    }

    public void handle(CustomQueue queue, Scanner input) {
        while (true) {
            System.out.print(": ");
            String line = input.nextLine();
            switch (line) {
                case "n":
                    nextItem(queue);
                    break;
                case "q":
                    return;
                default:
                    queue.push(line);
                    break;
            }
        }
    }

    public void nextItem(CustomQueue queue) {
        if (queue.isEmpty()) {
            out.println("Queue is empty");
        } else {
            String item = queue.pop();
            out.println("> " + item);
        }
    }
}
