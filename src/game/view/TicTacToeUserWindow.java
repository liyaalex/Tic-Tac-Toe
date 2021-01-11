package game.view;

import game.model.ModelCheck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeUserWindow extends JFrame implements Player, ActionListener {
    private ComputerWindow computerWindow;
    private JPanel panel;
    public JButton buttons[][];

   // private String value;
    private GridLayout gridLayout;
    private int v;
    private JButton buttonClicked;
    protected int row = 0;
    protected int column = 0;
    // private UserCheckController controller;
    private ModelCheck modelCheck;


    public TicTacToeUserWindow(String title) {
        super(title);
        this.setVisible(true);
        this.setSize(300, 300);
        this.setLocation(400, 300);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        initializeComponents();
        setValueToButtons();
        //controller=this::UserCheck;
        //controller.UserCheck(this);
        // Check();


    }

    void initializeComponents() {
        panel = new JPanel();
        buttons = new JButton[3][3];
        this.setContentPane(panel);
        gridLayout = new GridLayout(3, 3);
        panel.setBackground(Color.magenta);
        panel.setLayout(gridLayout);


    }

    public void setValueToButtons() {
        for (int position = 0; position < 3; position++) {

            for (int col = 0; col < 3; col++) {
                buttons[position][col] = new JButton();
                buttons[position][col].setBackground(Color.yellow);
                panel.add(buttons[position][col]);
                buttons[position][col].addActionListener(this);


            }

        }
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    @Override
    public void setValue(int row, int column) {
        buttons[row][column].setText("X");
        buttons[row][column].setForeground(Color.blue);

    }

    public int getRowPosition() {
        return row;
    }

    public int getColumnPosition() {
        return column;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        buttonClicked = (JButton) e.getSource();
        Rectangle rectangle = buttonClicked.getBounds();
        Point p = buttonClicked.getLocation();
        row = p.y / rectangle.height;
        column = p.x / rectangle.width;
        if (buttons[row][column].getText().equals(""))
            setValue(row, column);
        else
            JOptionPane.showMessageDialog(this, "COMPUTER'S TURN!!!", "MESSAGE",
                    JOptionPane.ERROR_MESSAGE);
        computerWindow = new ComputerWindow(this);

        //UserCheckController controller=(UserCheckController) (this);
        //UserCheckController controller= (UserCheckController) this;


    }


}
