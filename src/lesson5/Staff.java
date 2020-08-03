package lesson5;

public class Staff {
    String name;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Staff(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email= email;
        this.phone = phone;
        this.salary= salary;
        this.age = age;
    }

    public void staffInfo() {
        System.out.printf("Name: %s, Position: %s, Email: %s, Phone number: %s, Salary: %d, Age: %d\n", name, position,email, phone, salary, age);
    }
    public void staffOverForty() {
        if (age> 40){
            System.out.printf("Name: %s, Position: %s, Email: %s, Phone number: %s, Salary: %d, Age: %d\n", name, position,email, phone, salary, age);
        }

    }
}
