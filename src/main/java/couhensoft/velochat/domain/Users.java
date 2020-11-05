package couhensoft.velochat.domain;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
