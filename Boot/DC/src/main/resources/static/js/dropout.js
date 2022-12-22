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
                let html = '<div class="card m-2">\n' +
                    '    <div class="card-body">\n' +
                    '        <h5 class="card-title"></h5>\n' +
                    '        <p class="card-text"></p>\n'+
                    '<table id="member_list">' +
                    '<tr>\n' +
                    '  <td class="col-3 text-center bg-light">회원 번호</td>\n' +
                    '  <td class="col-3 text-center bg-light">회원 유형</td>\n' +
                    '  <td class="col-3 text-center bg-light">회원 아이디</td>\n' +
                    '  <td class="col-3 text-center bg-light">강제 탈퇴</td>\n' +
                    '</tr>' +
                    '</table>'+
                    '    </div>\n' +
                    '</div>'

                newDiv.html(html).addClass('fs-6 text-center');

                body.append(newDiv);
                setPostList();
            }
        })
}

function setPostList()
{
    $.ajax(
        {
            url : '/member',type : 'get', async : true, dataType :'JSON',contentType : 'application/json', success:function (data)
            {
                console.log(data)
                $.each(data,function (index,member)
                {
                    const newTR =$('<tr></tr>');
                    let html ='<td class = "col-3">'+member.unequeCode+'</td>' +
                        '<td class = "col-3">'+member.id+'</td>'+
                        '<td class = "col-3">'+member.nickname+'</td>'+
                        '<td class = "col-3">' +
                        '<a href="javascript:dropoutMember('+member.unequeCode +')">강제 탈퇴</a>\n'

                    newTR.html(html).addClass('text-center').attr('tr-index',member.unequeCode);

                    $('#member_list').append(newTR);
                })
            },
            error:function(err)
            {
                console.log(err);
            }
        })
}

function dropoutMember(memberNum)
{
    if (!confirm("해당 회원을 탈퇴 시키겠습니까?"))
        return;

    $.ajax(
        {
            url:'/dropout/'+memberNum,type:'delete',success:function (data)
            {
                if (data)
                {
                    // 화면에서 tr-index == rno 행을삭제
                    // 삭제 대상 행
                    const delTR = document.querySelector('tr[tr-index="' + memberNum + '"]');
                    console.log(delTR);
                    delTR.remove();
                    console.log("삭제 됐다");
                    alert('삭제되었습니다.');
                }
                else
                {
                    alert('삭제할 대상이 존재하지 않습니다.');
                }
            }
            , error: function (err)
            {
                console.log(err);
            }
        })
}