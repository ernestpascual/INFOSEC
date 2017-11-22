<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Registration</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.2.3/animate.min.css'>
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:400,300'>
<link rel="stylesheet" href="css/minimal.css">
</head>
<body>
<div class="jumbotron">
  <div id="black">
    <video id="video-bg" autoplay="" loop="">
    		<source src="img/Tourists.webm" type="video/webm"/>
      	<source src="img/Tourists.mp4" type="video/mp4"/>
    </video>
  </div>
<div class="container" id="main-wrapper">
 <div class="col-md-7 main-content">
 <h1>First Metro Asset Management Inc.</h1> 
 <p>Register now to avail our mutual funds. Minimum investment is Php 10,000. Enter your contact details below and choose your preferred product.</p>
 <p>SAVE & LEARN EQUITY FUND (SALEF) - for investors seeking high growth with high risk.</p>
 <p>SAVE & LEARN FIXED INCOME FUND (SALFIF) - for those who desire low to moderate income growth with low risk.</p>
 <p>SAVE & LEARN BALANCED FUND (SALBF) - for those who desire moderate growth and willing to assume moderate-to- high risk. </p>
 </div> </div> </div>
 <div class="container" id="main-wrapper">
  <div class="col-md-7 main-content">
   <h1> Register Now:</h1>
<div class="white-box">
<form action="ProcessRegistrationServlet" method="post"> 
<p> Enter Last Name:
	<input type="text" name="lastName" id="lastName" size="30" required>
	</p>
	<label id="failLN"></label>
<p> Enter First Name:
	<input type="text" name="firstName" id="firstName" size="30" required>
	</p>
	<label id="failFN"></label>
	
<p> Mutual Fund Type:
	<select name='fundType' id= 'fundType'>
	<option value="SALEF">SALEF </option>
	<option value="SALBF">SALBF </option>
	<option value="SALFIF">SALFIF</option>
	</select>
	</p>
	
<p> Amount to Invest:
	<input type="text" name="investAmount" id="investAmount" onKeyUp="checkInput()">
	</p>
	<label id="fail"></label>
	
<p> 
	<input type="submit" value = "Register" id="mySubmit" />&nbsp;&nbsp;&nbsp;
	<input type="reset"/>
</p>	
	
</form>
</div> </div> </div> 
<footer>
  <div class="container">© 2017 First Metro Asset Management Inc. All rights reserved.</div>
</footer>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-beta1/jquery.min.js'></script>
  <script>
  function checkInput(e){
	  if(parseInt(this.value) < 10000 || isNaN(this.value) ){
		  document.getElementById("fail").innerHTML = "Minimum amount must be Php 10 000!";  
		  document.getElementById("mySubmit").disabled = true;
	  }
	  else {
		  document.getElementById("mySubmit").disabled = false;
		  document.getElementById("fail").innerHTML = ""; 
	  }
  }
  	document.getElementById("investAmount").addEventListener("keyup",checkInput);
 	
 
  </script>
</body>
</html>