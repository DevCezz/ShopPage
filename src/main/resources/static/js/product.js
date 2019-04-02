var productImg = $(".unit-img");
var productDesc = $(".unit-desc");
var amountToPass = document.getElementById('amount');

$(document).ready(function () {
	productImg.fadeIn("slow");
	productDesc.fadeIn("slow");
	amountToPass.value = 1;
});

var btns = document.getElementsByClassName('button-inc');

for (let btn of btns) {
	btn.addEventListener('click', updateAmount);
}

var availableAmount = parseInt(document.getElementById('unit-available').textContent.trim(), 10);

function updateAmount() {
	var num = parseInt(document.getElementById('amount-num').textContent.trim(), 10);
	this.value === "minus" ? num-- : num++;
	
	if(num < 1)
		num = 1;
	else if(num > availableAmount)
		num = availableAmount;
	
	document.getElementById('amount-num').textContent = num;

	amountToPass.value = num;
}



