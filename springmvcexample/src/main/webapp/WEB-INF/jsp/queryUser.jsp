<%--
  Created by IntelliJ IDEA.
  User: renqun.yuan
  Date: 2015/11/27
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app>
<head>
    <title>queryUser</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"/>
    <script>
        function QueryUser($scope, $http) {
            $http.get('http://localhost:8080/user/queryUser').
            success(function (data) {
                $scope.user = data;
            });
        }
        function Hello($scope) {
            $scope.name = 'user';
            $scope.id = '54';
        }
    </script>
</head>
<body>
<div ng-controller="QueryUser">
    <p>userID: {{user.id}}</p>

    <p>userName: {{user.name}}</p>
</div>

<div ng-controller="Hello">
    <p>Id : {{id}}</p>
</div>
</body>
</html>
