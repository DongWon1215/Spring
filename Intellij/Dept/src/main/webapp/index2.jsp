<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<%--<script>--%>
<%--    console.log(1)--%>
<%--    console.log(2)--%>
<%--    setTimeout(()=> console.log(3),1000)--%>
<%--    console.log(4)--%>
<%--</script>--%>

<%--<script>--%>
<%--    const xhr = new XMLHttpRequest();--%>
<%--    // xhr.open('get','https://jsonplaceholder.typicode.com/todos/1')--%>
<%--    xhr.open('get','/api/v1/60')--%>
<%--    xhr.send();--%>

<%--    xhr.onreadystatechange = () => {--%>
<%--        if(xhr.readyState !== XMLHttpRequest.DONE)--%>
<%--        {--%>
<%--            return;--%>
<%--        }--%>

<%--        if(xhr.status === 200)--%>
<%--        {--%>
<%--            console.log(JSON.parse(xhr.response));--%>
<%--        }--%>
<%--        else {--%>
<%--            console.log("error", xhr.status, xhr.statusText}--%>
<%--        }--%>
<%--</script>--%>

<script>
    const request =
        {
            get(url)
            {
                return fetch(url);
            }
            post(url, payload)
            {
                return fetch(url,{ return fetch(url,
                {
                    method : 'POST',
                    headers : {'content-type':'application/json'},
                    body : JSON.stringify(payload)

                })
            }
            put(url)
            {
                return fetch(url, {
                    method : 'PUT',
                    headers : {'content-type':'application/json'},
                    body : JSON.stringify(payload)

                })
            }
            delete(url)
            {
                return fetch(url, {method: 'DELETE'});
            }}
        }

    request.get('/api/v1/depts')
    .then(response => {
        if (!response.ok)
        {
            throw new Error(response.statusText);
        }
        return response.json();
    })
    .then(list => console.log(list))
    .catch(err => console.log(err))

    request.post('/api/v1/depts',{deptno : 11, dname : 'test', loc : 'test123'})
        .then(response => {if(!response.ok)return new Error(response.statusText)
            console.log(response)
        })
        .catch(err => console.log(err))

    request.put('/api/v1/depts/11',{deptno : 22, dname : '기획', loc : '부산'})
        .catch(err => console.log(err))

    request.delete('/api/v1/depts/11')
        .then(res=> {console.log(res)})

</script>
</body>
</html>