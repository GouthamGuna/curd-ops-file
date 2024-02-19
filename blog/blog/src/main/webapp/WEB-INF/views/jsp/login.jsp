<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blog</title>
  </head>
  <body>
    <!-- /blog/login.do form action url by WebServlet -->
    <p><font color="red">${errorMessage}</font></p>
    <form action="/blog/login" method="POST">
      Name : <input name="name" type="text" /> Password :
      <input name="password" type="password" /> <input type="submit" />
    </form>
  </body>
  <script type="text/script" src="views/js/login.js"></script>
</html>
