package com.driver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws ParseException {
        // Create and manage Email
        Email email = new Email("accio@gmail.com");
        email.changePassword("Accio@123", "V12@");
        email.changePassword("Acio@123", "V12@v");
        email.changePassword("Accio@123", "V12@v123");

        // Create and manage Gmail
        Gmail gmail = new Gmail("accio@gmail.com", 3);
        gmail.receiveMail(new SimpleDateFormat("dd/MM/yyyy").parse("21/12/2022"), "Tushar", "Assignment Completed?");
        gmail.receiveMail(new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2022"), "Tushar", "We are running out of time.");
        gmail.receiveMail(new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2022"), "Abhishek", "Assignment to be uploaded on database.");
        gmail.receiveMail(new SimpleDateFormat("dd/MM/yyyy").parse("23/12/2022"), "Tushar", "Everything looks good.");

        System.out.println("Total " + gmail.getInboxSize() + " mails in inbox.");
        System.out.println("There are " + gmail.findMailsBetweenDates(new SimpleDateFormat("dd/MM/yyyy").parse("21/12/2022"), new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2022")) + " mails between given dates!");
        gmail.deleteMail("Everything looks good.");
        System.out.println("The latest message is :" + gmail.findLatestMessage());
        gmail.deleteMail("Assignment to be uploaded on database.");
        System.out.println("There are " + gmail.getTrashSize() + " mails in the trash.");
        gmail.emptyTrash();
        System.out.println("There are " + gmail.getTrashSize() + " mails in the trash.");

        // Create and manage Workspace
        Workspace workspace = new Workspace("accio@gmail.com");
        System.out.println("Inbox capacity is " + workspace.getInboxCapacity() + " in workspace.");

        // Using nested Meeting class
        Workspace.Meeting meeting1 = workspace.new Meeting(LocalTime.parse("17:40"), LocalTime.parse("18:40"));
        Workspace.Meeting meeting2 = workspace.new Meeting(LocalTime.parse("13:30"), LocalTime.parse("18:00"));
        Workspace.Meeting meeting3 = workspace.new Meeting(LocalTime.parse("18:20"), LocalTime.parse("19:10"));
        Workspace.Meeting meeting4 = workspace.new Meeting(LocalTime.parse("19:50"), LocalTime.parse("21:05"));

        workspace.addMeeting(meeting1);
        workspace.addMeeting(meeting2);
        workspace.addMeeting(meeting3);
        workspace.addMeeting(meeting4);

        System.out.println("Maximum meetings you can attend in a day is " + workspace.findMaxMeetings());
    }
}
