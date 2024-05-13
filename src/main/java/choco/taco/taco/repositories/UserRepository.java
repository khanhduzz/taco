package choco.taco.taco.repositories;

import choco.taco.taco.configs.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername (String username);

}
