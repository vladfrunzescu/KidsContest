package socialnetwork.domain;

import socialnetwork.utils.Proba;

import java.util.List;
import java.util.Objects;

public class Participant extends Entity<Long>{
    private String nume;
    private Integer varsta;
    private List<Proba> probe;

    public Participant(String nume, Integer varsta, List<Proba> probe) {
        this.setId(generateRandomId());
        this.nume = nume;
        this.varsta = varsta;
        this.probe = probe;
    }

    public Participant(Long id, String nume, Integer varsta, List<Proba> probe) {
        this.setId(id);
        this.nume = nume;
        this.varsta = varsta;
        this.probe = probe;
    }

    private Long generateRandomId() {
        long leftLimit = 1L;
        long rightLimit = 1000000000L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public List<Proba> getProbe() {
        return probe;
    }

    public void setProbe(List<Proba> probe) {
        this.probe = probe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(nume, that.nume) &&
                Objects.equals(varsta, that.varsta) &&
                Objects.equals(probe, that.probe) &&
                Objects.equals(that.getId(), this.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), nume, varsta, probe);
    }
}
