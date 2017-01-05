<html>
<head>
  <title>CNews</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#">CNews</a>
      </div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Sports</a></li>
        <li><a href="#">Tech</a></li>
        <li><a href="#">Economics</a></li>
        <li><a href="#">Culture</a></li>
        <li><a href="#">Politics</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span>Sign up</a></li>
        <li><a href="#loginModal" data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span> Log in</a></li>
      </ul>
    </div>
  </nav>

  <div class="modal fade" id="loginModal" role="dialog">
    <div class="modal-dialog">
      <form class="form-horizontal" action="/login" method="post">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Please log in</h4>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label class="control-label col-md-2" for="login">Login:</label>
              <div class="col-md-10">
                <input type="text" class="form-control" id="login" name="login" placeholder="Enter login"/>
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-md-2" for="password">Password:</label>
              <div class="col-md-10">
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password"/>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="submit" class="btn btn-info">Log in</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
          </div>
        </div>
      </form>
    </div>
  </div>

  <div class="container">
    <h1>Welcome!</h1>
    <div class="row">
      <div class="col-md-4">
        <div class="thumbnail">
          <a href="#">
            <img src="/resources/imgs/way.jpg" alt="way" style="width:100%">
            <div class="caption">
              <p>Way</p>
            </div>
          </a>
        </div>
      </div>
      <div class="col-md-4">
        <div class="thumbnail">
          <a href="#">
            <img src="/resources/imgs/city.jpg" alt="city" style="width:100%">
            <div class="caption">
              <p>City</p>
            </div>
          </a>
        </div>
      </div>
      <div class="col-md-4">
        <div class="thumbnail">
          <a href="#">
            <img src="/resources/imgs/sport.jpg" alt="sport" style="width:100%">
            <div class="caption">
              <p>Sport</p>
            </div>
          </a>
        </div>
      </div>
    </div>
  </div>

</body>
</html>