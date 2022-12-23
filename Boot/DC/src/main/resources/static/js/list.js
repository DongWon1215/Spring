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
    $.getJSON('/postlist',function (data)
        {
            {
                $.each(data.list,function (index,post)
                {
                    const newTR = $('<tr></tr>')
                    let html = '<td>'+post.idx+'</td>' +
                        '<td><a href="#">'+post.title+'</a></td>'+
                        //'<!--        <span text="${board.replycnt}"></span></td>-->\n' +
                        '<td>'+post.writer+'</td>' +
                    '<td>'+post.writeDate+'</td>'

                    newTR.html(html);
                    $('#postList').append(newTR);
                })
            pagingList(data);
            }
        }
    )
}

function pagingList(paginginfo)
{
    $.ajax(
        {
            success:function (info)
            {
                const newNav = $('<nav aria-label="..."></nav>');
                let html = '<ul class="pagination">\n' +
                    '        <th:block th:if="'+paginginfo.isPrev+'">\n' +
                    '        <li class="page-item">\n' +
                    '          <a class="page-link" /*th:href="@{/postList/list(p=${'+paginginfo.startNum+' - 1})}"*/>&laquo;</a>\n' +
                    '        </li>\n' +
                    '        </th:block>\n' +
                    '        <th:block th:each="num : ${#numbers.sequence('+paginginfo.startNum+','+paginginfo.endNum+')}" th:with="active=${'+paginginfo.curNum+' == num ? \'active\' : \'\'}">\n' +
                    '          <li class="page-item" th:classappend="${active}">\n' +
                    '            <a class="page-link" <!--th:href="@{/board/list(p=${num})}"--> th:text="${num}"></a>\n' +
                    '          </li>\n' +
                    '        </th:block>\n' +
                    '        <th:block th:if="'+paginginfo.isNext+'">\n' +
                    '        <li class="page-item">\n' +
                    '          <a class="page-link" /*th:href="@{/postList/list(p=${'+paginginfo.endNum+' + 1})}"*/>&raquo;</a>\n' +
                    '        </li>\n' +
                    '        </th:block>\n' +
                    '      </ul>'

                newNav.html(html);
            }
        }
    )
}