package aptech.t2008m.hellospring.account;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String passwordHash;
//    @Column(name = "identity_card_number")
//    private String identityCardNumber;//fogeign key
    @OneToOne
    @JoinColumn(name = "identityCardNumber")
    private IdentityCard identityCard;
    private Integer status;

}
