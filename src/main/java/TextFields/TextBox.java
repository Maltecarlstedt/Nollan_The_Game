package TextFields;

import model.MapStates.MapState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextBox extends JFrame implements ActionListener {

    JTextField textfield;
    MapState mapState;

    public TextBox(String s, MapState mapState){
        this.mapState = mapState;
        textfield = new JTextField();
        textfield.setFont(new Font("Consolas", Font.PLAIN, 35));
        textfield.setBackground(Color.BLACK);
        textfield.setCaretColor(Color.WHITE);
        textfield.setPreferredSize(new Dimension(250, 40));
        textfield.setText(s);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
