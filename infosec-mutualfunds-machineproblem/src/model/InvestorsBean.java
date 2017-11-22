package model;
import java.sql.*;

import utility.Security;
// make a database investorID INT, investorFirstName VARCHAR(30), investorLastName VARCHAR(30)
// investAmount FLOAT, fundType VARCHAR(5)

public class InvestorsBean {
// client input
private String investorFirstName;
private String investorLastName;
private float investAmount;
private String fundType;
public String getInvestorFirstName() {
	return investorFirstName;
}
public void setInvestorFirstName(String investorFirstName) {
	this.investorFirstName = investorFirstName;
}
public String getInvestorLastName() {
	return investorLastName;
}
public void setInvestorLastName(String investorLastName) {
	this.investorLastName = investorLastName;
}
public float getInvestAmount() {
	return investAmount;
}
public void setInvestAmount(float investAmount) {
	this.investAmount = investAmount;
}
public String getFundType() {
	return fundType;
}
public void setFundType(String fundType) {
	this.fundType = fundType;
}

// computations for storage
private float navps;
private float salesLoadAmount;
private float netAmount;
private int totalShares;


public float getNavps() {
	return navps;
}
public void setNavps(float navps) {
	this.navps = navps;
}
public float getSalesLoadAmount() {
	return salesLoadAmount;
}
public void setSalesLoadAmount(float salesLoadAmount) {
	this.salesLoadAmount = salesLoadAmount;
}
public float getNetAmount() {
	return netAmount;
}
public void setNetAmount(float netAmount) {
	this.netAmount = netAmount;
}
public int getTotalShares() {
	return totalShares;
}
public void setTotalShares(int totalShares) {
	this.totalShares = totalShares;
}
private Connection getConnectionDB() {
	Connection connection = null;
	// don't forget to change the connection 
	try{
		Class.forName("com.mysql.jdbc.Driver");
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
	String sql = "insert into famiInvestors" +
					"(investorFirstName, investorLastName, investAmount, " + 
						"fundType, navps, salesLoadAmount, netAmount, totalShares)" +
						" values (?,?,?,?,?,?,?,?)";
	try{
		Connection connection = getConnectionDB();
		if (connection != null){ 
			PreparedStatement prep =  connection.prepareStatement(sql);
			prep.setString(1, Security.encrypt(this.investorFirstName));
			prep.setString(2, Security.encrypt(this.investorLastName));
			prep.setFloat(3, this.investAmount);
			prep.setString(4, Security.encrypt(this.fundType));
			prep.setFloat(5, this.navps);
			prep.setFloat(6, this.salesLoadAmount);
			prep.setFloat(7, this.netAmount);
			prep.setInt(8, this.totalShares);
			prep.executeUpdate();
		}
	} catch (SQLException sqle){
		sqle.printStackTrace();
	}			
}

public ResultSet getRecords(){
	ResultSet records = null;
	String sql="select * from famiInvestors;";
	try{
		Connection connection = getConnectionDB();
		
		if (connection != null){ 
		PreparedStatement prep = connection.prepareStatement(sql);
			records = prep.executeQuery();
		}
	} catch (SQLException sqle){
		sqle.printStackTrace();
	}
	return records;
}


}
