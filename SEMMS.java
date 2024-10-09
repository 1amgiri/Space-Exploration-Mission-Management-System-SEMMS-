import java.sql.Date;
import java.util.*;
import models.*;
import services.*;


public class SEMMS {
    public static void main(String[] args) {
        MissionManagementService service = new MissionManagementService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Spacecraft");
            System.out.println("2. Add Mission");
            System.out.println("3. List Spacecrafts");
            System.out.println("4. List Missions");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Spacecraft Name: ");
                    String scName = scanner.nextLine();
                    System.out.print("Enter Spacecraft Type (Crewed/Uncrewed): ");
                    String scType = scanner.nextLine();
                    System.out.print("Enter Spacecraft Capacity: ");
                    int scCapacity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    service.addSpacecraft(new Spacecraft(0, scName, scType, scCapacity));
                    break;

                case 2:
                    service.listSpacecrafts();
                    System.out.print("Enter Mission Name: ");
                    String missionName = scanner.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter Launch Date (YYYY-MM-DD): ");
                    String launchDate = scanner.nextLine();
                    System.out.print("Enter Spacecraft ID: ");
                    int spacecraftId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    service.addMission(new Mission(0, missionName, destination, Date.valueOf(launchDate), spacecraftId));
                    break;

                    case 3:
                    List<Spacecraft> spacecrafts = service.listSpacecrafts();
                    System.out.println("Spacecrafts List:");
                    if (spacecrafts.isEmpty()) {
                        System.out.println("No spacecrafts available.");
                    } else {
                        for (Spacecraft spacecraft : spacecrafts) {
                            System.out.println("ID: " + spacecraft.getId() +
                                               ", Name: " + spacecraft.getName() +
                                               ", Type: " + spacecraft.getType() +
                                               ", Capacity: " + spacecraft.getCapacity());
                        }
                    }
                    break;
                
                case 4:
                    List<Mission> missions = service.listMissions();
                    System.out.println("Missions List:");
                    if (missions.isEmpty()) {
                        System.out.println("No missions available.");
                    } else {
                        for (Mission mission : missions) {
                            System.out.println("ID: " + mission.getId() +
                                               ", Name: " + mission.getMissionName() +
                                               ", Destination: " + mission.getDestination() +
                                               ", Launch Date: " + mission.getLaunchDate() +
                                               ", Spacecraft ID: " + mission.getSpacecraftId());
                        }
                    }
                    break;                
            }
        }
    }
}
