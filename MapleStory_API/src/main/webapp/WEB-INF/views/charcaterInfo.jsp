<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.entity.TotalStatsDetails" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Character Info</title>
    <style>
        table {
            width: 50%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #f4f4f4;
        }
        h1, h2 {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>캐릭터 정보</h1>
    <h2>캐릭터 닉네임 : <%= request.getAttribute("nickname") %></h2>
    <!-- <h2>캐릭터 직업 : <%= request.getAttribute("character_class") %></h2>  -->
    <h2>정보 : <%= request.getAttribute("details2") %></h2>
    

	<h2>캐릭터의 전체 스탯</h2>
    <table>
        <tr>
            <th>스탯</th>
            <th>값</th>
        </tr>
        <%
            List<TotalStatsDetails> stats = (List<TotalStatsDetails>) request.getAttribute("stats");
            if (stats != null) {
                for (TotalStatsDetails stat : stats) {
        %>
        <tr>
            <td><%= stat.getStatName() %></td>
            <td><%= stat.getStatValue() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="2">No stats found.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
