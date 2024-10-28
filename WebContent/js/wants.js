$(function() {

$("#title").blur(
		function() {
			$("#title_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#title").after("<span id='title_msg' style='color: red'>标题不能为空</span>");
			}
	});

$("#salary").blur(
		function() {
			$("#salary_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#salary").after("<span id='salary_msg' style='color: red'>薪水预期不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>个人介绍不能为空</span>");
			}
	});







$('#sub').click(function(){
var title = $("#title").val();
var salary = $("#salary").val();
var contents = $("#contents").val();
$("#title_msg").empty();
$("#salary_msg").empty();
$("#contents_msg").empty();
if (title == "" || title == null) {
	$("#title").after("<span id='title_msg' style='color: red'>标题不能为空</span>");
	return false;
}
if (salary == "" || salary == null) {
	$("#salary").after("<span id='salary_msg' style='color: red'>薪水预期不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>个人介绍不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#title_msg").empty();
$("#salary_msg").empty();
$("#contents_msg").empty();
});

});
