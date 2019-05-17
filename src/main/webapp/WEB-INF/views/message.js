function validateform()
{
	var n=document.myform.cno.value;
	var x = document.myform.email.value;
	var y= document.myform.pwd.value;
	var z= confirm("Are you sure to submit the details ?");
	var atpos = x.indexOf("@");
	    var dotpos = x.lastIndexOf(".");
	    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
	        alert("Not a valid e-mail address");
	        return false;
	    }
	else if(y.length<8)
		{
		alert("Password must be atleast of 8 digit");
		return false;
		}
	else if(n.length<10||n.length>10)
		{
		alert("please enter a valid  contact number");
		return false;
		}
	else
		{
		if(v==true)
			{
			alert("ok");
			return true;
			}
		else
			{
			alert("cancel");
			return false;
			}
		}
	}