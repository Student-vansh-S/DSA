import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame implements ActionListener{
    Label l;
    TextField t;
    Button b,b1;
    MyFrame(){
        super("login");
        setLayout(new FlowLayout());
        l=new Label("Name");
        t=new TextField(20);
        b=new Button("Click");
        b1=new Button("Exit");
        add(l);
        add(t);
        add(b);
        add(b1);
        b.addActionListener(this);
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            String str=t.getText();
            System.out.println("Hello"+str);
        }
        if(ae.getSource()==b1){
            System.out.println("Exit");
        }
    }
}

public class Clg {
    public static void main(String[] args) {
        MyFrame m=new MyFrame();
        m.setSize(300,300);
        m.setVisible(true);
    }

    
}