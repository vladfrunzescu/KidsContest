package socialnetwork.repository.file;

import socialnetwork.domain.Participant;
import socialnetwork.domain.validators.Validator;
import socialnetwork.utils.Constants;
import socialnetwork.utils.My_Enum;
import socialnetwork.utils.Proba;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticipantFile extends AbstractFileRepository<Long, Participant> {
    public ParticipantFile(String fileName, Validator<Participant> validator) {
        super(fileName, validator);
    }

    @Override
    public Participant extractEntity(List<String> attributes) {
        Long ID = Long.parseLong(attributes.get(0));
        String first_string = attributes.get(1);
        Integer first_Integer = Integer.parseInt(attributes.get(2));

        List<String> attr = Arrays.asList(attributes.get(3).split(","));
        List<Proba> probe = new ArrayList<>();

        for(String a : attr){
            probe.add(Proba.valueOf(a));
        }

        Participant entity = new Participant(ID, first_string, first_Integer, probe);
        return entity;
    }

    @Override
    protected String createEntityAsString(Participant entity) {

        String probe = "";
        for(Proba p : entity.getProbe()){
            probe += p.toString() + ",";
        }

        String newProbe = probe.substring(0, probe.length()-1);
        return entity.getId()+";"+entity.getNume()+";"+entity.getVarsta()+";"+newProbe;
    }
}
