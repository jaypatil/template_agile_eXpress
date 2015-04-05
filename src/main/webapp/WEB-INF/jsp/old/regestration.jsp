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
                                        <label>User Name</label>
                                        <p class="form-control-static">email@example.com</p>
                                    </div>



                                    <div class="form-group">
                                        <label>Address</label>
                                        <textarea class="form-control" rows="3"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Date Of Birth</label>

                                        <div class='input-group date' id='datetimepicker1'>
                                            <input type='text' class="form-control" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>

                                    </div>

                                    <div class="form-group">
                                        <label>Gender</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline1" value="option1" checked>Female
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline2" value="option2">Male
                                        </label>

                                    </div>
                                    <div class="form-group">
                                        <label>Country</label>
                                        <select class="form-control">
                                            <option>xyz</option>
                                            <option>xyz</option>
                                            <option>xyz</option>
                                            <option>xyz</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>State</label>
                                        <select class="form-control">
                                            <option>xyz</option>
                                            <option>xyz</option>
                                            <option>xyz</option>
                                            <option>xyz</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>City</label>
                                        <select class="form-control">
                                            <option>xyz</option>
                                            <option>xyz</option>
                                            <option>xyz</option>
                                            <option>xyz</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" class="form-control" placeholder="Password">
                                    </div>
                                    <div class="form-group">
                                        <label>Confirm Password</label>
                                        <input type="password" class="form-control" placeholder="Same as above Password">
                                    </div>


                                    <button type="submit" class="btn btn-default">Save</button>
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
