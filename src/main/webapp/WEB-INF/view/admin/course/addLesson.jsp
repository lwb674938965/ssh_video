<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>添加课程</title>
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
		<style>
			.container {
				border: 0px solid black;
				;
			}
		</style>
	</head>
	<body>
	         <jsp:include page="/WEB-INF/view/admin/admin.jsp">
			       <jsp:param value="course" name="fromJsp"/>
			</jsp:include>
		<div class="container">
			<div class="jumbotron">
				<h2>添加课程</h2>
			</div>
			<form class="form-horizontal" action="${pageContext.request.contextPath }/admin/course_addCourse" method="post">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">所属学科</label>
					<div class="col-sm-10">
						<select class="form-control" id="inputEmail3" name="subjectId">
							<option value="0">请选择所属学科</option>
							<c:forEach items="${addSubjectList }" var="aj">
							<option value="${aj.id }">${aj.subjectName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">标题</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3" placeholder="课程标题" name="courseName">
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">简介</label>
					<div class="col-sm-10">
						<textarea class="form-control"  placeholder="课程简介" name="courseDescr" rows="3"></textarea>
					</div>
				</div>
			
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">保存</button>
						<a class="btn btn-default" href="javascript:history.go(-1)">返回列表</a>
					</div>
				</div>
			</form>
			
			
		</div>
	</body>
</html>
