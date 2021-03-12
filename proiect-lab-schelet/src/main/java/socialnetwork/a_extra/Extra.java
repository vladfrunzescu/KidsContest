package socialnetwork.a_extra;

public class Extra {
}


/*
Pentru cautare:

@FXML
public void handleTextFieldSearch() {
    ObservableList<PrietenDTO> observableList = FXCollections.observableArrayList(usersPage.getService().getUtilizatorService().getAllFriends_forUser(usersPage.getConnected_user().getId()));
    FilteredList<PrietenDTO> filteredList = new FilteredList<PrietenDTO>(observableList, b -> true);
    textFieldSearch.textProperty().addListener(((observable, oldValue, newValue) -> {
        filteredList.setPredicate(prietenDTO -> {
            //daca textField-ul este gol, afisam toate
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();
            if (prietenDTO.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }
            else if (prietenDTO.getLastName().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }
            else if (prietenDTO.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }
            else {
                return false;
            }
        });
    }));
    SortedList<PrietenDTO> sortedList = new SortedList<>(filteredList);
    sortedList.comparatorProperty().bind(tableView.comparatorProperty());
    tableView.setItems(sortedList);
}


Interfata TEMPLATE cu un singur parametru:

OBSERVABLE
package socialnetwork.utils.observer;
import socialnetwork.utils.events.Event;
public interface Observable<E extends Event> {
    void addObserver(Observer<E> e);
    void removeObserver(Observer<E> e);
    void notifyObservers(E t);
}


OBSERVER
package socialnetwork.utils.observer;
import socialnetwork.utils.events.Event;
public interface Observer<E extends Event> {
    void update(E e);
}

SETARE BUTON IN TABEL
Callback<TableColumn<PrietenDTO,PrietenDTO>, TableCell<PrietenDTO,PrietenDTO>> cellFactory_unfriend = new Callback<TableColumn<PrietenDTO,PrietenDTO>, TableCell<PrietenDTO,PrietenDTO>>() {
    @Override
    public TableCell<PrietenDTO,PrietenDTO> call(TableColumn<PrietenDTO,PrietenDTO> param) {
        return new TableCell<PrietenDTO,PrietenDTO>() {
            final Button unfriendButton = new Button("Sterge");
            {
                unfriendButton.setOnAction(event -> {
                    PrietenDTO selectedItem = tableView.getSelectionModel().getSelectedItem();
                    deleteFriendship(selectedItem);
                });
                unfriendButton.setStyle("-fx-background-color: #581845;-fx-border-width: 0;-fx-text-alignment: center;-fx-text-fill: #fcf7f7;-fx-font-family: 'Times New Roman';-fx-cursor: 'OPEN_HAND';");
                ImageView imageView = new ImageView();
                Image image = new Image("/images/delete-icon.png");
                imageView.setImage(image);
                imageView.setFitHeight(18);
                imageView.setFitWidth(18);
                unfriendButton.setGraphic(imageView);
            }
            @Override
            protected void updateItem(PrietenDTO item, boolean empty) {
                super.updateItem(item, empty);
                this.setAlignment(Pos.CENTER);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(unfriendButton);
                }
            }
        };
    }
};



STERGERE OBIECT SELECTAT DIN TABEL
public void deleteFriendship(PrietenDTO selected) {
    if (selected != null) {
        try {
            String nume_prieten = selected.getFirstName() + " " + selected.getLastName();
            Prietenie deleted = usersPage.getService().getPrietenieService().deleteFriendship(new Tuple<>(usersPage.getConnected_user().getId(), selected.getUser().getId()));
            if (deleted != null) {
                MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Stergere", "Prietenia dintre tine si " + nume_prieten + " a fost stearsa cu succes!");
            }
        }
        catch (Exception ex) {
            MessageAlert.showErrorMessage(null, ex.getMessage());
        }
    }
    else {
        MessageAlert.showErrorMessage(null, "Nu a fost selectat niciun camp!");
    }
}


SELECTARE OBIECT TABEL
tableView.getSelectionModel().getSelectedItem();


SELECTARE OBIECT LISTVIEW
listViewMembers.getSelectionModel().getSelectedItem()


COMBOBOX
@FXML
private ComboBox<String> comboBoxType = new ComboBox<String>();
@FXML
private ComboBox<Utilizator> comboBoxUsers = new ComboBox<Utilizator>();


COMBOBOX INTIALIZAT DIN STARRT
@FXML
private void initialize() {
    List<String> options = new ArrayList<>();
    options.add("public");
    options.add("private");
    ObservableList<String> observableTypeList = FXCollections.observableArrayList(options);
    comboBoxType.setItems(observableTypeList);
}


COMBOBOX CU OBIECTE INTIALIZATE ULTERIOR
private void initVisualObjects() {
    List<Utilizator> all_users = StreamSupport
            .stream(usersPage.getService().getUtilizatorService().getAllUsers().spliterator(), false)
            .collect(Collectors.toList());
    ObservableList<Utilizator> observableUserList = FXCollections.observableArrayList(all_users);
    comboBoxUsers.setItems(observableUserList);
    comboBoxUsers.setCellFactory(new Callback<ListView<Utilizator>, ListCell<Utilizator>>() {
        @Override
        public ListCell<Utilizator> call(ListView<Utilizator> param) {
            return new ListCell<Utilizator>() {
                @Override
                protected void updateItem(Utilizator item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText("Email: " + item.getEmail() + "; Nume: " + item.getFirstName() + "; Prenume: " + item.getLastName());
                    }
                }
            };
        }
    });
    comboBoxUsers.setConverter(new StringConverter<Utilizator>() {
        @Override
        public String toString(Utilizator user) {
            if (user == null) {
                return null;
            }
            else {
                return "Email: " + user.getEmail() + "; Nume: " + user.getFirstName() + "; Prenume: " + user.getLastName();
            }
        }
        @Override
        public Utilizator fromString(String string) {
            return null;
        }
    });
    listViewUsers.setCellFactory(lv -> new ListCell<Utilizator>() {
        @Override
        public void updateItem(Utilizator user, boolean empty) {
            super.updateItem(user, empty) ;
            setText(empty ? null : "Email: " + user.getEmail() + "; Nume: " + user.getFirstName() + "; Prenume: " + user.getLastName());
        }
    });
}




DATE PICKER
@FXML
private DatePicker datePickerStart;
@FXML
private DatePicker datePickerEnd;

LocalDateTime start_date = datePickerStart.getValue().atTime(00, 00, 00);
LocalDateTime final_date = datePickerEnd.getValue().atTime(00, 00, 00);


BUTTONS ADD SI DELETE USERS
@FXML
public void handleAddUser() {
    Utilizator selected_user = comboBoxUsers.getSelectionModel().getSelectedItem();
    if (selected_user != null) {
        listViewUsers.getItems().add(selected_user);
    }
    else {
        MessageAlert.showErrorMessage(null, "Nu a fost selectat niciun camp din comboBox!");
    }
}
@FXML
public void handleDeleteUser() {
    Utilizator selected_user = listViewUsers.getSelectionModel().getSelectedItem();
    if (selected_user != null) {
        listViewUsers.getItems().remove(selected_user);
    }
    else {
        MessageAlert.showErrorMessage(null, "Nu a fost selectat niciun camp din listView!");
    }
}


CREEAZA UN EVENT FOLOSIND UN SET
@FXML
public void handleCreateEvent() {
    try {
        String nume = textFieldName.getText();
        String descriere = textAreaDescription.getText();
        String tip = comboBoxType.getSelectionModel().getSelectedItem();
        LocalDateTime start_date = datePickerStart.getValue().atTime(00, 00, 00);
        LocalDateTime final_date = datePickerEnd.getValue().atTime(00, 00, 00);
        Set<Long> participants = new HashSet<>();
        for (Utilizator user : listViewUsers.getItems()) {
            participants.add(user.getId());
        }
        usersPage.getService().getEvenimentService().addNewEvent(nume, descriere, tip, start_date, final_date, participants);
        MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eveniment", "Evenimentul a fost creat cu succes!");
        dialogStage.close();
    }
    catch (Exception ex) {
        MessageAlert.showErrorMessage(null, ex.getMessage());
    }
}


 */