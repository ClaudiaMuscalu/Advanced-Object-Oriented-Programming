package Model;

public class AdmissionExam
{
    private double gradeExam1;
    private double gradeExam2;
    private double examResult;

    public AdmissionExam(double gradeExam1, double gradeExam2)
    {
        this.gradeExam1 = gradeExam1;
        this.gradeExam2 = gradeExam2;
        this.examResult = (gradeExam1 + gradeExam2) / 2.0;
    }

    public double getGradeExam1()
    {
        return this.gradeExam1;
    }

    public void setGradeExam1(double gradeExam1)
    {
        this.gradeExam1 = gradeExam1;
    }

    public double getGradeExam2()
    {
        return this.gradeExam2;
    }

    public void setGradeExam2(double gradeExam2)
    {
        this.gradeExam2 = gradeExam2;
    }

    public double getExamResult()
    {
        return this.examResult;
    }

    public void setExamResult(double examResult)
    {
        this.examResult = examResult;
    }

    public void setAdmissionExam(double gradeExam1, double gradeExam2)
    {
        this.setGradeExam1(gradeExam1);
        this.setGradeExam1(gradeExam2);
        this.setExamResult((gradeExam1 + gradeExam2)/2.0);
    }
}
