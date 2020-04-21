package Service.CSVFile;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AuditService {

    private static final String filePath = "audit.csv";
    private static AuditService instance;
    private File file = new File(filePath);

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

    public void printAction(String name_action, String timestamp_action) {
        try (FileWriter outputfile = new FileWriter(file, true);
             CSVWriter writer = new CSVWriter(outputfile)) {
            String[] data = {name_action, timestamp_action};

            writer.writeNext(data);
            writer.flush();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
