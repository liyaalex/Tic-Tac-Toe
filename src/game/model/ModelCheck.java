package game.model;

import game.controller.ControllerCheck;
import game.controller.ControllerDisplay;
import game.view.ComputerWindow;
import game.view.TicTacToeUserWindow;

import javax.swing.*;

public class ModelCheck implements ModelDisplay, UserCheckController {
    private TicTacToeUserWindow window;
    private ComputerWindow computerWindow;
    private ControllerCheck controllerCheck;
    //private ControllerDisplay controllerDisplay;

    public ModelCheck(TicTacToeUserWindow window, ComputerWindow computerWindow) {
//        System.out.println("haiii");

        this.window = window;
        this.computerWindow = computerWindow;
        UserCheck(window);


    }


    @Override
    public void UserCheck(TicTacToeUserWindow window) {
        this.window = window;
        //displayMessage();
        controllerCheck = new ControllerCheck(this);


    }


    public void checkWinCondition() {


        if (chechkDiagonal(0, 1, 2, "X") ||
                checkHorizontal(0, 1, 2, "X") ||
                checkVertical(0, 1, 2, "X"))
        {
            JOptionPane.showMessageDialog(window, "YOU win!!!", "MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
            resetButtons();

            //window.setEnabled(false);
            //window.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        } else if (chechkDiagonal(0, 1, 2, "O") ||
                checkHorizontal(0, 1, 2, "O") ||
                checkVertical(0, 1, 2, "O"))
        {
            JOptionPane.showMessageDialog(window, "Computer win!!!", "MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
            resetButtons();
            // window.setEnabled(false);
        }


    }


    public void resetButtons() {
        for (int rowPosition = 0; rowPosition < 3; rowPosition++)
        {
            for (int columnPosition = 0; columnPosition < 3; columnPosition++)
            {
                window.buttons[rowPosition][columnPosition].setText("");
            }
        }
    }


    public boolean chechkDiagonal(int number1, int number2, int number3, String stringLetter) {
        if (window.buttons[number1][number1].getText().equals(stringLetter) && window.buttons[number2][number2].getText().equals(stringLetter) && window.buttons[number3][number3].getText().equals(stringLetter) ||
                window.buttons[number1][number3].getText().equals(stringLetter) && window.buttons[number2][number2].getText().equals(stringLetter) && window.buttons[number3][number1].getText().equals(stringLetter)) {
            return true;
        }

        return false;
    }


    public boolean checkHorizontal(int number1, int number2, int number3, String stringLetter) {
        if (window.buttons[number1][number1].getText().equals(stringLetter) && window.buttons[number1][number2].getText().equals(stringLetter) && window.buttons[number1][number3].getText().equals(stringLetter) ||
                window.buttons[number2][number1].getText().equals(stringLetter) && window.buttons[number2][number2].getText().equals(stringLetter) && window.buttons[number2][number3].getText().equals(stringLetter) ||
                window.buttons[number3][number1].getText().equals(stringLetter) && window.buttons[number3][number2].getText().equals(stringLetter) && window.buttons[number3][number3].getText().equals(stringLetter)) {
            return true;
        }
        return false;
    }

    public boolean checkVertical(int number1, int number2, int number3, String stringLetter) {
        if (window.buttons[number1][number1].getText().equals(stringLetter) && window.buttons[number2][number1].getText().equals(stringLetter) && window.buttons[number3][number1].getText().equals(stringLetter) ||
                window.buttons[number1][number2].getText().equals(stringLetter) && window.buttons[number2][number2].getText().equals(stringLetter) && window.buttons[number3][number2].getText().equals(stringLetter) ||
                window.buttons[number1][number3].getText().equals(stringLetter) && window.buttons[number2][number3].getText().equals(stringLetter) && window.buttons[number3][number3].getText().equals(stringLetter)) {
            return true;
        }
        return false;
    }


    @Override
    public void displayMessage() {
        checkWinCondition();
    }


}
