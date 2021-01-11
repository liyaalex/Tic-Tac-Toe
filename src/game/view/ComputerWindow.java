package game.view;

import game.model.ModelCheck;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ComputerWindow implements Player {
    private TicTacToeUserWindow window;
    private int rowPosition;
    private int columnPosition;

    public ComputerWindow(TicTacToeUserWindow window) {
        this.window = window;
        rowPosition = createPositionPlayer();
        columnPosition = createPositionPlayer();
        setValue(rowPosition, columnPosition);
        ModelCheck modelCheck = new ModelCheck(window, this);


    }


    public int createPositionPlayer() {
        Random random = new Random();
        int rand = random.nextInt(3);
        //  System.out.println("Row:"+rand);
        return rand;


    }




    @Override
    public void setValue(int row, int column) {


        if (window.buttons[row][column].getText().equals("X")) {

            //  System.out.println("FIRST IF:"+row);
            // System.out.println("First:"+YCoordinate);
            JOptionPane.showMessageDialog(window, "ALREADY SELECTED!!TRY AGAIN", "MESSAGE",
                    JOptionPane.ERROR_MESSAGE);

        } else if (window.buttons[row][column].getText().equals("O")) {
            // System.out.println("Second IF:"+row);
            //System.out.println("SECOND:"+YCoordinate);
            //System.out.println("ERROR");
            // window.buttons[row][YCoordinate].setText("O");
            //JOptionPane.showMessageDialog(window,"Now Its Your turn!!!");
            JOptionPane.showMessageDialog(window, "YOUR TURN!!!", "MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
        } else {


            System.out.println("R:" + row);
            System.out.println("C:" + column);
            window.buttons[row][column].setText("O");
            window.buttons[row][column].setForeground(Color.red);
        }

    }
}
