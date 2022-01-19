package com.example.homeoheals;

public class User {
    String id;
    String username;
    String useremail;
    String userphone;
    String userdate;
    String usergender;
    String spinnername;

    public User(){

    }

    public User(String id, String username, String useremail, String userphone, String userdate, String spinnername) {
        this.id = id;
        this.username = username;
        this.useremail = useremail;
        this.userphone = userphone;
        this.userdate = userdate;
        this.spinnername= spinnername;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUserdate() {
        return userdate;
    }

    public void setUserdate(String userdate) {
        this.userdate = userdate;
    }

    public String getUsergender() {
        return usergender;
    }

    public void setUsergender(String usergender) {
        this.usergender = usergender;
    }

    public String getSpinnername() { return spinnername; }

    public void setSpinnername(String spinnername) { this.spinnername = spinnername; }
}
