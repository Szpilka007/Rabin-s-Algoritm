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
			a = a-c;
		}
		
		
		return a;
	}
	
	public void start(Stage primaryStage) {
		try {
			
			
			//tworzenie i pozycja przycisku Uncode
			Button buttonCode = new Button();
			buttonCode.setText("Code");
			buttonCode.setPrefSize(100, 50);
			buttonCode.setLayoutX(110);
			buttonCode.setLayoutY(230);
					
			
			//tworzenie i pozycja przycisku Code
			Button buttonUncode =new Button();
			buttonUncode.setText("Uncode");
			buttonUncode.setPrefSize(100,50);
			buttonUncode.setLayoutX(230);
			buttonUncode.setLayoutY(230);
					
			//tworzenie i pozycja przycisku Generate key
			Button buttonGenerateKey =new Button();
			buttonGenerateKey.setText("Generate Key");
			buttonGenerateKey.setPrefSize(240,30);
			buttonGenerateKey.setLayoutX(100);
			buttonGenerateKey.setLayoutY(184);
			
			//tworzenie i pozycja przycisku Crypt/Encrypt File
			Button buttonCryptUncryprFile =new Button();
			buttonCryptUncryprFile.setText("Crypt/Encrypt File");
			buttonCryptUncryprFile.setPrefSize(240,30);
			buttonCryptUncryprFile.setLayoutX(100);
			buttonCryptUncryprFile.setLayoutY(370);
			
			//tworzenie pola tekstowego Plain text
			Label labelPlainText = new Label("Plain Text:");
			TextField textFieldPlainText = new TextField();
			labelPlainText.setLayoutX(60);
			textFieldPlainText.setLayoutX(140);
			labelPlainText.setLayoutY(44);
			textFieldPlainText.setLayoutY(40);
			
			//tworzenie pola tekstowego Key 1
			Label labelKey1 = new Label("Key 1:");
			TextField textFieldKey1 = new TextField();
			labelKey1.setLayoutX(90);
			textFieldKey1.setLayoutX(140);
			labelKey1.setLayoutY(94);
			textFieldKey1.setLayoutY(90);
			
			//tworzenie pola tekstowego Encrypted text
			Label labelEncryptedText = new Label("Encrypted text:");
			TextField textFieldEncryptedText = new TextField();
			labelEncryptedText.setLayoutX(30);
			textFieldEncryptedText.setLayoutX(140);
			labelEncryptedText.setLayoutY(304);
			textFieldEncryptedText.setLayoutY(300);
			
			//tworzenie pola tekstowego Key2
			Label labelKey2 = new Label("Key 2:");
			TextField textFieldKey2 = new TextField();
			labelKey2.setLayoutX(90);
			textFieldKey2.setLayoutX(140);
			labelKey2.setLayoutY(140);
			textFieldKey2.setLayoutY(136);
			
			//operacje dla przycisków key1,key2,code,uncode, generate key, Crypted/Encrypted File
			
			//buton Code
			buttonCode.setOnAction(value ->  
			{
				
				String tekst,klucz1,klucz2;
				tekst = textFieldPlainText.getText();
		        klucz1 = textFieldKey1.getText();
		        klucz2= textFieldKey2.getText();
		        
		        int key1=Integer.parseInt(klucz1);
		        int key2=Integer.parseInt(klucz2);     
		        int text=Integer.parseInt(tekst);
		        
		        text= modulo(text*text,key1*key2);
		     				   
		        
		        textFieldEncryptedText.setText(Integer.toString(text));
		        
			});
			
			//button Uncode
			buttonUncode.setOnAction(value ->  
			{
				
				String tekst,klucz1,klucz2,wyn;
				int text,text2,key1,key2,wynik,wynik2,wynik3,wynik4;
		        klucz1 = textFieldKey1.getText();
		        klucz2 = textFieldKey2.getText();
		        tekst = textFieldPlainText.getText();
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
		        textFieldEncryptedText.setText(wyn);
			
			});
			//button Generate key
			buttonGenerateKey.setOnAction(value ->  
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
				 
				 
				 textFieldKey1.setText(Integer.toString(key));
				 textFieldKey2.setText(Integer.toString(key2));
				 
		        });
			
			//buttonCryptUncryprFile Crypt/Encrypt File
			buttonCryptUncryprFile.setOnAction(value ->  
			{
		           
		        });
			
			//tworzenie panelu i umieszczanie przycisków
			Pane root = new Pane();
			root.getChildren().add(buttonCode);
			root.getChildren().add(buttonUncode);
			root.getChildren().add(buttonGenerateKey);
			root.getChildren().add(buttonCryptUncryprFile);
			root.getChildren().addAll(labelPlainText,textFieldPlainText);
			root.getChildren().addAll(textFieldKey1,labelKey1);
			root.getChildren().addAll(textFieldEncryptedText,labelEncryptedText);
			root.getChildren().addAll(textFieldKey2,labelKey2);
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
	
	