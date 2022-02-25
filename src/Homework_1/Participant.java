package Homework_1;

public class Participant {
    private String participantName;
    private int maxHeightJump;
    private int maxDistanceRun;

    public Participant(String participantName, int maxHeightJump, int maxDistanceRun) {
        this.participantName = participantName;
        this.maxHeightJump = maxHeightJump;
        this.maxDistanceRun = maxDistanceRun;
    }

    public String getParticipantName() {
        return participantName;
    }

    public int getMaxHeightJump() {
        return maxHeightJump;
    }

    public int getMaxDistanceRun() {
        return maxDistanceRun;
    }
}
