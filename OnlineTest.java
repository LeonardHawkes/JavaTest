package onlinetest;

/*Java Test using Arrays instead of a database*/

import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans = "+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que 1: Which one of these is not an import package");
			jb[0].setText("math");jb[1].setText("english");jb[2].setText("util");jb[3].setText("awt");	
		}
		if(current==1)
		{
			l.setText("Que 2: What is the size of a byte");
			jb[0].setText("16 bits");jb[1].setText("32 bits");jb[2].setText("8 bits");jb[3].setText("64 bits");
		}
		if(current==2)
		{
			l.setText("Que 3: Which package is directly available to our class without importing it");
			jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");
		}
		if(current==3)
		{
			l.setText("Que 4: Which of the following is the most optimal runtime (Big O Notation)");
			jb[0].setText("O(1)");jb[1].setText("O(n²)");jb[2].setText("O(n)");jb[3].setText("O(logn)");
		}
		if(current==4)
		{
			l.setText("Que 5: Which of the following is a principal of Object-Oriented Programming");
			jb[0].setText("linked list");jb[1].setText("binary search tree");jb[2].setText("polymorphism");jb[3].setText("arrays");
		}
		if(current==5)
		{
			l.setText("Que 6: Which of the following is not a loop");
			jb[0].setText("for");jb[1].setText("while");jb[2].setText("during");jb[3].setText("if");
		}
		if(current==6)
		{
			l.setText("Que 7: Which of the following is not a data type in Java");
			jb[0].setText("integer");jb[1].setText("variable");jb[2].setText("boolean");jb[3].setText("character");
		}
		if(current==7)
		{
			l.setText("Que 8: which one among these is not a function of Object class");
			jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");		
		}
		if(current==8)
		{
			l.setText("Que 9: What method does a java file need to run");
			jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("html");
		}
		if(current==9)
		{
			l.setText("Que 10: Who is the creator of this application and website");
			jb[0].setText("Eiichiro Oda");jb[1].setText("Steven Urkel");jb[2].setText("Leonard Hawkes");jb[3].setText("Guy Fawkes");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[1].isSelected());
		if(current==1)
			return(jb[2].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[2].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Online Test Of Java");
	}


}
