package Service.CSVFile;

import Model.Faculty;
import Repository.FacultyRepository;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FacultyWritingService {

    private static final String filePath = "faculties.csv";
    private static FacultyWritingService instance = null;
    private File file = new File(filePath);

    private FacultyRepository facultyRepository;

    FacultyWritingService(FacultyRepository c) {
        facultyRepository = c;
    }

    public static FacultyWritingService getInstance(FacultyRepository facultyRepository) {

        if (instance == null) {

            instance = new FacultyWritingService(facultyRepository);
        }
        return instance;
    }

    public void writeFaculty(Faculty f) {

        try (FileWriter outputfile = new FileWriter(file, true);
             CSVWriter writer = new CSVWriter(outputfile)) {

            String[] data = {f.getName(), f.getFacultyCode(), String.valueOf(f.getBudgetNumberPositions()),
                    String.valueOf(f.getTollNumberPositions()), String.valueOf(f.getCountrySideNumberPositions()), String.valueOf(f.getMinorityNumberPositions()),
                    String.valueOf(f.getTotalNumberPositions())};

            writer.writeNext(data);
            writer.flush();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void reloadFaculties() {

        try (FileWriter outputfile = new FileWriter(filePath);
             CSVWriter writer = new CSVWriter(outputfile)) {

            String[] header = {"Name:", "CodeFaculty:", "BudgetNumberPositions:", "TollNumberPositions:", "CountrySideNumberPositions:", "MinorityNumberPositions:",
                    "TotalNumberPositions:"};

            writer.writeNext(header);

            for (Faculty f : facultyRepository.getAllFaculties()) {
                String[] data = {f.getName(), f.getFacultyCode(), String.valueOf(f.getBudgetNumberPositions()),
                        String.valueOf(f.getTollNumberPositions()), String.valueOf(f.getCountrySideNumberPositions()), String.valueOf(f.getMinorityNumberPositions()),
                        String.valueOf(f.getTotalNumberPositions())};

                writer.writeNext(data);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
