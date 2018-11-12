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
	
	
	public int modulo_m(int a, int b)
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
	
	public int modulo_d(String n, int m) {
		int i;
		int result = 0;
		String x = "";
		 try
		 {
		for (i=0; i<n.length(); i++) {
		if (result == 0) {
		x = String.valueOf(n.charAt(i));
		}
		else {
		x = String.valueOf(result) + n.charAt(i);
		}
		result = Integer.parseInt(x);
		result %= m;
		}
		 }
		 catch(Exception e)
		 {
			 System.out.println("EROR Z LICZBA UJEMNA");
		 }
		return result;
		}
	
	/*	public int mod(String num, int a) 
		{ 
		    // Initialize result 
		    int res = 0; 
		  
		    // One by one process all digits of 'num' 
		    for (int i = 0; i < num.length(); i++) 
		         res = (res*10 + (int)num[i] - '0') %a; 
		  
		    return res; 
		} 
	*/
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
				
				String tekst,klucz1,klucz2,d;
				
				tekst = textFieldPlainText.getText()+"1";
		        klucz1 = textFieldKey1.getText();
		        klucz2= textFieldKey2.getText();
		        
		        DecimalBigInt d2 = DecimalBigInt.valueOf(tekst);
		       
		        d2= d2.times(d2);
		        
		       int key1=Integer.parseInt(klucz1);
		       int key2=Integer.parseInt(klucz2);     
		
		       d = d2.toDecimalString();
		       int text= modulo_d(d,key1*key2);
		  
		        textFieldEncryptedText.setText(Integer.toString(text));
		        
			});
			
			//button Uncode
			buttonUncode.setOnAction(value ->  
			{
				
				
				String tekst,tekst2,klucz1,klucz2,wyn,wyn1,wyn2,wyn3,wyn4,s;
				int text,text2,key1,key2,wynik,wynik2,wynik3,wynik4;
				
				Eukl e = new Eukl();
				
				
		        klucz1 = textFieldKey1.getText();
		        klucz2 = textFieldKey2.getText();
		        tekst = textFieldPlainText.getText();
		        tekst2= textFieldPlainText.getText();
		        key1=Integer.parseInt(klucz1);
		        key2=Integer.parseInt(klucz2);     
		        text=Integer.parseInt(tekst);
		        text2=Integer.parseInt(tekst);
		        
		        
		        DecimalBigInt t = DecimalBigInt.valueOf(tekst);
		        DecimalBigInt t1 = DecimalBigInt.valueOf(tekst);
		        DecimalBigInt tt = DecimalBigInt.valueOf(tekst);
		        DecimalBigInt tt1 = DecimalBigInt.valueOf(tekst);
		        
		        for(int i=1; i<(key1+1)/4; i++)
		        {
		        		t= DecimalBigInt.valueOf(tekst);
		        		t=t.times(t1);
		        		s=t.toDecimalString();
		        		text=modulo_d(s,key1);
		        		tekst=Integer.toString(text);
		        }
		        
		       
		        
		        for(int i=1; i<(key2+1)/4; i++)
		        {
		        	tt= DecimalBigInt.valueOf(tekst2);
	        		tt=tt.times(tt1);
	        		s=tt.toDecimalString();
	        		text2=modulo_d(s,key2);
	        		tekst2=Integer.toString(text2);
		        }
		    
		        t1 = DecimalBigInt.valueOf(Integer.toString(e.Euklides2(key1,key2)));
		        DecimalBigInt t2 = DecimalBigInt.valueOf(Integer.toString(key1));
		        DecimalBigInt t3 = DecimalBigInt.valueOf(Integer.toString(text2));
		        DecimalBigInt t4 = DecimalBigInt.valueOf(Integer.toString(e.Euklides1(key1,key2)));
		        DecimalBigInt t5 = DecimalBigInt.valueOf(Integer.toString(key2));
		        DecimalBigInt t6 = DecimalBigInt.valueOf(Integer.toString(text));
		        
		        
		        t1 = t1.times(t2);
		        t1 = t1.times(t3);
		        t4 = t4.times(t5);
		        t4 = t4.times(t6);
		        t1 = t1.plus(t4);
		        
		        wynik = modulo_d(t1.toDecimalString(),key1*key2);     
		     // wynik = modulo_m(e.Euklides2(key1,key2)*key1*text2+e.Euklides1(key1,key2)*key2*text,key1*key2);
		        
		        t1 = DecimalBigInt.valueOf(Integer.toString(e.Euklides2(key1,key2)));
		        t2 = DecimalBigInt.valueOf(Integer.toString(key1));
		        t3 = DecimalBigInt.valueOf(Integer.toString(text2));
		        t4 = DecimalBigInt.valueOf(Integer.toString(e.Euklides1(key1,key2)));
		        t5 = DecimalBigInt.valueOf(Integer.toString(-key2));
		        t6 = DecimalBigInt.valueOf(Integer.toString(text));
		        
		        t1 = t1.times(t2);
		        t1 = t1.times(t3);
		        t4 = t4.times(t5);
		        t4 = t4.times(t6);
		        t1 = t1.plus(t4);
		        
		        wynik2 = modulo_d(t1.toDecimalString(),key1*key2);
		     // wynik2= modulo_m(e.Euklides2(key1,key2)*key1*text2-(e.Euklides1(key1,key2)*key2*text),key1*key2); 
		       
		        t1 = DecimalBigInt.valueOf(Integer.toString(-e.Euklides2(key1,key2)));
		        t2 = DecimalBigInt.valueOf(Integer.toString(key1));
		        t3 = DecimalBigInt.valueOf(Integer.toString(text2));
		        t4 = DecimalBigInt.valueOf(Integer.toString(-e.Euklides1(key1,key2)));
		        t5 = DecimalBigInt.valueOf(Integer.toString(key2));
		        t6 = DecimalBigInt.valueOf(Integer.toString(text));
		        
		        t1 = t1.times(t2);
		        t1 = t1.times(t3);
		        t4 = t4.times(t5);
		        t4 = t4.times(t6);
		        t1 = t1.plus(t4);
		        
		        wynik3 = modulo_d(t1.toDecimalString(),key1*key2); 	     
		      //  wynik3= modulo_m(-(e.Euklides2(key1,key2)*key1*text2+e.Euklides1(key1,key2)*key2*text),key1*key2);
		       
		        t1 = DecimalBigInt.valueOf(Integer.toString(-e.Euklides2(key1,key2)));
		        t2 = DecimalBigInt.valueOf(Integer.toString(key1));
		        t3 = DecimalBigInt.valueOf(Integer.toString(text2));
		        t4 = DecimalBigInt.valueOf(Integer.toString((e.Euklides1(key1,key2))));
		        t5 = DecimalBigInt.valueOf(Integer.toString(key2));
		        t6 = DecimalBigInt.valueOf(Integer.toString(text));
		        
		        t1 = t1.times(t2);
		        t1 = t1.times(t3);
		        t4 = t4.times(t5);
		        t4 = t4.times(t6);
		        t1 = t1.plus(t4);
		        
		        wynik4 = modulo_d(t1.toDecimalString(),key1*key2); 
		      //  wynik4= modulo_m(-(e.Euklides2(key1,key2)*key1*text2-(e.Euklides1(key1,key2)*key2*text)),key1*key2);
		      
		        wyn1 = Integer.toString(wynik);
		        wyn2 = Integer.toString(wynik2);
		        wyn3 = Integer.toString(wynik3);
		        wyn4 = Integer.toString(wynik4);
		        
		       char d[]=wyn1.toCharArray();
		       char x[]=wyn2.toCharArray();
		       char y[]=wyn3.toCharArray();
		       char u[]=wyn4.toCharArray();
		       
		        if(d[d.length-1]=='1')
		        {
		        	wyn=wyn1.substring(0,d.length-1);
		        }
		        else if(x[x.length-1]=='1')
		        	{
		        	wyn=wyn2.substring(0,x.length-1);
		        	}
		        else if(y[y.length-1]=='1')
		        	{
		        	wyn=wyn3.substring(0,y.length-1);
		        	}
		        else if(u[u.length-1]=='1')
		        	{
		        	wyn=wyn4.substring(0,u.length-1);
		        	}
		        else wyn= "Error";
		        
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
				 
				 n1=modulo_m(n1,4);
				 n2=modulo_m(n2,4);
				
				 }while((n1!=3)||(n2!=3));
				 
				 
				 textFieldKey1.setText(Integer.toString(key));
				 textFieldKey2.setText(Integer.toString(key2));
				 
		        });
			
			//buttonCryptUncryprFile Crypt/Encrypt File
			buttonCryptUncryprFile.setOnAction(value ->  
			{
		           
				DecimalBigInt d2 = DecimalBigInt.valueOf("10");
				
				DecimalBigInt d4 = DecimalBigInt.valueOf("-3");
				
				System.out.println(d2);
				
				System.out.println(d4);
				
				d2= d2.times(d4);
				
				System.out.println(d2);
				
		       
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