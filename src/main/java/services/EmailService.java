package services;

public class EmailService implements MessageService {
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Email sent to " + rec +" with message " + msg);
        return true;
    }
}
