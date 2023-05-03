package io.datajek.databaserelationships.onetomany.bi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private PlayerProfile playerProfile;

    @OneToMany(mappedBy="player", cascade = CascadeType.ALL)
    private List<Registration> registrations = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player: " + name;
    }

    //set up bidirectional relationship with Registration class
    public void registerPlayer(Registration reg) {
        //add registration to the list
        registrations.add(reg);
        //set the player field in the registration
        reg.setPlayer(this);
    }
}
