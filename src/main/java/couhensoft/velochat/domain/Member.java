package couhensoft.velochat.domain;


import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name="MEMBER")
@AllArgsConstructor
@Getter @Setter
@Builder
public class Member {
    //@NonNull
    @Id
    private long mem_id;
    private final String mem_name;
    private final String mem_email;
    private final String mem_password;
    private String mem_grade;
    private String mem_point;
    private String mem_homepage;
    private String mem_phone;
    @Column(name="mem_receive_alarm", columnDefinition = "TINYINT", length=4)
    private int mem_receive_alarm;
    @Column(name="mem_open_profile", columnDefinition = "TINYINT", length=4)
    private int mem_open_profile;
    @Column(name="mem_receive_chat", columnDefinition = "TINYINT", length=4)
    private int mem_receive_chat;
    @Column(name="mem_email_cert", columnDefinition = "TINYINT", length=4)
    private int mem_email_cert;
    @Column(name="mem_register_ip", columnDefinition = "DATETIME")
    private String mem_register_ip;
    @Column(name="mem_register_datetime", columnDefinition = "DATETIME")
    private String mem_register_datetime;
    private String mem_lastlogin_ip;
    @Column(name="mem_lastlogin_datetime", columnDefinition = "DATETIME")
    private String mem_lastlogin_datetime;
    private String mem_adminmemo;
    private String mem_photo;
    private String mem_icon;
    private int mem_following;
    private int mem_followed;
    @Column(name="mem_denied", columnDefinition = "TINYINT", length=4)
    private int mem_denied;

    /*
    public Member(long mem_id, String mem_name, String mem_email, String mem_password) {
        Assert.hasText("0",String.valueOf(mem_id));
        Assert.hasText(null,String.valueOf(mem_name));
        Assert.hasText(null,String.valueOf(mem_email));
        Assert.hasText(null,String.valueOf(mem_password));

        this.mem_id = mem_id;
        this.mem_name = mem_name;
        this.mem_email = mem_email;
        this.mem_password = mem_password;
    }
    */
}

