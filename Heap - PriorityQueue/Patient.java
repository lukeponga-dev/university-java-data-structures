public class Patient extends Node {

  // Variables
  String name;
  int age;
  String medical_severity;
  int patientNumber;


    public Patient(Node Priority, String name, int age, String medical_severity, int patientNumber) {
        this.Priority = Priority;
        this.name = name;
        this.age = age;
        this.medical_severity = medical_severity;
        this.patientNumber = patientNumber;
    }

    @Override
    public String toString() {
        return "{" +" Priority: '"+Priority()+ "'" +" name='" + getName() + "'" + "}";
    }



    @Override
    public String toStringLong() {
        return "{" + " Priority:'" + Priority() + "'" +
             " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", medical_severity='" + getMedical_severity() + "'" +
            ", patientNumber='" + getPatientNumber() + "'" +
            "}";
    }


}
