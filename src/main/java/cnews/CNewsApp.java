package cnews;


import cnews.controllers.NewsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EntityScan
@ComponentScan
public class CNewsApp {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(CNewsApp.class, args);
  }
}
