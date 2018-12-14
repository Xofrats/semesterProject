package Javafx;

import Model.Meter.Meter;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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
import javafx.util.Pair;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import Model.Modelhandler;

public class Ui extends Application {
    public static ButtonType submitchanges = null;
    Scene startscene, meterscene,validationscene;








        public static void main (String args[]){

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

            Label startscenelbl = new Label("WELCOME ADMINISTRATOR");
            Button meteranddatabtn = new Button("Meters & Data");
            meteranddatabtn.setOnAction(event -> primaryStage.setScene(meterscene));
            Button validatebtn = new Button("Validation");
            validatebtn.setOnAction(event -> primaryStage.setScene(validationscene));
            VBox allmeterslayout = new VBox(20);
            allmeterslayout.getChildren().addAll(startscenelbl,meteranddatabtn,validatebtn);
            startscene =new Scene(allmeterslayout,500,500);


            Label meterscenelbl = new Label("METERS & DATA");
            Button return1 = new Button("Return to start");
            return1.setOnAction(event -> primaryStage.setScene(startscene));
            //buttons and labels for meters and data scene:
            // create meter button:
            Label addmeter=new Label("To create a new meter, fill out the form below");
            grid.add(addmeter,0,4);
            Label bbrpropertynumber=new Label("Please enter the BBR propertynumber in the box:");
            grid.add(bbrpropertynumber,0,5);
            TextField propertynumber = new TextField("Enter propertynumber");
            grid.add(propertynumber,0,6);

            Button createmeter =  new Button("Create Meter");
            grid.add(createmeter,0,7);






            createmeter.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    Dialog<Pair<String,String>> createMeterDialog = new Dialog<>();
                    createMeterDialog.setTitle("Create meter");
                    submitchanges = new ButtonType("Submit", ButtonBar.ButtonData.OK_DONE);
                    createMeterDialog.getDialogPane().getButtonTypes().addAll(submitchanges,ButtonType.CANCEL);

                    GridPane createMetergridpane = new GridPane();
                    createMetergridpane.setHgap(10);
                    createMetergridpane.setVgap(10);
                    createMetergridpane.setPadding(new Insets(20,150,20,20));

                    TextField createmeternumber =new TextField();
                    createmeternumber.setPromptText("Meter number");
                    TextField createBbr = new TextField();
                    createBbr.setPromptText("Propertynumber");

                    createMetergridpane.add(new Label("Enter meter number:"),0,0);
                    createMetergridpane.add(createmeternumber,1,0);
                    createMetergridpane.add(new Label("Enter BBR propertynumber:"),0,1);
                    createMetergridpane.add(createBbr,1,1);


                    //need to make the radiobuttons work somehow

                    RadioButton activate = new RadioButton("Activate");
                    activate.setSelected(true);
                    activate.setUserData("Activate");
                    RadioButton close = new RadioButton("Close");
                    close.setUserData("Close");


                    final ToggleGroup group = new ToggleGroup();
                    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                        @Override
                        public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                            if (group.getSelectedToggle() != null){
                                String radioSelected = group.getSelectedToggle().getUserData().toString();

                                if (radioSelected == "Activate"){
                                    System.out.println("it worked");
                                    //Modelhandler.createMeter(Integer.parseInt(createmeternumber.getText()), 1, Modelhandler.getBbr(Integer.parseInt(createBbr.getText())));
                                }

                                if (radioSelected == "Close"){
                                    //Modelhandler.createMeter(Integer.parseInt(createmeternumber.getText()), 0, Modelhandler.getBbr(Integer.parseInt(createBbr.getText())));
                                }



                            }
                        }
                    });
                    close.setToggleGroup(group);
                    activate.setToggleGroup(group);
                    createMetergridpane.add(activate,0,2);
                    createMetergridpane.add(close,1,2);

                    createMeterDialog.getDialogPane().setContent(createMetergridpane);

                    Optional<Pair<String,String>> result = createMeterDialog.showAndWait();









                }



            });

//edit meter button:

            Label editmeterlbl = new Label("Edit meter");
            grid.add(editmeterlbl,2,1);
            Button editmeterbtn = new Button("Edit");
            grid.add(editmeterbtn,2,2);

            editmeterbtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    Dialog<Pair<String,String>> editmeterdialog = new Dialog<>();
                    editmeterdialog.setTitle("Edit meter");
                    ButtonType submitchanges = new ButtonType("Submit", ButtonBar.ButtonData.OK_DONE);
                    editmeterdialog.getDialogPane().getButtonTypes().addAll(submitchanges,ButtonType.CANCEL);

                    GridPane editmetergridpane = new GridPane();
                    editmetergridpane.setHgap(10);
                    editmetergridpane.setVgap(10);
                    editmetergridpane.setPadding(new Insets(20,150,20,20));

                    TextField editmeternumber =new TextField();
                    editmeternumber.setPromptText("Meter number");
                    TextField editBbr = new TextField();
                    editBbr.setPromptText("Propertynumber");

                    editmetergridpane.add(new Label("Enter meter number:"),0,0);
                    editmetergridpane.add(editmeternumber,1,0);
                    editmetergridpane.add(new Label("Enter BBR propertynumber:"),0,1);
                    editmetergridpane.add(editBbr,1,1);
                    //need to make the radiobuttons work somehow
                    editmetergridpane.add(new RadioButton("Activate"),0,2);
                    editmetergridpane.add(new RadioButton("Close"),1,2);

                    editmeterdialog.getDialogPane().setContent(editmetergridpane);

                    Optional<Pair<String,String>> result = editmeterdialog.showAndWait();

                }
            });

//Close or activate meters:

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

                    int entermeternumber1 = Integer.parseInt(entermeternumber.getText());



                    //Alert error1 = new Alert(Alert.AlertType.ERROR);
                    //error1.setTitle("Error");
                    //error1.setHeaderText(null);
                    //error1.setContentText("Please only enter numbers!");

                    //error1.showAndWait();



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

//show meter data for a given meter:

            Label meterdatalbl = new Label("Show data for meter nr: ");
            grid.add(meterdatalbl,3,5);
            TextField meterdatatext = new TextField("meter nr:");
            grid.add(meterdatatext,3,6);
            Button meterdatabtn = new Button("Show data");
            grid.add(meterdatabtn,3,7);

            meterdatabtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                }
            });

            // showing all meters in an array table:

            Label allmeterslbl = new Label("Show all meters");
            grid.add(allmeterslbl,3,10);
            Button allmetersbtn = new Button("Show");
            grid.add(allmetersbtn,3,11);

            allmetersbtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                }
            });

            VBox meterscenelayout =new VBox(20);
            meterscenelayout.getChildren().addAll(meterscenelbl,return1,addmeter,bbrpropertynumber,propertynumber,createmeter,editmeterlbl,editmeterbtn,closeactivatemeter,closeactivatemeter2,entermeternumber,closeactivatemeterbutton,meterdatalbl,meterdatatext,meterdatabtn,allmeterslbl,allmetersbtn);
            meterscene=new Scene(meterscenelayout,650,800);

            Label validationscenelbl = new Label("VALIDATION");
            Button return2 = new Button("Return to start");
            return2.setOnAction(event -> primaryStage.setScene(startscene));
// validation buttons inside window 3:

            //check if meter activated or closed with the meters number:
            Label activeclosedvallbl = new Label("Meter active or closed?");
            grid.add(activeclosedvallbl, 1, 4);
            TextField activeclosedvaltext = new TextField("Input meternr.");
            grid.add(activeclosedvaltext,1,5);
            Button activeclosedvalbtn =new Button("Check");
            grid.add(activeclosedvalbtn,1,6);

            activeclosedvalbtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    int activeclosedvaltext1 = Integer.parseInt(activeclosedvaltext.getText());

//how to make an if else statement here?

                    if (activeclosedvaltext.equals(activeclosedvaltext1)){

                        Alert activeclosedvalalert =new Alert(Alert.AlertType.INFORMATION);
                        activeclosedvalalert.setHeaderText(null);
                        activeclosedvalalert.setContentText("The meter is "); //insert code for active or closed meters

                        activeclosedvalalert.showAndWait();

                    }
                    else {
                        Alert error2 = new Alert(Alert.AlertType.ERROR);
                        error2.setTitle("Error");
                        error2.setHeaderText(null);
                        error2.setContentText("Please only enter numbers, thank you!");

                        error2.showAndWait();
                    }


                }
            });

            //missing or wrong values:

            Label checkvalueslbl =new Label("Check for missing or wrong values");
            grid.add(checkvalueslbl,0,15);
            Button checkvaluesbtn =new Button("Check");
            grid.add(checkvaluesbtn,0,16);

            checkvaluesbtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                }
            });
            VBox validationscenelayout = new VBox(20);
            validationscenelayout.getChildren().addAll(validationscenelbl, return2,activeclosedvallbl,activeclosedvaltext,activeclosedvalbtn,checkvalueslbl,checkvaluesbtn);
            validationscene = new Scene(validationscenelayout,500,500);






























            primaryStage.setScene(startscene);
            primaryStage.show();



        }
}
