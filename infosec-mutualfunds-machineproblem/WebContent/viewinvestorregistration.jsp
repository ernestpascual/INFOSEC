<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
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
  <div class="animated fadeInDown">
    <div class="container">
      <div class="logo"> 
        <h1>Registered!</h1>
	</div>
<p>Last Name: <b>${investor.investorLastName}</b></p>
<p>First Name: <b>${investor.investorFirstName}</b></p>
<p>Fund Type: <b>${investor.fundType}</b></p>
<p>Amount Invested:  <b>${investor.investAmount}</b></p>
<p>NAVPS: <b>Php ${investor.navps} (as of November 17, 2017)</b></p>
<p>Sales Load Amount: <b>${investor.salesLoadAmount}</b></p>
<p>Net Amount Invested:  <b>${investor.netAmount}</b></p>
<p>Total Number of Shares:  <b>${investor.totalShares}</b></p>
<hr/>
<p><form action='ListAllRecordsServlet'>
<button class="btn btn-3" type="submit">View Records</button>
</form>
<hr/>
<form action='index.jsp'>
<button class="btn btn-3"  type="submit"> GO BACK</button>
</form>
</div></div> </div>
<footer>
  <div class="container">© 2017 First Metro Asset Management Inc. All rights reserved.</div>
</footer>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-beta1/jquery.min.js'></script>
</body>
</html>