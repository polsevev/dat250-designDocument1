package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_access",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "access_id"))
    private Collection<User> users;

    @ManyToOne
    private Poll poll;

    public Access() {
        users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public void setPoll(Poll poll){
        this.poll = poll;
    }

    public Collection<User> getUsers() {
        // TODO: implement method!
        return users;
    }

}
