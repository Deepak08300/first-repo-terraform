
var myscript = function(){

	
console.log('tesitngs on load1');
let xhr = new XMLHttpRequest();
xhr.open('POST', '/onload',true);

// send the request
xhr.send();
xhr.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200) {
var response = xhr.responseText;
console.log(response);
//response.push(response);
//document.getElementById("response").innerHTML = response;
var head;
this.head = response;
};	
}

}