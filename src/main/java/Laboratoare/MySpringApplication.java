package Laboratoare;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import Laboratoare.difexamples.ClientComponent;
import Laboratoare.difexamples.SingletonComponent;
import Laboratoare.difexamples.TransientComponent;

@SpringBootApplication
public class MySpringApplication {

    public static void main(String[] args) {

        // Bootstraps Spring + begins DI container
        ApplicationContext context =
                SpringApplication.run(MySpringApplication.class, args);

        TransientComponent transientBean =
                context.getBean(TransientComponent.class);
        transientBean.operation();

        // New instance each time
        transientBean =
                context.getBean(TransientComponent.class);
        transientBean.operation();

        SingletonComponent singletonBean =
                context.getBean(SingletonComponent.class);
        singletonBean.operation();

        // Same instance returned again
        singletonBean =
                context.getBean(SingletonComponent.class);
        singletonBean.operation();

        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();

        // Requesting by name
        c = (ClientComponent) context.getBean("clientComponent");
        c.operation();
    }
}
