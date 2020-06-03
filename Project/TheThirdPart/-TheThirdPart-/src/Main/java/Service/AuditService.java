package Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuditService {

    private static final String filePath = "C:\\Users\\asus\\Documents\\GitHub\\Advanced-Object-Oriented-Programming\\Project\\-TheThirdPart-\\src\\Main\\java\\main\\audit.csv";

    private static AuditService instance;

    private AuditService() {
    }

    public static AuditService getInstance() {
        if (instance == null) {
            instance = new AuditService();
        }
        return instance;
    }

    public String getTimestamp_action() {
        return java.time.LocalDateTime.now().toString();
    }

    public void printAction(String action, String timeStamp, String nameThread) {

        try (FileWriter csvWriter = new FileWriter(String.valueOf(filePath), true)) {

            List<String> newline =  Arrays.asList(action, timeStamp, nameThread);
            csvWriter.append(String.join(",", newline));
            csvWriter.append("\n");
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}