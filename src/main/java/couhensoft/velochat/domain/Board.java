package couhensoft.velochat.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Board")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long brd_id;
    private long bgr_id;
    private String brd_key;
    private String brd_name;
    private String brd_mobile_name;
    private int brd_order;
    private String brd_search;
}
