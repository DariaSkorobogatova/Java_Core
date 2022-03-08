package Homework_1;

public class Course {
    Obstacle[] obstacles = new Obstacle [3];

    public Course() {
        obstacles[0] = new Obstacle (5, 10);
        obstacles[1] = new Obstacle (1, 11);
        obstacles[2] = new Obstacle (1, 12);
    }

    public void doIt(Team team) {
        System.out.println(team.getTeamName() + " is going to participate in the course");
    }
    }

