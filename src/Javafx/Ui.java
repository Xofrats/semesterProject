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

public class Ui extends Application {
    Scene startscene, meterscene,validationscene, createmeterscene, editmeterscene;








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

//Startscene:

            Label startscenelbl = new Label("WELCOME ADMINISTRATOR");
            Button meteranddatabtn = new Button("Meters & Data");
            meteranddatabtn.setOnAction(event -> primaryStage.setScene(meterscene));
            Button validatebtn = new Button("Validation");
            validatebtn.setOnAction(event -> primaryStage.setScene(validationscene));
            VBox allmeterslayout = new VBox(20);
            allmeterslayout.getChildren().addAll(startscenelbl,meteranddatabtn,validatebtn);
            startscene =new Scene(allmeterslayout,500,500);

//Meters and data scene:

            Label meterscenelbl = new Label("METERS & DATA");
            Button return1 = new Button("Return to start");
            return1.setOnAction(event -> primaryStage.setScene(startscene));
            //buttons and labels for meters and data scene:
            // create meter button:
            Label addmeter=new Label("To create a new meter, push the button and fill out the form");
            grid.add(addmeter,0,4);

            Button createmeter =  new Button("Create Meter");
            grid.add(createmeter,0,7);

            createmeter.setOnAction(event -> primaryStage.setScene(createmeterscene));

//edit meter button:

            Label editmeterlbl = new Label("To dit meter, push the button and fill out the form");
            grid.add(editmeterlbl,2,1);
            Button editmeterbtn = new Button("Edit");
            grid.add(editmeterbtn,2,2);
            editmeterbtn.setOnAction(event -> primaryStage.setScene(editmeterscene));



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
            meterscenelayout.getChildren().addAll(meterscenelbl,return1,addmeter,createmeter,editmeterlbl,editmeterbtn,meterdatalbl,meterdatatext,meterdatabtn,allmeterslbl,allmetersbtn);
            meterscene=new Scene(meterscenelayout,650,800);

  // Create meter scene:

            Label createmeterscenelbl = new Label("CREATE METER");
            //Button return3 = new Button("Return to start");
            //return3.setOnAction(event -> primaryStage.setScene(meterscene));

  //Buttons inside createmeterscene:

            Label entermeternrlbl = new Label("Enter meternumber");
            TextField entermeternrtxt =new TextField("Meternr.");
            Label enterBBRlbl = new Label("Enter BBR Propertynumber");
            TextField enterBBrtxt = new TextField("Propertynumber");

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

            Button submitmeterbtn = new Button("Submit");
            Button cancelmeterbtn = new Button("Cancel and return to start");
            cancelmeterbtn.setOnAction(event -> primaryStage.setScene(meterscene));

            VBox createmeterscenelayout = new VBox(20);
            createmeterscenelayout.getChildren().addAll(entermeternrlbl,entermeternrtxt,enterBBRlbl,enterBBrtxt,activate,close,submitmeterbtn,cancelmeterbtn);
            createmeterscene =new Scene(createmeterscenelayout,500,500);





            Label validationscenelbl = new Label("VALIDATION");
            Button return2 = new Button("Return to start");
            return2.setOnAction(event -> primaryStage.setScene(startscene));

// validation buttons inside validationscene:

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


 //Edit meter scene:

            Label editmeterscenelbl = new Label("EDIT METER");
            Label entermeternrlbl1 = new Label("Enter meternumber here");
            TextField entermeternrtxt1 =new TextField("Meternr.");
            Label enterBBRlbl1 = new Label("Enter BBR Propertynumber");
            TextField enterBBrtxt1 = new TextField("Propertynumber");

            RadioButton activate1 = new RadioButton("Activate");
            activate.setSelected(true);
            activate.setUserData("Activate");
            RadioButton close1 = new RadioButton("Close");
            close.setUserData("Close");


            final ToggleGroup group1 = new ToggleGroup();
            group1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                @Override
                public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                    if (group1.getSelectedToggle() != null){
                        String radioSelected = group1.getSelectedToggle().getUserData().toString();

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

            Button submitmeterbtn1 = new Button("Submit");
            Button cancelmeterbtn1 = new Button("Cancel and return to start");
            cancelmeterbtn1.setOnAction(event -> primaryStage.setScene(meterscene));

            VBox editmeterscenelayout = new VBox(20);
            editmeterscenelayout.getChildren().addAll(entermeternrlbl1,entermeternrtxt1,enterBBRlbl1,enterBBrtxt1,activate1,close1,submitmeterbtn1,cancelmeterbtn1);
            editmeterscene =new Scene(editmeterscenelayout,500,500);

































            primaryStage.setScene(startscene);
            primaryStage.show();

//the end

        }
}
