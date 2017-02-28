package ru.test.model;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "autos")
@NamedQueries({
        @NamedQuery(name = "Auto.findAll", query = "select p from Auto p"),
        @NamedQuery(name = "Auto.findById", query = "select distinct p from Auto p where p.id = :id")
})
public class Auto {
    private Long id;
    private String name;
    private Set<Autosalon> autosalons = new HashSet<Autosalon>();

    public Auto() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "autosalon_auto",
            joinColumns={@JoinColumn(name = "auto_id")},
            inverseJoinColumns={@JoinColumn(name = "autosalon_id")})
    public Set<Autosalon> getAutosalons() {
        return autosalons;
    }

    public void setAutosalons(Set<Autosalon> autosalons) {
        this.autosalons = autosalons;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Auto that = (Auto) obj;
        if (!name.equals(that.name)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + "]";
    }
}