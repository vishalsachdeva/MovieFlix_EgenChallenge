<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Movieflix</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="css/main.css">
    <script src="http://www.google.com/jsapi" type="text/javascript"></script>
<script type="text/javascript">
    google.load("jquery", "1.2.6");
</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.6/d3.min.js" charset="utf-8"></script>
    <script src="http:////code.jquery.com/jquery-1.10.2.js"></script>
    
</head>
<body>

<div id="mainContainer" class="container-fluid" ng-app="myApp" ng-controller="Ctrl">
    <nav id="navbar" class="navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" id="nav-browse-btn" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Browse <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <div class="arrow-up arrow-up-align-left"></div>
                            <li><a href="#">Home</a></li>
                            <li><a href="#">My Lists</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">New Arrivals</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Top Hits</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Movies</a></li>
                    <li><a href="#">Series</a></li>
                </ul>
                	
                <div class="navbar-form navbar-right" role="search">
                    <div id="nav-search-div" class="form-group">
                        <span class="glyphicon glyphicon-search"></span>
                        <input id="nav-search" type="text" class="form-control" placeholder="Search">
                    </div>
                    
                    <a href="login.jsp"><button value ="signout"> signout </button></a>
                </div>
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>
  <div>
  
  <p></p>
  
  </div>
  
  <div id="row1" class="container-fluid">
        <div id="carousel-1" class="carousel slide" data-interval=false data-wrap=true>
            <div class="carousel-inner" role="listbox">
                <div class="item" ng-repeat="movieSet in movieData" ng-class="{active: $index==0}">
                    <div class="row row-item row-item-1">
                        <div ng-repeat="item in movieSet.child" class="col-xs-2 col-row-item-1">
                            <a href="#x" class="thumbnail" ng-mouseenter="addHover($index)">
                                <img ng-src="{{item.Poster}}" />
                                <div class="carousel-caption" ng-class="carousel-caption-{{$index}}">
                                    <div class="container-fluid container-caption">
                                        <div class="row-caption">
                                            <span class="span-title">{{item.Title}}</span></div>
                                        <div class="row-caption">
                                            <span>{{item.Year}}</span>
                                            <span class="span-rated">{{item.Rated}}</span>
                                            <span>{{item.Runtime}}</span>
                                        </div>
                                        <div class="row-caption">
                                            <span class="span-plot">{{item.Plot}}</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
  
  
  <h1 style="color:skyblue;">Movies List</h1>
  <div id = "list" class= "list"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script> -->
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>