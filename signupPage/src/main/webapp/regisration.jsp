<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login page</title>
    <link rel="stylesheet" href="./index.Signup.css">


</head>

<body>
    <input type="hidden" id="status" value="<%request.getAttribute(" status");%>">
    <form action="regisration" method="post">
        <h1>REGISTER</h1>
        <label placeholder="User name">User Name</label>
        <input type="text" name="username">
        <label placeholder="E-mail">Email</label>
        <input type="email" name="email">
        <label placeholder="Password">Password</label>
        <input type="password" name="password">
        <label for="" placeholder="mobile">mobile</label>
        <input type="text" name="mobile">
        <button type="submit">Sign up</button>

    </form>
    <script type="text/javascript">
        console.log("hii....");
        var status = document.getElementById("status")
        console.log(status);

        if (status == "yes") {
            alert("Account created....!");
        }
        if (status == "no") {
            alert("signup failed...!");
        }

    </script>


</body>

</html>