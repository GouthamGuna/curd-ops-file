<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blog</title>
    <link
      rel="shortcut icon"
      href="https://gouthamguna.github.io/in/favicon.ico"
      type="image/x-icon"
    />
  </head>
  <body>
    <!-- /blog/login.do form action url by WebServlet -->
    <p><font color="red">${errorMessage}</font></p>
    <form action="/blog/login" method="POST">
      Name : <input name="name" type="text" /> Password :
      <input name="password" type="password" /> <input type="submit" />
    </form>
    <script type="text/script" src="views/js/login.js"></script>
  </body>
</html>
