// main body 얻어옴
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
                    let html = '<div class="card-body">\n' +
                        '    <table class="table table-borderless; text-center">\n' +
                        '      <thead class="table table-dark">\n' +
                        '      <tr>\n' +
                        '        <th class="col-1">번호</th>\n' +
                        '        <th class="col">제목</th>\n' +
                        '        <th class="col-2">작성자</th>\n' +
                        '        <th class="col-3">등록일</th>\n' +
                        '      </tr>\n' +
                        '      </thead>' +
                        '       <tbody id="postList"></tbody>'

                    newDiv.html(html).addClass('fs-6 text-center');

                    body.append(newDiv);
                    setlist();
            }
        })
}

function setlist()
{
    $.getJSON('/post',function (data)
        {
            console.log(data);
            {
                $.each(data,function (index,post)
                {
                    console.log(post);
                    const newTR = $('<tr></tr>')
                    let html = '<td>'+post.idx+'</td>' +
                        '<td><a href="#">'+post.title+'</a></td>'+
                        //'<!--        <span text="${board.replycnt}"></span></td>-->\n' +
                        '<td>'+post.writer+'</td>' +
                    '<td>'+post.writeDate+'</td>'

                    newTR.html(html);
                    $('#postList').append(newTR);
                })
            }
        }
    )
}