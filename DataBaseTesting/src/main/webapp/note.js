/**
 * 
 */
//var http = require('http');
/*'use strict';
define( [], function(){*/
//function note($scope , $http ){


var add = function(){
	var bookid = document.getElementById("bookid").value;
	var orderername = document.getElementById("orderername").value;
	var ordereraddress = document.getElementById("ordereraddress").value;
	var quantity = document.getElementById("quantity").value;
	const data = {bookid, orderername,ordereraddress,quantity};
	const data1 = JSON.stringify(data);
	let xhr = new XMLHttpRequest(); 
	xhr.open('POST', '/orderbook',true);
		
	    // send the request
		xhr.send(data1);
		xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		var response = xhr.responseText;
		console.log(response);
		
		};	
		}
};

