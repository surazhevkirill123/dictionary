<html xmlns:p="http://www.w3.org/1999/html">
<head>
    <title>Dictionary</title>
</head>
<body>Hello world!</body>
<h1>Dictionary</h1>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Word in english:</b>
<p><b>${word.englishWord}</b></p>
<b>Description:</b>
<p style="white-space:pre">${word.description}</p>
<form action="/word/delete/${word.id}" method="post">
    <input type="submit" value="Delete word"/>
</form>
</html>