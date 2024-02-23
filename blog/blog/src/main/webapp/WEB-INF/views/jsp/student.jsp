<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      rel="shortcut icon"
      href="https://gouthamguna.github.io/in/favicon.ico"
      type="image/x-icon"
    />
  </head>
  <body>
    <h1>Student List...</h1>
    ${student_service}

    <script>
      (function () {
        const response = fetch("/blog/student");
        const data = response.json();

        console.log(data);
      })();
    </script>
  </body>
</html>
