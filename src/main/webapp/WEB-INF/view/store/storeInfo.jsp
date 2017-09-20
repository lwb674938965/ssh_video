<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
		<meta charset="utf-8">
		<title>考试测试  - 20170901</title>
		<link rel="stylesheet" href="http://cdn.amazeui.org/amazeui/2.7.2/css/amazeui.min.css">
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/css/jquery-confirm.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/jquery-confirm.js"></script>
		<style>
			th{
				text-align: center;
			}
			td{
				text-align: center;
			}
			.dataDiv{
				margin-top: 50px;
			}
		</style>
		<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
		<script src="http://cdn.amazeui.org/amazeui/2.7.2/js/amazeui.min.js"></script>
		
		<script>
			$(function(){
				//console.log("start");
				$("#editBtn").click(function(){
					$('#doc-modal').modal('open');
					
				});
				$('#cancleBtn').click(function(){
					$('#doc-modal').modal('close');
				});
				$('#submitBtn').click(function(){
					$('#doc-modal').modal('close');
				});
				
				$('#editImg').click(function(){
					$('#imgForm').removeClass('am-hide');
					$('#editImg').hide();
					
				});
				$('#cancleImg').click(function(){
					$('#imgFile').val('');
					$('#imgForm').addClass('am-hide');
					$('#editImg').show();
				});
				$('#updateImg').click(function(){
					$("#imgForm").submit();

				});	
				
				function addStore(the){

					$.post("${pageContext.request.contextPath }/front/store/storeInfo.action",
						$("#formId").serialize());
			
				}
				
				
				
			});
			
			
				
				
		
			
			
		</script>
	
</head>
<body>

		<div class="am-container dataDiv">
			<section class="am-panel am-panel-primary">
			  <header class="am-panel-hd">
			    <h3 class="am-panel-title">商家信息展示</h3>
			  </header>
			  <div class="am-panel-bd">
			    <table class="am-table am-table-bordered">

				    <tbody>
				    	<tr>
					    	<th class="am-u-sm-4">商家名称</th>
					    	<td class="am-u-sm-8">${store.storename }</td>
				    	</tr>
				    	<tr>
					    	<th class="am-u-sm-4">法人</th>
					    	<td class="am-u-sm-8">${store.storeperson }</td>
				    	</tr>
				    	<tr>
					    	<th class="am-u-sm-4">联系地址</th>
					    	<td class="am-u-sm-8">${store.address }</td>
				    	</tr>
				    	<tr>
					    	<th class="am-u-sm-4">联系电话</th>
					    	<td class="am-u-sm-8">${store.telephone }</td>
				    	</tr>
				    	<tr>
					    	<th class="am-u-sm-4">所属行业</th>
					    	<td class="am-u-sm-8">${store.trade }</td>
				    	</tr>
				    	<tr>
					    	<th class="am-u-sm-4">备注说明</th>
					    	<td class="am-u-sm-8">${store.note }</td>
				    	</tr>
				    
				    	<tr>
					    	<th class="am-u-sm-4">营业执照</th>
					    	<td class="am-u-sm-8">
					    		<div>
					    		<a title="点击查看大图" href="img/f76da06c940cbefcdb1253542df627e0_images_uuid=0a787663-0f77-45f5-8a7b-194d530bfa42.jpg.jpg" target="_blank">
					    			<img src="${store.licence }" width="120px">
					    		</a>
					    		</div>
							  	<div class="am-text-right">
							  		<form class="am-form-inline am-hide" id="imgForm" enctype="multipart/form-data" style="margin-top: 10px;" action="${pageContext.request.contextPath }/front/store/addLicence.action" method="post">
							  			 <div class="am-form-group">
									      <input type="file" id="imgFile" name="licencefile">									      
									   
									    </div>
							  			   <a class="am-btn am-btn-default" id="updateImg">更新</a>
							  			<a href="javascript:void(0)" id="cancleImg">取消</a>
							  		</form>
							  		<a href="javascript:void(0);" id="editImg">编辑营业执照</a>
							  	</div>
					    	</td>
				    	</tr>
				    	
				    </tbody>
				</table>
				<p>信息录入时间：2017-08-20&nbsp;&nbsp;最后更新时间：2017-09-01</p>
			  </div>
			  <div class="am-panel-footer">
			  	<button class="am-btn am-btn-primary" id="editBtn">编辑基本信息</button>
			  	
			  </div>
			</section>
		</div>
		
		
		<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal">
		  <div class="am-modal-dialog">
		    <div class="am-modal-hd">
		      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a>
		    </div>
		    <div class="am-modal-bd">
		      	<form class="am-form am-text-left am-form-horizontal" method="post" id="formId" onsubmit="return addStore(this)">
				
				    <div class="am-form-group">
				      <label for="doc-ipt-1" class="am-u-sm-3 am-form-label">商家名称</label>
				      <div class="am-u-sm-9">
				      	<input type="text" class="" id="doc-ipt-1" placeholder="商家名称" value="智游教育" name="storename">
				      </div>
				    </div>
				 	<div class="am-form-group">
				      <label for="doc-ipt-2" class="am-u-sm-3 am-form-label">法人</label>
				      <div class="am-u-sm-9">
				      <input type="text" class="" id="doc-ipt-2" placeholder="法人" value="张三" name="storeperson">
				      </div>
				    </div>
				    <div class="am-form-group">
				      <label for="doc-ipt-3" class="am-u-sm-3 am-form-label">联系地址</label>
				      <div class="am-u-sm-9">
				      <input type="text" class="" id="doc-ipt-3" placeholder="联系地址" value="郑州经开区河南通信产业园" name="address">
				      </div>
				    </div>
				    <div class="am-form-group">
				      <label for="doc-ipt-4" class="am-u-sm-3 am-form-label">联系电话</label>
				      <div class="am-u-sm-9">
				      <input type="text" class="" id="doc-ipt-4" placeholder="联系电话" value="0371-66667777" name="telephone">
				      </div>
				    </div>
				
				    <div class="am-form-group">
				      <label for="doc-select-1" class="am-u-sm-3 am-form-label">行业</label>
				      <div class="am-u-sm-9">
				      <select id="doc-select-1" name="trade">
				      	<option value="0">选择商家行业性质</option>
				        <option value="教育" >教育</option>
				        <option value="视频">视频</option>
				        <option value="文化">文化</option>
				        <option value="体育">体育</option>
				      </select>
				      </div>
				    </div>
				
				    <div class="am-form-group">
				      <label for="doc-ta-1" class="am-u-sm-3 am-form-label">备注说明</label>
				      <div class="am-u-sm-9">
				      <textarea class="" rows="5" id="doc-ta-1" name="note">已有备注信息</textarea>
				      </div>
				    </div>
				
				    <p class="am-fr">
				    	<button type="button" class="am-btn am-btn-default" id="cancleBtn">取消</button>
				    	<button type="submit" class="am-btn am-btn-primary" id="submitBtn">提交</button></p>
				</form>
		      	
		      	
		    </div>
		  </div>
		</div>
</body>
</html>