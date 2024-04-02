# Conference Session Scheduling Algorithm

## 1. Define Tracks:
   - Create track schedules based on provided session durations.

## 2. Define Preferred Sessions:
   - Store attendee preferences in a list, including session IDs and desired start and end times.

## 3. Schedule Sessions:
   - Create a queue to manage sessions.
   - Initialize an empty list to store scheduled sessions.
   - Iterate through the preferred sessions queue:
     - Dequeue the next session from the preferred sessions queue.
     - Check for conflicts with already scheduled sessions:
       - For each already scheduled session:
         - Check if the new session overlaps with it.
         - And for check that overlaps or note simply check that is currentSession's starting time lies between the already scheduled sessions starting time and ending time. 
         - If there's an overlap, mark `canAttend` as false and break the loop.
     - If there are no conflicts (`canAttend` is true), add the session to the scheduled list and increment the count of attended sessions.

## 4. Output:
   - Print the scheduled sessions.
   - Print the total number of sessions that could be attended without any conflicts.
