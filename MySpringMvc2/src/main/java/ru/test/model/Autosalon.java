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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "autosalon")

public class Autosalon {
    private Long id;
    private String address;
    private Worker worker;
    private Set<Auto> autos = new HashSet<Auto>();

    public Autosalon() {
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(name = "autosalon_auto", joinColumns = { @JoinColumn(name = "autosalon_id") }, inverseJoinColumns = {
            @JoinColumn(name = "auto_id") })
    public Set<Auto> getAutos() {
        return autos;
    }

    public void setAutos(Set<Auto> autos) {
        this.autos = autos;
    }

    @ManyToOne
    @JoinColumn(name = "worker_id")
    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Autosalon that = (Autosalon) obj;
        if (!address.equals(that.address))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "[id=" + this.id + ", name=" + this.address + "]";
    }
}
