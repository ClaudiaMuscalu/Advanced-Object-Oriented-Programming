package Service.CSVFile;

import Model.*;
import Repository.CandidateRepository;
import com.opencsv.CSVReader;

import java.io.FileReader;

public class CandidateReadingService {

    private static final String filePath = "candidates.csv";
    private static CandidateReadingService instance = null;
    private CandidateRepository candidateRepository;

    private CandidateReadingService(CandidateRepository c) {

        candidateRepository = c;
    }

    public static CandidateReadingService getInstance(CandidateRepository candidateRepository) {

        if (instance == null) {

            instance = new CandidateReadingService(candidateRepository);
        }
        return instance;
    }

    public void readingCandidates() {

        try (FileReader filereader = new FileReader(filePath);
             CSVReader csvReader = new CSVReader(filereader)) {

            String[] nextRecord;

            int step = 0;
            while ((nextRecord = csvReader.readNext()) != null) {

                if (nextRecord.length == 6) {

                    if (step != 0) {

                        switch (nextRecord[5]) {

                            case "budget": {

                                BudgetCandidate bc = new BudgetCandidate(nextRecord[0], nextRecord[1], nextRecord[2], Double.parseDouble(nextRecord[4]), nextRecord[3], nextRecord[5]);
                                candidateRepository.addCandidate(bc);
                                break;
                            }
                            case "toll": {

                                TollCandidate tc = new TollCandidate(nextRecord[0], nextRecord[1], nextRecord[2], Double.parseDouble(nextRecord[4]), nextRecord[3], nextRecord[5]);
                                candidateRepository.addCandidate(tc);
                                break;
                            }
                            case "countryside": {

                                CountrysideCandidate csc = new CountrysideCandidate(nextRecord[0], nextRecord[1], nextRecord[2], Double.parseDouble(nextRecord[4]), nextRecord[3], nextRecord[5]);
                                candidateRepository.addCandidate(csc);
                                break;
                            }
                            case "minority": {
                                MinorityCandidate mc = new MinorityCandidate(nextRecord[0], nextRecord[1], nextRecord[2], Double.parseDouble(nextRecord[4]), nextRecord[3], nextRecord[5]);
                                candidateRepository.addCandidate(mc);
                                break;
                            }
                        }
                    }
                    step++;


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


