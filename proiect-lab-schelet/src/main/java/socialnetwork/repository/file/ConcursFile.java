package socialnetwork.repository.file;

import socialnetwork.domain.Concurs;
import socialnetwork.domain.validators.Validator;
import socialnetwork.utils.Constants;
import socialnetwork.utils.My_Enum;
import socialnetwork.utils.Proba;

import java.time.LocalDateTime;
import java.util.List;

public class ConcursFile extends AbstractFileRepository<Proba, Concurs> {
    public ConcursFile(String fileName, Validator<Concurs> validator) {
        super(fileName, validator);
    }

    @Override
    public Concurs extractEntity(List<String> attributes) {
        Proba proba= Proba.valueOf(attributes.get(0));
        Integer first_Integer = Integer.parseInt(attributes.get(1));
        Concurs entity = new Concurs(proba, first_Integer);
        return entity;
    }

    @Override
    protected String createEntityAsString(Concurs entity) {
        return entity.getId()+";"+entity.getParticipanti();
    }
}
