var $hamburger = $(".hamburger");
var $menuList = $(".menu-list");

$hamburger.click( function() {
	$hamburger.toggleClass("is-active");
	$menuList.slideToggle("slow");
});