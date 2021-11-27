// 验证用户名是否已经存在
function checkUser(obj) {
    $.ajax({
        url: contextPath + '/user/checkUserName',
        data: {"username": obj.value},
        method: "post",
        success: function (data) {
            $("#message").css("display", "block");
            if( data === "102") {
                $("#tip").html("用户名不合法");
                $("#tip").removeClass("alert-success");
                $("#tip").addClass("alert-danger");
            } else {
                $("#tip").html("用户名可以注册");
                $("#tip").removeClass("alert-danger");
                $("#tip").addClass("alert-success");
            }
        }
    })
}
// 验证密码长度是否合适
function checkLength(obj) {
    $("#pwdmsg").css("display", "block");
    if(obj.value.length <= 18 && obj.value.length >= 6){
        $("#wrongpwd").html("密码长度合法");
        $("#wrongpwd").removeClass("alert-danger");
        $("#wrongpwd").addClass("alert-success");
    } else {
        $("#wrongpwd").html("密码长度不合法");
        $("#wrongpwd").addClass("alert-danger");
        $("#wrongpwd").removeClass("alert-success");
    }
}
// 验证密码是否一致
function checkPassword(obj) {
    $("#msg").css("display", "block");
    if(obj.value != $("#password")[0].value){
        $("#cfmtip").html("密码不一致");
        $("#cfmtip").addClass("alert-danger");
        $("#cfmtip").removeClass("alert-success");
    }else {
        $("#cfmtip").html("密码一致");
        $("#cfmtip").removeClass("alert-danger");
        $("#cfmtip").addClass("alert-success");
    }
}
// 用户注册
function register() {
    var datas = $("#regForm").serialize();
    $.ajax({
        url: contextPath + '/user/register',
        data: datas,
        method: "post",
        success: function (data) {
            if(data === 'success'){
                alert("注册成功，请登录");
                $("#register").modal('hide');
            }
        }
    })
}
// 用户登录
function login() {
    var datas =  $("#loginForm").serialize();
    $.ajax({
        url: contextPath + '/user/login',
        data: datas,
        method: "post",
        success: function (data) {
            $("#userTip").css("display", "none");
            $("#pwdTip").css("display", "none");
            if(data == 100){
                $("#loginModal").modal('hide');
                window.location.href = contextPath + "/book/index";
            } else if(data == 101) {
                $("#userTip").css("display", "block");
            } else  {
                $("#pwdTip").css("display", "block");
            }
        }
    })

}
// 搜索功能
function searchData() {
    var search = $("#search").val();
    var datas = $("#searchForm").serialize();
    // $("#searchList").load(contextPath + "/book/getBookSearch", querySearch($("#search").val()))
    $.ajax({
        url: contextPath + "/book/checkBookSearch",
        data: datas,
        method: "post",
        success: function (data) {
            if(data == "102"){
                window.location.href = contextPath + "/book/searchList";
            }else {
                window.location.href = contextPath + "/book/index";
            }
        }
    })
}
function querySearch(search) {
    var query = {};
    query.search = search;
    return query;
}