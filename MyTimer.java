import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTimer implements ActionListener {

    Timer timer;
    int count = 0;

    JButton b1 = new JButton("Start");
    JButton b2 = new JButton("Pause");

    JLabel label = new JLabel("00:00:00");

    MyTimer (){
        timer = new Timer(1000, this);


        label.setFont(new Font("Arial", Font.BOLD, 40));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panel1.setPreferredSize(new Dimension(75, 75));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());

        b1.addActionListener(this);
        b2.addActionListener(this); 
        panel1.add(b1);
        panel1.add(b2);
        panel2.add(label);

        JFrame frame = new JFrame("Timer");
        frame.setSize(230,230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel1, BorderLayout.SOUTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object s1 = e.getSource();

        String s2 = e.getActionCommand();
        System.out.println(s2);

        if (b1 == e.getSource()){
            
            timer.start();
            /*System.out.println("Sss");*/
        }else if (b2 == e.getSource()){
            timer.stop();
            /*System.out.println("ppp");*/
        }else if (timer == e.getSource()){

            count = count + 1;

            int hour; 
            int min;
            int sec;

            hour = count / 3600;
            sec = count % 3600;
            min = sec / 60;
            sec = sec % 60;

            String formattedTime = String.format("%02d:%02d:%02d", hour, min, sec);
            label.setText(formattedTime);
        }
    }

    public static void main (String [] args) {
        new MyTimer ();
    }
}