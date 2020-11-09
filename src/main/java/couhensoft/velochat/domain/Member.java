package couhensoft.velochat.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Member")
public class Member {
    public long getMem_id() {
        return mem_id;
    }

    public String getMem_name() {
        return mem_name;
    }

    public String getMem_email() {
        return mem_email;
    }

    public String getMem_password() {
        return mem_password;
    }

    public String getMem_grade() {
        return mem_grade;
    }

    public String getMem_point() {
        return mem_point;
    }

    public String getMem_homepage() {
        return mem_homepage;
    }

    public String getMem_phone() {
        return mem_phone;
    }

    public int getMem_receive_alarm() {
        return mem_receive_alarm;
    }

    public int getMem_open_profile() {
        return mem_open_profile;
    }

    public int getMem_receive_chat() {
        return mem_receive_chat;
    }

    public int getMem_email_cert() {
        return mem_email_cert;
    }

    public String getMem_register_ip() {
        return mem_register_ip;
    }

    public String getMem_register_datetime() {
        return mem_register_datetime;
    }

    public String getMem_lastlogin_ip() {
        return mem_lastlogin_ip;
    }

    public String getMem_lastlogin_datetime() {
        return mem_lastlogin_datetime;
    }

    public String getMem_adminmemo() {
        return mem_adminmemo;
    }

    public String getMem_photo() {
        return mem_photo;
    }

    public String getMem_icon() {
        return mem_icon;
    }

    public int getMem_following() {
        return mem_following;
    }

    public int getMem_followed() {
        return mem_followed;
    }

    public int getMem_denied() {
        return mem_denied;
    }

    public void setMem_id(long mem_id) {
        this.mem_id = mem_id;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public void setMem_email(String mem_email) {
        this.mem_email = mem_email;
    }

    public void setMem_password(String mem_password) {
        this.mem_password = mem_password;
    }

    public void setMem_grade(String mem_grade) {
        this.mem_grade = mem_grade;
    }

    public void setMem_point(String mem_point) {
        this.mem_point = mem_point;
    }

    public void setMem_homepage(String mem_homepage) {
        this.mem_homepage = mem_homepage;
    }

    public void setMem_phone(String mem_phone) {
        this.mem_phone = mem_phone;
    }

    public void setMem_receive_alarm(int mem_receive_alarm) {
        this.mem_receive_alarm = mem_receive_alarm;
    }

    public void setMem_open_profile(int mem_open_profile) {
        this.mem_open_profile = mem_open_profile;
    }

    public void setMem_receive_chat(int mem_receive_chat) {
        this.mem_receive_chat = mem_receive_chat;
    }

    public void setMem_email_cert(int mem_email_cert) {
        this.mem_email_cert = mem_email_cert;
    }

    public void setMem_register_ip(String mem_register_ip) {
        this.mem_register_ip = mem_register_ip;
    }

    public void setMem_register_datetime(String mem_register_datetime) {
        this.mem_register_datetime = mem_register_datetime;
    }

    public void setMem_lastlogin_ip(String mem_lastlogin_ip) {
        this.mem_lastlogin_ip = mem_lastlogin_ip;
    }

    public void setMem_lastlogin_datetime(String mem_lastlogin_datetime) {
        this.mem_lastlogin_datetime = mem_lastlogin_datetime;
    }

    public void setMem_adminmemo(String mem_adminmemo) {
        this.mem_adminmemo = mem_adminmemo;
    }

    public void setMem_photo(String mem_photo) {
        this.mem_photo = mem_photo;
    }

    public void setMem_icon(String mem_icon) {
        this.mem_icon = mem_icon;
    }

    public void setMem_following(int mem_following) {
        this.mem_following = mem_following;
    }

    public void setMem_followed(int mem_followed) {
        this.mem_followed = mem_followed;
    }

    public void setMem_denied(int mem_denied) {
        this.mem_denied = mem_denied;
    }

    //@NonNull
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long mem_id;
    private String mem_name;
    private String mem_email;
    private String mem_password;
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

    public Member(){

    }
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

