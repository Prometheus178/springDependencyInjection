import consumer.MyApplication;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import services.MessageService;

@Configuration
@ComponentScan(value = "consumer")
public class MyApplicationTest {
    private AnnotationConfigApplicationContext configApplicationContext = null;
    @Bean
    public MessageService getMessageService(){
        return new MessageService() {
            public boolean sendMessage(String msg, String rec) {
                System.out.println("MockService");
                return true;
            }
        };
    }

    @Before

    public void setUp() throws Exception{
        configApplicationContext = new AnnotationConfigApplicationContext(MyApplicationTest.class);

    }

    @After

    public void tearDown() throws Exception {
        configApplicationContext.close();
    }

    @Test
    public void test() {
        MyApplication application = configApplicationContext.getBean(MyApplication.class);
        Assert.assertTrue(application.processMessage("hello", "sirius@mail.com"));

    }
}
