google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawTitleSubtitle);

function drawTitleSubtitle() {
      _("VarButton").disabled = true;
          
      var formdata3 = new FormData();
      formdata3.append( "t", _("VarSelect").value);

      fetch('https://example.com/profile/avatar', {
        method: 'PUT',
        body: formdata3
      })

      .then(response3 => response3.json())
      .catch(error3 => console.error('Error:', error3))
      .then(response3 => console.log('Success:', response3));

      var data = google.visualization.arrayToDataTable([
        ['City', 'Positive Sentiments', 'Neutral Sentiments', 'Negative Sentiments'],
        ['New York', 8175000, 8008000, 8008000],
        ['Los Angeles', 3792000, 3694000, 8008000],
        ['Chicago', 2695000, 2896000, 8008000],
        ['Houston', 2099000, 1953000, 8008000],
        ['Philadelphia', 1526000, 1517000, 8008000],
        ['Phoenix', 8175000, 8008000, 8008000],
        ['San Antonio', 3792000, 3694000, 8008000],
        ['San Diego', 2695000, 2896000, 8008000],
        ['Dallas', 2099000, 1953000, 8008000],
        ['San Jose', 1526000, 1517000, 8008000]
      ]);

      var materialOptions = {
        colors: ['#00b359', '#ffac59', '#ff3333'],
        hAxis: {
          title: 'Sentiment',
          minValue: 0
        },
        vAxis: {
          title: 'Cities'
        },
        bars: 'horizontal',
        legend: {
            position: 'none'
        }
      };
      var materialChart = new google.charts.Bar(document.getElementById('VarBarChartContainer'));
      materialChart.draw(data, materialOptions);
    }