package services;

import services.MessageService;

public class TwitterService implements MessageService {
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Twitter sent to " + rec + " with message " + msg);
        return true;
    }
}
