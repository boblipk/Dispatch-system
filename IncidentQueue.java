
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IncidentQueue {
    private Incident head;
    private Incident tail;
    private Scanner scanner;
    private Set<String> uniqueIncidentsToday;

    private String tableLine(String pos, String type, String district, String priority) {
        int chunklen = 4;
        String[] data = {pos, type, district, priority};
        StringBuilder line = new StringBuilder("│");
        for (String datum : data) {
            if (datum.length() > (chunklen)) {
                datum = datum.substring(0, chunklen - 3) + "...";
            } else {
                int padding = chunklen - datum.length();
                int leftPadding = padding / 2;
                int rightPadding = padding - leftPadding;
                datum = " ".repeat(leftPadding) + datum + " ".repeat(rightPadding);
            }
            line.append(datum).append("│");
            chunklen = 30; // Set chunklen to 30 for the remaining columns
        }
        return line.toString();
    }

    public IncidentQueue(Scanner scanner) {
        this.head = null;
        this.tail = null;
        this.scanner = scanner;
        this.uniqueIncidentsToday = new HashSet<>();
    }
    public void addIncident() {

        System.out.println("Enter an Incident type ");
        String incType = scanner.nextLine();
        System.out.println("Enter an Incident district ");
        String incDistrict = scanner.nextLine();
        System.out.println("Is this a high priority Incident? (true/false) ");
        while (!scanner.hasNextBoolean()) {
            System.out.println("Please enter 'true' or 'false' for high priority: ");
            scanner.next(); // Consume the invalid input
        }
        boolean isHighPriority = scanner.nextBoolean();
        scanner.nextLine(); // Consume the newline character
        
        Incident newIncident = new Incident(incType, incDistrict, isHighPriority);
        uniqueIncidentsToday.add(incType);
    
        if (head == null) {
            head = newIncident;
            tail = newIncident;
        } else if (newIncident.getPriority()) {
            newIncident.newNext(head);
            head = newIncident;
        } else {
            tail.newNext(newIncident);
            tail = newIncident;
        }
    }

    public void  proccessIncident() {
        if (head == null) {
            System.out.println("Incident queue is empty.");
        }
        else {
            System.out.println("┌────┬──────────────────────────────┬──────────────────────────────┬──────────────────────────────┐");
            System.out.println(tableLine("Pos", "Type", "District", "Priority"));
            System.out.println("├────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┤");
            String dispPrio = head.getPriority() ? "High" : "Low";
            System.out.println(tableLine("1", head.getIncType(), head.getIncDistrict(), dispPrio));
            System.out.println("└────┴──────────────────────────────┴──────────────────────────────┴──────────────────────────────┘");
            System.out.println("do you want to process this incident? (y/n) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("y")) {
                head = head.getNext();
                if (head == null) {
                    tail = null;
                }
                System.out.println("Incident processed.");
            } else if (response.equalsIgnoreCase("n")) {
                System.out.println("Incident not processed.");
            } else {
                System.out.println("Invalid response. Please enter 'y' or 'n'.");
            }   
        }
        
    }



    public void displayIncidents() {
        System.out.println("┌────┬──────────────────────────────┬──────────────────────────────┬──────────────────────────────┐");
        String between = "├────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┤";
        System.out.println(tableLine("Pos", "Type", "District", "Priority"));
        int linepos = 1;
        Incident current = head;
        while (current != null) {
            System.out.println(between);
            String dispPrio = current.getPriority() ? "High" : "Low";
            System.out.println(tableLine(Integer.toString(linepos), current.getIncType(), current.getIncDistrict(), dispPrio));
            current = current.getNext();
            linepos++;
        }
        System.out.println("└────┴──────────────────────────────┴──────────────────────────────┴──────────────────────────────┘");
    }

    public void displayIncTypesToday() {
        if (uniqueIncidentsToday.isEmpty()) {
            System.out.println("No Incidents have been added today.");
        } else {
            System.out.println("Unique Incident types today: " + uniqueIncidentsToday);
        }
    }

    public void searchIncidents(boolean byType) {
        System.out.println("Enter the " + (byType ? "type" : "district") + " to search for: ");
        String searchTerm = scanner.nextLine().trim();
        Incident current = head;
        boolean found = false;
        
        System.out.println("┌────┬──────────────────────────────┬──────────────────────────────┬──────────────────────────────┐");
        String between = "├────┼──────────────────────────────┼──────────────────────────────┼──────────────────────────────┤";
        System.out.println(tableLine("Pos", "Type", "District", "Priority"));
        int linepos = 1;


        while (current != null) {
            String fieldToCheck = byType ? current.getIncType() : current.getIncDistrict();
            if (fieldToCheck.equalsIgnoreCase(searchTerm)) {
                found = true;
                String dispPrio = current.getPriority() ? "High" : "Low";
                System.out.println(between);
                System.out.println(tableLine(Integer.toString(linepos), current.getIncType(), current.getIncDistrict(), dispPrio));
            }
            current = current.getNext();
            linepos++;
        }
        System.out.println("└────┴──────────────────────────────┴──────────────────────────────┴──────────────────────────────┘");
        if (!found) {
            System.out.println("No Incidents found whith the " + (byType ? "type" : "district") + " '" + searchTerm + "'.");
        }
    }
}
        