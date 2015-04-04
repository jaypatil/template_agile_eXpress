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

                        <div id="navbar" class="navbar-collapse collapse">
                            <ul id="navlist" class="nav navbar-nav">
                                <li class="active"><a href="index.htm">Home</a></li>
                                <li><a href="sidenavpage.htm">Admin</a></li>
                                <li><a href="regestrationpage.htm">Registration Step 2</a></li>

                            </ul>
                        </div>


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
                                    Forms
                                </h1>
                                <ol class="breadcrumb">
                                    <li>
                                        <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                                    </li>
                                    <li class="active">
                                        <i class="fa fa-edit"></i> Forms
                                    </li>
                                </ol>
                            </div>
                        </div>
                        <!-- /.row -->

                        <div class="row">
                            <div class="col-lg-6">

                                <form role="form">
                                    <div class="form-group">
                                        <label>First Name</label>
                                        <input class="form-control" placeholder="First Name">
                                    </div>
                                    <div class="form-group">
                                        <label>Last Name</label>
                                        <input class="form-control" placeholder="First Name">
                                    </div>

                                    <div class="form-group">
                                        <label>Role</label>
                                        <select class="form-control">
                                            <option>xyz</option>
                                            <option>xyz</option>
                                            <option>xyz</option>
                                            <option>xyz</option>
                                        </select>
                                    </div>
                                    <div class="form-group">

                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" value="">Checkbox 1
                                            </label>
                                        </div>
                                        <label>Send Mail</label>

                                    </div>
                                    <button type="submit" class="btn btn-default">Register</button>
                                    <button type="reset" class="btn btn-default">Cancel</button>

                                </form>

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
