package Repository;

import Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsernameIsAndPasswordIs(String username, String password);

    Optional<User> findUserByUsername(String username);

    @Query("select user from User user where user.username =?1 and user.password =?2")
    Optional<User> findCorrectUserName(String username, String password);
}
