<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Delete Event or Inventory</title>

 
</head>

<script>
function f()
{
alert("Are you sure?");
document.getElementById("deleteConfirmed").disabled=false;

	}
</script>

<style>
div {
color:#667292;

}

</style>
<body>
<div class = "container" align = "center">
<form action='deleteInventory.htm' method='POST'><!-- /HW5_P2/addSuccessfully.htm -->
        <h1>Enter the inventoryID you want to delete:</h1>
       	<label>Inventory/Event ID:</label> <input type="text"   name="inventoryID" />
       	<br/>
       Inventory/Event type: <select name='isselect' class="selectpicker" multiple title="Choose one of the following...">
            <option value='Inventory' >Delete An Inventory</option>
            <option value='Event' >Delete Event</option>
         </select >
         <!-- 
          <option value='Movie' >Delete a Movie</option>
            <option value='Music' >Delete Music</option>
         -->
		<br/><br/>
		<button type="button" class="btn btn-primary btn-lg active" onClick="f()">Delete</button>
		<button type="submit" ID = "deleteConfirmed" class="btn btn-lg btn-primary" disabled="disabled">Confirm</button> 
		
		${warning}
</form>
</div>
</body>
</html>