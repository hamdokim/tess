<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form action="/join" method="post">
	  <div class="form-group">
	    <input type="text" name="username" class="form-control" placeholder="Enter username" required="required">
	  </div>
	  <div class="form-group">
	    <input type="password" name="password" class="form-control" placeholder="Enter password" id="pwd">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<div class="form-group">
	    <input type="email" name="email" class="form-control" placeholder="Enter email" id="pwd">
	  </div>
	  <button type="submit" class="btn btn-primary">회원가입</button>
	</form>
</div>	
<%@ include file="../layout/footer.jsp" %>



   