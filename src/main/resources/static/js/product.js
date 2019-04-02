var productImg = $(".unit-img");
var productDesc = $(".unit-desc");

$(document).ready(function () {
	productImg.fadeIn("slow");
	productDesc.fadeIn("slow");
});

var btns = document.getElementsByClassName('button-inc');

for (let btn of btns) {
	btn.addEventListener('click', updateAmount);
}

var availableAmount = parseInt(document.getElementById('unit-available').textContent.trim(), 10);

function updateAmount() {
	var num = parseInt(document.getElementById('amount').textContent.trim(), 10);
	this.value === "minus" ? num-- : num++;
	
	if(num < 1)
		num = 1;
	else if(num > availableAmount)
		num = availableAmount;
	
	document.getElementById('amount').textContent = num;
}



