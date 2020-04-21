package Service.CSVFile;

import Model.Faculty;
import Repository.FacultyRepository;
import com.opencsv.CSVReader;

import java.io.FileReader;

public class FacultyReadingService {
    private static final String filePath = "faculties.csv";
    private static FacultyReadingService instance = null;
    private FacultyRepository facultyRepository;

    private FacultyReadingService(FacultyRepository f) {
        facultyRepository = f;
    }

    public static FacultyReadingService getInstance(FacultyRepository facultyRepository) {

        if (instance == null) {
            instance = new FacultyReadingService(facultyRepository);
        }
        return instance;
    }

    public void readingFaculties() {

        try (FileReader filereader = new FileReader(filePath);
             CSVReader csvReader = new CSVReader(filereader)) {

            String[] nextRecord;
            int step = 0;

            while ((nextRecord = csvReader.readNext()) != null) {

                if (step != 0) {

                    Faculty f = new Faculty(nextRecord[0], nextRecord[1], Integer.parseInt(nextRecord[2]), Integer.parseInt(nextRecord[3]),
                            Integer.parseInt(nextRecord[4]), Integer.parseInt(nextRecord[5]));
                    facultyRepository.addFaculty(f);
                }
                step++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}