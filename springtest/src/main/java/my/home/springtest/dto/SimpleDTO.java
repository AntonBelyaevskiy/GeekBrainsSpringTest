package my.home.springtest.dto;

import my.home.springtest.entity.User;

import java.util.Date;
import java.util.UUID;

public class SimpleDTO {

    private String label;
    private User user;
    private Date date;

    public SimpleDTO() {
        label = UUID.randomUUID().toString();
        user = new User("Test", "test@test.test");
        user.setId(777L);
        date = new Date();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
