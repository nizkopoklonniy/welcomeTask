<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Test task welcome</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/resources/css/starter-template.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Optional theme -->
    <link rel="stylesheet" href="/resources/css/bootstrap-theme.min.css">

</head>
<body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Test task welcome</a>
            </div>
            <!--/.nav-collapse -->
        </div>
    </nav>

    <div class="container">

        <div class="starter-template">

            <c:choose>
                <c:when test="${showAlert}">
                    <div class="alert alert-info" role="alert">
                        <a href="#" class="alert-link">${message}</a>
                    </div>
                </c:when>
                <c:when test="${showError}">
                    <div class="alert alert-danger" role="alert">
                        <a href="#" class="alert-link">${message}</a>
                    </div>
                </c:when>
            </c:choose>

            <!-- Form code -->
            <form id="form-hello" method="post">

                <select class="form-control" name="sex">
                    <option>Mr</option>
                    <option>Ms</option>
                </select>

                <div class="form-group">
                    <label for="enterName">Enter your name</label>
                    <input type="text" class="form-control" id="enterName" name="nameGuest" placeholder="Enter your name">
                </div>

                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="showSex"> Show sex
                    </label>
                </div>
                <button type="submit" class="btn btn-default">Say hello</button>
            </form>

        </div>

    </div><!-- /.container -->

    <script src="/resources/jquery-1.11.2.min.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="/resources/js/bootstrap.min.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/resources/js/ie10-viewport-bug-workaround.js"></script>

</body>
</html>