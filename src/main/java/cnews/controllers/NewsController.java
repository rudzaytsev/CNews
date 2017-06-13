package cnews.controllers;


import cnews.modals.User;
import cnews.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewsController {

  @Autowired
  UserService userService;

  private final Logger logger = LoggerFactory.getLogger(NewsController.class);

  @RequestMapping(value = "/")
  public String home() {
    logger.info("Welcome to main page!!!");
    return "main";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(@RequestParam String login, @RequestParam String password, Model model) {
    logger.info("Log in method invoked!!!");
    if (userService.isExist(login, password)){
      model.addAttribute("user", new User(login, password));
    }
    return "main";
  }


}