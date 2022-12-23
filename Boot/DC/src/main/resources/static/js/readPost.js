let body = $('#main-body');

let editmodal;
let deletemodal;

$(document).ready(function ()
{
    setframe();

})

function setframe()
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
        '        <a class="btn btn-warning" <!--th:href="@{/board/edit(bno=${boardView.bno},p=${currentPageNum})}"-->>수정</a>\n' +
        '        <a class="btn btn-primary" <!--th:href="javascript:list.js"-->>글 목록</a>\n' +
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
        '            <div>\n' +
        '            아이디 : <input type="text" id="comment_id">\n' +
        '            비밀번호 : <input type="password" id="comment_password">\n' +
        '            </div>' +
        '        <div class="mb-3">\n' +
        '          <label class="form-label">내용</label>\n' +
        '          <input type="text" class="form-control" id="comment_content">' +
        '        </div>\n' +
        '    <div class="mb-3">\n' +
        '      <label for="formFile" class="form-label">사진</label>\n' +
        '      <input class="form-control" type="file" id="formFile" name="formFile">\n' +
        '    </div>\n' +
        '        <div class="mb-3" id="button_area">\n' +
        '<button type="button" onclick="javascript:addComment()">작성</button>\n' +
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
        '  <div class="modal fade" id="commentEditModal" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">\n' +
        '    <div class="modal-dialog">\n' +
        '      <div class="modal-content">\n' +
        '        <div class="modal-header">\n' +
        '          <h1 class="modal-title fs-5" id="staticBackdropLabel">댓글 수정</h1>\n' +
        '          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>\n' +
        '        </div>\n' +
        '        <div class="modal-body">\n' +
        '          <div class="mb-3">\n' +
        '            <label class="form-label">아이디</label>\n' +
        '            <input type="text" class="form-control" id="editer_id" readonly>\n' +
        '            <input type="hidden" id="edit_idx">\n' +
        '            <label class="form-label">비밀번호</label>\n' +
        '            <input type="text" class="form-control" id="editer_password" readonly>\n' +
        '          </div>\n' +
        '          <div class="mb-3">\n' +
        '            <label class="form-label">내용</label>\n' +
        '            <textarea class="form-control" rows="3" id="editer_content" style="resize: none"></textarea>\n' +
        '          </div>\n' +
        '        </div>\n' +
        '        <div class="modal-footer">\n' +
        '          <button type="button" id="btn_edit" class="btn btn-primary" onclick="javascript:editComment()">수정</button>\n' +
        '        </div>\n' +
        '      </div>\n' +
        '    </div>\n' +
        '  </div>\n'+


        //delete modal
        '  <div class="modal fade" id="commentDeleteModal" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">\n' +
        '    <div class="modal-dialog">\n' +
        '      <div class="modal-content">\n' +
        '        <div class="modal-header">\n' +
        '          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>\n' +
        '        </div>\n' +
        '        <div class="modal-body">\n' +
        '          <div class="mb-3">\n' +
        '            <label class="form-label">아이디</label>\n' +
        '            <input type="text" class="form-control" id="deleter_id">\n' +
        '            <input type="hidden" id="deleter_idx">\n' +
        '          </div>\n' +
        '          <div class="mb-3">\n' +
        '            <label class="form-label">비밀번호</label>\n' +
        '            <input type="text" class="form-control" id="deleter_password" >\n' +
        '          </div>\n' +
        '        </div>\n' +
        '        <div class="modal-footer">\n' +
        '          <button type="button" id="btn_delete" class="btn btn-primary" onclick="javascript:deleteComment()">제거</button>\n' +
        '        </div>\n' +
        '      </div>\n' +
        '    </div>\n' +
        '  </div>\n'

    body.append(newDiv.html(html));

    setPostInfo();

    editmodal = new bootstrap.Modal('#commentEditModal');
    deletemodal = new bootstrap.Modal('#commentDeleteModal');
}

function setPostInfo()
{
    $.ajax(
        {
            url:'/post/' + 15,type:'get',dataType:'JSON',contentType:'application/json',success:function (data)
            {
                const newDiv = $('<td class="text-center" >'+data.title+'</td>')
                const newDiv2 = $('<td class="text-center">'+data.writer+'</td>>')
                const newDiv3 = $('<td class="text-center">'+data.content+'</td>>')
                const newDiv4 = $('<td class="text-center">'+data.writeDate+'</td>>')
                // const newEditbutton = $('<button type="button" class="btn btn-danger" onclick="javascript:editPost()">수정</button>\n')
                // const newDeletebutton = $('<button type="button" class="btn btn-danger" onclick="javascript:deletePost('+data.idx +')">삭제</button>\n')
                // const newReturnbutton = $('<button type="button" class="btn btn-danger" onclick="javascript:returnToList()">목록</button>\n')

                if(data.img != null)
                {
                    console.log("이미지 => "+data.img);
                    let html = '<tr>' +
                        '<td class="col-2 text-center bg-light">사진</td>\n' +
                        '<td>\n' +
                        '<img src="/upload/post/photo/'+data.img+'" width="300" alt="왜 안나오지">\n' +
                        '</td>\n' +
                        '</tr>'

                        newDiv3.html(html);
                    console.log(newDiv3.html())
                }

                $('#post_title').append(newDiv);
                $('#post_writer').append(newDiv2);
                $('#post_content').append(newDiv3);
                $('#post_writeDate').append(newDiv4);
                // $('#button_area').append(newEditbutton);
                // $('#button_area').append(newDeletebutton);
                // $('#button_area').append(newReturnbutton);
            }
        }
    )
    .then(setCommentList())
}

function setCommentList(postindex)
{
    $.ajax(
        {
            url:'/comment/' + 15,type:'get',dataType:'JSON',contentType:'application/json',success:function (data)
            {
                $.each(data,function (index,comment)
                {
                    const newTR = $('<tr></tr>')
                    let html = '<td><span>'+comment.writer +'</span><span>'+ comment.content +'</span></td>' +
                        '<td>'+comment.content+'</td>' +
                        '<th:block th:if="'+comment.img+'" ne null>' +
                        '<td><img src="/upload/comment/photo/'+comment.img+'" width="100" height="100"></td>' +
                        '</th:block>' +
                        '<td class="col-2">\n' +
                        '<button type="button" onclick="javascript:showEditModal('+comment.idx+')">수정</button>\n' +
                        '<button type="button" onclick="javascript:showDeleteModal('+comment.idx+')">삭제</button>\n' +
                        '</td>'
                    newTR.html(html).addClass('fs-6 text-center').attr('tr-index'+comment.idx);
                    $('#replyList').append(newTR);
                })
            }
        }
    )
}

function addComment(postindex)
{
    const imageInput = $("#formFile")[0];

    const formData = new FormData();
    if(imageInput != null)
        formData.append("img", imageInput.files[0]);

    else
        formData.append("img", null);

    formData.append("writer",$('#comment_id').val());
    formData.append("content",$('#comment_content').val());
    formData.append("password",$('#comment_password').val());
    formData.append("postIndex",15);

    $.ajax({url:'/comment',type:'post',data:formData,processData: false,contentType: false,success:function (data)
        {
            let html = '<td class="col-2">'+data.writer+'</td>'+
                        '<td class="col">'+data.content+'</td>'+
                        '<th:block th:if="'+data.img+' ne null">' +
                        '<td><img src="/upload/comment/photo/'+data.img+'" width="100" height="100"></td>' +
                        '</th:block>' +
                        '<td class="col-2">'+
                        '<button onclick="javascript:showEditModal('+data.idx+')" class="badge text-decoration-none edit">수정</button>'+
                        '<button onclick="javascript:showDeleteModal('+data.idx+')" class="badge text-decoration-none edit">삭제</button>'+
                        '</td>'


            const newTR = $('<tr></tr>').attr('class', 'fs-6 text-center').attr('tr-index',data.idx).html(html)

            // 부모 태그에 요소 추가
            $('#replyList').append(newTR)

            $("#comment_id").val('')
            $("#comment_password").val('')
            $("#comment_content").val('')
        }})
}

function showEditModal(commentNum)
{
    editmodal.show();

    const editDt =$('tr[tr-index'+commentNum+']>td');

    console.log(editDt.val());

    $('#edit_idx').val(commentNum);
    $('#editer_id').val(editTD[0].textContent);
    $('#editer_password').val(editTD[1].textContent);
    $('#editer_content').val(editTD[2].textContent);
}

function editComment()
{
    const imageInput = $("#formFile")[0];

    const formData = new FormData();
    if(imageInput != null)
    formData.append("img", imageInput.files[0]);

    else
        formData.append("img", null);

    formData.append("writer",$('#editer_id').val());
    formData.append("content",$('#editer_content').val());
    formData.append("password",$('#editer_password').val());
    formData.append("postIndex",$('#edit_idx'));

    $.ajax(
        {
            url:'/comment/' + idx,type:'put',data:formData,processData: false,contentType: false,success:function (data)
            {
                alert('댓글 수정이 완료 되었습니다');
                const editTD = $('tr[tr-index="' + payload.rno + '"]>td');
                editTD[1].textContent = payload.reply;

                editmodal.hide();
            }
        ,error:function()
            {
                alert('아이디 또는 비밀번호가 잘못되었습니다');
            }
        })
}

function showDeleteModal(commentNum)
{
    deletemodal.show();

    const delDt =$('tr[tr-index'+commentNum+']>td');

    console.log(delDt.val());

    $('#deleter_idx').val(commentNum);
    $('#deleter_id').val(delDt[0].textContent);
    $('#deleter_password').val(delDt[1].textContent);
}

function deleteComment()
{
    const deleteRequest =
    {
        id : $('#deleter_id').val(),
        password : $('#deleter_password').val(),
        index :
    }

    $.ajax({url:'/comment',type:'delete',data:JSON.stringify(deleteRequest),dataType:'JSON',contentType:'application/json',success:function (data)
        {
            deletemodal.hide();
            $('tr[tr-index="'+ deleteRequest.index +'"]').remove()
        }
        ,error:function (err)
        {
            alert('아이디 또는 비밀번호가 잘못되었습니다');
        }
    })
}

function deletePost(idx)
{
    $.ajax(
        {
            url:'/post/'+idx,type:'delete',success:function()
            {
                // 여기에 메인 페이지로 돌아가는 로직 집어넣어야 함
            }
        }
    )
}

function editPost()
{
    $.ajax(
        {

        }
    )
}

function returnToList()
{
    $.ajax(
        {

        }
    )
}