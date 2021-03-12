package socialnetwork.domain;

import socialnetwork.utils.My_Enum;

import java.time.LocalDateTime;
import java.util.Objects;

public class DoiDTO {
    private My_Enum first_myenum;
    private My_Enum second_myenum;
    private Long ID;
    private Unu obiect_unu;
    private String first_string;
    private String second_string;
    private Integer first_Integer;
    private Integer second_Integer;
    private int first_integer;
    private int second_integer;
    private Long first_Long;
    private Long second_Long;
    private long first_long;
    private long second_long;
    private Double first_Double;
    private Double second_Double;
    private double first_double;
    private double second_double;
    private LocalDateTime first_date;
    private LocalDateTime second_date;

    public DoiDTO(My_Enum first_myenum, My_Enum second_myenum, Long ID, Unu obiect_unu, String first_string, String second_string, Integer first_Integer, Integer second_Integer, int first_integer, int second_integer, Long first_Long, Long second_Long, long first_long, long second_long, Double first_Double, Double second_Double, double first_double, double second_double, LocalDateTime first_date, LocalDateTime second_date) {
        this.first_myenum = first_myenum;
        this.second_myenum = second_myenum;
        this.ID = ID;
        this.obiect_unu = obiect_unu;
        this.first_string = first_string;
        this.second_string = second_string;
        this.first_Integer = first_Integer;
        this.second_Integer = second_Integer;
        this.first_integer = first_integer;
        this.second_integer = second_integer;
        this.first_Long = first_Long;
        this.second_Long = second_Long;
        this.first_long = first_long;
        this.second_long = second_long;
        this.first_Double = first_Double;
        this.second_Double = second_Double;
        this.first_double = first_double;
        this.second_double = second_double;
        this.first_date = first_date;
        this.second_date = second_date;
    }

    public My_Enum getFirst_myenum() {
        return first_myenum;
    }

    public void setFirst_myenum(My_Enum first_myenum) {
        this.first_myenum = first_myenum;
    }

    public My_Enum getSecond_myenum() {
        return second_myenum;
    }

    public void setSecond_myenum(My_Enum second_myenum) {
        this.second_myenum = second_myenum;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Unu getObiect_unu() {
        return obiect_unu;
    }

    public void setObiect_unu(Unu obiect_unu) {
        this.obiect_unu = obiect_unu;
    }

    public Long getUnu_id() {
        return ID;
    }

    public String getFirst_string() {
        return first_string;
    }

    public void setFirst_string(String first_string) {
        this.first_string = first_string;
    }

    public String getSecond_string() {
        return second_string;
    }

    public void setSecond_string(String second_string) {
        this.second_string = second_string;
    }

    public Integer getFirst_Integer() {
        return first_Integer;
    }

    public void setFirst_Integer(Integer first_Integer) {
        this.first_Integer = first_Integer;
    }

    public Integer getSecond_Integer() {
        return second_Integer;
    }

    public void setSecond_Integer(Integer second_Integer) {
        this.second_Integer = second_Integer;
    }

    public int getFirst_integer() {
        return first_integer;
    }

    public void setFirst_integer(int first_integer) {
        this.first_integer = first_integer;
    }

    public int getSecond_integer() {
        return second_integer;
    }

    public void setSecond_integer(int second_integer) {
        this.second_integer = second_integer;
    }

    public Long getFirst_Long() {
        return first_Long;
    }

    public void setFirst_Long(Long first_Long) {
        this.first_Long = first_Long;
    }

    public Long getSecond_Long() {
        return second_Long;
    }

    public void setSecond_Long(Long second_Long) {
        this.second_Long = second_Long;
    }

    public long getFirst_long() {
        return first_long;
    }

    public void setFirst_long(long first_long) {
        this.first_long = first_long;
    }

    public long getSecond_long() {
        return second_long;
    }

    public void setSecond_long(long second_long) {
        this.second_long = second_long;
    }

    public Double getFirst_Double() {
        return first_Double;
    }

    public void setFirst_Double(Double first_Double) {
        this.first_Double = first_Double;
    }

    public Double getSecond_Double() {
        return second_Double;
    }

    public void setSecond_Double(Double second_Double) {
        this.second_Double = second_Double;
    }

    public double getFirst_double() {
        return first_double;
    }

    public void setFirst_double(double first_double) {
        this.first_double = first_double;
    }

    public double getSecond_double() {
        return second_double;
    }

    public void setSecond_double(double second_double) {
        this.second_double = second_double;
    }

    public LocalDateTime getFirst_date() {
        return first_date;
    }

    public void setFirst_date(LocalDateTime first_date) {
        this.first_date = first_date;
    }

    public LocalDateTime getSecond_date() {
        return second_date;
    }

    public void setSecond_date(LocalDateTime second_date) {
        this.second_date = second_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoiDTO doiDTO = (DoiDTO) o;
        return getFirst_integer() == doiDTO.getFirst_integer() &&
                getSecond_integer() == doiDTO.getSecond_integer() &&
                getFirst_long() == doiDTO.getFirst_long() &&
                getSecond_long() == doiDTO.getSecond_long() &&
                Double.compare(doiDTO.getFirst_double(), getFirst_double()) == 0 &&
                Double.compare(doiDTO.getSecond_double(), getSecond_double()) == 0 &&
                getFirst_myenum() == doiDTO.getFirst_myenum() &&
                getSecond_myenum() == doiDTO.getSecond_myenum() &&
                Objects.equals(getID(), doiDTO.getID()) &&
                Objects.equals(getObiect_unu(), doiDTO.getObiect_unu()) &&
                Objects.equals(getFirst_string(), doiDTO.getFirst_string()) &&
                Objects.equals(getSecond_string(), doiDTO.getSecond_string()) &&
                Objects.equals(getFirst_Integer(), doiDTO.getFirst_Integer()) &&
                Objects.equals(getSecond_Integer(), doiDTO.getSecond_Integer()) &&
                Objects.equals(getFirst_Long(), doiDTO.getFirst_Long()) &&
                Objects.equals(getSecond_Long(), doiDTO.getSecond_Long()) &&
                Objects.equals(getFirst_Double(), doiDTO.getFirst_Double()) &&
                Objects.equals(getSecond_Double(), doiDTO.getSecond_Double()) &&
                Objects.equals(getFirst_date(), doiDTO.getFirst_date()) &&
                Objects.equals(getSecond_date(), doiDTO.getSecond_date());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst_myenum(), getSecond_myenum(), getID(), getObiect_unu(), getFirst_string(), getSecond_string(), getFirst_Integer(), getSecond_Integer(), getFirst_integer(), getSecond_integer(), getFirst_Long(), getSecond_Long(), getFirst_long(), getSecond_long(), getFirst_Double(), getSecond_Double(), getFirst_double(), getSecond_double(), getFirst_date(), getSecond_date());
    }
}
