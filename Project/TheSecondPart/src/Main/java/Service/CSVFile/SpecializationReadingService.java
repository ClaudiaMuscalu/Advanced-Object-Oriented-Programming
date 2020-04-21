package Service.CSVFile;

import Model.*;
import Repository.SpecializationRepository;
import com.opencsv.CSVReader;

import java.io.FileReader;

public class SpecializationReadingService {
    private static final String filePath = "specializations.csv";
    private static SpecializationReadingService instance = null;
    private SpecializationRepository specializationRepository;

    private SpecializationReadingService(SpecializationRepository s) {
        specializationRepository = s;
    }

    public static SpecializationReadingService getInstance(SpecializationRepository specializationRepository) {

        if (instance == null) {

            instance = new SpecializationReadingService(specializationRepository);
        }
        return instance;
    }

    public void readingSpecializations() {

        try (FileReader filereader = new FileReader(filePath);
             CSVReader csvReader = new CSVReader(filereader)) {

            String[] nextRecord;

            int step = 0;

            while ((nextRecord = csvReader.readNext()) != null) {

                if (step != 0) {

                    Specialization s = new Specialization(nextRecord[0], nextRecord[1], Integer.parseInt(nextRecord[2]), Integer.parseInt(nextRecord[3]),
                            Integer.parseInt(nextRecord[4]), Integer.parseInt(nextRecord[5]), nextRecord[6]);

                    specializationRepository.addSpecialization(s);
                }
                step++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
