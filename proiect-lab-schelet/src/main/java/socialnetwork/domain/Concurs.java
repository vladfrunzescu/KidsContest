package socialnetwork.domain;

import socialnetwork.utils.My_Enum;
import socialnetwork.utils.Proba;

import java.time.LocalDateTime;
import java.util.Objects;

public class Concurs extends Entity<Proba> {

    private Integer participanti;

    public Concurs(Proba id, Integer participanti) {
        this.setId(id);
        this.participanti = participanti;
    }

    public Integer getParticipanti() {
        return participanti;
    }

    public void setParticipanti(Integer participanti) {
        this.participanti = participanti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concurs concurs = (Concurs) o;
        return Objects.equals(participanti, concurs.participanti) &&
                Objects.equals(concurs.getId(), this.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), participanti);
    }
}
