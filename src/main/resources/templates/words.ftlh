<html xmlns:p="http://www.w3.org/1999/html">
<head>
    <title>Dictionary</title>
</head>
<body>Hello world!</body>
<h1>Dictionary</h1>
<form action="/" method="get">
    <p>Find a word by name:</p>
    <input type="text" name="englishWord"><br>
    <input type="submit" value="Get words">
</form>
<#list words as word>
    <div>
        <p><b>${word.englishWord}</b></p>
        <a href="/word/${word.id}">Подробнее...</a>
    </div>
<#else >
    <h3>No words</h3>
</#list>
<hr>
<h3>Make new word</h3>
<form action="/word/create" method="post">
    Word in english:<input type="text" name="englishWord"/><br>
    Description:<input type="text" name="description"/><br>
    <input type="submit" value="Add word"/>
</form>
</html>