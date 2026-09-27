import java.util.ArrayList;
import java.util.Scanner;

class Event {
    int id;
    String name;
    String date;
    String venue;

    Event(int id, String name, String date, String venue) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.venue = venue;
    }

    void display() {
        System.out.println("Event ID : " + id);
        System.out.println("Name     : " + name);
        System.out.println("Date     : " + date);
        System.out.println("Venue    : " + venue);
        System.out.println("----------------------------");
    }
}

class Registration {
    String studentName;
    int eventId;

    Registration(String studentName, int eventId) {
        this.studentName = studentName;
        this.eventId = eventId;
    }

    void display() {
        System.out.println("Student Name : " + studentName);
        System.out.println("Event ID     : " + eventId);
        System.out.println("----------------------------");
    }
}

public class CollegeEventManagement {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Event> events = new ArrayList<>();
    static ArrayList<Registration> registrations = new ArrayList<>();

    static void addEvent() {
        System.out.print("Enter Event ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Event Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Event Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Venue: ");
        String venue = sc.nextLine();

        events.add(new Event(id, name, date, venue));

        System.out.println("Event added successfully!");
    }

    static void viewEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        System.out.println("\n========== COLLEGE EVENTS ==========");

        for (Event event : events) {
            event.display();
        }
    }

    static void registerStudent() {
        if (events.isEmpty()) {
            System.out.println("No events available for registration.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Event ID: ");
        int eventId = sc.nextInt();
        sc.nextLine();

        for (Event event : events) {
            if (event.id == eventId) {
                registrations.add(
                    new Registration(studentName, eventId)
                );

                System.out.println("Student registered successfully!");
                return;
            }
        }

        System.out.println("Event not found.");
    }

    static void viewRegistrations() {
        if (registrations.isEmpty()) {
            System.out.println("No registrations found.");
            return;
        }

        System.out.println("\n========== REGISTRATIONS ==========");

        for (Registration registration : registrations) {
            registration.display();
        }
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n====================================");
            System.out.println("   COLLEGE EVENT MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Register Student");
            System.out.println("4. View Registrations");
            System.out.println("5. Exit");
            System.out.println("====================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addEvent();
                    break;

                case 2:
                    viewEvents();
                    break;

                case 3:
                    registerStudent();
                    break;

                case 4:
                    viewRegistrations();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
