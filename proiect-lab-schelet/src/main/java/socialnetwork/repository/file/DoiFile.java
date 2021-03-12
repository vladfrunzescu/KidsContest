package socialnetwork.repository.file;

import socialnetwork.domain.Doi;
import socialnetwork.domain.Unu;
import socialnetwork.domain.validators.Validator;
import socialnetwork.repository.Repository;
import socialnetwork.utils.Constants;
import socialnetwork.utils.My_Enum;

import java.time.LocalDateTime;
import java.util.List;

public class DoiFile extends AbstractFileRepository<Long, Doi> {
    private Repository<Long, Unu> repoUnu;
    public DoiFile(Repository<Long, Unu> repoUnu, String fileName, Validator<Doi> validator){
        super(fileName, validator);
        this.repoUnu = repoUnu;
    }

    @Override
    public Doi extractEntity(List<String> attributes) {
        Long unu_id = Long.parseLong(attributes.get(1));
        Unu obiect_unu = null;//repoUnu.findOne(unu_id);
        Long ID = Long.parseLong(attributes.get(0));
        My_Enum first_myenum = My_Enum.valueOf(attributes.get(2));
        My_Enum second_myenum = My_Enum.valueOf(attributes.get(3));
        String first_string = attributes.get(4);
        String second_string = attributes.get(5);
        Integer first_Integer = Integer.parseInt(attributes.get(6));
        Integer second_Integer = Integer.parseInt(attributes.get(7));
        int first_integer = Integer.parseInt(attributes.get(8));
        int second_integer = Integer.parseInt(attributes.get(9));
        Long first_Long = Long.parseLong(attributes.get(10));
        Long second_Long = Long.parseLong(attributes.get(11));
        long first_long = Long.parseLong(attributes.get(12));
        long second_long = Long.parseLong(attributes.get(13));
        Double first_Double = Double.parseDouble(attributes.get(14));
        Double second_Double = Double.parseDouble(attributes.get(15));
        double first_double = Double.parseDouble(attributes.get(16));
        double second_double = Double.parseDouble(attributes.get(17));
        LocalDateTime first_date = LocalDateTime.parse(attributes.get(18), Constants.DATE_TIME_FORMATTER);
        LocalDateTime second_date  = LocalDateTime.parse(attributes.get(19), Constants.DATE_TIME_FORMATTER);
        Doi entity = new Doi(first_myenum, second_myenum, ID, obiect_unu, unu_id, first_string, second_string, first_Integer, second_Integer, first_integer, second_integer, first_Long, second_Long, first_long, second_long, first_Double, second_Double, first_double, second_double, first_date, second_date);
        return entity;
    }

    @Override
    protected String createEntityAsString(Doi entity) {
        return entity.getId()+";"+entity.getUnu_id()+";"+entity.getFirst_myenum()+";"+entity.getSecond_myenum()+";"+entity.getFirst_string()+";"+entity.getSecond_string()+";"+entity.getFirst_Integer()+";"+entity.getSecond_Integer()+";"+entity.getFirst_integer()+";"+entity.getSecond_integer()+";"+entity.getFirst_Long()+";"+entity.getSecond_Long()+";"+entity.getFirst_long()+";"+entity.getSecond_long()+";"+entity.getFirst_Double()+";"+entity.getSecond_Double()+";"+entity.getFirst_double()+";"+entity.getSecond_double()+";"+entity.getFirst_date()+";"+entity.getSecond_date();
    }
}
