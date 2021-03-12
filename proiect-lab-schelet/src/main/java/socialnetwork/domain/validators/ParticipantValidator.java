package socialnetwork.domain.validators;

import socialnetwork.domain.Concurs;
import socialnetwork.domain.Participant;
import socialnetwork.domain.Unu;
import socialnetwork.repository.Repository;
import socialnetwork.utils.Proba;

public class ParticipantValidator implements Validator<Participant> {

    private Repository<Proba, Concurs> repoConcurs;

    public ParticipantValidator(Repository<Proba, Concurs> repoConcurs) {
        this.repoConcurs = repoConcurs;
    }

    @Override
    public void validate(Participant entity) throws ValidationException {
        String errors = "";

        if(entity.getId() == null || entity.getId() < 0){
            errors += "Id invalid!\n";
        }

        if(entity.getNume() == null || entity.getNume().equals("")){
            errors += "Nume invalid!\n";
        }

        if(entity.getVarsta() == null || entity.getVarsta() < 0){
            errors += "Primul Integer invalid!\n";
        }

        if(entity.getProbe().size() == 0){
            errors += "Participantul trebuie sa participe la cel putin o proba!\n";
        }

        for(Proba p : entity.getProbe()){
            if(repoConcurs.findOne(p) == null){
                errors += "Nu exista o astfel de proba la concurs!\n";
            }
        }

        if(!errors.equals("")){
            throw new ValidationException(errors);
        }
    }
}
