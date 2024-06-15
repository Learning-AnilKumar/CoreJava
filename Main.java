import java.util.ArrayList;

abstract class Emplyoee {
    private final String name;
    private final int id;

    public Emplyoee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "[Employee name : " + name + "   id : " + id + "  salary :  " + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Emplyoee {
    double monthlysalary;

    public FullTimeEmployee(String name, int id, double monthlysalary) {
        super(name, id);
        this.monthlysalary = monthlysalary;
    }


    @Override
    public double calculateSalary() {
        return monthlysalary;
    }
}

class PartTimeEmployee extends Emplyoee {
    private final int hourWorked;
    private final int hourlyRate;

    public PartTimeEmployee(String name, int id, int hourWorked, int hourlyRate) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hourWorked = hourWorked;
    }


    @Override
    public double calculateSalary() {
        return hourWorked * hourlyRate;
    }
}


class PayrollSystem {
    ArrayList<Emplyoee> emplyoeesList;

    public PayrollSystem() {
        emplyoeesList = new ArrayList<>();
    }

    public void addEmployee(Emplyoee emp) {
        emplyoeesList.add(emp);
    }

    public void removeEmployee(int id) {
        Emplyoee empToRemove = null;
        for (Emplyoee e : emplyoeesList) {
            if (e.getId() == id) {
                empToRemove = e;
                break;
            }
        }

        if (empToRemove != null) {
            emplyoeesList.remove(empToRemove);
        }
    }

    public ArrayList<Emplyoee> showAllEmployee() {
        return emplyoeesList;
    }
}


public class Main {
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Anil", 1, 20000);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Amal", 2, 5, 1000);

        PayrollSystem payrollSystem = new PayrollSystem();
        payrollSystem.addEmployee(fullTimeEmployee);
        payrollSystem.addEmployee(partTimeEmployee);

        System.out.println("All Emp");
        System.out.println("----------------");
        System.out.println(payrollSystem.showAllEmployee());
        System.out.println("Remove id 1 emp");
        System.out.println("----------------");
        payrollSystem.removeEmployee(1);
        System.out.println("Remaining All Emp");
        System.out.println("----------------");
        System.out.println(payrollSystem.showAllEmployee());
    }
}

//Learning
// child class object also a parent class object
//child class implementation apply when use parent class object
//The toString method in your code is overridden in the abstract class Emplyoee. 
//In Java, the toString method is originally defined in the Object class, which is the superclass of all classes in Java. 
//By overriding the toString method in the Emplyoee class, 
//you are providing a custom implementation of how Emplyoee objects should be represented as a string.
