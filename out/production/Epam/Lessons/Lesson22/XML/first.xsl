<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:math="http://www.w3.org/2005/xpath-functions/math"
    xmlns:myspace="http://aaa.com/Purchase"
    exclude-result-prefixes="xs"
    version="3.0">
 <xsl:template match="/">
  <html>
     <body>
       <table>
          <th>
              <td>id</td>
              <td>firstName</td>
              <td>secondName</td>
              <td>city</td>
              <td>country</td>
          </th>
          <xsl:for-each select="root/person"> 
            <tr>
              <td><xsl:value-of select="@id"/></td>
              <td><xsl:value-of select="firstName"/></td>
              <td><xsl:value-of select="secondName"/></td>
              <td><xsl:value-of select="myspace:city"/></td>
              <td><xsl:value-of select="myspace:country"/></td>
            </tr> 
          
          
          
          
          </xsl:for-each>
        </table>  
       
         
     </body>      
  </html>
 </xsl:template>
          













</xsl:stylesheet>