package Homework_1;

public class Competition {

    public static void main(String[] args) {
        Team team = new Team ("Greek heroes");
        team.showInfo();
        System.out.println("*************");
        Course course = new Course();
        course.doIt(team);
        System.out.println("*************");
        team.result(course);
    }
}
