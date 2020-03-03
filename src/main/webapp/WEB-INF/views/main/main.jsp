<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
<title>SeoyoeonRental</title>
<link rel="stylesheet" href="resources/css/main/main.css">
</head>
<body id="myPage" data-spy="scroll" data-offset="60">
	<jsp:include page="../common/topNav.jsp" />

	<!-- Carousel Section -->
	<div class="">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="https://via.placeholder.com/500" alt="Chania">
					<div class="carousel-caption">
						<h3>Los Angeles</h3>
						<p>LA is always so much fun!</p>
					</div>
				</div>

				<div class="item">
					<img src="https://via.placeholder.com/500" alt="Chicago">
					<div class="carousel-caption">
						<h3>Chicago</h3>
						<p>Thank you, Chicago!</p>
					</div>
				</div>

				<div class="item">
					<img src="https://via.placeholder.com/500" alt="New York">
					<div class="carousel-caption">
						<h3>New York</h3>
						<p>We love the Big Apple!</p>
					</div>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>

	<!-- mfpRental Best 3 Section -->
	<div id="" class="container-fluid text-center bg-grey main-section">
		<h2>Portfolio</h2>
		<br>
		<h4>What we have created</h4>
		<div class="row text-center slideanim">
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="paris.jpg" alt="Paris" width="400" height="300">
					<p>
						<strong>Paris</strong>
					</p>
					<p>Yes, we built Paris</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="newyork.jpg" alt="New York" width="400" height="300">
					<p>
						<strong>New York</strong>
					</p>
					<p>We built New York</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="sanfran.jpg" alt="San Francisco" width="400" height="300">
					<p>
						<strong>San Francisco</strong>
					</p>
					<p>Yes, San Fran is ours</p>
				</div>
			</div>
		</div>
		<br>
	</div>

	<!-- InstallBoard Section -->
	<div id="" class="container-fluid text-center bg-grey main-section">
		<h2>Portfolio</h2>
		<br>
		<h4>What we have created</h4>
		<div class="row text-center slideanim">
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="paris.jpg" alt="Paris" width="400" height="300">
					<p>
						<strong>Paris</strong>
					</p>
					<p>Yes, we built Paris</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="newyork.jpg" alt="New York" width="400" height="300">
					<p>
						<strong>New York</strong>
					</p>
					<p>We built New York</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="sanfran.jpg" alt="San Francisco" width="400" height="300">
					<p>
						<strong>San Francisco</strong>
					</p>
					<p>Yes, San Fran is ours</p>
				</div>
			</div>
		</div>
		<br>
	</div>

	<!-- QuestionBoard Section -->
	<div id="" class="container-fluid text-center bg-grey main-section">
		<h2>문의하세요.</h2>
		<br />
		<div id="questionBoardLeft">
			<h3>1:1 문의하기</h3>
			<br />
			<button type="button" class="btn btn-primary btn-lg">로그인 후
				이용해주세요.</button>
		</div>
		<div id="questionBoardRight">
			<h3>실시간 문의현황</h3>
			<br />
			<div class="container" style="width:100%">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Firstname</th>
							<th>Lastname</th>
							<th>Email</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>John</td>
							<td>Doe</td>
							<td>john@example.com</td>
						</tr>
						<tr>
							<td>Mary</td>
							<td>Moe</td>
							<td>mary@example.com</td>
						</tr>
						<tr>
							<td>July</td>
							<td>Dooley</td>
							<td>july@example.com</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<br />
	</div>

	<!-- Company Section -->
	<div id="" class="container-fluid text-center bg-grey main-section">
		<h2>Portfolio</h2>
		<br>
		<h4>What we have created</h4>
		<div class="row text-center slideanim">
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="paris.jpg" alt="Paris" width="400" height="300">
					<p>
						<strong>Paris</strong>
					</p>
					<p>Yes, we built Paris</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="newyork.jpg" alt="New York" width="400" height="300">
					<p>
						<strong>New York</strong>
					</p>
					<p>We built New York</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="sanfran.jpg" alt="San Francisco" width="400" height="300">
					<p>
						<strong>San Francisco</strong>
					</p>
					<p>Yes, San Fran is ours</p>
				</div>
			</div>
		</div>
		<br>
	</div>

	<jsp:include page="../common/footer.jsp" />
	<script type="text/javascript" src="resources/js/main/main.js"></script>
</body>
</html>