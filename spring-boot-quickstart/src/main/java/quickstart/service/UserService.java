package quickstart.service;

import org.springframework.stereotype.Service;
import quickstart.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
private final List<User> users=List.of(
        new User(1l,"zhansan",22),
        new User(2l,"hansan",20),
        new User(3l,"zhnsan",19),
        new User(4l,"zhanan",18)
);
public List<String> getAdultUserNames(){
    return users.stream().filter(user -> user.getAge()>18).map(User::getName).collect(Collectors.toList());
}
}
