package socialnetwork.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import socialnetwork.domain.Concurs;
import socialnetwork.domain.DoiDTO;
import socialnetwork.domain.Participant;
import socialnetwork.domain.Unu;
import socialnetwork.service.Service;
import socialnetwork.utils.Proba;
import socialnetwork.utils.observer.Observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class MainController implements Observer {

    private Service service;

    private ObservableList<Concurs> concursModel = FXCollections.observableArrayList();
    private ObservableList<Participant> participantModel = FXCollections.observableArrayList();

    @FXML
    private TableView<Participant> tableView;
    @FXML
    private TableColumn<Participant,String> tableColumnNume;
    @FXML
    private TableColumn<Participant,String> tableColumnVarsta;

    @FXML
    private TextField textFieldNume;
    @FXML
    private TextField textFieldVarsta;
    @FXML
    private TextField textFieldProbe;

    @FXML
    private Label labelNume;

    @FXML
    private ListView<Concurs> listView;

    @Override
    public void update() {
        this.initModel();
    }

    public void setPage( Service service, String s) {
        this.service = service;
        labelNume.setText(s);
        service.addObserver(this);
        initModel();
    }

    @FXML
    public void initialize() {

        tableColumnNume.setCellValueFactory(new PropertyValueFactory<Participant, String>("Nume"));
        tableColumnVarsta.setCellValueFactory(new PropertyValueFactory<Participant, String>("Varsta"));

        // se leaga modelul de tabel
        tableView.setItems(participantModel);
    }

    private void initModel() {

        listView.setCellFactory(lv -> new ListCell<Concurs>() {
            @Override
            public void updateItem(Concurs entity, boolean empty) {
                super.updateItem(entity, empty) ;
                setText(empty ? null : "Proba: " + entity.getId() + "    Numar Participanti: " + entity.getParticipanti().toString());
            }
        });

        concursModel = FXCollections.observableArrayList(service.getAllConcurs());
        listView.setItems(concursModel);
    }

    @FXML
    public void handleCautaButton(){

        Concurs concurs = listView.getSelectionModel().getSelectedItem();
        if(concurs != null){
            List<Participant> participanti = service.getAllParticipantiConcurs(concurs);
            participantModel.setAll(participanti);
        }else{
            MessageAlert.showErrorMessage(null, "Selectati o proba!");
        }
    }

    @FXML
    public void handleInscrieButton(){
        try {
            if(textFieldNume.getText() != null && textFieldVarsta.getText() != null && textFieldProbe.getText() != null) {
                List<String> attr = Arrays.asList(textFieldProbe.getText().split(","));
                if (attr.size() > 2) {
                    MessageAlert.showErrorMessage(null, "Participantul se poate inscrie la cel mult doua probe!");
                } else {
                    List<Proba> probe = new ArrayList<>();
                    for (String a : attr) {
                        probe.add(Proba.valueOf(a));
                    }
                    Participant p = new Participant(textFieldNume.getText(), Integer.parseInt(textFieldVarsta.getText()), probe);
                    service.addParticipant(p);
                    MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Participant adaugat!", "Succes!");
                }
            }
        }catch(Exception e){
            MessageAlert.showErrorMessage(null, e.getMessage());
        }
    }

    /*
    @FXML
    public void handleTrimiteButton() {
        try {
            String text_message = textField.getText();
            List<Long> all_entities = new ArrayList<>();
            for(Unu e : service.getAllUnu()){
                if(!e.equals(unu)){
                    all_entities.add(e.getId());
                }
            }

            //service.addEntity();
            //MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Mesaj", "Mesajul a fost trimis cu succes!");
            textField.setText("");
        }
        catch (Exception ex) {
            MessageAlert.showErrorMessage(null, ex.getMessage());
        }
    }

    @FXML
    public void handleRetragButton(){
        try{
            //if(service.action() == null){
                MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "", "!");
            //}
        } catch(Exception ex){
                MessageAlert.showErrorMessage(null, ex.getMessage());
        }
    }

    @FXML
    public void handleRevinButton(){
        try{
            //if(service.action() == null){
                MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "", "!");
            //}
        } catch(Exception ex){
            MessageAlert.showErrorMessage(null, ex.getMessage());
        }
    }

     */
}
