function populateCities(){

    let dropdown = document.getElementById('city');
    dropdown.length = 0;

    let defaultOption = document.createElement('option');
    defaultOption.text = 'Seleccione ciudad';

    dropdown.add(defaultOption);
    dropdown.selectedIndex = 0;

    const url = 'http://localhost:8090/resources/cities.json';

    const request = new XMLHttpRequest();
    request.open('GET', url, true);

    request.onload = function() {
    if (request.status === 200) {
        const data = JSON.parse(request.responseText);
        let option;
        for (let i = 0; i < data.length; i++) {
        option = document.createElement('option');
        option.text = data[i].name;
        option.value = data[i].id;
        dropdown.add(option);
        }
    } else {
        // Reached the server, but it returned an error
        console.error('Ocurrió error: ' + url);
    }   
    }

    request.onerror = function() {
    console.error('Ocurrió error: ' + url);
    };

    request.send();


}


function getCityData(){

    var e = document.getElementById("city");
	var selectedCity = e.options[e.selectedIndex].value;
	
	
	var today_span = document.getElementById("today");
	var cityName_span = document.getElementById("cityName");
	var overallDesc_span = document.getElementById("overallDescription");
	var farenheit_span = document.getElementById("farenheit");
	var celsius_span = document.getElementById("celsius");
	var sunrise_span = document.getElementById("sunrise");
	var sunset_span = document.getElementById("sunset");
	
	

    var request = new XMLHttpRequest()

    request.open('GET', 'http://localhost:8090/weather/'+selectedCity, true)
    request.onload = function() {
      // Begin accessing JSON data here
      var data = JSON.parse(this.response)
    
      if (request.status >= 200 && request.status < 400) {
          today_span.innerHTML = data.today;
		  cityName_span.innerHTML = data.cityName;
		  overallDesc_span.innerHTML = data.overallDescription;
		  farenheit_span.innerHTML = data.farenheit;
		  celsius_span.innerHTML = data.celsius;
		  sunrise_span.innerHTML = data.sunrise;
		  sunset_span.innerHTML = data.sunset;
      } else {
        console.log('error');
      }
    }
    
    request.send()

}