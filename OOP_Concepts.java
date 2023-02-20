public class Person {
    // Private attributes
    private String name;
    private int age;
    private String gender;

    // Constructor method to initialize the object
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Encapsulation: Getter and Setter methods for private attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Abstraction: Method to print person's details
    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }

    // Inheritance: A derived class that extends the Person class
    public static class Employee extends Person {
        private String employeeId;

        public Employee(String name, int age, String gender, String employeeId) {
            super(name, age, gender);
            this.employeeId = employeeId;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        // Polymorphism: Override the printDetails() method to include employeeId
        @Override
        public void printDetails() {
            super.printDetails();
            System.out.println("Employee ID: " + employeeId);
        }
    }
}
