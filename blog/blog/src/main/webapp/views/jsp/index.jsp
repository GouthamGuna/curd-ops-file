<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blog</title>

    <link
      rel="shortcut icon"
      href="https://gouthamguna.github.io/in/favicon.ico"
      type="image/x-icon"
    />

    <script src="https://cdn.jsdelivr.net/npm/core-js-bundle@3.32.1/minified.min.js"></script>

    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.6.7/axios.min.js"
      integrity="sha512-NQfB/bDaB8kaSXF8E77JjhHG5PM6XVRxvHzkZiwl3ddWCEPBa23T76MuWSwAJdMGJnmQqM0VeY9kFszsrBEFrQ=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    ></script>
  </head>
  <body>
    <div class="container">
        <form>
            <label for="userName">
                User Name : 
                <input type="text" id="userName" />
            </label>
            <input type="submit" value="submit" id="myAnchor">
        </form>
    </div>
    <div class="result"></div>
    <script src="views/js/login.js"></script>
  </body>
</html>
