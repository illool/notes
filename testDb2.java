package tspsolver;

import java.sql.DriverManager;
import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.sql.Statement;
  import java.sql.Connection;

public class testDb2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
    	Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
        String URL="jdbc:db2://10.27.80.98:60004/SDASDB";
        			//jdbc:db2://10.27.80.98:60004/SDASDB:currentSchema=DMSDA
        String USER="sopdmusr";
        String PASSWORD="4cRr#4243";
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
       //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from SYS_MENU");
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){
            System.out.println(rs.getString("MENU_ID")+" " +rs.getString("DATE_UPDATED"));
            }
            //关闭资源
         rs.close();
         st.close();
         conn.close();
    }
}
