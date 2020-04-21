package Service.CSVFile;

import Model.*;
import Repository.ApplicationRepository;
import Service.CandidateService;
import Service.FacultyService;
import Service.SpecializationService;
import com.opencsv.CSVReader;

import java.io.FileReader;

public class ApplicationReadingService {
    private static final String filePath = "applications.csv";
    private static ApplicationReadingService instance = null;
    private ApplicationRepository applicationRepository;

    private SpecializationService specializationService = SpecializationService.getInstance();
    private FacultyService facultyService = FacultyService.getInstance();
    private CandidateService candidateService = CandidateService.getInstance();

    private ApplicationReadingService(ApplicationRepository a) {

        applicationRepository = a;
    }

    public static ApplicationReadingService getInstance(ApplicationRepository applicationRepository) {

        if (instance == null) {

            instance = new ApplicationReadingService(applicationRepository);
        }
        return instance;
    }

    public void readingApplications() {

        try (FileReader filereader = new FileReader(filePath);
             CSVReader csvReader = new CSVReader(filereader)) {

            String[] nextRecord;

            int step = 0;
            while ((nextRecord = csvReader.readNext()) != null) {

                if (nextRecord.length == 11) {

                    if (step != 0) {
                        CandidateApplication a = new CandidateApplication(nextRecord[0], specializationService.getSpecByName(nextRecord[1]),
                                candidateService.getCandidateByCNP(nextRecord[4]), facultyService.findFacultyByName(nextRecord[8]), Double.parseDouble(nextRecord[9]));
                        applicationRepository.addApplication(a);
                    }
                    step++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
