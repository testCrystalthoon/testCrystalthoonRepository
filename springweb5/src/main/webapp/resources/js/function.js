function idCheck() {
	window.open('idCheck', null, 'top=100px, left=200px, width=400px, height=200px');
}
function searchId() {
	var id = document.getElementById('id').value;
	if(id.length < 3 || id.length > 10) {
		alert('ID는 3~10자로 입력해주세요.');
		return false;
	}
	return true;
}
function useThisId(param) {
	opener.document.getElementById('id').value = param;
	window.close();
}
function loginCheck() {
	var id = document.getElementById().value;
	var password = document.getElementById().value;
	if(id.length < 0) {
		alert('ID를 입력하세요.');
		return false;
	}
	if(password.length < 0) {
		alert('Password를 입력하세요.');
		return false;
	}
	return true;
}
function formCheck() {
	
}