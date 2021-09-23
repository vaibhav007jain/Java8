package main.java.com.practice.entity;

public class RetirementAgeModifier {

    private static Employee employee = new Employee("John", 58);

    public RetirementAgeModifier(){

    }
    public static void main(String[] args) {
        modifyRetirementAge();
        printRetirementAge();

        Employee employeeOne = new Employee("Mark", 60);
        setEmployee(employeeOne);
        printRetirementAge();

        modifyAge();

        RetirementAgeModifier retirementAgeModifier = new RetirementAgeModifier();
        System.out.println("Call Parent: ");
        retirementAgeModifier.call();

        double i = (2147483647 * 2147483647);
        System.out.println("i: "+i);

    }

    public void call(){
        A a = new B();
        System.out.println(a.a);
        a.print();
    }

    public class A{
        int a = 10;

        public void print(){
            System.out.println("A: "+a);
        }
    }

    public class B extends  A{
        int a =20;
        public void print(){
            System.out.println("A: "+super.a);
            System.out.println("B: "+a);
        }
    }

    private static void modifyAge() {
        Employee employeeTwo = getEmployee();
        employeeTwo.setRetirementAge(65);
        printRetirementAge();
    }

    public static Employee getEmployee() {
        return new Employee(employee.getName(), employee.getRetirementAge());
    }

    public static void setEmployee(Employee employee) {
        RetirementAgeModifier.employee.setName(employee.getName());
        RetirementAgeModifier.employee.setRetirementAge(employee.getRetirementAge());
    }

    private static void modifyRetirementAge(){
        employee.retirementAge=18;
    }

    private static void printRetirementAge(){
        System.out.println("Retirement Age: "+employee.retirementAge);
    }
}
