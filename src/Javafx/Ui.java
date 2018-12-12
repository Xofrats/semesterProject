package Javafx;

import Model.Meter.Meter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Ui extends Application {








        public static void notmain (String args[]){

//Beginning of javafx:
            launch(args);
        }

        public Ui(){
        }
        public void start(Stage primaryStage){
            primaryStage.setTitle("Energistyring");
            GridPane grid=new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);


            Text scenetitle=new Text("WELCOME ADMINISTRATOR");
            scenetitle.setId("energistyring");
            grid.add(scenetitle,0,0,2,1);
            grid.setAlignment(Pos.TOP_CENTER);

// javafx to create meter:
            Label addmeter=new Label("To create a new meter, fill out the form below");
            grid.add(addmeter,0,4);
            Label bbrpropertynumber=new Label("Please enter the BBR propertynumber in the box:");
            grid.add(bbrpropertynumber,0,5);
            TextField propertynumber = new TextField("Enter propertynumber");
            grid.add(propertynumber,0,6);

            Button createmeter =  new Button("Create Meter");
            HBox hcreatemeter = new HBox(20);
            grid.add(createmeter,0,7);


            createmeter.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    Alert metercreated=new Alert(Alert.AlertType.INFORMATION);
                    metercreated.setHeaderText(null);
                    metercreated.setContentText("Meter was created");

                    metercreated.showAndWait();


                }
            });

            Label closeactivatemeter=new Label("To close or activate a meter,");
            grid.add(closeactivatemeter,0,10);
            Label closeactivatemeter2= new Label(" enter the number of the meter and then press the button below");
            grid.add(closeactivatemeter2,0,11);
            TextField entermeternumber = new TextField("Enter meternr.");
            grid.add(entermeternumber,0,12);
            Button closeactivatemeterbutton=new Button("Activate/Close");
            HBox hcloseactivatebutton=new HBox(20);
            grid.add(closeactivatemeterbutton,0,13);

            closeactivatemeterbutton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    Alert error1 = new Alert(Alert.AlertType.ERROR);
                    error1.setTitle("Error");
                    error1.setHeaderText(null);
                    error1.setContentText("Please only enter numbers!");

                    error1.showAndWait();

                    int entermeternumber1 = Integer.parseInt(entermeternumber.getText());

                    Alert closeactivatemeter = new Alert(Alert.AlertType.CONFIRMATION);
                    closeactivatemeter.setHeaderText(null);
                    closeactivatemeter.setContentText("Choose to activate or close meter number "+entermeternumber.getText());

                    ButtonType activate = new ButtonType("Activate meter");
                    ButtonType close = new ButtonType("Close meter");
                    ButtonType cancel = new ButtonType("Cancel");

                    closeactivatemeter.getButtonTypes().setAll(activate, close, cancel);

                    Optional<ButtonType> result = closeactivatemeter.showAndWait();
                    if (result.get() == activate) {
                    } else if (result.get() == close) {
                    } else  {
                    }

                }


            });














            Scene scene=new Scene (grid);
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(750);
            primaryStage.setMinHeight(800);
            primaryStage.setResizable(true);





            primaryStage.show();



        }
}
