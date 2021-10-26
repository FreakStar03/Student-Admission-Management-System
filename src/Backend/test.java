package Backend;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class test{  
   public static void main(String args[]){  
      try{
      ArrayList<String> list = new ArrayList<>(Arrays.asList("PersonalData", "RegistrationData"));
      for(int counter = 0; counter < list.size(); counter++){
      Class.forName("com.mysql.cj.jdbc.Driver");  
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","Chiragsp","admin");  
      PreparedStatement Pstatement=con.prepareStatement("SELECT * FROM " + list.get(counter) + " WHERE id = ?");
      Pstatement.setInt(1, 30);
      ResultSet rs = Pstatement.executeQuery();
      if (rs.next()) {
         if(list.get(counter) == "PersonalData") ;

         System.out.println("done");
          Pstatement.close();
          con.close();
      } else {
         if(list.get(counter) == "PersonalData") ;
         System.out.println("no next");
          Pstatement.close();
          con.close();
      }
   };
      }catch(Exception e){ System.out.println(e);System.out.println("excpt");}        

   }  
}  
// SELECT a.*, b.*
// FROM studentReg as a
// INNER JOIN PersonalData as b ON a.id=b.id