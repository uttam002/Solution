import java.util.*;

class TrackDB {
    int[] st;
    int[] et;

    TrackDB(int[] min) {
        int n = min.length;
        st = new int[n];
        et = new int[n];

        st[0] = 0;
        et[0] = min[0];

        for (int i = 1; i < n; i++) {
            st[i] = st[i - 1] + min[i - 1] + 5;
            et[i] = et[i - 1] + min[i] + 5;
        }
    }
}

public class SessionSchedule {
    public static void main(String[] args) {
        // Define tracks
        int[] T1Min = {25, 30, 45};
        TrackDB T1 = new TrackDB(T1Min);

        int[] T2Min = {45, 35, 50};
        TrackDB T2 = new TrackDB(T2Min);

        int[] T3Min = {25, 45, 40, 30, 50};
        TrackDB T3 = new TrackDB(T3Min);

        // Define preferred sessions
        Queue<Session> preferredSessions = new LinkedList<>();
        preferredSessions.add(new Session("T1-S1", T1.st[0], T1.et[0]));
        preferredSessions.add(new Session("T1-S3", T1.st[2], T1.et[2]));
        preferredSessions.add(new Session("T3-S3", T3.st[2], T3.et[2]));
        preferredSessions.add(new Session("T2-S3", T2.st[2], T2.et[2]));
        preferredSessions.add(new Session("T3-S2", T3.st[1], T3.et[1]));
        preferredSessions.add(new Session("T3-S5", T3.st[4], T3.et[4]));

        // Schedule sessions
        int numSessionsAttended = scheduleSessions(preferredSessions);
        System.out.println("\n" + numSessionsAttended + " sessions can be attended without conflict.");
    }

    static class Session {
        String id;
        int startTime;
        int endTime;

        public Session(String id, int startTime, int endTime) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static int scheduleSessions(Queue<Session> preferredSessions) {
        List<Session> scheduledSessions = new ArrayList<>();
        int numSessionsAttended = 0;

        while (!preferredSessions.isEmpty()) {
            Session session = preferredSessions.poll();
            int sessionStartTime = session.startTime;

            boolean canAttend = true;

            for (Session scheduledSession : scheduledSessions) {
                int scheduledSessionStartTime = scheduledSession.startTime;
                int scheduledSessionEndTime = scheduledSession.endTime;
                // Check if the session's start time falls within the range of any already scheduled session
                if (sessionStartTime >= scheduledSessionStartTime && sessionStartTime < scheduledSessionEndTime) {
                    canAttend = false;
                }
            }

            if (canAttend) {
                numSessionsAttended++;
                scheduledSessions.add(session);
            }
        }

        System.out.println("Scheduled Sessions:");
        for (Session session : scheduledSessions) {
            System.out.println(session.id);
        }

        return numSessionsAttended;
    }
}
