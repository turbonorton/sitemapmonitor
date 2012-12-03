<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Sitemap Delivery Monitor</title>
</head>
<body>
<h1>
	Useage
</h1>

<h2>Configs</h2>
<p>
	Currently defined in application.properties within the war.<br/>
	<br/>
	<ul>
		<li>dailymail</li>
		<li>thisismoney</li>
	</ul>
</p>

<h2>Simple Healthcheck</h2>
<P>  Execute a simple healthcheck with <strong>/simple/{config}</strong>.  This returns the number of minutes 
since the sitemap was updated.  This is designed for use with tools such as SiteScope.</P>

</body>
</html>
