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
    private Collection<EndUser> endUsers;

    @ManyToOne
    private Poll poll;

    public Access() {
        endUsers = new ArrayList<>();
    }

    public void addUser(EndUser endUser){
        endUsers.add(endUser);
    }

    public void setPoll(Poll poll){
        this.poll = poll;
    }

    public Collection<EndUser> getUsers() {
        // TODO: implement method!
        return endUsers;
    }

}
