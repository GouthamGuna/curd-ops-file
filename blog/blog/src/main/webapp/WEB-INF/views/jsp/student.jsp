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
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.6.7/axios.min.js"
      integrity="sha512-NQfB/bDaB8kaSXF8E77JjhHG5PM6XVRxvHzkZiwl3ddWCEPBa23T76MuWSwAJdMGJnmQqM0VeY9kFszsrBEFrQ=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    ></script>
  </head>
  <body>
    <h1>Student List...</h1>
    ${student_service}

    <script>
      const BASE_URL = "http://localhost:9090/blog/";
      axios({
        method: "GET",
        url: BASE_URL + "student/?name=karan",
      }).then(
        (response) => {
          console.log(response);
        },
        (e) => {
          console.error(e);
        }
      );
    </script>
  </body>
</html>
