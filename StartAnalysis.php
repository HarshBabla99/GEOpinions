<?php
    if( isset($_POST['t']) && isset($_POST['l']) && isset($_POST['r']))
    {
		$topic = strip_tags($_POST['t']);
		$location = strip_tags($_POST['l']);
        $radius = strip_tags($_POST['r']);
        
        //Run python code to get result

        if( )
		{
			echo "success,"+result;
		}
		else
		{
			echo "The server failed to send the message. Please try again later";
		}
		
	}
    
    else
	{
		echo "The server failed to receive all the data";
	}
	
?>