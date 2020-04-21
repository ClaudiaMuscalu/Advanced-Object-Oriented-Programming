package Main;

import Model.*;
import Service.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        FacultyService facultyService = FacultyService.getInstance();
        Faculty f1 = new Faculty("FMI", "F1", 500,
                300, 60, 20);
        Faculty f2 = new Faculty("LLS", "F2", 263,
                164, 27, 13);
        Faculty f3 = new Faculty("Biologie", "F3", 166,
                70, 12, 11);

        facultyService.add(f1);
        facultyService.add(f2);
        facultyService.add(f3);

        ArrayList<Faculty> faculties = facultyService.getAllFaculties();

        System.out.println("\n Show all faculties:");
        for(Faculty f : faculties)
            System.out.println(f);

        SpecializationService specializationService = SpecializationService.getInstance();
        Specialization s1 = new Specialization("FMI-S1", "Mate",
                5, 3,2, 1, "F1");
        Specialization s2 = new Specialization("FMI-S2", "Info",
                4, 2,1, 1, "F1");
        Specialization s3 = new Specialization("FMI-S3", "CTI",
                5, 3,1, 1, "F1");
        Specialization s4 = new Specialization("LLS-S1", "Engleza-Rusa", 56,
                90,9, 5, "F2");
        Specialization s5 = new Specialization("LLS-S2", "Engleza-Portugheza",77,
                46,10, 4, "F2");
        Specialization s6 = new Specialization("LLS-S3", "Engleza-Franceza",133,
                28,8, 4, "F2");

        specializationService.addSpecialization(s1);
        specializationService.addSpecialization(s2);
        specializationService.addSpecialization(s3);
        specializationService.addSpecialization(s4);
        specializationService.addSpecialization(s5);
        specializationService.addSpecialization(s6);

        ArrayList<Specialization> specializations = specializationService.getAllSpecializations();

        System.out.println("\n Show all specializations from all faculties:");
        for(Specialization s : specializations)
            System.out.println(s);

        ArrayList<Specialization> specializationsFMI = specializationService.gelAllFacultySpecializationsByCode("F1");
        System.out.println("\n Show specializations from FMI:");
        for(Specialization s : specializationsFMI)
            System.out.println(s);

        ArrayList<Specialization> specializationsLLS = specializationService.gelAllFacultySpecializationsByCode("F2");

        System.out.println("\n Show specializations from LLS:");
        for(Specialization s : specializationsLLS)
            System.out.println(s.toString());

        // Declar mai multi candidati pentru a ilustra cum ii aleg pe cei admisi
        BudgetCandidate bc1 = new BudgetCandidate("Radu", "Popescu", "1234567891234",
                new Baccalaureate(8.9,7.89, 9), "F1");
        BudgetCandidate bc2 = new BudgetCandidate("Medeea", "Manole", "1234567894444",
                new Baccalaureate(9.5,9.7, 9), "F1");
        BudgetCandidate bc3 = new BudgetCandidate("Mircea", "Buzau", "1234567895555",
                new Baccalaureate(8.33,8.80, 6.7), "F1");
        BudgetCandidate bc4 = new BudgetCandidate("Ion", "Dascalescu", "1234567891222",
                new Baccalaureate(6.33,9.80, 7.7), "F1");
        BudgetCandidate bc5 = new BudgetCandidate("Sorin", "Zaim", "2834567895555",
                new Baccalaureate(8.73,8.40, 7.7), "F1");
        BudgetCandidate bc6 = new BudgetCandidate("Madalina", "Soare", "1224567895555",
                new Baccalaureate(8.73,8.34, 8.7), "F1");
        BudgetCandidate bc7 = new BudgetCandidate("Miruna", "Iacob", "1234577895555",
                new Baccalaureate(9.33,8.77, 7.7), "F1");
        BudgetCandidate bc8 = new BudgetCandidate("Sanziana", "Tarta", "1234567885555",
                new Baccalaureate(9.33,8.80, 9.7), "F1");
        BudgetCandidate bc9= new BudgetCandidate("Mirela", "Brumariu", "5234567895555",
                new Baccalaureate(8.33,9.80, 10), "F1");
        BudgetCandidate bc10 = new BudgetCandidate("Catinca", "David", "1234567894545",
                new Baccalaureate(10,10, 10), "F1");
        BudgetCandidate bc11 = new BudgetCandidate("Elisabeta", "Buzau", "2334567895555",
                new Baccalaureate(9.33,9.80, 9.7), "F1");
        BudgetCandidate bc12 = new BudgetCandidate("Mihaela", "Buzau", "1234507895555",
                new Baccalaureate(9.33,9.80, 9.7), "F1");
        BudgetCandidate bc13 = new BudgetCandidate("Mircea", "Buzau", "1234567898989",
                new Baccalaureate(5.33,7.80, 9.7), "F1");
        BudgetCandidate bc14 = new BudgetCandidate("Mircea", "Buzau", "1234567895555",
                new Baccalaureate(8.33,8.80, 6.7), "F1");
        BudgetCandidate bc15 = new BudgetCandidate("Mircea", "Buzau", "1234567895555",
                new Baccalaureate(8.33,8.80, 6.7), "F1");
        BudgetCandidate bc16 = new BudgetCandidate("Mircea", "Buzau", "1234567895555",
                new Baccalaureate(8.33,8.80, 6.7), "F1");
        BudgetCandidate bc17 = new BudgetCandidate("Mircea", "Buzau", "1234567895555",
                new Baccalaureate(8.33,8.80, 6.7), "F1");
        BudgetCandidate bc18 = new BudgetCandidate("Mihai", "Nelu", "1234567895555",
                new Baccalaureate(8.33,8.80, 6.7), "F1");
        BudgetCandidate bc19 = new BudgetCandidate("Ionut", "Horecica", "1234597895555",
                new Baccalaureate(8.33,8.80, 9.7), "F1");
        BudgetCandidate bc20 = new BudgetCandidate("Gheorghe", "Visan", "2234567895555",
                new Baccalaureate(9.33,6.80, 8.37), "F1");
        BudgetCandidate bc21 = new BudgetCandidate("George", "Apetrei", "6034567895555",
                new Baccalaureate(8.33,8.80, 6.7), "F1");

        TollCandidate tc1 = new TollCandidate("Giulian", "Dumi", "9234567899998",
                new Baccalaureate(9.9,9.89, 9.45), "F1");
        TollCandidate tc2 = new TollCandidate("Marian", "Preda", "8234567899998",
                new Baccalaureate(7.9,8.89, 7.45), "F1");
        TollCandidate tc3 = new TollCandidate("Sorin", "Preda", "1234567899998",
                new Baccalaureate(5.9,9.89, 7.45), "F1");
        TollCandidate tc4 = new TollCandidate("Mari", "Dinu", "6234567899998",
                new Baccalaureate(7.9,9.89, 7.45), "F1");
        TollCandidate tc5 = new TollCandidate("Bogdan", "Duta", "7234567899998",
                new Baccalaureate(9.12,7.89, 7.45), "F1");
        TollCandidate tc6 = new TollCandidate("Iuliana", "Busuioc", "1234544899998",
                new Baccalaureate(7.9,7.89, 9.45), "F1");
        TollCandidate tc7 = new TollCandidate("David", "Canache", "1234567899998",
                new Baccalaureate(5.9,9.89, 7.45), "F1");
        TollCandidate tc8 = new TollCandidate("Diana", "Nelu", "9234567899998",
                new Baccalaureate(8.9,5.89, 9.45), "F1");
        TollCandidate tc9 = new TollCandidate("Mirela", "Ion", "1234567899998",
                new Baccalaureate(5.69,7.55, 7.45), "F1");
        TollCandidate tc10 = new TollCandidate("Felicia", "Dragomir", "1234567899998",
                new Baccalaureate(9.9,9.89, 9.45), "F1");
        TollCandidate tc11 = new TollCandidate("Marioara", "Severin", "1234567899998",
                new Baccalaureate(7.1,9.89, 7.45), "F1");
        TollCandidate tc12 = new TollCandidate("Iuli", "Mortun", "1234567892298",
                new Baccalaureate(5.9,6.79, 9.45), "F1");
        TollCandidate tc13 = new TollCandidate("Dan", "Grigore", "1234567819998",
                new Baccalaureate(5.9,6.89, 7.37), "F1");
        TollCandidate tc14 = new TollCandidate("Nicolas", "Catianis", "9994567899998",
                new Baccalaureate(8.55,9.89, 8.7), "F1");
        TollCandidate tc15 = new TollCandidate("Alexandra", "Lupu", "1294567899998",
                new Baccalaureate(7.9,9.12, 7.45), "F1");

        CountrysideCandidate csc1 = new CountrysideCandidate("Relu", "Neagu", "1294567899978",
                new Baccalaureate(5.76,7.89, 6.45), "F1");
        CountrysideCandidate csc2 = new CountrysideCandidate("Sorina", "Turcu", "1256567899978",
                new Baccalaureate(5.76,9.89, 9.45), "F1");
        CountrysideCandidate csc3 = new CountrysideCandidate("Vasile", "Nita", "1234567899778",
                new Baccalaureate(9.76,9.99, 8.45), "F1");
        CountrysideCandidate csc4 = new CountrysideCandidate("Danut", "Lungu", "8234567899978",
                new Baccalaureate(9.76,9.89, 6.77), "F1");
        CountrysideCandidate csc5 = new CountrysideCandidate("Dumitru", "Gherasim", "1234967899978",
                new Baccalaureate(9.36,9.89, 9.45), "F1");
        CountrysideCandidate csc6 = new CountrysideCandidate("Elena", "Mira", "1235567899978",
                new Baccalaureate(8.76,9.89, 9.75), "F1");
        CountrysideCandidate csc7 = new CountrysideCandidate("Medeea", "Husaru", "1234967899978",
                new Baccalaureate(8.76,9.89, 9.45), "F1");
        CountrysideCandidate csc8 = new CountrysideCandidate("Paul", "Stamate", "1234567845978",
                new Baccalaureate(5.96,8.89, 7.45), "F1");
        CountrysideCandidate csc9 = new CountrysideCandidate("Filip", "Neagu", "1234567899978",
                new Baccalaureate(5.76,9.89, 9.45), "F1");

        MinorityCandidate mc1 = new MinorityCandidate("John", "Smith", "1111111111111",
                new Baccalaureate(5.00,9.89, 9.45), "F1");
        MinorityCandidate mc2 = new MinorityCandidate("Selena", "Smith", "2111111111111",
                new Baccalaureate(9.00,7.89, 9.45), "F1");
        MinorityCandidate mc3 = new MinorityCandidate("Agatha", "Christie", "1191111111111",
                new Baccalaureate(9.00,6.89, 8.45), "F1");
        MinorityCandidate mc4 = new MinorityCandidate("Philliphe", "D.", "1118111111111",
                new Baccalaureate(7.58,6.89, 9.45), "F1");
        MinorityCandidate mc5 = new MinorityCandidate("Justin", "S.", "1111111111119",
                new Baccalaureate(5.90,9.79, 7.45), "F1");
        MinorityCandidate mc6 = new MinorityCandidate("Miriam", "C.", "1111111111711",
                new Baccalaureate(5.99,9.33, 8.45), "F1");

        BudgetCandidate x = new BudgetCandidate("Andrei", "Rusu", "1234567891333",
                new Baccalaureate(6.7,7.67, 10), "F2");
        BudgetCandidate y = new BudgetCandidate("Toader", "Badarau", "1234567897777",
                new Baccalaureate(9.78,8.96, 9.88), "F2");
        BudgetCandidate z = new BudgetCandidate("Luiza", "Husaru", "1234567899999",
                new Baccalaureate(9.9,8.89, 6.45), "F2");
        TollCandidate w = new TollCandidate("Maria", "Duta", "1234567899998",
                new Baccalaureate(5.9,6.89, 7.45), "F2");

        CandidateService candidateService = CandidateService.getInstance();

        candidateService.addCandidate(bc1);
        candidateService.addCandidate(bc2);
        candidateService.addCandidate(bc3);
        candidateService.addCandidate(bc4);
        candidateService.addCandidate(bc5);
        candidateService.addCandidate(bc6);
        candidateService.addCandidate(bc7);
        candidateService.addCandidate(bc8);
        candidateService.addCandidate(bc9);
        candidateService.addCandidate(bc10);
        candidateService.addCandidate(bc11);
        candidateService.addCandidate(bc12);
        candidateService.addCandidate(bc13);
        candidateService.addCandidate(bc14);
        candidateService.addCandidate(bc15);
        candidateService.addCandidate(bc16);
        candidateService.addCandidate(bc17);
        candidateService.addCandidate(bc18);
        candidateService.addCandidate(bc19);
        candidateService.addCandidate(bc20);
        candidateService.addCandidate(bc21);

        candidateService.addCandidate(tc1);
        candidateService.addCandidate(tc2);
        candidateService.addCandidate(tc3);
        candidateService.addCandidate(tc4);
        candidateService.addCandidate(tc5);
        candidateService.addCandidate(tc6);
        candidateService.addCandidate(tc7);
        candidateService.addCandidate(tc8);
        candidateService.addCandidate(tc9);
        candidateService.addCandidate(tc10);
        candidateService.addCandidate(tc11);
        candidateService.addCandidate(tc12);
        candidateService.addCandidate(tc13);
        candidateService.addCandidate(tc14);
        candidateService.addCandidate(tc15);

        candidateService.addCandidate(csc1);
        candidateService.addCandidate(csc2);
        candidateService.addCandidate(csc3);
        candidateService.addCandidate(csc4);
        candidateService.addCandidate(csc5);
        candidateService.addCandidate(csc6);
        candidateService.addCandidate(csc7);
        candidateService.addCandidate(csc8);
        candidateService.addCandidate(csc9);

        candidateService.addCandidate(mc1);
        candidateService.addCandidate(mc2);
        candidateService.addCandidate(mc3);
        candidateService.addCandidate(mc4);
        candidateService.addCandidate(mc5);
        candidateService.addCandidate(mc6);

        candidateService.addCandidate(x);
        candidateService.addCandidate(y);
        candidateService.addCandidate(z);
        candidateService.addCandidate(w);


        ArrayList<BudgetCandidate> budgetCandidates = candidateService.getAllBudgetCandidates();

        System.out.println(" \nShow all applications candidates for budget:");
        for(BudgetCandidate b : budgetCandidates)
            System.out.println(b);


        ArrayList<CountrysideCandidate> countrysideCandidates = candidateService.getAllCountrysideCandidates();

        System.out.println(" \nShow all countryside candidate applications: ");
        for(CountrysideCandidate c : countrysideCandidates)
            System.out.println(c);


        ArrayList<TollCandidate> tollCandidates = candidateService.getAllTollCandidates();

        System.out.println(" \nShow all toll candidates applications: ");
        for(TollCandidate t : tollCandidates)
            System.out.println(t);


        ApplicationService applicationService = ApplicationService.getInstance();

        applicationService.addApplication(new CandidateApplication(true, s1, bc1, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, bc2, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, bc3, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, bc4, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, bc5, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, bc20, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, bc21, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, tc1, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, tc2, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, tc3, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, tc12, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, tc13, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, tc14, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, tc15, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, csc1, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, csc2, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, csc8, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, csc5, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, mc1, f1));
        applicationService.addApplication(new CandidateApplication(true, s1, mc6, f1));

        applicationService.addApplication(new CandidateApplication(true, s2, bc6, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, bc7, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, bc8, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, bc9, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, bc17, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, bc18, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, bc19, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, tc4, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, tc5, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, tc10, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, tc11, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, csc3, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, csc7, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, mc2, f1));
        applicationService.addApplication(new CandidateApplication(true, s2, mc5, f1));


        applicationService.addApplication(new CandidateApplication(true, s3, bc10, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, bc11, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, bc12, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, bc13, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, bc14, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, bc15, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, bc16, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, tc6, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, tc7, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, tc8, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, tc9, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, csc4, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, csc5, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, csc6, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, mc3, f1));
        applicationService.addApplication(new CandidateApplication(true, s3, mc4, f1));

        applicationService.addApplication(new CandidateApplication(false, s5, x, f2));
        applicationService.addApplication(new CandidateApplication(false, s5, y, f2));
        applicationService.addApplication(new CandidateApplication(false, s5, z, f2));
        applicationService.addApplication(new CandidateApplication(false, s5, w, f2));

        System.out.println("\n Show all the applications:");
        ArrayList<CandidateApplication> allCandidates = applicationService.getListOfApplications();
        for(CandidateApplication a : allCandidates)
            System.out.println(a);

        ArrayList<Double> admissionNote1 = new ArrayList<>();
        ArrayList<Double> admissionNote2 = new ArrayList<>();

        // Citesc notele la cele doua probe de admitere din doua fisiere
        try
        {
            Scanner scan;
            File file1 = new File("C:\\Users\\asus\\IdeaProjects\\-Advanced-Object-Oriented-Programming\\Project\\TheFirstPart\\src\\Main\\data1.txt");
            scan = new Scanner(file1);

            while (scan.hasNextDouble())
            {

                admissionNote1.add(scan.nextDouble());

            }

            File file2 = new File("C:\\Users\\asus\\IdeaProjects\\-Advanced-Object-Oriented-Programming\\Project\\TheFirstPart\\src\\Main\\data2.txt");
            scan = new Scanner(file2);
            while(scan.hasNextDouble())
            {
                admissionNote2.add(scan.nextDouble());
            }
        }
        catch (FileNotFoundException e1)
        {
            e1.printStackTrace();
        }

        // Adaug pentru fiecare candidat note pentru cele doua probe la admitere
        int count = 0;
        for(CandidateApplication a : allCandidates)
        {
            if(a.getAdmissionOption())
            {
                double n1 = admissionNote1.get(count);
                double n2 = admissionNote2.get(count);
                applicationService.addAdmissionExamCandidate(a, n1, n2);
                count ++;

            }
        }

        System.out.println("\n Show all applications to FMI:");
        ArrayList<CandidateApplication> allCandidatesFMI = applicationService.getApplicationsFacultyByName("FMI");
        for(CandidateApplication a : allCandidatesFMI)
            System.out.println(a.toString());

        System.out.println(" \nShow list of applications for budget at FMI:");
        ArrayList<CandidateApplication> a = applicationService.getAllBudgetCandidatesApp();
        for(CandidateApplication app : a)
            System.out.println(app);

        applicationService.removeAppByCnp("1234567885555");

        DistributionService distributionService = DistributionService.getInstance();

        List<CandidateApplication> admittedBudgetCandidateFMI = distributionService.getAdmittedCandidatesSpecB("FMI", "Info");
        System.out.println(" \nAll admitted budget candidate to FMI - Info (descending by result):");
        for(CandidateApplication c : admittedBudgetCandidateFMI)
        {
            System.out.println(c.print());
        }

        List<CandidateApplication> admittedTollCandidateFMI = distributionService.getAdmittedCandidatesSpecT("FMI", "Info");
        System.out.println(" \nAll admitted toll candidate to FMI - Info (descending by result):");
        for(CandidateApplication c : admittedTollCandidateFMI)
        {
            System.out.println(c.print());
        }
    }
}
