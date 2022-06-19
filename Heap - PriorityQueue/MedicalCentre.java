import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MedicalCentre {

    private PriorityQueue pq;

    public MedicalCentre() {
        pq = new PriorityQueue(1000);
    }

    public void processQueue(String fileName) {
        int nextPatientNumber = 1;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] split = str.split(",");
                int priority;
                String patientName = split[0];
                int patientAge = Integer.parseInt(split[1]);
                String medicalSeverity = split[2];
                if (medicalSeverity.equals("low")) {
                    priority = 3;
                } else if (medicalSeverity.equals("medium") && patientAge < 65) {
                    priority = 2;
                } else {
                    priority = 1;
                }

                Patient p = new Patient(
                        priority,
                        patientName,
                        patientAge,
                        medicalSeverity,
                        nextPatientNumber);
                nextPatientNumber++;

                pq.insert(p);
            }

            Patient P = (Patient) pq.delete();
            while (P != null) {
                System.out.println(P.toStringLong());
                P = (Patient) pq.delete();
            }
            // more code
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            // exception handling left as an exercise for the reader
        }
    }
}
