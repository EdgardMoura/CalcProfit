function loadDoc() {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("demo").innerHTML = this.responseText;
    }
  xhttp.open("GET", "/findname/"+document.getElementById('fname').value, true);
  xhttp.send();
}

function loadDefault() {
    document.getElementById("demo").innerHTML = "<h2>Let AJAX change this text</h2>";
}

function loadDelete() {
	  const xhttp = new XMLHttpRequest();
	  xhttp.onload = function() {
	    document.getElementById("demo").innerHTML = this.responseText;
	    }
	  xhttp.open("GET", "/delete/"+document.getElementById('fdelete').value, true);
	  xhttp.send();
	}