//Suraj Prathik Kumar
//2016101
import java.awt.event.*;

import javax.swing.BoxLayout;

import java.awt.*;
import java.applet.*;
public  class calculator extends  Applet implements ActionListener
 {
int sum,sum1, total_available;
Label  l1,l2,l3,l4,l5,l8,u1,u2,u3,u4,u5,u6,u8,iiitd,inventory,user,i1,i2,q1,q2;TextField t1,t2,t3,t4,t5,t8,ut1,ut2,ut3,ut4,ut5,ut8;Button b,b1,b2,b3;
  public void init()
  {  
	  BoxLayout mainLayout = new BoxLayout(this, BoxLayout.Y_AXIS); // Create vertical layout for the applet
		super.setLayout(mainLayout); 
	  
  Panel iiit =new Panel();
  
  
  
  iiitd=new Label("IIITD Fruit Stall",Label.CENTER);
  iiit.add(iiitd);
  
  super.add(iiit);
  Panel inventorya=new Panel();
  inventory=new Label("Inventory",Label.LEFT);
  inventorya.add(inventory);
  user=new Label("User",Label.LEFT);
  inventorya.add(user);
  super.add(inventorya);
  Panel items=new Panel();
  i1=new Label("Item",Label.LEFT);
  items.add(i1);
  q1=new Label("Quantity",Label.LEFT);
  items.add(q1);
  i2=new Label("Item",Label.LEFT);
  items.add(i2);
  q2=new Label("Quantity",Label.LEFT);
  items.add(q2);
  super.add(items);
  
  
  
  Panel apple=new Panel();
  l1=new Label("Apple",Label.LEFT);
  apple.add(l1);
  t1=new TextField(5);
  apple.add(t1);
  t1.addActionListener(this);
  t1.setText("10");
  t1.setEditable(false);
  
  u1=new Label("Apple",Label.LEFT);
  apple.add(u1);
  ut1=new TextField(5);
  ut1.setText("0");
  apple.add(ut1);
  ut1.addActionListener(this);
  super.add(apple);
  
  
  

  Panel mango=new Panel();
  l2=new Label("Mango",Label.LEFT);mango.add(l2);
  t2=new TextField(5);
  mango.add(t2);
  t2.addActionListener(this);
  t2.setText("6");
  t2.setEditable(false);
  u2=new Label("Mango",Label.LEFT);
  mango.add(u2);
  ut2=new TextField(5);
   ut2.setText("0");
  mango.add(ut2);
  ut2.addActionListener(this);
  super.add(mango);
  
  Panel orange=new Panel();
  l3=new Label("Orange",Label.LEFT);orange.add(l3);
  t3=new TextField(5);orange.add(t3); t3.setText("8");
  t3.addActionListener(this);
  t3.setEditable(false);
  u3=new Label("Orange",Label.LEFT);
  orange.add(u3);
  ut3=new TextField(5);
   ut3.setText("0");
  orange.add(ut3);
  ut3.addActionListener(this);
  super.add(orange);

  
  Panel pineapple=new Panel();
  l4=new Label("Pineapple",Label.LEFT);pineapple.add(l4);
  t4=new TextField(5);pineapple.add(t4);t4.setText("4");
  t4.addActionListener(this);
  t4.setEditable(false);
  u4=new Label("Pineapple",Label.LEFT);
  pineapple.add(u4);

  ut4=new TextField(5);
   ut4.setText("0");
  pineapple.add(ut4);
  ut4.addActionListener(this);
  super.add(pineapple);
  Panel banana =new Panel();
  l5=new Label("Banana",Label.LEFT);banana.add(l5);
  t5=new TextField(5);banana.add(t5); t5.setText("2");
  t5.addActionListener(this);
  t5.setEditable(false);
  u5=new Label("Banana",Label.LEFT);
  banana.add(u5);

  ut5=new TextField(5);
  ut5.setText("0");
  banana.add(ut5);
  ut5.addActionListener(this);
  super.add(banana);
  
  Panel total=new Panel();
   l8=new Label("Total",Label.CENTER);total.add(l8);
   t8=new TextField(5); 
   total.add(t8);
   t8.addActionListener(this);
   t8.setText("");

 
  u8=new Label("Total",Label.CENTER);total.add(u8);
   ut8=new TextField(5); 
   total.add(ut8);t8.setText("");
   ut8.addActionListener(this);
   super.add(total);
   
   b=new Button("Submit"); add(b); 
   b.addActionListener(this);

    }//init
  public void actionPerformed (ActionEvent e)
  {   repaint();
	 if (e.getSource()==b)
	 { sum=Integer.parseInt(t1.getText()) +Integer.parseInt(t2.getText())+ Integer.parseInt		  (t3.getText()) + Integer.parseInt(t4.getText())+Integer.parseInt(t5.getText());
          	  t8.setText(String.valueOf(sum));
          

     

       	  {  if (Integer.parseInt(ut1.getText()) > Integer.parseInt(t1.getText()))
              {  
                 ut1.setText("0");
                }
             if (Integer.parseInt(ut2.getText()) > Integer.parseInt(t2.getText()))
              {  
                 ut2.setText("0");
                }
              if (Integer.parseInt(ut3.getText()) > Integer.parseInt(t3.getText()))
              {  
                 ut3.setText("0");
                }
             if (Integer.parseInt(ut4.getText()) > Integer.parseInt(t4.getText()))
              {  
                 ut4.setText("0");
                }
             if (Integer.parseInt(ut5.getText()) > Integer.parseInt(t5.getText()))
              {  
                 ut5.setText("0");
                }


              

          sum1=Integer.parseInt(ut1.getText()) +Integer.parseInt(ut2.getText())+ Integer.parseInt		  (ut3.getText()) + Integer.parseInt(ut4.getText())+Integer.parseInt(ut5.getText());
          	  ut8.setText(String.valueOf(sum1));
          }
	 }
       total_available=sum-sum1;
       t1.setText(Integer.toString(Integer.parseInt(t1.getText())-Integer.parseInt(ut1.getText())));
       t2.setText(Integer.toString(Integer.parseInt(t2.getText())-Integer.parseInt(ut2.getText())));
       t3.setText(Integer.toString(Integer.parseInt(t3.getText())-Integer.parseInt(ut3.getText())));
       t4.setText(Integer.toString(Integer.parseInt(t4.getText())-Integer.parseInt(ut4.getText())));
       t5.setText(Integer.toString(Integer.parseInt(t5.getText())-Integer.parseInt(ut5.getText())));
       t8.setText(Integer.toString(Integer.parseInt(t8.getText())-Integer.parseInt(ut8.getText())));

	
 }//ActionPerformed   


}//calculator
