<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
</head>
<body>

	<table width="800" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.bName}</td>
			<td>
				<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
				<a href="content_view.do?bId=${dto.bId}&page=${page.curPage}">${dto.bTitle}</a></td>
			<td>${dto.bDate}</td>
			<td>${dto.bHit}</td>
		</tr>
		</c:forEach>

		<tr>
			<td colspan="5"> <a href="write_view.do">글작성</a> 
			
				<!-- 페이지 당 : <select>
				<option selected="selected">10개</option>
				<option>20개</option>
				<option>50개</option>
				</select><br /> -->
				
				</td>
			
			
		</tr>

		<tr>
			<td colspan="5">
			
				<!-- 처음 버튼 -->
				<c:choose>
					<c:when test="${(page.curPage -1) < 1}">
						[ &lt;&lt; ]
					</c:when>
					<c:otherwise>
						<a href="list.do?page=1">[ &lt;&lt; ]</a>				
					</c:otherwise>
				</c:choose>
				
				<!-- 이전 버튼 -->
				<c:choose>
					<c:when test="${(page.curPage -1) < 1}">
						[ &lt; ]
				</c:when>
					<c:otherwise>
						<a href="list.do?page=${page.curPage - 1}">[ &lt; ]</a>				
					</c:otherwise>
				</c:choose>
				
				<!-- 개별 페이지 -->
				<c:forEach var = "fEach" begin="${page.startPage}" end="${page.endPage}" varStatus="status">
					<c:choose>
						<c:when test="${page.curPage == fEach}">
							[ ${fEach} ]
						</c:when>
						<c:otherwise>
					<a href="list.do?page=${fEach}">[ ${fEach} ]</a> 				
						</c:otherwise>
					</c:choose>
				</c:forEach>
					
				<!-- 다음 버튼 -->
				<c:choose>
					<c:when test="${(page.curPage +1) > page.totalPage}">
						[ &gt; ]
					</c:when>
					<c:otherwise>
						<a href="list.do?page=${page.curPage + 1}">[ &gt; ]</a>			
					</c:otherwise>
				</c:choose>
				
				<!-- 끝 버튼 -->
				<c:choose>
					<c:when test="${(page.curPage +1) > page.totalPage}">
						[ &gt;&gt; ]
					</c:when>
					<c:otherwise>
						<a href="list.do?page=${page.totalPage}">[ &gt;&gt; ]</a>				
					</c:otherwise>
				</c:choose>
				
			</td>
		</tr>
				
		
	</table>	

	totalCount : ${page.totalCount} <br />
	listCount : ${page.listCount} <br />
	totalPage : ${page.totalPage} <br />
	curPage : ${page.curPage} <br />
	pageCount : ${page.pageCount} <br />
	startPage : ${page.startPage} <br />
	endPage :  ${page.endPage} <br />

</body>
</html>