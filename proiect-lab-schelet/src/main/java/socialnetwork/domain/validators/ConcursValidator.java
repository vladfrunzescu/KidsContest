package socialnetwork.domain.validators;

import socialnetwork.domain.Concurs;
import socialnetwork.domain.Concurs;
import socialnetwork.utils.Proba;

public class ConcursValidator implements Validator<Concurs> {

    @Override
    public void validate(Concurs entity) throws ValidationException {
        String errors = "";

        if (entity.getId() == null) {
            errors += "Id invalid!\n";
        }

        if (entity.getParticipanti() == null || entity.getParticipanti() < 0) {
            errors += "Numar participanti invalid!\n";
        }

        if(!errors.equals("")){
            throw new ValidationException(errors);
        }
    }
}
