package plusplus.OldBookSeller.services;

import org.springframework.stereotype.Service;
import plusplus.OldBookSeller.reponsitory.UserRepository;
import plusplus.OldBookSeller.reponsitory.entity.User;

@Service
public class UserService {
    UserRepository userRepository;
    public String login(String email,String password)
    {
        if(userRepository.existsByEmailAndPassword(email,password))
            return "Login successfull";
        else
            return "Wrong email or password"
    }
    public String register(String email,String password,String phonenumber,String token)
    {
        if(userRepository.existsByEmail(email))
            return "Email has already existed";
        
        User user = new User(email,password,phonenumber);

    }

}
