// Last updated: 1/19/2026, 9:57:16 PM
import java.util.*;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        boolean[] online = new boolean[numberOfUsers];
        int[] comeBackAt = new int[numberOfUsers];

        Arrays.fill(online, true);

        // SORT EVENTS BY TIMESTAMP
        // Tiebreak: OFFLINE BEFORE MESSAGE
        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2) return t1 - t2;

            boolean aOffline = a.get(0).equals("OFFLINE");
            boolean bOffline = b.get(0).equals("OFFLINE");
            if (aOffline && !bOffline) return -1;
            if (!aOffline && bOffline) return 1;
            return 0;
        });

        for (List<String> event : events) {
            String type = event.get(0);
            int time = Integer.parseInt(event.get(1));
            String payload = event.get(2);

            // AUTO-UPDATE ONLINE USERS BEFORE PROCESSING THIS EVENT
            for (int i = 0; i < numberOfUsers; i++) {
                if (!online[i] && comeBackAt[i] <= time) {
                    online[i] = true;
                }
            }

            if (type.equals("OFFLINE")) {
                int user = Integer.parseInt(payload);
                online[user] = false;
                comeBackAt[user] = time + 60;
            } 
            else { // MESSAGE EVENT
                if (payload.equals("ALL")) {
                    // mention all users (offline included)
                    for (int i = 0; i < numberOfUsers; i++) {
                        mentions[i]++;
                    }
                }
                else if (payload.equals("HERE")) {
                    // mention only online users
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (online[i]) mentions[i]++;
                    }
                }
                else {
                    // id<number> mentions
                    String[] tokens = payload.split(" ");
                    for (String t : tokens) {
                        if (t.startsWith("id")) {
                            int user = Integer.parseInt(t.substring(2));
                            mentions[user]++;    // duplicates count
                        }
                    }
                }
            }
        }

        return mentions;
    }
}
