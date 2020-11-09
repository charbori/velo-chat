package couhensoft.velochat.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long post_id;
    private long post_num;
    private String post_reply;
    private long brd_id;
    private String post_title;
    private String post_content;
    private String post_category;
    private long mem_id;
    private String post_userid;
    private String post_username;
    private String post_nickname;
    private String post_email;
    private String post_symbol;
    private String post_homepage;
    @Column(name="post_datetime", columnDefinition = "DATETIME")
    private String post_datetime;
    private String post_password;
    @Column(name="post_updated_datetime", columnDefinition = "DATETIME")
    private String post_updated_datetime;
    private long post_update_mem_id;
    private int post_comment_count;
    @Column(name="post_comment_updated_datetime", columnDefinition = "DATETIME")
    private String post_comment_updated_datetime;
    private int post_link_count;
    @Column(name="post_secret", columnDefinition = "TINYINT", length=4)
    private int post_secret;
    @Column(name="post_notice", columnDefinition = "TINYINT", length=4)
    private int post_notice;
    private int post_hit;
    private int post_like;
    private int post_dislike;
    //private int ppo_id;
    private String post_ip;
    private int post_blame_count;
    @Column(name="post_file_count", columnDefinition = "TINYINT", length=4)
    private int post_file_count;
    @Column(name="post_image_count", columnDefinition = "TINYINT", length=4)
    private int post_image_count;
    @Column(name="post_del", columnDefinition = "TINYINT", length=4)
    private int post_del;
    private String post_device;
}
