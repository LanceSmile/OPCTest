
<%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.6.7/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.6.7//themes/icon.css"/>
<!--2个js文件 ,要先引入jquery,然后再引入easyui-->
<script src="${pageContext.request.contextPath}/jquery-easyui-1.6.7/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/jquery-easyui-1.6.7/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
<script>

    <c:forEach items="${cs}" var="c" varStatus="st">
        <c:out value="${c.id}" />
        <c:out value="${c.name}" />
    </c:forEach>


    $("#language").combobox({
        url : "getDictValueByType",
        method: 'get',
        valueField : 'id',
        textField : 'name',
        panelHeight: 'auto',
        editable: false,
        required: true,
        onLoadSuccess: function() {
            var data = $(this).combobox('getData');
            if (data.length > 0) {
                $(this).combobox('select', data[0].name);
            }
        }
    });
</script>
<html>
<head>
<body>
    <h2>Basic ComboBox</h2>
    <p>Type in ComboBox to try auto complete.</p>
    <div style="margin:20px 0"></div>

    <h2>Load Dynamic ComboBox Data</h2>
    <p>请选择OPC服务器：</p>
    <select class="easyui-combobox" name="state" style="width:200px;">
        <c:forEach items="${cs}" var="c" varStatus="st">
            <option value="${c.id}">"${c.name}"</option>
        </c:forEach>
    </select>

</body>

</head>
<body>

</body>
</html>
