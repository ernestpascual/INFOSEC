package controller;

public class ComputationsController {
	//Computing salesLoadAmount = salesLoadPercentage * investAmount based on the given table
	float salesLoadAmount(float investAmount){
		float salesLoadAmount = 0;
		if (investAmount > 1000 && investAmount < 99999.99){
			salesLoadAmount = (float) (investAmount * 0.02);
		} else if (investAmount > 100000  && investAmount < 499999.99){
			salesLoadAmount = (float) (investAmount * 0.015);
		}else if (investAmount > 500000  && investAmount < 1999999.99){
			salesLoadAmount = (float) (investAmount * 0.01);
		} else if (investAmount > 2000000){
			salesLoadAmount = (float) (investAmount * 0.005);
		}
		return salesLoadAmount;
		}

	//Computing for the Net Amount invested
	float netAmountInvested(float investAmount, float salesLoadAmount){
		float netAmountInvested = investAmount - salesLoadAmount;
		return netAmountInvested;
		}

	// Determining fund type to output NAVPU amount of the type of fund
	int fundType(String fundType) {
		int fundTypeModifier = 0;
		if(fundType.equals("SALEF")) {
			fundTypeModifier =  0;
		}else if(fundType.equals("SALBF")){
			fundTypeModifier =  1;
		}else if(fundType.equals("SALFIF")){
			fundTypeModifier =  2;
		}
		return fundTypeModifier;
		}
	
	float navpsValue(String fundType) {
		float[] navpsValues = {(float) 5.8222, (float) 2.7205,(float) 2.2136};
		float value = 0;
		if(fundType.equals("SALEF")) {
			value =  navpsValues[0];
		}else if(fundType.equals("SALBF")){
			value = navpsValues[1];
		}else if(fundType.equals("SALFIF")){
			value = navpsValues[2];
		}
			return value;
		}

	//Computing for the number of share of the shareholder
	int computeNumberOfShares(float netAmountInvested, int fundType){
		float[] navpsValues = {(float) 5.8222, (float) 2.7205,(float) 2.2136};
		float navps = navpsValues[fundType];
		float numberOfShares = netAmountInvested/navps;
		return (int) numberOfShares;
		}
}
