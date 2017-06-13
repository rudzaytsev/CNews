package cnews.services;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

  boolean isExist(String login, String password);
}
