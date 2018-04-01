function _(id)
{	
	return document.getElementById(id);
}

function SubmitSearchForm()
{			
	_("SubmitButton").disabled = true;
	_("TwitterSentimentsTitle").innerHTML += _("location").value;
	
	var formdata = new FormData();
	formdata.append( "t", _("topic").value);
    formdata.append( "l", _("location").value);
	formdata.append( "r", _("radius").value);
	
	fetch('https://example.com/profile/avatar', {
		method: 'PUT',
		body: formData
	})

	.then(response => response.json())
	.catch(error => console.error('Error:', error))
	.then(response => console.log('Success:', response));


	
	
	var data1 = [
		{x: "Positive", value: SentimentsVec[1]},
		{x: "Neutral", value: 	SentimentsVec[2]},
		{x: "Negative", value: SentimentsVec[3]},
	];
	
	// create the chart
	var chart = anychart.pie();

	// set the chart title
	chart.title("");

	// add the data
	chart.data(data);

	// display the chart in the container
	chart.container('PieChartContainer');
	chart.draw();

    _("SubmitButton").disabled = false;	
	window.scrollTo(0, 615);

	
}