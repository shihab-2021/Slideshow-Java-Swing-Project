import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class SlideShow extends JFrame implements ActionListener {
    private Container c;
    private JButton backBtn, nextBtn;
    private JPanel panel;
    private CardLayout cl;
    private JLabel headingLabel, label;
    private ImageIcon icon, nextImage, backImage;
    private Font f;

    SlideShow(){
        initComponents();
        showImage();
    }
    public void initComponents(){
        Color hsb = new Color(204, 204, 255);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(hsb);

        cl = new CardLayout();

        f = new Font("Tahoma", Font.BOLD, 25);

        nextImage = new ImageIcon(getClass().getResource("nextButton.png"));
        backImage = new ImageIcon(getClass().getResource("returnButton.png"));

        headingLabel = new JLabel("Slideshow");
        headingLabel.setBounds(250, 30, 150, 50);
        headingLabel.setFont(f);
        c.add(headingLabel);

        panel = new JPanel(cl);
        panel.setBounds(10, 90, 560, 380);
        c.add(panel);

        nextBtn = new JButton(nextImage);
        nextBtn.setBounds(475, 495, 90, 45);
        c.add(nextBtn);

        backBtn = new JButton(backImage);
        backBtn.setBounds(10, 495, 90, 45);
        c.add(backBtn);

        nextBtn.addActionListener(this);
        backBtn.addActionListener(this);
    }
    public void showImage(){
        String[] imageNames = {"bootstrap.jpg", "js.jpg", "mui.jpg", "react.jpg", "sta-je-css.jpg", "sta-je-html.jpg", "tailwind.jpg"};
        for(String n: imageNames){
            icon = new ImageIcon("images/"+n);

            //Resizing the image
            Image img = icon.getImage();
            Image newImage = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);

            label = new JLabel(icon);
            panel.add(label);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backBtn){
            cl.previous(panel);
        }
        if(e.getSource() == nextBtn){
            cl.next(panel);
        }
        
    }
    public static void main(String[] args){
        SlideShow frame = new SlideShow();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Slideshow");
    }
}