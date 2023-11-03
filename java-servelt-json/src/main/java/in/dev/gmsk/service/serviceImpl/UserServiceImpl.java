package in.dev.gmsk.service.serviceImpl;

import in.dev.gmsk.model.User;
import in.dev.gmsk.service.UserService;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAllUserList() {
        return Arrays.asList(
                new User(20231124, "Gowtham Sankar", "Gunasekaran",
                        "gowtham@gmsk.in", "9876543210"),
                new User(20231127, "Karan", "Gunasekaran",
                        "karan@gmsk.in", "987654123"),
                new User(20231128, "Saran", "k",
                        "saran@gmsk.in", "987654123")
        );
    }
}
