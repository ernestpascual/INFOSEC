package dls.csb.sdbmrs.model;
import java.sql.*;
import dls.csb.sdbmrs.utility.Security;
public class StudentBean {
	// make sure that all instance variables are protected
	// from direct access to achieve encapsulation
	
	private String studentId;
	private String lastName;
	private String firstName;
	private int yearLevel;
	private String course;
	
	// create equivalent setter and getter methods here (Source > Get Getters and Setters)
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getYearLevel() {
		return yearLevel;
	}
	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	/*
	 * this section is reserved for JDBC database table manipulation
	 * extract mysql-connector-java-5.1.22-bin and commons-codec-1.9(AES encryption)
	 * Right Click > Properties > Java Build Path > Libraries > Add Library > User Libraries 
	 * > New > OracleMySqlJdbcLib/ AESEncryption > Add External JAR > Find the JAR > Finish
	 * Deployment Assembly > Add > Select libs > Apply > OK 
	 * http://localhost:8080/phpmyadmin/
	 */
	
	private Connection getConnectionDB() {
		Connection connection = null;
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// connected as root, no password (data source vs driver manager)
			// http://localhost:8080/phpmyadmin
		
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pascual-tc001-infosec",
							"root", "");
		} catch (ClassNotFoundException cfne){
			cfne.printStackTrace();
		} catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return connection;
	}
	
	public void insertRecord(){
		String sql = "insert into student(studentid, lastName, firstName, yearLevel, course) values (?,?,?,?,?)";
		
		try{
			Connection connection = getConnectionDB();
			
			if (connection != null){ // if true we have session in the database
				PreparedStatement prep =  connection.prepareStatement(sql);
				prep.setString(1, Security.encrypt(this.studentId));
				prep.setString(2, Security.encrypt(this.lastName));
				prep.setString(3, Security.encrypt(this.firstName));
				prep.setInt(4, this.yearLevel);
				prep.setString(5, this.course);
				
				// now commit this to database
				prep.executeUpdate();
			}
		} catch (SQLException sqle){
			sqle.printStackTrace();
		}
				
	}
	
	public ResultSet getRecords(){
		ResultSet records = null;
		String sql="select * from student;";
		try{
			Connection connection = getConnectionDB();
			
			if (connection != null){ // if true we have session in the database
			PreparedStatement prep = connection.prepareStatement(sql);
			
				// problem isolation: put else 
				// now commit this to database
				records = prep.executeQuery();
			}
		} catch (SQLException sqle){
			sqle.printStackTrace();
		}
		return records;
	}
}
