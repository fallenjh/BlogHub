/**
 * 
 */
Vue.component('b-register', {
  template: '<div>A Register component!<br>'
	  + '<button type="button" class="btn btn-danger" v-on:click="doRegister">注册</button></div>'
	  ,
  method : {
	  doRegister : function () {
//			this.showRegister = false;
//			this.showLogin = true;
//			loginMain();
		  this.$emit('doRegister');
        },
  }
});

Vue.component('b-login', {
  template: '<div>A Login component!</div>'
});


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
		logined : false,
		showRegister : false,
		showLogin : false
	},
    computed: {
        notLogined: function () {
          return !this.logined;
        }
      },
	methods : {
		changeMain : function (e) {
			this.showRegister = true;
			this.showLogin = false;
		},
		
		doRegister: function (e) {
			this.showRegister = true;
			this.showLogin = false;
//			loginMain();
		},
		
		doLogin: function (e) {
			this.showRegister = false;
			this.showLogin = true;
//			loginMain();
        },
        
        doLogout: function (e) {
        	this.userCode = "";
        	this.userName = "";
			sessionStorage.clear();
			this.logined = false;
		}
	}
	
});