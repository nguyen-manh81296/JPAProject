package aptech.t2008m.hellospring.account;

import lombok.*;
import org.springframework.core.SpringVersion;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "identity_cards")
public class IdentityCard {
    @Id
    private String number;
    private String fullName;
    private Integer gender;//0,1,2
    private Date birthday;
    private String address;
    private String description;
    private String createBy;
    private String createAt;
    private Date updateAt;
    private Integer status;
    @OneToOne(mappedBy = "identityCard")
    private Account account;

}
