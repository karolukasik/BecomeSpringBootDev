package io.datajek.databaserelationships.manytomany;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Tournament {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @NonNull
    private String name;
    @NonNull
    private String location;

    @OneToMany(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "tournament_id")
    private List<Registration> registrations = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "tournament_categories", joinColumns = @JoinColumn(name = "tournament_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonIgnoreProperties("tournaments")
    private List<Category> playingCategories = new ArrayList<>();

    public void addRegistration(Registration reg) {
        registrations.add(reg);
    }

    public void removeRegistration(Registration reg) {
        if (registrations != null) {
            registrations.remove(reg);
        }
    }

    public void addCategory(Category category) {
        playingCategories.add(category);
    }

	public void removeCategory(Category category) {
		if (playingCategories != null)
			playingCategories.remove(category);
	}
}
