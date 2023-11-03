package in.dev.gmsk.model;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String mobileNo;
}
