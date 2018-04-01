google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawTitleSubtitle);

function drawTitleSubtitle() {
      _("LocButton").disabled = true;
      
      var formdata2 = new FormData();
	    formdata2.append( "l", _("Loc").value);

      fetch('https://example.com/profile/avatar', {
        method: 'PUT',
        body: formdata2
      })

      .then(response2 => response2.json())
      .catch(error2 => console.error('Error:', error2))
      .then(response2 => console.log('Success:', response2));


      var bar_data = google.visualization.arrayToDataTable([
        ['Trend', 'Positive Sentiments', 'Neutral Sentiments', 'Negative Sentiments'],
        ['Gun Violence', 8175000, 8008000, 8008000],
        ['Elections', 3792000, 3694000, 8008000],
        ['March Madness', 2695000, 2896000, 8008000],
        ['Trump', 2099000, 1953000, 8008000],
        ['NASA', 1526000, 1517000, 8008000],
        ['Temp1', 8175000, 8008000, 8008000],
        ['Temp2', 3792000, 3694000, 8008000],
        ['Temp3', 2695000, 2896000, 8008000],
        ['Super Bowl', 2099000, 1953000, 8008000],
        ['Temp4', 1526000, 1517000, 8008000]
      ]);

      var materialOptions = {
        colors: ['#00b359', '#ffac59', '#ff3333'],
        hAxis: {
          title: 'Sentiment',
          minValue: 0
        },
        vAxis: {
          title: 'Trends'
        },
        bars: 'horizontal',
        legend: {
          position: 'none'
        }
      };
      var materialChart = new google.charts.Bar(document.getElementById('BarChartContainer'));
      materialChart.draw(bar_data, materialOptions);
    }