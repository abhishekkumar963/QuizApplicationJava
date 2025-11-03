package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame {

    Score(String name, int score){

        // ----------------------------------------------------------------------
        // 1. Trophy Image (Added first in the video's constructor logic)
        // ----------------------------------------------------------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        // Original scale from the video code/your first provided file
        Image i2 = i1.getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        // Original bounds from the video (x=60, y=200)
        image.setBounds(60,200,200,150);
        add(image);


        // ----------------------------------------------------------------------
        // 2. Heading Label (The video uses a single space after "Thank You" and "name")
        // ----------------------------------------------------------------------
        JLabel heading = new JLabel("Thank You " + name + " For playing QUIZ Test");
        // Original bounds from the video (x=100, y=80)
        heading.setBounds(100,80,700,30);
        heading.setFont(new Font("Tahoma", Font.BOLD,26));
        add(heading); // Defaults to black color


        // ----------------------------------------------------------------------
        // 3. Score Label
        // ----------------------------------------------------------------------
        JLabel Score = new JLabel("Your Score is " + score);
        // Original bounds from the video (x=350, y=200)
        Score.setBounds(350,200,300,30);
        Score.setFont(new Font("Tahoma", Font.BOLD,26));
        add(Score); // Defaults to black color


        // ----------------------------------------------------------------------
        // 4. Exit Button
        // ----------------------------------------------------------------------
        JButton exit = new JButton("Exit");
        // Original bounds from the video (x=380, y=270)
        exit.setBounds(380,270,120,30);
        exit.setBackground(new Color(22,99,54));
        exit.setForeground(Color.WHITE);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });


        // ----------------------------------------------------------------------
        // 5. Background Image (CRUCIAL: This must be added LAST to ensure it is behind the elements)
        // Note: The previous logic for `imagee` was incorrect. We need to use `getContentPane().add()`
        // for the background image to ensure it is rendered behind the other components when using
        // a null layout, or simply ensure it is added after other components when they overlap
        // (which is the case here since all bounds overlap the background).
        // ----------------------------------------------------------------------
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image i22 = i11.getImage().getScaledInstance(750,550, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imagee = new JLabel(i33);
        // The bounds for the background image is full frame size
        imagee.setBounds(0,0,750,550);
        // The key to fixing the overlap in the video's original code is that the background
        // image is added LAST, and the image it is *supposed* to be behind is added earlier.
        add(imagee);


        // ----------------------------------------------------------------------
        // 6. Frame Setup
        // ----------------------------------------------------------------------
        setSize(750,550);
        setLocation(400,150);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
