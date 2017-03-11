/**
 * 
 */

function changeMain()
{
	$("div[role='main']").find("div.jumbotron").find("div").html('请注册');
}

function loginSuccess()
{
	$("div[role='main']").find("div.jumbotron").find("div").html('欢迎回来，CYS');
}

function loginMain(){
//	alert("out vue loginMain");
	$.ajax({ 
	url: "user/login", 
	data : {
		userCode :"cys", 
		userPwd : "1234"
	}, 
	type : "POST",
	success: function(str){
		var json = JSON.parse(str);
		vm.userCode = json.userCode;
		vm.userName = json.userName;
		sessionStorage.setItem("userCode", json.userCode);
		sessionStorage.setItem("userName", json.userName);
		vm.email = json.email;
		vm.logined = true;
      }
});
}

var vm = new Vue({
	el :　"#login-app",
	data : {
		userCode : '',
		userName : '',
		email : '',
		logined : false
	},
    computed: {
        notLogined: function () {
          return !this.logined;
        }
      },
	methods : {
		changeMain : function (e) {
			this.logined = false;
		},
		
		doLogin: function (e) {
			loginMain();
        },
        
        doLogout: function (e) {
        	this.userCode = "";
        	this.userName = "";
			sessionStorage.clear();
			this.logined = false;
		}
	}
	
});