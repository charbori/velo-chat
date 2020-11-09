package couhensoft.velochat.controller;

public class MemberForm {
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean getOpenProfile() {
        return openProfile;
    }
    public void setOpenProfile(boolean openProfile) {
        this.openProfile = openProfile;
    }
    public boolean getReceiveAlarm() {
        return receiveAlarm;
    }
    public void setReceiveAlarm(boolean receive_alarm) {
        this.receiveAlarm = receive_alarm;
    }
    private String name;
    private String email;
    private String password;
    private String phone;
    private boolean openProfile;
    private boolean receiveAlarm;



}
