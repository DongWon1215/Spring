
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
                let html = '<div class="card m-3">\n' +
                    '  <div class="card-header">\n' +
                    '    Board Write\n' +
                    '  </div>\n' +
                    '  <form method="post" enctype="multipart/form-data">\n' +
                    '<th:block th:if="${#authentication.principal">' +
                    '   <tr>\n' +
                    '<td>닉네임</td>\n' +
                    '<td><input type="text" id="writer"></td>\n' +
                    '<td>비밀번호</td>\n' +
                    '<td><input type="password" id="password"></td>\n' +
                    '</tr>'+
                    '</th:block>'+
                    '    <div class="mb-3">\n' +
                    '      <label for="title" class="form-label">제목</label>\n' +
                    '      <input type="text" style="width: 800px" id="title" name="title">\n' +
                    '    </div>\n' +
                    '    <div class="mb-3">\n' +
                    '<th:block th:if="${#authentication.principal">'+
                    '    </div>\n' +
                    '    <div class="mb-3">\n' +
                    '      <label for="content" class="form-label">내용</label>\n' +
                    '      <textarea class="form-control" id="content" rows="20" cols="150" name="content" style="resize: none"></textarea>\n' +
                    '    </div>\n' +
                    '    <div class="mb-3">\n' +
                    '      <label for="formFile" class="form-label">사진</label>\n' +
                    '      <input class="form-control" type="file" id="formFile" name="formFile">\n' +
                    '    </div>\n' +
                    '    <div class="mb-3">\n' +
                    '      <button type="button" id="write_button" onclick="javascript:addpost()" class="btn btn-primary">작성</button>' +
                    '    </div>\n' +
                    '  </form>' +
                    '</div>'

                newDiv.html(html).addClass('fs-6 text-center');

                body.append(newDiv);
            }
        }
    )
}

function addpost()
{
    const writePost =
        {
            title : $('#title').val(),
            writer : $('#writer').val(),
            content : $('#content').val(),
            nickname : $('#nickname').val(),
            password : $('#password').val(),
            formFile : $('#formFile').val()
        }

    const imageInput = $("#formFile")[0];

    const formData = new FormData();
    formData.append("img", imageInput.files[0]);
    formData.append("title",$('#title').val());
    formData.append("writer",$('#writer').val());
    formData.append("content",$('#content').val());
    formData.append("nickname",$('#nickname').val());
    formData.append("password",$('#password').val());

        $.ajax({url:'/post',type:'post',data:formData,processData: false,contentType: false,success:function (data) {}})
}