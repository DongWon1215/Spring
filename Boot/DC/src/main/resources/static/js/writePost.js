
let body = $('#main-body');

$(document).ready(function ()
{
    setframe();



})

function setframe()
{
    $.ajax(
        {
            success:function (data)
            {
                const newDiv = $('<div></div>');
                let html = '<div class="card m-3">\n' +
                    '  <div class="card-header">\n' +
                    '    Board Write\n' +
                    '  </div>\n' +
                    '  <form method="post" enctype="multipart/form-data">\n' +
                    '    <div class="mb-3">\n' +
                    '      <label for="title" class="form-label">제목</label>\n' +
                    '      <input type="text" class="form-control" id="title" name="title">\n' +
                    '    </div>\n' +
                    '    <div class="mb-3">\n' +
                    '<th:block th:if="${#authentication.principal">'+
                    '      <label for="writer" class="form-label">작성자</label>\n' +
                    '      <input type="name" class="form-control" th:value="${#authentication.principal.boardMember.idx} readonly">\n' +
                    '      <input type="name" class="form-control" id="writer" name="writer" th:value="${#authentication.principal.boardMember.idx}">\n' +
                    '</th:block>'+
                    '    </div>\n' +
                    '    <div class="mb-3">\n' +
                    '      <label for="content" class="form-label">내용</label>\n' +
                    '      <textarea class="form-control" id="content" rows="3" name="content"></textarea>\n' +
                    '    </div>\n' +
                    '    <div class="mb-3">\n' +
                    '      <label for="formFile" class="form-label">사진</label>\n' +
                    '      <input class="form-control" type="file" id="formFile" name="formFile">\n' +
                    '    </div>\n' +
                    '    <div class="mb-3">\n' +
                    '      <button type="button" id="write_button" class="btn btn-primary">작성</button>' +
                    '    </div>\n' +
                    '  </form>' +
                    '</div>'
            }
                .then($('#write_button').click(addpost()))
        }
    )
}

function addpost()
{

    const writePost =
        {

        }

        $.ajax({url:'/post',type:'post',data:JSON.stringify(writePost),dataType:'JSON',contentType:'application/json',success:function (data) {}})
}