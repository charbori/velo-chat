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
    private String ip_address;
    private long timestamp;
    @Column(name="data",columnDefinition = "BLOB")
    private String data;
}
