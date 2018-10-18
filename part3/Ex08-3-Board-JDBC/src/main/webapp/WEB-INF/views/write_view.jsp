<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>write_view</title>
<script type="text/javascript" src="./naver_editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</head>

	<script>
		function form_check(){
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
			document.write_form.submit();
		}	
	</script>

<body>


	<table cellpadding="0" cellspacing="0" border="1">
		<form name="write_form" action="write.do" method="post">
			<tr>
				<td>이름</td>
				<td> <input type="text" name="bName" size = "50"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td> <input type="text" name="bTitle" size = "50"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td> 
					<textarea name="bContent" id="ir1" rows="10" cols="100">
					</textarea>
					<script type="text/javascript">
						var oEditors = [];
						nhn.husky.EZCreator.createInIFrame({
						    oAppRef: oEditors,
						    elPlaceHolder: "ir1",
						    sSkinURI: "./naver_editor/SmartEditor2Skin.html",
						    fCreator: "createSEditor2"
						});
					</script>
				</td>
			</tr>
			<tr>
				<td colspan="2"> 
				<a href="JavaScript:form_check();">입력</a> &nbsp;&nbsp;
				<a href="list.do">목록보기</a>
				</td>
			</tr>
		</form>
		
	</table>
</body>
</html>