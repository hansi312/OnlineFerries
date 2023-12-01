package Dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(force = true)
@Getter
@Setter
public class LoginDao {
    private final String username;
    private final String pasword;

    public LoginDao(String username, String pasword) {
        this.username = username;
        this.pasword = pasword;
    }
}
