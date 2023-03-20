package mastermind2;
import java.util.Scanner;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;
public class start {
	public static void main(String[] args) throws InterruptedException
	{
		game();
	}
	static void game() throws InterruptedException
	{
		System.out.println("welcome to master mind");
		System.out.println("please inter your name ");
		Scanner input=new Scanner(System.in);
		String name=input.next();
		System.out.println("please inter number of chance");
		int chance=input.nextInt();
		String[] color= {"B","R","P","Y","O","G","W"};            // colors name
		String random_color="";
		for(int i=0;i<5;i++)
		{
			Random r=new Random();                              													 // making random color
			int random_number =r.nextInt(6);
			String random_char=color[random_number];
			random_color=random_color+random_char;
		}
        System.out.println("remmember the name of colors\nB=blue\nY=yellow\nO=orange\nW=white\nP=pink\nG=green\nR=red\n");		
		for (int count=1;;count++)                             																  // game algorithm
		{ 
			String exit="0";
			String help="1";
			if(count>chance)
			{
			
				System.out.println("sorry "+name+" you loose!!! better luck next time");
				System.out.print("press any key to exit ");
				String out=input.next();
				game();
				break;
			}
			System.out.print(name+" : ");                      															 //get input from user
			String in=input.next();	
			if (in.equals(exit))                           																		     // exit
			{
				int p=40;
				while (p>0)
				{
					System.out.print("\n");
					p--;
				}
			
				game();
				break;
			}
			else
			if(in.equals(help)) 						      // show answer
			{
				JFrame f = new JFrame();                      // make alert to show answer
		        final JDialog dialog = new JDialog(f, random_color, true);
		        Timer timer = new Timer(2000, new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                dialog.setVisible(true);
		                dialog.dispose();
		                
		            }
		        });
		        timer.setRepeats(false);
		        timer.start();

		        dialog.setVisible(true);
		        count++;
			}
				
			else
			if (in.length()!=5 )
			{
				System.out.println("invalid input");
				count--;
			}
			else
			{
				check(in,random_color,name);                     //show help bar
			if (in.equals(random_color))
			{
				System.out.println("congratulation "+name+" you win");
				System.out.println("press any key to exit");
				in=input.next();
				game();
			}
			}			
		}
	}
	
	static void check(String in,String r,String name)                         //help method
	{

		for(int i=0;i<name.length();i++)
		{
			System.out.print(".");
		}
	System.out.print(" : ");
	
		char ch1,ch2;
		for(int i=0;i<5;i++)
		{
			Boolean b=false;
			for (int j=0;j<5;j++)
				if((ch1=in.charAt(i))==(ch2=r.charAt(j)))
				{
					b=true;
				}
				if(b)
				{
						if((ch1=in.charAt(i))==(ch2=r.charAt(i)))
							System.out.print("#");
						else 
							System.out.print("+");
				}
				else
					System.out.print("-");
		}
		System.out.println("\n");
	}
	}