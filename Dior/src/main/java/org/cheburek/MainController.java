package org.cheburek;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MainController
{

    private static final Logger log = Logger.getLogger(Triangle.class);

    public static void main(String[] args) {

        log.debug("Start of Main");
        SpringApplication.run(MainController.class, args);
        log.debug("End of Main");
    }
}
