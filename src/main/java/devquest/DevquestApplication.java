// src\main\java\devquest\DevquestApplication.java

package devquest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevquestApplication {

    public static void main(final String[] args) {
        System.out.println("hello, devQuest!");
        SpringApplication.run(DevquestApplication.class, args);
    } // End of main method

}
