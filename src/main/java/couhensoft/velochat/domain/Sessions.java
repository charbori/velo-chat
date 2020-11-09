package couhensoft.velochat.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Sessions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Sessions {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private String mem_grade;
    private String mem_point;
    private int mem_email_cert;
    private String ip_address;
    private long timestamp;
    private int mem_denied;
    @Column(name="data",columnDefinition = "BLOB")
    private String data;
}
