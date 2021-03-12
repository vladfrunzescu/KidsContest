package socialnetwork.domain.validators;

import socialnetwork.domain.Doi;
import socialnetwork.domain.Unu;
import socialnetwork.repository.Repository;

public class DoiValidator implements Validator<Doi> {
    private Repository<Long, Unu> repoUnu;
    public DoiValidator(Repository<Long, Unu> repoUnu){
        this.repoUnu = repoUnu;
    }

    @Override
    public void validate(Doi entity) throws ValidationException {
        String errors = "";

        if(entity.getId() == null || entity.getId() < 0){
            errors += "Id invalid!\n";
        }

        if(entity.getUnu_id() == null || entity.getUnu_id() < 0){
            errors += "Id unu invalid!";
        }

        if(repoUnu.findOne(entity.getUnu_id()) == null){
            errors += "Nu exista ID-ul pentru unu!";
        }

        if(entity.getFirst_string() == null || entity.getFirst_string().equals("")){
            errors += "Primul string invalid!\n";
        }

        if(entity.getSecond_string() == null || entity.getSecond_string().equals("")){
            errors += "Al doilea string invalid!\n";
        }

        if(entity.getFirst_Integer() == null || entity.getFirst_Integer() < 0){
            errors += "Primul Integer invalid!\n";
        }

        if(entity.getSecond_Integer() == null || entity.getSecond_Integer() < 0){
            errors += "Al doilea Integer invalid!\n";
        }

        if(entity.getFirst_integer() < 0){
            errors += "Primul integer invalid!\n";
        }

        if(entity.getSecond_integer() < 0){
            errors += "Al doilea integer invalid!\n";
        }

        if(entity.getFirst_Long() == null || entity.getFirst_Long() < 0){
            errors += "Primul Long invalid!\n";
        }

        if(entity.getSecond_Long() == null || entity.getSecond_Long() < 0){
            errors += "Al doilea Long invalid!\n";
        }

        if(entity.getFirst_long() < 0){
            errors += "Primul long invalid!\n";
        }

        if(entity.getSecond_long() < 0){
            errors += "Al doilea long invalid!\n";
        }

        if(entity.getFirst_Double() == null || entity.getFirst_Double() < 0){
            errors += "Primul Double invalid!\n";
        }

        if(entity.getSecond_Double() == null || entity.getSecond_Double() < 0){
            errors += "Al doilea Double invalid!\n";
        }

        if(entity.getFirst_double() < 0){
            errors += "Primul double invalid!\n";
        }

        if(entity.getSecond_double() < 0){
            errors += "Al doilea double invalid!\n";
        }

        if(entity.getFirst_date().getYear() > 1800){
            errors += "Prima data invalida!\n";
        }

        if(entity.getSecond_date().getYear() > 1800){
            errors += "A doua data invalida!\n";
        }

        if(errors.equals("")){
            throw new ValidationException(errors);
        }
    }
}
