<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="common/metatag.jspf"%>
        <%@include file="common/stylesheet.jspf"%>

        <title>Carousel Template for Bootstrap</title>
    </head>


    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">        
                        <a class="navbar-brand" href="index.htm" title="">Agile <span style="color:#f9f9f9;font-weight:200;">eXpress</span></a>

                    </div>
                </div>
                <!-- /.navbar-collapse -->
            </nav>
            <div class="bodycontent">
                <div id="page-wrapper">

                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <div class="row">
                            <div class="col-lg-12">
                                <h1 class="page-header">
                                    Tables
                                </h1>
                                <ol class="breadcrumb">
                                    <li>
                                        <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                                    </li>
                                    <li class="active">
                                        <i class="fa fa-table"></i> Tables
                                    </li>
                                </ol>
                            </div>
                        </div>
                        <!-- /.row -->
                        <div class="row">
                            <div class="col-lg-6">
                                <h2>User List</h2>
                                <div class="form-group input-group">
                                    <input type="text" class="form-control">
                                    <span class="input-group-btn"><button class="btn btn-default" type="button"><i class="fa fa-search"></i></button></span>
                                </div>
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>SR</th>
                                                <th>Name</th>
                                                <th>Gender</th>
                                                <th>DOB</th>
                                                <th>City</th>
                                                <th>User Name</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr class="active">
                                                <td>/index.html</td>
                                                <td>1265</td>
                                                <td>32.3%</td>
                                                <td>$321.33</td>
                                            </tr>
                                            <tr class="success">
                                                <td>/about.html</td>
                                                <td>261</td>
                                                <td>33.3%</td>
                                                <td>$234.12</td>
                                            </tr>
                                            <tr class="warning">
                                                <td>/sales.html</td>
                                                <td>665</td>
                                                <td>21.3%</td>
                                                <td>$16.34</td>
                                            </tr>
                                            <tr class="danger">
                                                <td>/blog.html</td>
                                                <td>9516</td>
                                                <td>89.3%</td>
                                                <td>$1644.43</td>
                                            </tr>
                                            <tr>
                                                <td>/404.html</td>
                                                <td>23</td>
                                                <td>34.3%</td>
                                                <td>$23.52</td>
                                            </tr>
                                            <tr>
                                                <td>/services.html</td>
                                                <td>421</td>
                                                <td>60.3%</td>
                                                <td>$724.32</td>
                                            </tr>
                                            <tr>
                                                <td>/blog/post.html</td>
                                                <td>1233</td>
                                                <td>93.2%</td>
                                                <td>$126.34</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                        </div>
                        <!-- /.row -->

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- /#page-wrapper -->

            </div>
            <!-- /#wrapper -->


        </div>
        <%@include file="common/javascript.jspf"%>

    </body>
</html>
