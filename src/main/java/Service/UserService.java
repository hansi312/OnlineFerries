package Service;

import Dao.LoginDao;
import Entity.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Exception.NotException;


import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User getLogin(String username, String password) {
        Optional<User> u = userRepository.findCorrectUserName(username,password);
        if(u.isEmpty()) throw new NotException("Username or password incorrect");
        return u.get();
    }

    public User persistUser(User user) {
        Optional <User> u = userRepository.findUserByUsername(user.getUsername());
        if(u.isPresent()) throw new NotException("User already Exsits please Change Username");
        System.out.println(user);
        return userRepository.save(user);
    }

    public User getUserById(Integer userId) {
        Optional <User> u = userRepository.findById(userId);
        if(u.isEmpty()) throw new NotException("User with ID: "+userId+"not found");
        return u.get();
    }

    public User findUser(User user) {
        return userRepository.save(user);
    }
}
