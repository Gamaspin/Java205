

// 회원의 정보 : 아이디, 비밀번호, 이름
// Member -> 생성자 함수 정의해보자

function Member(id, pw, name) {
    this.userID = id;
    this.userPW = pw;
    this.userName = name;
}
// 객체가 가지는 메소드는 공통으로 사용 
//   -> prototype을 이용하여 공통속성으로 사용하자
Member.prototype.makeHtml = function() {
    return '[id:' +this.userID+' , pw:'+this.userPW+' , name:'+this.userName+ ']'
};



// var member = new Member();
//////////////////////////////////////////////////////////////////

// 사용자가 입력한 정보를 가지고 Member 객체를 생성해보자
// submit의 event 연결을 해야한다
window.onload = function() {

    // regForm 캐스팅
    var regForm = document.getElementById('regForm');
    regForm.onsubmit = function(){
        // 사용자가 입력한 값



        return false;
    }
}