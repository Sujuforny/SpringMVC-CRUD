<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.16/dist/tailwind.min.css" rel="stylesheet">
<title>Student</title>
</head>
<body>
<h1 class = "text-center text-5xl py-10">Student Management </h1>
<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="px-6 py-3">
                    ID
                </th>
                <th scope="col" class="px-6 py-3">
                    NAME
                </th>
                <th scope="col" class="px-6 py-3">
                    GENDER
                </th>
                <th scope="col" class="px-6 py-3">
                    SUBJECT
                </th>
                 <th scope="col" class="px-6 py-3">
                    isDELETE
                </th>
                <th scope="col" class="px-6 py-3">
                    <span class="sr-only">Edit</span>
                </th>
            </tr>
        </thead>
   <tbody>
    <c:forEach var="student" items="${student}"> 
        <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
            <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                ${student.id}
            </th>
            <td class="px-6 py-4">
                ${student.name}
            </td>
            <td class="px-6 py-4">
                ${student.gender}
            </td>
            <td class="px-6 py-4">
                ${student.subject}
            </td>
            <td class="px-6 py-4">
                ${student.isDeleted}
            </td>
            <td class="px-6 py-4 text-right">
                <c:choose>
                    <c:when test="${student.isDeleted}">
                        <!-- If student is deleted, show a disabled link -->
                        <span class="text-gray-400">Edit</span>
                        <span class="text-gray-400">Delete</span>
                    </c:when>
                    <c:otherwise>
                        <!-- If student is not deleted, show regular links -->
                        <a href="editstudent/${student.id}" class="font-medium text-blue-600 dark:text-blue-500 hover:underline pe-[100px]">Edit</a>
                        <a href="delete-by-status/${student.id}" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Delete</a>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</tbody>
    </table>
</div>
</body>
</html>