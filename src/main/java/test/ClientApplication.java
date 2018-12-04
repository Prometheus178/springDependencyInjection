package test;

import configuration.DIconfiguration;
import consumer.MyApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(DIconfiguration.class);
        MyApplication application = configApplicationContext.getBean(MyApplication.class);
        application.processMessage("hello", "sirius@mail.com");
        configApplicationContext.close();

    }

}
