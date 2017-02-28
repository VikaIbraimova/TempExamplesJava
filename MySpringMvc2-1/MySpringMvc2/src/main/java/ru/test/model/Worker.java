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
    private String fio;
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

    @Column(name = "fio")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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
        if (!fio.equals(that.fio))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Worker{" + "id=" + id + ", fio='" + fio + '\'' + '}';
    }
}
