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
                    '            <td><input type="text" name="id"></td>\n' +
                    '        </tr>\n' +
                    '        <tr>\n' +
                    '            <td>비밀번호</td>\n' +
                    '            <td><input type="password" name="password"></td>\n' +
                    '        </tr>\n' +
                    '        <tr>\n' +
                    '            <td>이름</td>\n' +
                    '            <td><input type="text" name="nickname"></td>\n' +
                    '        </tr>\n' +
                    '        <tr>\n' +
                    '            <td>계정 유형 선택</td>\n' +
                    '            <td><select name="authorities">\n' +
                    '                <option value="">계정 유형</option>\n' +
                    '                <option value="USER">이용자</option>\n' +
                    '                <option value="ADMIN">관리자</option>\n' +
                    '            </select></td>\n' +
                    '        </tr>\n' +
                    '        <tr>\n' +
                    '            <td></td>\n' +
                    '            <td><input type="submit" value="회원가입"></td>\n' +
                    '        </tr>'
                newTable.html(html).addClass('fs-6 text-center');

                body.append(newDiv);
                setlist();
            }
        })
}