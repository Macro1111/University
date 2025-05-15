public abstract class Teacher {
    protected String name;
    protected double baseSalary;
    protected SalaryCalculator salaryCalculator;

    public Teacher(String name, double baseSalary, SalaryCalculator salaryCalculator) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.salaryCalculator = salaryCalculator;
    }

    public double getSalary() {
        return salaryCalculator.calculateSalary(this);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getName() {
        return name;
    }
}