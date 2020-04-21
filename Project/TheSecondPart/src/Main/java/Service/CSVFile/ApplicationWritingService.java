package Service.CSVFile;

import Model.CandidateApplication;
import Repository.ApplicationRepository;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ApplicationWritingService {
    private static ApplicationWritingService instance = null;

    private String filePath = "applications.csv";
    private File file = new File(filePath);

    private ApplicationRepository applicationRepository;

    private ApplicationWritingService(ApplicationRepository a) {
        applicationRepository = a;
    }

    public static ApplicationWritingService getInstance(ApplicationRepository applicationRepository) {

        if (instance == null) {
            instance = new ApplicationWritingService(applicationRepository);

        }
        return instance;
    }

    public void writeAnApplication(CandidateApplication c) {

        try (FileWriter outputfile = new FileWriter(file, true);
             CSVWriter writer = new CSVWriter(outputfile)) {

            String Bac = String.format("%.2f", c.getCandidate().getBacResult());
            String b = Bac.replace(',', '.');

            String ad = String.format("%.2f", c.getAdmissionExam());
            String a = ad.replace(',', '.');

            String res = String.format("%.2f", c.getResult());
            String r = ad.replace(',', '.');

            String[] data = {c.getAdmissionOption(), c.getSpecialization().getNameS(), c.getCandidate().getLastName(), c.getCandidate().getFirstName(), c.getCandidate().getCnp(),
                    c.getCandidate().getFacultyCode(), b, c.getFaculty().getName(), a, r};
            writer.writeNext(data);

            writer.flush();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void reloadApplications() {

        try (FileWriter outputfile = new FileWriter(filePath);
             CSVWriter writer = new CSVWriter(outputfile)) {

            String[] header = {"AdmissionOption:", "Specialization:", "LastName:", "FirstName:", "CNP:", "FacultyCode:", "Bac result:", "CandidateType:", "FacultyName:", "Admission result:", "End result:"};

            writer.writeNext(header);

            for (CandidateApplication c : applicationRepository.getListOfApplications()) {
                String[] data = {c.getAdmissionOption(), c.getSpecialization().getNameS(), c.getCandidate().getLastName(), c.getCandidate().getFirstName(), c.getCandidate().getCnp(),
                        c.getCandidate().getFacultyCode(), c.getCandidate().getCandidateType(), String.format("%.2f", c.getCandidate().getBacResult()), c.getFaculty().getName(), String.format("%.2f", c.getAdmissionExam()), String.format("%.2f", c.getResult())};


                writer.writeNext(data);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
