


	$(document).ready(function() {
		

			var action = "api/movies";
			var method = "get"
		    var data = {}	    
		    
        $.ajax(
        		{
        	
                beforeSend: function (xhr){ 
              //  xhr.setRequestHeader("Content-Type","application/json");
                xhr.setRequestHeader("Accept","application/json");
            },
            
            type: method,
            url: action,
        //    dataType : 'json',
//            data : {email : $('#email').val(), password : $('#password').val() },//JSON.stringify(data),
            success : function(rs){              
            	console.log(rs);
            	display(rs);
            },
            error : function(ts){
            	console.log(ts.responseText);
                $(this).html("Error!");
            }
        });
			
	function display(rs){
		
		  var selection = d3.select("#list") 
          //Create virtual elements to be bound to the data
          .selectAll("li")
          //Bind each future 'li' elements with each item in the data
          .data(rs, function(d) { return d.Title; }); //.splice(0,100)
  

      
    //enter -> Operate only in new elements
      selection.enter() 
      
      .append("li")
    // .append("text")
     .style("color", "white")
      .style("font-size","16px")   
  //    .style("font-family","verdana")
      .style("letter-spacing","1pt")
  //    .style("font-style","italic")
      .style("font-weight", "bold")
      .style("line-height","1") 
          //Set the text inside the 'li' element to be the name and the GDP of the give country
      .text(function(d) { return d.Title})
      .on('click' , function(d) { console.log(d); xyz = d.Title; refresh(data); return d; });
	}
	});