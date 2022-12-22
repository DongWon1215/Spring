let body = $('#main-body');

$(document).ready(function ()
{
    setframe();
})

function setframe()
{
    $.ajax(
        {
            success:function ()
            {
                const newDiv = $('<div></div>');
                let html = '<div class="card-body">\n' +
                    '      <table class="table border-top-1">\n' +
                    '        <tr>\n' +
                    '          <td class="col-2 text-center bg-light" id="post_title">제목</td>\n' +
                    '        </tr>\n' +
                    '        <tr>\n' +
                    '          <td class="col-2 text-center bg-light" id="post_writer">작성자</td>\n' +
                    '        </tr>\n' +
                    '        <tr>\n' +
                    '          <td class="col-2 text-center bg-light" id="post_content">내용</td>\n' +
                    '        </tr>\n' +
                    '        <tr>\n' +
                    '          <td class="col-2 text-center bg-light" id="post_writeDate">작성일</td>\n' +
                    '        </tr>\n' +
                    '      </table>\n' +
                    '      <div class="text-end" id="button_area">\n' +
                    // '        <a class="btn btn-warning" th:href="@{/board/edit(bno=${boardView.bno},p=${currentPageNum})}">수정</a>\n' +
                    // '        <a class="btn btn-danger" th:onclick="\'deleteBoard(\'+${boardView.bno}+\')\'">삭제</a>\n' +
                    // '        <a class="btn btn-primary" th:href="@{/board/list(p=${currentPageNum})}">글 목록</a>\n' +
                    '      </div>\n' +
                    '      <!-- 댓글 영역 시작-->\n' +
                    '      <div class="card m-2 my-2">\n' +
                    '        <div class="card-header">\n' +
                    '          댓글\n' +
                    '        </div>\n' +
                    '        <div class="card-body">\n' +
                    '      <!--댓글 작성 영역-->\n' +
                    '      <div class="p-3 border-bottom">\n' +
                    '        <h5 class="title my-2">댓글 작성</h5>\n' +
                    '        <div class="mb-3">\n' +
                    '          <label class="form-label">작성자</label>\n' +
                    '        </div>\n' +
                    '        <div class="mb-3">\n' +
                    '          <label class="form-label">내용</label>\n' +
                    '        </div>\n' +
                    '        <div class="mb-3" id="button_area">\n' +
                    '        </div>\n' +
                    '      </div>\n' +
                    '      <!--댓글 리스트 영역-->\n' +
                    '      <table class="table">\n' +
                    '        <tbody id="replyList">\n' +
                    '        </tbody>\n' +
                    '      </table>\n' +
                    '        </div>\n' +
                    '      </div>\n' +
                    '  </div>\n' +
                    '</div>\n' +
                    '</div>\n' +
                    '  <!-- Modal -->\n' +
                    '  <div class="modal fade" id="replyEditModal" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">\n' +
                    '    <div class="modal-dialog">\n' +
                    '      <div class="modal-content">\n' +
                    '        <div class="modal-header">\n' +
                    '          <h1 class="modal-title fs-5" id="staticBackdropLabel">댓글 수정</h1>\n' +
                    '          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>\n' +
                    '        </div>\n' +
                    '        <div class="modal-body">\n' +
                    '          <div class="mb-3">\n' +
                    '            <label class="form-label">작성자</label>\n' +
                    '            <input type="text" class="form-control" id="ereplyer" readonly>\n' +
                    '            <input type="hidden" id="erno">\n' +
                    '            <input type="hidden" id="ereplydate">\n' +
                    '          </div>\n' +
                    '          <div class="mb-3">\n' +
                    '            <label class="form-label">내용</label>\n' +
                    '            <textarea class="form-control" rows="3" id="ereply" style="resize: none"></textarea>\n' +
                    '          </div>\n' +
                    '        </div>\n' +
                    '        <div class="modal-footer">\n' +
                    '          <button type="button" id="btn_edit" class="btn btn-primary">수정</button>\n' +
                    '        </div>\n' +
                    '      </div>\n' +
                    '    </div>\n' +
                    '  </div>\n'

                body.append(newDiv);
            }
                .then(setPostInfo())
        }
    )
}

function setPostInfo()
{
    $.ajax(
        {
            url:'',type:'',dataType:'JSON',contentType:'application/json',success:function (data)
            {
                const newDiv = $('<td th:text="'+data.title+'">')
                const newDiv2 = $('<td th:text="'+data.writer+'">')
                const newDiv3 = $('<td th:text="'+data.content+'">')
                const newDiv4 = $('<td th:text="'+data.writeDate+'">')

                if(data.img != null)
                {
                    let html = '<tr>' +
                        '<td class="col-2 text-center bg-light">사진</td>\n' +
                        '<td>\n' +
                        '<img th:src="@{/upload/post/photo/{name}(name='+data.img+')}" width="300">\n' +
                        '</td>\n' +
                        '</tr>'

                        newDiv3.html(html);
                }

                $('#post_title').append(newDiv);
                $('#post_writer').append(newDiv2);
                $('#post_content').append(newDiv3);
                $('#post_writeDate').append(newDiv4);
            }
        }
    )
}