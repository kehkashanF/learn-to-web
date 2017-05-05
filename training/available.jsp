<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <title>Donate Blood - IBMS</title>
     <link href="css/bootstrap.css" rel="stylesheet"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
     <style type="text/css">
            .opaqueLayer
            {
                display:none;
                position:absolute;
                top:0px;
                left:0px;
                opacity:0.6;
                filter:alpha(opacity=60);
                background-color: #000000;
                z-Index:1000;
            }
            

            .questionLayer
            {
                position:relative;
                top:0px;
                left:0px;
                width:350px;
                height:200px;
                display:none;
                z-Index:1001;
                border:2px solid black;
                background-color:#FFFFFF;
                text-align:center;
                vertical-align:middle;
                padding:10px;
            }
        </style>
        <script type="text/javascript">
        $(document).ready(function(){
            if(((sessionStorage.getItem("itmClick1") == "Available")||(sessionStorage.getItem("itmClick1") == "Not Available"))
            		&&localStorage.getItem("did")== $("#d").val())
            {    
            	$("#avail").prop("disabled", true);
                $("#navail").prop("disabled", true);
            }
        	
            $("[name=na]").on("click", function(){
                sessionStorage.setItem("itmClick1", $(this).val());
                $("#avail").prop("disabled", true);
                $("#navail").prop("disabled", true);
                localStorage.setItem("did", $("#d").val());
            });
            
        });
        </script>
        <script type="text/javascript">
        	
        function getBrowserHeight() {
            var intH = 0;
            var intW = 0;
                    

           if(typeof window.innerWidth  == 'number' ) {
                        intH = window.innerHeight;
                        intW = window.innerWidth;
           }
            else if(document.documentElement && (document.documentElement.clientWidth || document.documentElement.clientHeight)) {
                         intH = document.documentElement.clientHeight;
                         intW = document.documentElement.clientWidth;
                     }
                     else if(document.body && (document.body.clientWidth || document.body.clientHeight)) {
                         intH = document.body.clientHeight;
                         intW = document.body.clientWidth;
                     }


                     return { width: parseInt(intW), height: parseInt(intH) };
                 }


                 function setLayerPosition() {
                     var shadow = document.getElementById("shadow");
                     var question = document.getElementById("question");


                     var bws = getBrowserHeight();
                     shadow.style.width = bws.width + "px";
                     shadow.style.height = bws.height + "px";


                     question.style.left = parseInt((bws.width - 350) / 2);
                     question.style.top = parseInt((bws.height - 200) / 2);


                     shadow = null;
                     question = null;
                 }


                 function showLayer() {
                     setLayerPosition();
                     
                var shadow = document.getElementById("shadow");
                var question = document.getElementById("question");
      

                shadow.style.display = "block";
                question.style.display = "block";


                   shadow = null;
                   question = null;
           }
            
           window.onresize = setLayerPosition;
           
   </script>
        
    </head>
    <body>
        <div id="shadow" class="opaqueLayer"> </div>
        <div id="question" class="questionLayer">
            <br />
            <br />
            <br />
            THANK YOU FOR YOUR RESPONSE!
	        <br />
            <br />
            <br />
        </div>
        <h3>PLEASE CHOOSE</h3>
        <p>Note: You can only choose once</p>
        <p>Donate to save a life!</p>
       <form action="CounterServlet" method="post">
       		<input type="hidden" value="<%=request.getParameter("rId")%>" name="rId">
			<input type="hidden" value="<%=request.getParameter("bId")%>" name="bId">
			<input type="hidden" id="d" value="<%=request.getParameter("dId")%>" name="dId">
			<input class="btn btn-default" type="submit" name="na" id="avail" value="Available" onclick="showLayer();"  >
       		<input class="btn btn-default" type="submit" name="na" id="navail" value="Not Available" onclick="showLayer();" >
       	</form> 
        
    </body>
</html>