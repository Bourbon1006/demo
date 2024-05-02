

function signin() {
    window.location.href = "http://localhost:8080/Signin";
}

function login() {
    var a = "123456";
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    // 使用Ajax将用户名和密码发送到后端进行验证
    $.ajax({
        url: "/checkCredentials", // 后端接口的 URL
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({username: username, password: password}), // 提交的数据，包括用户名和密码
        success: function (response) {
            if (response === true) {
                // 登录成功，重定向到 count.html 页面
                window.location.href = "count.html";
            } else {
                // 用户名或密码不正确
                document.getElementById("error-message").innerText = "用户名或密码不正确";
            }
        },
        error: function (xhr, status, error) {
            console.error("发生错误：" + error);
        }
    });
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toGMTString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function checkCookie() {
    var user = getCookie("username");
    var pass = getCookie("password");
    if (user !== "") {
        document.getElementById("username").value = user;
        if (pass !== "") {
            document.getElementById("password").value = pass;
        }
    }
}

function rememberPassword() {
    if (document.getElementById('remember').checked) {
        setCookie('password', document.getElementById('password').value, 30);
    } else {
        setCookie('password', '', -1);
    }
}
