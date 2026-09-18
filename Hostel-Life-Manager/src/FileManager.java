import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static ArrayList<String> readFile(String fileName) {

        ArrayList<String> lines = new ArrayList<>();

        File file = new File(fileName);

        if (!file.exists()) {
            return lines;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                    "Error reading file: " + fileName
            );
        }

        return lines;
    }

    public static void writeFile(
            String fileName,
            ArrayList<String> lines
    ) {

        try {

            File file = new File(fileName);

            File parent = file.getParentFile();

            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(file)
                    );

            for (String line : lines) {

                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error writing file: " + fileName
            );
        }
    }
}
