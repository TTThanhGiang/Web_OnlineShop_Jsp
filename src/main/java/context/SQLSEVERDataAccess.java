package context;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSEVERDataAccess {
	private Connection cnn;
	private Statement stm;
	private PreparedStatement ps;

	public SQLSEVERDataAccess() {
		try {
			String DriverClass, DriverURL;
			String UserName="sa";
			String PassWord="123";
			DriverClass= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			DriverURL = "jdbc:sqlserver://LAPTOP-9TOR6RJG:1433;encrypt=true;trustServerCertificate=true;databaseName=dbQUANLYBANGIAY";
			Class.forName(DriverClass);
			this.cnn=DriverManager.getConnection(DriverURL,UserName,PassWord);  
			this.stm=this.cnn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet getResultSet(String SQL) {
		try {
			ResultSet rs;
			rs = this.stm.executeQuery(SQL);
			return rs;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public ResultSet getResultSet(String SQL, Object[] param) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = cnn.prepareStatement(SQL);
			int i = 1;
			for (Object value : param) {
				ps.setObject(i, value);
				i++;
			}
			rs = ps.executeQuery();
			return rs;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public int ExecuteSQL(String SQL) {
		try {
			int k = 0;
			k = this.stm.executeUpdate(SQL);
			return k;
		} catch (SQLException e) {
		}
		return 0;
	}

	public int ExecuteSQL(String SQL, Object[] param) {
		try {
			int k = 0;
			PreparedStatement ps = this.cnn.prepareStatement(SQL);
			int i = 1;
			for (Object value : param) {
				ps.setObject(i, value);
				i++;
			}
			k = ps.executeUpdate();
			return k;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int Execute_StoredProcedures(String NameStoredProcedures, Object[] param) {
		try {
			int k = 0;
            CallableStatement ps = this.cnn.prepareCall("{call "+NameStoredProcedures+"}");
            int i = 1;
            for (Object value : param) {
                
                ps.setObject(i, value);
                i++;
            }
            k = ps.executeUpdate();
            ps.close();
            return k;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ResultSet getResultSet_StoredProcedures(String NameStoredProcedures, Object[] param) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = cnn.prepareCall("{call "+NameStoredProcedures+"}");
            if(param!=null)
            {
	            int i = 1;
	            for (Object value : param) {
	                ps.setObject(i, value);
	                i++;
	            }
            }
            rs = ps.executeQuery();
            ps.close();
            return rs;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
        // TODO Auto-generated method stub
		try{              

	       	SQLSEVERDataAccess con=new SQLSEVERDataAccess(); 

	         	 ResultSet rs=con.getResultSet("select * from tbSANPHAM"); 

	         	while(rs.next()) 

	        	{ 

	        		System.out.println("giá trị"+rs.getString(2));  

	         	} 

	   } 

	   catch(SQLException sqle) { 

	   	   System.out.println("Sql Exception :"+sqle.getMessage()); 

	   }        
   
	}
       
       
 }
	

