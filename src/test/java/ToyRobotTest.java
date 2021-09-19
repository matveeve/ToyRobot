import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToyRobotTest {

    @Test
    public void file1Test() {
        assertOutput(1, "Output: 0, 1, NORTH");
    }

    @Test
    public void file2Test() {
        assertOutput(2, "Output: 0, 0, WEST");
    }

    @Test
    public void file3Test() {
        assertOutput(3, "Output: 3, 3, NORTH");
    }

    private void assertOutput(int fileNumber, String expectedOutput) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream oldOutput = System.out;
        System.setOut(printStream);

        runTest(fileNumber);

        System.out.flush();
        System.setOut(oldOutput);
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    private void runTest(int fileNumber) {
        List<String> lines = null;
        String fileName = new StringBuilder()
                .append("commands")
                .append(fileNumber)
                .append(".txt")
                .toString();
        try {
            lines = Files.readAllLines(Path.of("src", "test", "resources", fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Position position = Position.getPosition(lines.get(0));
        for (String line : lines) {
            position.changePosition(line);
        }
    }
}
