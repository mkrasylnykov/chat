<%-- 
    Document   : color
    Created on : 18.09.2011, 21:59:02
    Author     : jab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>Text Color</title>
	<script language="JavaScript" type="text/javascript">
	<!--
	function selectColor(color) {
		self.parent.setColor(color);
	}
	
	function InitColorPalette() {
		if (document.getElementsByTagName)
			var x = document.getElementsByTagName('TD');
		else if (document.all)
			var x = document.all.tags('TD');
		for (var i=0;i<x.length;i++) {
			x[i].onclick = click;
		}
	}
	
	function click() {
		selectColor(this.id);
	}
	//-->
	</script>
</head>
<body bgcolor="white" onLoad="InitColorPalette()" leftmargin="0" rightmargin="0" marginwidth="0" marginheight="0" topmargin="0" bottommargin="0">
<table width="150" height="100" cellpadding="0" cellspacing="1" border="1" align="center">
	<tr>
		<td id="#FFFFFF" bgcolor="#FFFFFF" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FFCCCC" bgcolor="#FFCCCC" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FFCC99" bgcolor="#FFCC99" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FFFF99" bgcolor="#FFFF99" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FFFFCC" bgcolor="#FFFFCC" width="10" height="10"><img width="1" height="1"></td>
		<td id="#99FF99" bgcolor="#99FF99" width="10" height="10"><img width="1" height="1"></td>
		<td id="#99FFFF" bgcolor="#99FFFF" width="10" height="10"><img width="1" height="1"></td>
		<td id="#CCFFFF" bgcolor="#CCFFFF" width="10" height="10"><img width="1" height="1"></td>
		<td id="#CCCCFF" bgcolor="#CCCCFF" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FFCCFF" bgcolor="#FFCCFF" width="10" height="10"><img width="1" height="1"></td>
	</tr>
	<tr>
		<td id="#CCCCCC" bgcolor="#CCCCCC" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FF6666" bgcolor="#FF6666" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FF9966" bgcolor="#FF9966" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FFFF66" bgcolor="#FFFF66" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FFFF33" bgcolor="#FFFF33" width="10" height="10"><img width="1" height="1"></td>
		<td id="#66FF99" bgcolor="#66FF99" width="10" height="10"><img width="1" height="1"></td>
		<td id="#33FFFF" bgcolor="#33FFFF" width="10" height="10"><img width="1" height="1"></td>
		<td id="#66FFFF" bgcolor="#66FFFF" width="10" height="10"><img width="1" height="1"></td>
		<td id="#9999FF" bgcolor="#9999FF" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FF99FF" bgcolor="#FF99FF" width="10" height="10"><img width="1" height="1"></td>
	</tr>
	<tr>
		<td id="#C0C0C0" bgcolor="#C0C0C0" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FF0000" bgcolor="#FF0000" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FF9900" bgcolor="#FF9900" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FFCC66" bgcolor="#FFCC66" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FFFF00" bgcolor="#FFFF00" width="10" height="10"><img width="1" height="1"></td>
		<td id="#33FF33" bgcolor="#33FF33" width="10" height="10"><img width="1" height="1"></td>
		<td id="#66CCCC" bgcolor="#66CCCC" width="10" height="10"><img width="1" height="1"></td>
		<td id="#33CCFF" bgcolor="#33CCFF" width="10" height="10"><img width="1" height="1"></td>
		<td id="#6666CC" bgcolor="#6666CC" width="10" height="10"><img width="1" height="1"></td>
		<td id="#CC66CC" bgcolor="#CC66CC" width="10" height="10"><img width="1" height="1"></td>
	</tr>
	<tr>
		<td id="#999999" bgcolor="#999999" width="10" height="10"><img width="1" height="1"></td>
		<td id="#CC0000" bgcolor="#CC0000" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FF6600" bgcolor="#FF6600" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FFCC33" bgcolor="#FFCC33" width="10" height="10"><img width="1" height="1"></td>
		<td id="#FFCC00" bgcolor="#FFCC00" width="10" height="10"><img width="1" height="1"></td>
		<td id="#33CC00" bgcolor="#33CC00" width="10" height="10"><img width="1" height="1"></td>
		<td id="#00CCCC" bgcolor="#00CCCC" width="10" height="10"><img width="1" height="1"></td>
		<td id="#3366FF" bgcolor="#3366FF" width="10" height="10"><img width="1" height="1"></td>
		<td id="#6633FF" bgcolor="#6633FF" width="10" height="10"><img width="1" height="1"></td>
		<td id="#CC33CC" bgcolor="#CC33CC" width="10" height="10"><img width="1" height="1"></td>
	</tr>
	<tr>
		<td id="#666666" bgcolor="#666666" width="10" height="10"><img width="1" height="1"></td>
		<td id="#990000" bgcolor="#990000" width="10" height="10"><img width="1" height="1"></td>
		<td id="#CC6600" bgcolor="#CC6600" width="10" height="10"><img width="1" height="1"></td>
		<td id="#CC9933" bgcolor="#CC9933" width="10" height="10"><img width="1" height="1"></td>
		<td id="#999900" bgcolor="#999900" width="10" height="10"><img width="1" height="1"></td>
		<td id="#009900" bgcolor="#009900" width="10" height="10"><img width="1" height="1"></td>
		<td id="#339999" bgcolor="#339999" width="10" height="10"><img width="1" height="1"></td>
		<td id="#3333FF" bgcolor="#3333FF" width="10" height="10"><img width="1" height="1"></td>
		<td id="#6600CC" bgcolor="#6600CC" width="10" height="10"><img width="1" height="1"></td>
		<td id="#993399" bgcolor="#993399" width="10" height="10"><img width="1" height="1"></td>
	</tr>
	<tr>
		<td id="#333333" bgcolor="#333333" width="10" height="10"><img width="1" height="1"></td>
		<td id="#660000" bgcolor="#660000" width="10" height="10"><img width="1" height="1"></td>
		<td id="#993300" bgcolor="#993300" width="10" height="10"><img width="1" height="1"></td>
		<td id="#996633" bgcolor="#996633" width="10" height="10"><img width="1" height="1"></td>
		<td id="#666600" bgcolor="#666600" width="10" height="10"><img width="1" height="1"></td>
		<td id="#006600" bgcolor="#006600" width="10" height="10"><img width="1" height="1"></td>
		<td id="#336666" bgcolor="#336666" width="10" height="10"><img width="1" height="1"></td>
		<td id="#000099" bgcolor="#000099" width="10" height="10"><img width="1" height="1"></td>
		<td id="#333399" bgcolor="#333399" width="10" height="10"><img width="1" height="1"></td>
		<td id="#663366" bgcolor="#663366" width="10" height="10"><img width="1" height="1"></td>
	</tr>
	<tr>
		<td id="#000000" bgcolor="#000000" width="10" height="10"><img width="1" height="1"></td>
		<td id="#330000" bgcolor="#330000" width="10" height="10"><img width="1" height="1"></td>
		<td id="#663300" bgcolor="#663300" width="10" height="10"><img width="1" height="1"></td>
		<td id="#663333" bgcolor="#663333" width="10" height="10"><img width="1" height="1"></td>
		<td id="#333300" bgcolor="#333300" width="10" height="10"><img width="1" height="1"></td>
		<td id="#003300" bgcolor="#003300" width="10" height="10"><img width="1" height="1"></td>
		<td id="#003333" bgcolor="#003333" width="10" height="10"><img width="1" height="1"></td>
		<td id="#000066" bgcolor="#000066" width="10" height="10"><img width="1" height="1"></td>
		<td id="#330099" bgcolor="#330099" width="10" height="10"><img width="1" height="1"></td>
		<td id="#330033" bgcolor="#330033" width="10" height="10"><img width="1" height="1"></td>
	</tr>
</table>
</body>
</html>

