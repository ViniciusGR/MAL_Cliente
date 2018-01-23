<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
#tabelaDeAnimes {
	float: left;
	width: 45%;
}

#tabelaDeMangas {
	float: right;
	width: 45%;
}
</style>
</head>
<body>
	<table id="tabelaDeAnimes">
		<c:forEach var="entry" items="${anime.entries}">
			<tr>
				<td><img src="${entry.image}" /></td>
				<td><a href="https://myanimelist.net/anime/${entry.id}/">${entry.title}</a></td>
			</tr>
		</c:forEach>
	</table>
	<table id="tabelaDeMangas">
		<c:forEach var="entry" items="${manga.entries}">
			<tr>
				<td><img src="${entry.image}" /></td>
				<td><a href="https://myanimelist.net/manga/${entry.id}/">${entry.title}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>