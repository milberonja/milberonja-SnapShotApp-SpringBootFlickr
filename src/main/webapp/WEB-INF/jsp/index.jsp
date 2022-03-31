<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>SnapShot</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/css/style.css">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans|Lobster" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<h1>SnapShot</h1>
<form class="search" action="/showSearchedPhotos" style="margin:auto; max-width:700px">
    <input type="text" placeholder="Search..." name="search" oninput="checkIsEmpty()" id="searchInput">
    <button type="submit" id="searchBtn"><i class="fa fa-search"></i></button>
</form>
<div class="buttonContainer" style="margin:auto; max-width:700px">
    <button type="button" onclick='btnClicked("montains")'>Montains</button>
    <button type="button" onclick='btnClicked("beaches")'>Beaches</button>
    <button type="button" onclick='btnClicked("birds")'>Birds</button>
    <button type="button" onclick='btnClicked("food")'>Food</button>
</div><br>

<div class="topicName" style="margin:auto; max-width:700px"><h2><c:out value="${tag} Images"></c:out></h2></div><br>
<div class="galleryContainer" style="margin:auto">
	<c:choose>
		<c:when test="${message == 'noImages'}">
			<div class="topicName" style="margin:auto; max-width:700px">
				<h2><b>No Images Found</b></h2>
				<p>Please try a different search term</p>
			</div><br>
		</c:when>
		<c:otherwise>
			<c:forEach items="${photos}" var="photo">
			    <div class="imageContainer">
			        <img src="https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}_m.jpg" alt="${photo.title}">
			    </div>
		    </c:forEach>
		</c:otherwise>
	</c:choose>
</div><br>

<div class="gitHub" style="margin:auto"><h3>Fork me on GitHub</h3></div><br>

<script>
var searchBtn = document.getElementById("searchBtn");
function checkIsEmpty() {
  var searchInput = document.getElementById("searchInput").value;
  
  if(searchInput == ""){
    searchBtn.style.background = "#fcfcfc";
  } else {
    searchBtn.style.background = "#051c33";
  }
}

function btnClicked(name){
	location.href = "/showPhotos?tag=" + name;
}

</script>

</body>
</html>

