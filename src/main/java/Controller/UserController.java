package Controller;

import Dao.LoginDao;
import Entity.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/OnlineFerries/login")
    public ResponseEntity<User>  getLogin(@RequestBody LoginDao loginDao){
        try{
            User user = userService.getLogin(loginDao.getUsername(), loginDao.getPasword());
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        catch(Exception  e){
            HttpHeaders h1 = new HttpHeaders();
            h1.set("msg",e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(h1).body(null);
        }
    }
    @PostMapping("/OnlineFerries/register")
    public ResponseEntity<User> getRegister(@RequestBody User user){
        User u = userService.persistUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }
    @GetMapping("/OnlineFerries/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Integer userId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userId));
        }
        catch(Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.set("msg",e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(null);
        }
    }
    @PutMapping("/OnlineFerries/user")
    public ResponseEntity <User> changeUser(@RequestBody User user){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.findUser(user));
        }
        catch (Exception e){
            HttpHeaders h1 = new HttpHeaders();
            h1.set("msg", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(h1).body(null);
        }
    }
}
