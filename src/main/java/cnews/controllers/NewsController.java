package cnews.controllers;


import cnews.modals.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class NewsController {

  private final Logger logger = LoggerFactory.getLogger(NewsController.class);

  @RequestMapping(value = "/")
  public String home() {
    logger.info("Welcome to main page!!!");
    return "main";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(@RequestParam String login, @RequestParam String password, Model model) {
    logger.info("Log in method invoked!!!");
    model.addAttribute("user",new User("winni", "123"));
    return "main";
  }



  public static void main(String[] args) throws Exception {
    SpringApplication.run(NewsController.class, args);
  }
}