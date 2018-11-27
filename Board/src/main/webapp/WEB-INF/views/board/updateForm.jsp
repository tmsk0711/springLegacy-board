<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <c:import url="header.jsp" charEncoding="UTF-8"/> --%>
<!-- header 시작  -->
<!-- header 시작 -->
<%@include file="../header.jsp"%>
<script type="text/javascript"
	src="/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript"
	src="/resources/editor/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js"
	charset="utf-8"></script>

<!-- header 끝 -->
<!-- header 끝 -->

<div class="container">
	<h2>작성</h2>
	<br>
	<br>
	<form action="/board/update" method="post" name="w_form">
	<input type="hidden" value="${boardVO.bNum }" name="bNum" />
		<div class="form-group">
			<input type="text" name="bTitle" class="form-control"
				placeholder="제목" id="usr" value="${boardVO.bTitle }">
		</div>

		<div class="form-group">
			<textarea name="bContent" id="textAreaContent" style="width: 100%"
				rows="15" cols="80">${boardVO.bContent }</textarea>



		</div>
		<input type="button" class="btn btn-success" onClick="submitContents(this)" value="수정">
	</form>

</div>



<!-- footer 시작 -->
<!-- footer 시작 -->
<script>
  var form = document.w_form; // form에 name값이 있어야한다.
  var oEditors = [];
  nhn.husky.EZCreator.createInIFrame({
      oAppRef: oEditors,
      elPlaceHolder: "textAreaContent",
      sSkinURI: "/resources/editor/SmartEditor2Skin.html",
      fCreator: "createSEditor2"
  });
   
  // submit
  function submitContents(elClickedObj) {
      // 에디터의 내용이 textarea에 적용된다.
      oEditors.getById["textAreaContent"].exec("UPDATE_CONTENTS_FIELD", [ ]);
      var con = document.w_form.bContent;
      con.value = document.getElementById("textAreaContent").value; // 위 textarea id .value;
      try {
          elClickedObj.form.submit();
      } catch(e) {
       
      }
  }
   
  // textArea에 이미지 첨부
  function pasteHTML(filepath){
      var sHTML = '<img src="/resources/editor/upload/'+ filepath + '">';
	  oEditors.getById["textAreaContent"].exec("PASTE_HTML", [ sHTML ]);
  }
</script>



<%@include file="../footer.jsp"%>
<!-- footer 끝 -->
<!-- footer 끝-->
<%-- <c:import url="footer.jsp" charEncoding="UTF-8"/> --%>
