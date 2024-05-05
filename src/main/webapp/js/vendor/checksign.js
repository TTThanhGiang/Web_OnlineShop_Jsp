/* global session */

function check() {
    const status = (document.getElementById('login-out').innerHTML).trim();
    const  compareValue = status.localeCompare("Sign in");

    if (compareValue === 0)
    {
        var ul = document.getElementById("hide-ul");
        var li = document.getElementById("p-ul");
        li.removeChild(ul);

        document.getElementById("login-out").href = "login.jsp";
    }
    
    
    const compareValue_admin = status.localeCompare("chungnghia");
    if (compareValue_admin === 0)
    {
        document.getElementById('check-admin').innerHTML = "Upload Product";
        document.getElementById("check-admin").href = "upload.jsp";


    }


}

function  checksign() {

    document.getElementById('login-out').innerText = "Sign in";

    var ul = document.getElementById("hide-ul");
    var li = document.getElementById("p-ul");
    li.removeChild(ul);

    document.getElementById("login-out").href = "login.jsp";


}




