<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-01
  Time: 오전 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!--bootstrap.css--><link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
    <table style="place-content: center">
        <tr>
            <td>${post.title}</td>
        </tr>
        <tr>
            <td style="text-align: justify">${post.writer} </td>
            <td style="vertical-align: middle">${post.views} </td>
        </tr>
        <tr>
            <td></td>
            <td><textarea rows="40" cols="120" style="resize : none"  name="context" readonly>${post.content}</textarea> </td>
        </tr>
    </table>
    <c:if test="${loginInfo ne null}">
        <a href="/page/modify?index=${param.index}">수정/삭제</a>
    </c:if>

    <c:forEach var="comment" items="${commentList}" varStatus="status">
        <li>
            <div style="width: 10%;">${comment.writer}</div>
            <div>${comment.content}</div>
        </li>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modifymodal" data-whatever="${comment.index}">수정</button>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deletemodal" data-whatever="${comment.index}">삭제</button>
    <hr>
    </c:forEach>
    </table>
    <div></div>

    <div class="comment">
        <form action="/comment/add" method="post" style="vertical-align: center">
            <div class="fl" style="width : 10%; height : 100px;float: left" >
            <input type="text" name="id" placeholder="이름">
            <input type="password" name="password" placeholder="비밀번호" style="float: left">
                <input type="hidden" name="postindex" value="${post.index}">
            </div>
            <div style="float: inside">
                <textarea rows="3" cols="50" style="resize: none" name="content"></textarea>
                <input type="submit" value="작성">
            </div>

        </form>
    </div>
<%--<div class="container">--%>
<%--    <div class="form-group">--%>
<%--        <form method="post" enctype="multipart/form-data" action="/commentAdd.jsp?"/>--%>
<%--    </div>--%>
<%--</div>--%>

    <!-- Modal -->
    <div class="modal fade" id="modifymodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog  modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">댓글 수정</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="/comment/modify" method="post">
                <div class="modal-body">
                        <div class="form-group">
                            <label for="recipient-name" class="col-form-label">비밀번호:</label>
                            <input type="password" class="form-control" id="recipient-name" name="password">
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">수정 할 내용:</label>
                            <textarea class="form-control" style="resize: none" id="message-text" name="content"></textarea>
                        </div>
                        <input type="hidden" name="postIndex" value="${post.index}">
                        <input type="hidden" name="index" id="commentIndex">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                    <button type="submit" class="btn btn-primary">수정</button>
                </div>
                </form>
            </div>
        </div>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="deletemodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog  modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteModalLabel">해당 댓글 삭제</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="/comment/delete" method="post">
                <div class="modal-body">
                        <div class="form-group">
                            <label for="recipient-name" class="col-form-label">비밀번호:</label>
                            <input type="password" class="form-control" id="comment-password" name="password">
                                <input type="hidden" name="postIndex" value="${post.index}">
                                <input type="hidden" name="index" id="deletablecommentindex">

                        </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                    <button type="submit" class="btn btn-primary">제거</button>
                </div>
                </form>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<script>
    $('.modal').on('hidden.bs.modal',function (e){
        $(this).find('form')[0].reset();
    })

    // const btn_commendDelete = document.querySelector("btn_commendDelete");
    // btn_commendDelete.addEventListener('click',deleteComment());

    $('#modifymodal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var index = button.data('whatever')
        var modal = $(this)
        modal.find('#commentIndex').val(index)
    })

    $('#deletemodal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var index = button.data('whatever')
        var modal = $(this)
        modal.find('#deletablecommentindex').val(index)
    })


</script>


    <a href="/page/main">목록</a>

</body>
</html>
