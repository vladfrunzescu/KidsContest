package socialnetwork.repository.file;

import socialnetwork.domain.Unu;
import socialnetwork.domain.validators.Validator;
import socialnetwork.utils.Constants;
import socialnetwork.utils.My_Enum;

import java.time.LocalDateTime;
import java.util.List;

public class UnuFile extends AbstractFileRepository<Long, Unu> {
    public UnuFile(String fileName, Validator<Unu> validator) {
        super(fileName, validator);
    }

    @Override
    public Unu extractEntity(List<String> attributes) {
        Long ID = Long.parseLong(attributes.get(0));
        My_Enum first_myenum = My_Enum.valueOf(attributes.get(1));
        My_Enum second_myenum = My_Enum.valueOf(attributes.get(2));
        String first_string = attributes.get(3);
        String second_string = attributes.get(4);
        Integer first_Integer = Integer.parseInt(attributes.get(5));
        Integer second_Integer = Integer.parseInt(attributes.get(6));
        int first_integer = Integer.parseInt(attributes.get(7));
        int second_integer = Integer.parseInt(attributes.get(8));
        Long first_Long = Long.parseLong(attributes.get(9));
        Long second_Long = Long.parseLong(attributes.get(10));
        long first_long = Long.parseLong(attributes.get(11));
        long second_long = Long.parseLong(attributes.get(12));
        Double first_Double = Double.parseDouble(attributes.get(13));
        Double second_Double = Double.parseDouble(attributes.get(14));
        double first_double = Double.parseDouble(attributes.get(15));
        double second_double = Double.parseDouble(attributes.get(16));
        LocalDateTime first_date = LocalDateTime.parse(attributes.get(17), Constants.DATE_TIME_FORMATTER);
        LocalDateTime second_date  = LocalDateTime.parse(attributes.get(18), Constants.DATE_TIME_FORMATTER);
        Unu entity = new Unu(first_myenum, second_myenum, ID, first_string, second_string, first_Integer, second_Integer, first_integer, second_integer, first_Long, second_Long, first_long, second_long, first_Double, second_Double, first_double, second_double, first_date, second_date);
        return entity;
    }

    @Override
    protected String createEntityAsString(Unu entity) {
        return entity.getId()+";"+entity.getFirst_myenum()+";"+entity.getSecond_myenum()+";"+entity.getFirst_string()+";"+entity.getSecond_string()+";"+entity.getFirst_Integer()+";"+entity.getSecond_Integer()+";"+entity.getFirst_integer()+";"+entity.getSecond_integer()+";"+entity.getFirst_Long()+";"+entity.getSecond_Long()+";"+entity.getFirst_long()+";"+entity.getSecond_long()+";"+entity.getFirst_Double()+";"+entity.getSecond_Double()+";"+entity.getFirst_double()+";"+entity.getSecond_double()+";"+entity.getFirst_date()+";"+entity.getSecond_date();
    }
}
