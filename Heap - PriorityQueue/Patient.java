public class Patient extends Node {

    // Variables
    public String name;
    public int age;
    public String medicalSeverity;
    public int patientNumber;

    public Patient(
            int priority,
            String name,
            int age,
            String medicalSeverity,
            int patientNumber) {
        super(priority);
        this.name = name;
        this.age = age;
        this.medicalSeverity = medicalSeverity;
        this.patientNumber = patientNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", Name: " + name;
    }

    public String toStringLong() {
        return this
                + ", Age: "
                + age
                + ", Medical severity level: "
                + medicalSeverity
                + ", Patient number: "
                + patientNumber;
    }
}
