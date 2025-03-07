<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Character Stats</title>
    <style>
        table {
            width: 30%;
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
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>"<%= request.getAttribute("nickname") %>" 의 스탯 정보</h1>

    <table>
        <tr>
            <th>스탯</th>
            <th>값</th>
        </tr>
        <tr>
            <td>최소 스탯공격력</td>
            <td><%= request.getAttribute("minAtkValue") != null ? request.getAttribute("minAtkValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>최대 스탯공격력</td>
            <td><%= request.getAttribute("maxAtkValue") != null ? request.getAttribute("maxAtkValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>데미지</td>
            <td><%= request.getAttribute("dmgValue") != null ? request.getAttribute("dmgValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>보스 몬스터 데미지</td>
            <td><%= request.getAttribute("bossDmgValue") != null ? request.getAttribute("bossDmgValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>최종 데미지</td>
            <td><%= request.getAttribute("finalDmgValue") != null ? request.getAttribute("finalDmgValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>방어율 무시</td>
            <td><%= request.getAttribute("ignArmorValue") != null ? request.getAttribute("ignArmorValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>크리티컬 확률</td>
            <td><%= request.getAttribute("criChanceValue") != null ? request.getAttribute("criChanceValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>크리티컬 데미지</td>
            <td><%= request.getAttribute("criDmgValue") != null ? request.getAttribute("criDmgValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>스타포스</td>
            <td><%= request.getAttribute("starFoceValue") != null ? request.getAttribute("starFoceValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>아케인포스</td>
            <td><%= request.getAttribute("arcaneForceValue") != null ? request.getAttribute("arcaneForceValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>어센틱포스</td>
            <td><%= request.getAttribute("authenticForceValue") != null ? request.getAttribute("authenticForceValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>STR</td>
            <td><%= request.getAttribute("strValue") != null ? request.getAttribute("strValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>DEX</td>
            <td><%= request.getAttribute("dexValue") != null ? request.getAttribute("dexValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>INT</td>
            <td><%= request.getAttribute("intValue") != null ? request.getAttribute("intValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>LUK</td>
            <td><%= request.getAttribute("lukValue") != null ? request.getAttribute("lukValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>HP</td>
            <td><%= request.getAttribute("hpValue") != null ? request.getAttribute("hpValue") : "N/A" %></td>
        </tr>
        <tr>
            <td>MP</td>
            <td><%= request.getAttribute("mpValue") != null ? request.getAttribute("mpValue") : "N/A" %></td>
        </tr>
    </table>
</body>
</html>
