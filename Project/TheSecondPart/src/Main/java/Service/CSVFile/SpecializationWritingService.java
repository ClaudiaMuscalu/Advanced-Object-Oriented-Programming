package Service.CSVFile;

import Model.Specialization;
import Repository.SpecializationRepository;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SpecializationWritingService {

    private static final String filePath = "specializations.csv";
    private static SpecializationWritingService instance = null;
    private File file = new File(filePath);

    private SpecializationRepository specializationRepository;

    SpecializationWritingService(SpecializationRepository s) {
        specializationRepository = s;
    }

    public static SpecializationWritingService getInstance(SpecializationRepository specializationRepository) {

        if (instance == null) {

            instance = new SpecializationWritingService(specializationRepository);
        }
        return instance;
    }

    public void writeSpecialization(Specialization s) {

        try (FileWriter outputfile = new FileWriter(file, true);
             CSVWriter writer = new CSVWriter(outputfile)) {

            String[] data = {s.getCode(), s.getNameS(), String.valueOf(s.getNumberOfPositionsBudget()),
                    String.valueOf(s.getNumberOfPositionsToll()), String.valueOf(s.getCountrySideNumberPositions()), String.valueOf(s.getMinorityNumberPositions()),
                    s.getFacultyCode()};

            writer.writeNext(data);
            writer.flush();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void reloadSpecializations() {

        try (FileWriter outputfile = new FileWriter(filePath);
             CSVWriter writer = new CSVWriter(outputfile)) {

            String[] header = {"Code:", "Names:", "BudgetNumberPositions:", "TollNumberPositions:", "CountrySideNumberPositions:", "MinorityNumberPositions:",
                    "FacultyCode:"};

            writer.writeNext(header);

            for (Specialization s : specializationRepository.getAllSpecializations()) {
                String[] data = {s.getCode(), s.getNameS(), String.valueOf(s.getNumberOfPositionsBudget()),
                        String.valueOf(s.getNumberOfPositionsToll()), String.valueOf(s.getCountrySideNumberPositions()), String.valueOf(s.getMinorityNumberPositions()),
                        s.getFacultyCode()};
                writer.writeNext(data);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
