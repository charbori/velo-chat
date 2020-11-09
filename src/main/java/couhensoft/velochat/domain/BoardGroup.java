package couhensoft.velochat.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="BoardGroup")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BoardGroup {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long bgr_id;
    private String bgr_key;
    private String bgr_name;
    private int bgr_order;
}
