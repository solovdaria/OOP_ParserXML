<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
	
	<html>
		<head>
			<title>Candy collection</title>	
		</head>
		<body>
			<table border = "1">
				<tr>
					<th>Name</th>
					<th>Production</th>
					<th>Energy</th>
					<th>Production</th>
					<th>Value</th>
				</tr>
				<xsl:for-each select = "collection/candy">
					<tr>
						<td><xsl:value-of select="name"/></td>
						<td><xsl:value-of select="production"/></td>
						<td><xsl:value-of select="energy"/></td>
						<td>
							Water: <xsl:value-of select="ingridients/water"/> <br/>
							Sugar: <xsl:value-of select="ingridients/sugar"/> <br/>
							Fructose: <xsl:value-of select="ingridients/fructose"/>
						</td>
						<td>
							Proteins: <xsl:value-of select="value/protein"/><br/>
							Fats: <xsl:value-of select="value/fat"/><br/>
							Carbohydrates: <xsl:value-of select="value/carbohydrate"/>
						</td>
					</tr>
				</xsl:for-each>
			</table>
		</body>
	</html>
	
	</xsl:template>
</xsl:stylesheet>