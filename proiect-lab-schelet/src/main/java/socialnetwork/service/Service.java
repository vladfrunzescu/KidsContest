package socialnetwork.service;

import socialnetwork.domain.*;
import socialnetwork.repository.Repository;
import socialnetwork.utils.Proba;
import socialnetwork.utils.observer.Observable;
import socialnetwork.utils.observer.Observer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Service implements Observable {
    private Repository<Proba, Concurs> concursRepo;
    private Repository<Long, Participant> participantRepo;

    public Service(Repository<Proba, Concurs> concursRepo, Repository<Long, Participant> participantRepo) {
        this.participantRepo = participantRepo;
        this.concursRepo = concursRepo;
    }

    @Override
    public void addObserver(Observer e){
        observers.add(e);
    }
    @Override
    public void removeObserver(Observer e){
        observers.remove(e);
    }
    @Override
    public void notifyObservers(){
        observers.stream().forEach(x->x.update());
    }

    public List<Concurs> getAllConcurs() {
        List<Concurs> list = new ArrayList<Concurs>();
        concursRepo.findAll().forEach(list::add);
        return list;
    }

    public List<Participant> getAllParticipantiConcurs(Concurs concurs) {
        List<Participant> list = new ArrayList<>();
        for(Participant p : getAllParticipanti()){
            if(p.getProbe().contains(concurs.getId())){
                list.add(p);
            }
        }
        return list;
    }

    public List<Participant> getAllParticipanti(){
        List<Participant> list = new ArrayList<Participant>();
        participantRepo.findAll().forEach(list::add);
        return list;
    }

    public void addParticipant(Participant p) {
        Participant participant = participantRepo.save(p);
        if(participant == null){
            actualizeazaConcurs(p.getProbe());
            notifyObservers();
        }
    }

    public void actualizeazaConcurs(List<Proba> probe){
        for(Proba p : probe){
            Concurs c = concursRepo.findOne(p);
            c.setParticipanti(c.getParticipanti() + 1);
            updateConcurs(c);
        }
    }

    public void updateConcurs(Concurs newC){
        if(concursRepo.update(newC) == null){
            notifyObservers();
        }

    }
    /*
    //exp: hotels by location
    //     doi       unu
    public List<Doi> doiByUnu(Long ID){
        List<Doi> list = new ArrayList<>();
        for(Doi e : this.getAllDoi()){
            if(e.getUnu_id().equals(ID))
                list.add(e);
        }
        return list;
    }

    public List<Unu> getAllUnu(){
        List<Unu> list = new ArrayList<Unu>();
        unuRepo.findAll().forEach(list::add);
        return list;
    }

    public List<Doi> getAllDoi(){
        List<Doi> list = new ArrayList<Doi>();
        doiRepo.findAll().forEach(list::add);
        return list;
    }

    //exp: hotels by location
    //     doi       unu
    public List<Doi> doiByUnuDates(Long ID, LocalDateTime start, LocalDateTime end){
        List<Doi> list = new ArrayList<>();
        for(Doi e : this.getAllDoi()){
            if(e.getUnu_id().equals(ID) && e.getFirst_date().isAfter(start) && e.getSecond_date().isBefore(end))
                list.add(e);
        }
        return list;
    }

    public List<DoiDTO> personalizate(Unu entity){
        List<DoiDTO> list = new ArrayList<>();
        for(Doi e : this.getAllDoi()){
            if(true){//e.getFirst_date().isAfter(LocalDateTime.now()) && e.getUnu_id().equals(entity.getId())){
                Unu entitate = unuRepo.findOne(e.getUnu_id());
                DoiDTO dto = new DoiDTO(e.getFirst_myenum(), e.getSecond_myenum(), e.getId(), entitate, e.getFirst_string(), e.getSecond_string(), e.getFirst_Integer(), e.getSecond_Integer(), e.getFirst_integer(), e.getSecond_integer(), e.getFirst_Long(), e.getSecond_Long(), e.getFirst_long(), e.getSecond_long(), e.getFirst_Double(), e.getSecond_Double(), e.getFirst_double(), e.getSecond_double(), e.getFirst_date(), e.getSecond_date());
                list.add(dto);
            }
        }
        return list;
    }
    
     */
    
}