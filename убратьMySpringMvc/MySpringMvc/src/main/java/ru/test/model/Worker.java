package ru.test.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "worker")
public class Worker {
    private Long id;
    private String address;
    private Set<Autosalon> autosalons = new HashSet<Autosalon>();

    public Worker() {
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

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "worker")
    public Set<Autosalon> getAutosalons() {
        return autosalons;
    }

    public void setAutosalons(Set<Autosalon> autosalons) {
        this.autosalons = autosalons;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Worker that = (Worker) obj;
        if (!address.equals(that.address))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[id=" + this.id + ", address=" + this.address + "]";
    }
}