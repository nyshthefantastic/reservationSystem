
function priceAdder(){
$(document).ready(function(){
			        $( "input[type=checkbox]" ).each(function(){
			            if($(this).is(':checked'))
			            {
			                var value = $(this).closest('tr').find($( "input[type=text]" )).val();
			                console.log(value);
			                var customerId = document.getElementById("xy").value;
			                console.log(customerId);
			            }
			        });
			    });

}