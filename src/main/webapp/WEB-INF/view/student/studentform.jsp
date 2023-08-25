
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

		<h1>Add New Student</h1>
       <form:form method="post" action="save-student">  
      	<table >  
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
          <td>Gender :</td>  
          <td><form:input path="gender" /></td>
         </tr> 
         <tr>  
          <td>Subject :</td>  
          <td><form:input path="subject" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
