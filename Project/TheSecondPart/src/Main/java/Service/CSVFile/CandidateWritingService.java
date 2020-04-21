package Service.CSVFile;

import Model.Candidate;
import Repository.CandidateRepository;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CandidateWritingService {

    private static final String filePath = "candidates.csv";
    private static CandidateWritingService instance = null;
    private File file = new File(filePath);

    private CandidateRepository candidateRepository;

    CandidateWritingService(CandidateRepository c) {
        candidateRepository = c;
    }

    public static CandidateWritingService getInstance(CandidateRepository candidateRepository) {

        if (instance == null) {

            instance = new CandidateWritingService(candidateRepository);
        }
        return instance;
    }

    public void writeCandidate(Candidate c) {

        try (FileWriter outputfile = new FileWriter(file, true);
             CSVWriter writer = new CSVWriter(outputfile)) {

            String Bac = String.format("%.2f", c.getBacResult());
            String b = Bac.replace(',', '.');

            String[] data = {c.getLastName(), c.getFirstName(), c.getCnp(),
                    c.getFacultyCode(), b, c.getCandidateType()};

            writer.writeNext(data);
            writer.flush();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void reloadCandidates() {

        try (FileWriter outputfile = new FileWriter(filePath);
             CSVWriter writer = new CSVWriter(outputfile)) {

            String[] header = {"LastName:", "FirstName:", "CNP:", "FacultyCode:", "Bac result:", "CandidateType:"};

            writer.writeNext(header);

            for (Candidate c : candidateRepository.getAllCandidates()) {
                String Bac = String.format("%.2f", c.getBacResult());
                String b = Bac.replace(',', '.');

                String[] data = {c.getLastName(), c.getFirstName(), c.getCnp(),
                        c.getFacultyCode(), b, c.getCandidateType()};

                writer.writeNext(data);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

