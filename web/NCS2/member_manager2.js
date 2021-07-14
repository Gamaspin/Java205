function Member(id, pw, name) {
    this.userId = id;
    this.pw = pw;
    this.userName = name;
}

Member.prototype.makeHtml = function () {
    return '[id:' + this.userId + ' , pw: ' + this.pw + ' , name: ' + this.userName + ' ]'
};

var members = [];

$(document).ready(function () {

    if (localStorage.getItem('members') == null) {
        localStorage.setItem('members', JSON.stringify(members));
    } else {
        members = JSON.parse(localStorage.getItem('members'));
        console.log(members);
        setList();
    }

  var userId = $('#userId');
  var pw = $('#pw');
  var repw = $('#repw');
  var userName = $('#userName');

  $('#regForm').submit(function () {
    if ($(userId).val().trim().length < 1) {
      $('#userId + div.msg').css('display', 'block').html('필수항목입니다.');
      return false;
    }

    if ($(pw).val().trim().length < 1) {
      $('#pw + div.msg').css('display', 'block').html('필수항목입니다.');
      return false;
    }

    if ($(repw).val().trim().length < 1) {
      $('#repw + div.msg').css('display', 'block').html('필수항목입니다.');
      return false;
    }

    if ($(pw).val().trim() != $(repw).val().trim()) {
      $('#repw + div.msg').css('display', 'block').html('비밀번호가 일치하지 않습니다.');
      return false;
    }

    if ($(userName).val().trim() < 1) {
      $('#userName + div.msg').css('display', 'block').html('필수항목입니다.');
      return false;
    }

    members.push(new Member(userId.val(), pw.val(), userName.val()));
    localStorage.setItem('members', JSON.stringify(members));
    alert('등록되었습니다.');
    this.reset();
    setList();
    return false;
  });

  $(userId).focus(function () {
    $('#userId + div.msg').css('display', 'none').html('');
    userId.val('');
  });

  $(pw).focus(function () {
    $('#pw + div.msg').css('display', 'none').html('');
    pw.val('');
  });

  $(repw).focus(function () {
    $('#repw + div.msg').css('display', 'none').html('');
    repw.val('');
  });

  $(userName).focus(function () {
    $('#userName + div.msg').css('display', 'none').html('');
    userName.val('');
  });
});

function setList() {
  var tbody = '<tr>';
    tbody += '  <th>순번(index)</th>';
    tbody += '  <th>아이디</th>';
    tbody += '  <th>비밀번호</th>';
    tbody += '  <th>이름</th>';
    tbody += '  <th>관리</th>';
  tbody += '</tr>';

  if (members.length < 1) {
    tbody += '<tr>';
        tbody += '<td colspan="5">데이터가 존재하지 않습니다.</td>';
    tbody += '</tr>';
  } else {
    for (var i = 0; i < members.length; i++) {
      tbody += '<tr>';
      tbody += '  <td>' + i + '</td>';
      tbody += '  <td>' + members[i].userId + '</td>';
      tbody += '  <td>' + members[i].pw + '</td>';
      tbody += '  <td>' + members[i].userName + '</td>';
      tbody += '  <td> <a href="javascript:editMember(' + i + ')">수정</a> |' + '<a href="javascript:deleteMember(' + i + ')">삭제</a></td>';
      tbody += '</tr>';
    }
  }
  $(list).html(tbody);
}


// 회원 정보 수정
function editMember(index) {
    $('#editFormArea').css('display', 'block');

    var editUserId = $('#editId');
    var editPw = $('#editPw');
    var editRePw = $('#editRePw');
    var editName = $('#editName');
    var editIndex = $('#index');

    editUserId.val(members[index].userId);
    editPw.val(members[index].pw);
    editRePw.val(members[index].pw);
    editName.val(members[index].userName);
    editIndex.val(index);

    $('#editForm').on('submit', function () {
        if (editPw.val() != editRePw.val()) {
            alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
            return false;
        }
        if (!confirm('수정하시겠습니까?')) {
            return false;
        }
        members[editIndex.val()].pw = editPw.val();
        members[editIndex.val()].userName = editName.val();
        localStorage.setItem('members', JSON.stringify(members));
        alert('수정되었습니다.');
        setList();
        $('#editFormArea').css('display', 'none');
        return false;
    });
}

// 회원 정보 수정 창 닫기
function editMemberClose() {
  $('#editFormArea').css('display', 'none');
}

// 회원정보 삭제
function deleteMember(index) {
    if (confirm('삭제하시겠습니까?')) {
        members.splice(index, 1);
        alert('삭제되었습니다.');
        localStorage.setItem('members', JSON.stringify(members));
        setList();
    }
}


