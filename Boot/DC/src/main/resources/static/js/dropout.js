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
                let html = '<div class="card m-2">\n' +
                    '    <div class="card-body">\n' +
                    '        <h5 class="card-title"></h5>\n' +
                    '        <p class="card-text"></p>\n' +
                    '        <button type="button" id="dropout">강제 탈퇴</button>\n' +
                    '    </div>\n' +
                    '</div>'

                newDiv.html(html).addClass('fs-6 text-center');

                body.append(newDiv);
                setlist();
            }
        })
}

function setPostList()
{
    $.ajax(
        {
            url : '/dropout',type : 'get', async : true, dataType :'JSON',contentType : 'application/json', success:function (data)
            {
                $.each(data,function (index,member)
                {
                    const newTR =$('<tr></tr>');
                    let html ='<td class = "col-2">'+member.id+'</td>' +
                        '<td class = "col-2">'+member.nickname+'</td>'+
                        '<td class = "col-2">' +
                        '<a href="javascript:dropoutMember('+member.unequeCode+')" class="badge bg-primary"></a>'+'</td>'

                    newTR.html(html).addClass('text-center').attr('tr-index',index);

                    $('#').append(newTR);
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
    if (confirm("해당 회원을 탈퇴 시키겠습니까?"))
    {
        location.href ='/dropout?memberNum='+memberNum;
    }
}