package game.controller;

import game.model.ModelCheck;
import game.view.ComputerWindow;

public class ControllerCheck implements ControllerDisplay {

    private ModelCheck modelCheck;


    public ControllerCheck(ModelCheck modelCheck) {

        this.modelCheck = modelCheck;
        displayMessage();

    }


    @Override
    public void displayMessage() {
        // System.out.println("Hellooo");
        modelCheck.displayMessage();

    }

}
