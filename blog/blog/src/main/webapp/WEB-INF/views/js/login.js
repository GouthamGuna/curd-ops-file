console.log("JS init...");
/*
document.getElementById("myAnchor").addEventListener("click", function (event) {
  event.preventDefault();

  let userName = document.getElementById("userName");
  let result = document.getElementById("result");

  axios({
    method: "POST",
    url: "http://localhost:9090/blog/login.do",
    params: { userName: userName.value },
  }).then(
    (response) => {
      console.log("response : ", response.data);
      result.innerHTML = `<h1>${response.data}</h1>`;
    },
    (e) => {
      console.error(e);
    }
  );
});
*/

// Disable the right-click context menu
document.addEventListener('contextmenu', event => event.preventDefault());


