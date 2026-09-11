package securevault.service;

import securevault.model.ActivityLog;
import java.util.ArrayList;
import java.io.*;

public class LoggingService {

    private ArrayList<ActivityLog> logs;
    private static final String LOG_FILE = "logs.txt";

    public LoggingService() {
        logs = new ArrayList<>();
        loadLogs();
    }

    public void logActivity(String username, String action) {

        ActivityLog log = new ActivityLog(username, action);
        logs.add(log);

        saveLog(username, action);

        System.out.println("Activity recorded.");
    }

    public void viewLogs() {

        if (logs.isEmpty()) {
            System.out.println("No activity logs available.");
            return;
        }

        System.out.println("\n===== ACTIVITY LOGS =====");

        for (ActivityLog log : logs) {
            log.displayLog();
        }
    }

    private void saveLog(String username, String action) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(LOG_FILE, true))) {

            writer.write(username + ":" + action);
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error saving activity log.");
            e.printStackTrace();
        }
    }

    private void loadLogs() {

        File file = new File(LOG_FILE);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(LOG_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(":", 2);

                if (parts.length == 2) {

                    ActivityLog log =
                            new ActivityLog(parts[0], parts[1]);

                    logs.add(log);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading activity logs.");
            e.printStackTrace();
        }
    }
}