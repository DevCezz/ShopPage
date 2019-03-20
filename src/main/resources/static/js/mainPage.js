var productData = $(".prod-data");
var productImg = $(".prod-img");

$(document).ready(function () {
	productData.fadeIn("slow");
	productImg.css("transition-duration", "0.6s");
});

productData.mouseover(function () {
	$(this).find(".prod-img").css("filter", "grayscale(100%)")
});

productData.mouseout(function () {
	$(this).find(".prod-img").css("filter", "grayscale(0%)")
});