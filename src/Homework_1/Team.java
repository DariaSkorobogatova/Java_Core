package Homework_1;

public class Team {
    private String teamName;
    Participant[] participants = new Participant[4];

    public Team(String teamName) {
        this.teamName = teamName;
        participants[0] = new Participant("Achilles", 5, 10);
        participants[1] = new Participant("Heracles", 7, 15);
        participants[2] = new Participant("Icarus", 5, 30);
        participants[3] = new Participant("Orpheus", 1, 11);
    }

    public void showInfo() {
        for (int i = 0; i < participants.length; i++) {
            System.out.println(participants[i].getParticipantName() + " could jump this high: " + participants[i].getMaxHeightJump() + " and run this far: " + participants[i].getMaxDistanceRun());
            }
        }

    public void result(Course course) {
        int n = 0;
        for (int i = 0; i < participants.length; i++) {
            int m = 0;
            for (int j = 0; j < course.obstacles.length; j++) {
                if (course.obstacles[j].getHeight() <= participants[i].getMaxHeightJump() && course.obstacles[j].getDistance() <= participants[i].getMaxDistanceRun()) {
                    m++;
                }
            }
            if (m == course.obstacles.length) {
                System.out.println(participants[i].getParticipantName() + " overcame the obstacle course");
                n++;
            }
        }
        if (n == 0) {
            System.out.println("All participants failed");
        }
    }

        public String getTeamName () {
            return teamName;
        }


}
