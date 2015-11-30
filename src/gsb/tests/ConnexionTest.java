package gsb.tests;

import java.sql.Connection;
import java.sql.DriverManager;

//CTRL + SHIFT + O pour générer les imports
public class ConnexionTest {
  public static void main(String[] args) {    
	  System.out.println("Test1");
    try {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Test2");
      System.out.println("Driver O.K.");

      String url = "jdbc:mysql://192.168.1.38:3306/gsb";
      String user = "usergsb";
      String passwd = "password";
      System.out.println("Test3");
      Connection cnx = DriverManager.getConnection(url, user, passwd);
      System.out.println("Connexion effective !");         
         
    } catch (Exception e) {
      e.printStackTrace();
    }     
	 	  
	  
  }
}