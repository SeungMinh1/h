<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3 id="msg"></h3>

<script>

  fetch('cheering.do')
    .then(resolve => resolve.json())
    .then(result => {
    	document.querySelector('#msg').innerHTML = result.msg;
    })
    .catch(console.error);
</script>