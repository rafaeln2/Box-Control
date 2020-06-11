package ClearBuffer;

import java.util.Scanner;

public class ClearBuffer {
	public void clearBuffer (Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
