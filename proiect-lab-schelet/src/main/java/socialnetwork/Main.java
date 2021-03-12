package socialnetwork;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import socialnetwork.controller.MainController;
import socialnetwork.domain.Concurs;
import socialnetwork.domain.Doi;
import socialnetwork.domain.Participant;
import socialnetwork.domain.Unu;
import socialnetwork.domain.validators.ConcursValidator;
import socialnetwork.domain.validators.DoiValidator;
import socialnetwork.domain.validators.ParticipantValidator;
import socialnetwork.domain.validators.UnuValidator;
import socialnetwork.repository.Repository;
import socialnetwork.repository.file.ConcursFile;
import socialnetwork.repository.file.DoiFile;
import socialnetwork.repository.file.ParticipantFile;
import socialnetwork.repository.file.UnuFile;
import socialnetwork.service.Service;
import socialnetwork.utils.Proba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends Application {

    private static List<String> argumente = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Repository<Proba, Concurs> concursRepo = new ConcursFile("data/concurs.txt", new ConcursValidator());
        Repository<Long, Participant> participantRepo = new ParticipantFile("data/participanti.txt", new ParticipantValidator(concursRepo));
        Service service = new Service(concursRepo, participantRepo);

        for (String s : argumente) {
            List<String> attr = Arrays.asList(s.split(":"));
            Stage stage = new Stage();
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/views/mainView.fxml"));
                AnchorPane root = loader.load();
                MainController controller = loader.getController();
                service.addObserver(controller);
                controller.setPage(service, s);
                stage.setTitle("Contest Page");
                stage.setScene(new Scene(root, 632, 405));
                stage.show();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        for(String s:args){
            argumente.add(s);
        }

        launch(args);
    }
}



