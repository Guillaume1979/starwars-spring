package co.simplon.starwars.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "planets")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "planet_generator", sequenceName = "planet_id_seq", allocationSize= 1)
    private int id;
    @Column(name = "planet_name", length = 127, nullable = false)
    private String name;
    @Column(name = "rotation_period")
    private Integer rotationPeriod;
    @Column(name = "orbital_period")
    private Integer orbitalPeriod;
    @Column(name = "diameter")
    private Integer diameter;
    @Column(name = "gravity")
    private BigDecimal gravity;
    @Column(name = "surface_water")
    private Long surfaceWater;
    @Column(name = "population")
    private Long population;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "planet_climates",
            joinColumns = @JoinColumn(name = "planet_idx"),
            inverseJoinColumns = @JoinColumn(name = "climate_idx"))
    private Set<Climate> planetClimates = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "planet_terrains",
            joinColumns = @JoinColumn(name = "planet_idx"),
            inverseJoinColumns = @JoinColumn(name = "terrain_idx"))
    private Set<Terrain> planetTerrains = new HashSet<>();

    //dans la classe Climate et la classe Terrain
  /*@JsonIgnore
  @ManyToMany (mappedBy = "planetClimates")//il s'agit ici du nom de l'attribut
    private Set<Planet> planetSet = new HashSet<>();*/


    public Planet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(Integer rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public Integer getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(Integer orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public BigDecimal getGravity() {
        return gravity;
    }

    public void setGravity(BigDecimal gravity) {
        this.gravity = gravity;
    }

    public Long getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(Long surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Set<Climate> getPlanetClimates() {
        return planetClimates;
    }

    public void setPlanetClimates(Set<Climate> planetClimates) {
        this.planetClimates = planetClimates;
    }

    public Set<Terrain> getPlanetTerrains() {
        return planetTerrains;
    }

    public void setPlanetTerrains(Set<Terrain> planetTerrains) {
        this.planetTerrains = planetTerrains;
    }
}
