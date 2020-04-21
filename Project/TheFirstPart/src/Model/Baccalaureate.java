package Model;

public class Baccalaureate
{
    private double exam1Result;
    private double exam2Result;
    private double exam3Result;
    private double endResult;

    public Baccalaureate(double exam1Result, double exam2Result, double exam3Result)
    {
        this.exam1Result = exam1Result;
        this.exam2Result = exam2Result;
        this.exam3Result = exam3Result;
        this.endResult = (exam1Result + exam2Result + exam3Result) / 3.0;
    }

    public double getExam1Result()
    {
        return this.exam1Result;
    }

    public void setExam1Result(double exam1Result)
    {
        this.exam1Result = exam1Result;
    }

    public double getExam2Result() { return this.exam2Result; }

    public void setExam2Result(double exam2Result)
    {
        this.exam2Result = exam2Result;
    }

    public double getExam3Result()
    {
        return this.exam3Result;
    }

    public void setExam3Result(double exam3Result)
    {
        this.exam3Result = exam3Result;
    }

    public double getEndResult()
    {
        return this.endResult;
    }

    public void setEndResult(double endResult) {
        this.endResult = endResult;
    }
}
