package securevault.model;

import java.time.LocalDateTime;

public class ActivityLog {

    private String username;
    private String action;
    private LocalDateTime timestamp;

    public ActivityLog(String username, String action) {
        this.username = username;
        this.action = action;
        this.timestamp = LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }

    public String getAction() {
        return action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void displayLog() {
        System.out.println(
            timestamp + " | User: " + username + " | Action: " + action
        );
    }
}