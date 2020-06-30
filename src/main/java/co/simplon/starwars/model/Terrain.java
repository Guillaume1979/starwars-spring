package co.simplon.starwars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "terrains")
public class Terrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "terrain_name", length = 127, nullable = false)
    private String name;

    //@JsonIgnore
    @ManyToMany(mappedBy = "planetTerrains")//il s'agit ici du nom de l'attribut (de type HashSet)
    private Set<Planet> planetSet = new HashSet<>();

    public Terrain() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public Set<Planet> getPlanetSet() {
        return planetSet;
    }

    public void setPlanetSet(Set<Planet> planetSet) {
        this.planetSet = planetSet;
    }*/
}
