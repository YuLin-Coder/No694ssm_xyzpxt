$(function() {

$("#title").blur(
		function() {
			$("#title_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#title").after("<span id='title_msg' style='color: red'>标题不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>招聘人数不能为空</span>");
			}
	});

$("#asignnum").blur(
		function() {
			$("#asignnum_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#asignnum").after("<span id='asignnum_msg' style='color: red'>报名人数不能为空</span>");
			}
	});

$("#salary").blur(
		function() {
			$("#salary_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#salary").after("<span id='salary_msg' style='color: red'>薪资不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>职务介绍不能为空</span>");
			}
	});







$('#sub').click(function(){
var title = $("#title").val();
var num = $("#num").val();
var asignnum = $("#asignnum").val();
var salary = $("#salary").val();
var contents = $("#contents").val();
$("#title_msg").empty();
$("#num_msg").empty();
$("#asignnum_msg").empty();
$("#salary_msg").empty();
$("#contents_msg").empty();
if (title == "" || title == null) {
	$("#title").after("<span id='title_msg' style='color: red'>标题不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>招聘人数不能为空</span>");
	return false;
}
if (asignnum == "" || asignnum == null) {
	$("#asignnum").after("<span id='asignnum_msg' style='color: red'>报名人数不能为空</span>");
	return false;
}
if (salary == "" || salary == null) {
	$("#salary").after("<span id='salary_msg' style='color: red'>薪资不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>职务介绍不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#title_msg").empty();
$("#num_msg").empty();
$("#asignnum_msg").empty();
$("#salary_msg").empty();
$("#contents_msg").empty();
});

});
