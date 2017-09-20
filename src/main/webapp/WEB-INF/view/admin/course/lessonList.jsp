<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="bobo" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>视频添加-视频管理</title>
		<link href="${pageContext.request.contextPath }/res/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/res/css/jquery-confirm.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/res/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/res/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/res/js/jquery-confirm.js"></script>
		<style>
			.container {
				border: 0px solid black;
			
			}
		</style>
		
		<script type="text/javascript">
				
				function deleteCourse(id){
					
					$.confirm({
					    title: '警告',
					    content: '您确定要删除吗!!!',
					    buttons: {
					        confirm:{
					        	 text: '十分肯定',
					        	 action:function () { 
					        		 $.ajax({
										 dataType:"json",
										 data:{"thisId":id},
										 type:"post",
										 url:"${pageContext.request.contextPath }/ajax/ajax_deleteCourse",
										 success:function(msg){
											 if(msg.orSuccess){
												 location.reload();
											 }
										 }	 
									 });
					             }
					        },
					                     取消: function () {
					        },
					        
					    }
					});
						
				}	
				
		
		</script>
	</head>

	<body>
	         <jsp:include page="/WEB-INF/view/admin/admin.jsp">
			       <jsp:param value="course" name="fromJsp"/>
			</jsp:include>
	    <div class="container">
			<div class="jumbotron">
				<h2>课程列表-课程管理</h2>
			</div>
			<div>
				<div class="navbar-form navbar-left">
					<a href="${pageContext.request.contextPath }/admin/course_addCourseView" class="btn btn-primary">添加课程</a>
				</div>
				<div style="margin-top: 10px;">
					<table class="table table-hover">
						<tr>
							<th class="col-md-0">序号</th>
							<th class="col-md-1">标题</th>
							<th class="col-md-1">学科</th>
							<th class="col-md-10">简介</th>
							<th class="col-md-0">编辑</th>
							<th class="col-md-0">删除</th>
						</tr>
						<c:forEach items="${page1.rows }" var="course" varStatus="status">
						<tr>
							<td>${status.count+(page1.page-1)*5 }</td>
							<td>${course.courseName }</td>
							<td>${course.subject.subjectName }</td>
							<td>${course.courseDescr }</td>
							<td>
								<a class="glyphicon glyphicon-edit" role="button" href="${pageContext.request.contextPath }/admin/course_editCourseView?thisId=${course.id}&page=${page1.page}"></a>
							</td>
							<td>
								<a class="glyphicon glyphicon-trash abc" onclick="deleteCourse(${course.id})" role="button"></a>
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>
			</div>
             <div>
			   <div style="float:right;margin-right: 50px;margin-top: -10px; ">  
			 
                <bobo:page url="${pageContext.request.contextPath }/admin/course_courseList"></bobo:page>
                </div>
               <div style="float:right; margin-right:2px; margin-top: 15px;font-size: 20px;">共有${page1.total }条</div>
           </div>
             
             
		</div>
	</body>	

</html>