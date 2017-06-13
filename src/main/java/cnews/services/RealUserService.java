package cnews.services;


import cnews.datasource.UserRepository;
import cnews.modals.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealUserService implements UserService {

  @Autowired
  UserRepository repository;

  private final Logger logger = LoggerFactory.getLogger(RealUserService.class);

  @Override
  public boolean isExist(String login, String password) {
    User user = repository.findByLoginAndPassword(login, password);
    return  user != null;
  }
}
