### **Faculty Admission Management System Java Project**

**The Second Part**

	Organizarea claselor:

Faculty – această clasă conține numărul de locuri alocat pe fiecare ramură: locuri buget, locuri taxă, locuri alocate persoanelor din mediul rural, locuri alocate minorităților și alte câmpuri specifice.

Specialization – această clasă conține o specializare de la o anumită facultate (codeFaculty) și locurile destinate pe fiecare ramură.

Candidate  - această clasă va fi o clasă-părinte (ilustrarea moștenirii) pentru clasele:
   BudgetCandidate; TollCandidate; CountrysideCandidate; MinorityCandidate.

Baccalaureate – această clasă păstrează notele unui candidat la Bac și va fi un câmp al clasei Candidate (ilustrarea agregării).

AdmissionExam – această clasă păstrează notele unui candidat la admiterea dată la facultate, în cazul în care facultatea are un astfel de examen.

CandidateApplication - pentru a păstra cu ușurință aplicațiile unui candidat împreună cu nota de la Bacalaureat, nota de la admitere ( dacă este cazul), facultatea și specializarea la care aplică am construit o clasă care gestionează toate aceste date.

Astfel, obiectele ce se întâlnesc în proiectul meu sunt:
1.	Faculty
2.	Specialization
3.	Baccalaureate
4.	AdmissionExam
5.	Candidate 
6.	BudgetCandidate 
7.	TollCandidate
8.	CountrysideCandidate 
9.	MinorityCandidate 
10.	CandidateApplication


 Acțiuni și interogări ce se pot realiza:
 
  Get – implementată in Repository pentru clasele :
 
 
•	CandidateRepository :

o	getCandidateByName;

o	getCandidateByCNP;

o	getAllCandidates;

o	getAllBudgetCandidates;

o	getAllCountrysideCandidate;

o	getAllMinorityCandidates;


•	ApplicationRepository:	

o	getApplicationByName;

o	getApplicationByName;

o	getApplicationsByCNP;

o	getAllBudgetCandidatesApp;

o	getListOfApplications.

  Aceleași metode și pentru FacultyRepository, SpecilizationRepository.

  Add – pentru fiecare clasă se pot adauga obiecte noi.       
  
  Update – pentru fiecare clasă pot modifica anumite câmpuri, de exemplu media de admitere va fi adăugată ulterior, ea neexistând în momentul înscrierii la facultate a unui candidat.   
  
  Remove – ștergerea aplicației unui candidant.

