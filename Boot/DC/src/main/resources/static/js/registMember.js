let body = $('#main-body');

$(document).ready(function ()
{
    setframe();
})

function setframe()
{
    $.ajax(
        {
            success:function () {
                const newTable = $('<table></table>');
                let html = '<tr>\n' +
                    '            <td>아이디</td>\n' +
                    '            <td><input type="text" name="id" id="member_id"></td>\n' +
                    '        </tr>\n' +
                    '        <tr>\n' +
                    '            <td>비밀번호</td>\n' +
                    '            <td><input type="password" name="password" id="member_password"></td>\n' +
                    '        </tr>\n' +
                    '        <tr>\n' +
                    '            <td>이름</td>\n' +
                    '            <td><input type="text" name="nickname" id="member_nickname"></td>\n' +
                    '        </tr>\n' +
                    '        <tr>\n' +
                    '            <td>계정 유형 선택</td>\n' +
                    '            <td><select name="authorities" id="member_authorities">\n' +
                    '                <option value="">계정 유형</option>\n' +
                    '                <option value="USER">이용자</option>\n' +
                    '                <option value="ADMIN">관리자</option>\n' +
                    '            </select></td>\n' +
                    '        </tr>\n' +
                    '        <tr>\n' +
                    '            <td></td>\n' +
                    '            <td><button type="button" onclick="javascript:registMember()">회원가입</button></td>\n' +
                    '        </tr>'
                newTable.html(html).addClass('fs-6 text-center');

                body.append(newTable);
            }
        })
}

function registMember()
{
    const MemberInfo =
        {
            id : $('#member_id').val(),
            password : $('#member_password').val(),
            nickname : $('#member_nickname').val(),
            authorities : $('#member_authorities').val()
        }

    $.ajax({url:'/member',type:'post',data:JSON.stringify(MemberInfo),dataType:'JSON',contentType:'application/json',success:function (){}})
}
