package application;
	
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;



public class Main extends Application {
	
	public int Euklides1(int nwd_a, int nwd_b) 
	{
		int r, a, q, b;
		int  x,x1, x2;
		int  y,y1, y2;
		int nwd;	

		if (nwd_b > nwd_a)
		{
		nwd = nwd_b;
		nwd_b = nwd_a;
		nwd_a = nwd;
		}
		
		a = nwd_a;
		b = nwd_b;
		 
	
		q = a/b;
		r = a - q*b;
		nwd = b;
		 
		x2 = 1;
		x1 = 0;
		y2 = 0;
		y1 = 1;
		x = 1;
		y = y2 - (q-1)*y1;
		 
		while (r != 0)
		{
		a = b;
		b = r;
		 
		x = x2 - q*x1;
		x2 = x1;
		x1 = x;
		 
		y = y2 - q*y1;
		y2 = y1;
		y1 = y;     
		 
		nwd = r;
		q = a/b;
		r = a - q*b;
		}
	return x;
	}
	
	public int Euklides2(int nwd_a, int nwd_b) 
	{
		int r, a, q, b;
		int  x,x1, x2;
		int  y,y1, y2;
		int nwd;
		 
		if (nwd_b > nwd_a)
		{
		nwd = nwd_b;
		nwd_b = nwd_a;
		nwd_a = nwd;
		}
		
		a = nwd_a;
		b = nwd_b;
		 
		q = a/b;
		r = a - q*b;
		nwd = b;
		 
		x2 = 1;
		x1 = 0;
		y2 = 0;
		y1 = 1;
		x = 1;
		y = y2 - (q-1)*y1;
		 
		while (r != 0)
		{
		a = b;
		b = r;
		 
		x = x2 - q*x1;
		x2 = x1;
		x1 = x;
		 
		y = y2 - q*y1;
		y2 = y1;
		y1 = y;     
		 
		nwd = r;
		q = a/b;
		r = a - q*b;
		}
	return y;
	}
	
	public int modulo(int a, int b)
	{
		
		
		if(a>b)
		{
			while(a>=b)
			{	
				a-=b;
			}
		}
		if(a<0)
		{
			int c= (-a)-b;
			a = b-c;
		}
		
		
		return a;
	}
	
	public void start(Stage primaryStage) {
		try {
			
			//public String klucz;
			
			//tworzenie i pozycja przycisku Uncode
			Button button = new Button();
			button.setText("Code");
			button.setPrefSize(100, 50);
			button.setLayoutX(110);
			button.setLayoutY(230);
					
			
			//tworzenie i pozycja przycisku Code
			Button button1 =new Button();
			button1.setText("Uncode");
			button1.setPrefSize(100,50);
			button1.setLayoutX(230);
			button1.setLayoutY(230);
					
			//tworzenie i pozycja przycisku Generate key
			Button button2 =new Button();
			button2.setText("Generate Key");
			button2.setPrefSize(240,30);
			button2.setLayoutX(100);
			button2.setLayoutY(184);
			
			//tworzenie i pozycja przycisku Crypt/Encrypt File
			Button button3 =new Button();
			button3.setText("Crypt/Encrypt File");
			button3.setPrefSize(240,30);
			button3.setLayoutX(100);
			button3.setLayoutY(370);
			
			//tworzenie pola tekstowego Plain text
			Label label1 = new Label("Plain Text:");
			TextField textfield = new TextField();
			label1.setLayoutX(60);
			textfield.setLayoutX(140);
			label1.setLayoutY(44);
			textfield.setLayoutY(40);
			
			//tworzenie pola tekstowego Key 1
			Label label2 = new Label("Key 1:");
			TextField textfield2 = new TextField();
			label2.setLayoutX(90);
			textfield2.setLayoutX(140);
			label2.setLayoutY(94);
			textfield2.setLayoutY(90);
			
			//tworzenie pola tekstowego Encrypted text
			Label label3 = new Label("Encrypted text:");
			TextField textfield3 = new TextField();
			label3.setLayoutX(30);
			textfield3.setLayoutX(140);
			label3.setLayoutY(304);
			textfield3.setLayoutY(300);
			
			//tworzenie pola tekstowego Key2
			Label label4 = new Label("Key 2:");
			TextField textfield4 = new TextField();
			label4.setLayoutX(90);
			textfield4.setLayoutX(140);
			label4.setLayoutY(140);
			textfield4.setLayoutY(136);
			
			//operacje dla przycisków key1,key2,code,uncode, generate key, Crypted/Encrypted File
			
			//buton Code
			button.setOnAction(value ->  
			{
				
				String tekst,klucz1,klucz2;
				tekst = textfield.getText();
		        klucz1 = textfield2.getText();
		        klucz2= textfield4.getText();
		        
		        int key1=Integer.parseInt(klucz1);
		        int key2=Integer.parseInt(klucz2);     
		        int text=Integer.parseInt(tekst);
		        
		        text= modulo(text*text,key1*key2);
		     				   
		        
		        textfield3.setText(Integer.toString(text));
		        
			});
			
			//button Uncode
			button1.setOnAction(value ->  
			{
				
				String tekst,klucz1,klucz2,wyn;
				int text,text2,key1,key2,wynik,wynik2,wynik3,wynik4;
		        klucz1 = textfield2.getText();
		        klucz2 = textfield4.getText();
		        tekst = textfield.getText();
		        key1=Integer.parseInt(klucz1);
		        key2=Integer.parseInt(klucz2);     
		        text=Integer.parseInt(tekst);
		        text2=Integer.parseInt(tekst);
		        
		        int tex = text;
		        
		        int potega= ((key1+1)/4);
		        int potega2=((key2+1)/4);
		        
		        for(int i=1; i<potega; i++)
		        {
		        		text=text*tex;
		        		text=modulo(text,key1);
		        		
		        }
		        
		        for(int i=1; i<potega2; i++)
		        {
		        	text2=text2*tex;
		        	text2=modulo(text2,key2);
		        }
		    
		       
		        wynik = modulo(Euklides2(key1,key2)*key1*text2+Euklides1(key1,key2)*key2*text,key1*key2);
		        wynik2= modulo(Euklides2(key1,key2)*key1*text2-(Euklides1(key1,key2)*key2*text),key1*key2);
		        wynik3= modulo(-(Euklides2(key1,key2)*key1*text2+Euklides1(key1,key2)*key2*text),key1*key2);
		        wynik4= modulo(-(Euklides2(key1,key2)*key1*text2-(Euklides1(key1,key2)*key2*text)),key1*key2);
		        wyn= Integer.toString(wynik)+","+Integer.toString((wynik2))+","+Integer.toString((wynik3))+","+Integer.toString((wynik4));
		        textfield3.setText(wyn);
			
			});
			//button Generate key
			button2.setOnAction(value ->  
			{
				
				 Random rand = new Random(System.currentTimeMillis());
				 int key,key2,n1,n2;
				
				 do 
				 {
				 key= rand.nextInt(100);
				 key2= rand.nextInt(100);
				 n1=key;
				 n2=key2;
				 
				 n1=modulo(n1,4);
				 n2=modulo(n2,4);
				
				 }while((n1!=3)||(n2!=3));
				 
				 
				 textfield2.setText(Integer.toString(key));
				 textfield4.setText(Integer.toString(key2));
				 
		        });
			
			//button3 Crypt/Encrypt File
			button3.setOnAction(value ->  
			{
		           
		        });
			
			//tworzenie panelu i umieszczanie przycisków
			Pane root = new Pane();
			root.getChildren().add(button);
			root.getChildren().add(button1);
			root.getChildren().add(button2);
			root.getChildren().add(button3);
			root.getChildren().addAll(label1,textfield);
			root.getChildren().addAll(textfield2,label2);
			root.getChildren().addAll(textfield3,label3);
			root.getChildren().addAll(textfield4,label4);
			Scene scene = new Scene(root,400,450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
		
public static void main(String[] args) 
	{
		launch(args);
		
	}
}
	
	