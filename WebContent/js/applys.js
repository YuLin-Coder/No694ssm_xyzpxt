$(function() {

$("#url").blur(
		function() {
			$("#url_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#url").after("<span id='url_msg' style='color: red'>简历文件不能为空</span>");
			}
	});







$('#sub').click(function(){
var url = $("#url").val();
$("#url_msg").empty();
if (url == "" || url == null) {
	$("#url").after("<span id='url_msg' style='color: red'>简历文件不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#url_msg").empty();
});

});
