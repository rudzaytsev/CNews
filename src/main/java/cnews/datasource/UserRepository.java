package cnews.datasource;

import cnews.modals.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {

   public User findByLoginAndPassword(String login, String password);
}
