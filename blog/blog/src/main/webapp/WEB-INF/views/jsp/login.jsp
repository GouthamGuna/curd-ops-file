<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blog</title>
  </head>
  <body>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/blog/login.do" method="POST">
      Name : <input name="name" type="text" /> Password :
      <input name="password" type="password" /> <input type="submit" />
    </form>
  </body>
</html>
