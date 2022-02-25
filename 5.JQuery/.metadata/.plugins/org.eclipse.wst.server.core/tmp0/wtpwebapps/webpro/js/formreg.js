/**
 * 
 */

function formcheck1(){
	//입력받은 값들을 가져온다. - value
	f = document.ff;
	//====================================================
	idvalue = f.id.value.trim();
	idlen = idvalue.length;
	if(idlen < 1){
		alert("ID를 입력하세요.");
		return false;
	}
	if(idlen < 8 || idlen > 20){
		alert("ID는 8~20 사이 입니다.");
		return false;
	}
	
	idreg = /^[a-z][a-zA-Z0-9-_]{7,19}$/;
	if(!(idreg.test(idvalue))){
		alert("형식에 맞지 않는 ID입니다.");
		return false;
	}
	//====================================================
	
	birthvalue = f.birth.value.trim();
	birthlen = birthvalue.length;
	if(birthlen < 1){
		alert("생일을 입력하세요.");
		return false;
	}
	//====================================================
	
	namevalue = f.name.value.trim();
	namelen = namevalue.length;
	if(namelen < 1){
		alert("이름을 입력하세요.");
		return false;
	}
	if(namelen < 2 || namelen > 5){
		alert("이름은 2~5 사이 입니다.");
		return false;
	}
	
	namereg = /^[가-힣]{2,5}$/;
	if(!(namereg.test(namevalue))){
		alert("형식에 맞지 않는 이름입니다.");
		return false;
	}
	//====================================================
	
	telvalue = f.tel.value.trim();
	tellen = telvalue.length;
	if(tellen < 1){
		alert("휴대폰 번호를 입력하세요.");
		return false;
	}
	
	telreg = /^\d{3}-\d{3,4}-\d{4}$/;
	if(!(telreg.test(telvalue))){
		alert("형식에 맞지 않는 휴대폰 번호입니다.");
		return false;
	}
	
	emailvalue = f.email.value.trim();
	if(emailvalue.length < 1){
		alert("이메일을 입력하세요.");
		return false;
	}
	
	emailreg = /^[a-zA-Z0-9-_]+@[a-zA-Z]+(\.[a-zA-Z]+){1,2}$/;
	if(!(emailreg.test(emailvalue))){
		alert("형식에 맞지 않는 이메일입니다.");
		return false;
	}
	//====================================================
	
	//전방탐색 : \w+(?=찾는문자열) : '찾는문자열'을 기준으로 앞의 어떤 문자나 숫자를 찾는것
	//aa = "http://daum.net";
	/* aa = "https://daum.net";
		
	reg = /\w+(?=:)/;
		
	bb = aa.match(reg);
	
	alert(bb); */
	
	passvalue = f.pass.value.trim();
	if(passvalue.length < 1){
		alert("패스워드를 입력하세요.");
		return false;
	}
	
	if(passvalue.length < 8 || passvalue.length > 20){
		alert("패스워드는 8~20 사이 입니다");
		return false;
	}
	passreg = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#$@!]).{8,20}$/;
	//.* : 어떤 문자가 0번 이상 온다(올수도 안올수도 있음)
	if(!(passreg.test(passvalue))){
		alert("형식에 맞지 않는 패스워드입니다.");
		return false;
	}
	
	pass2value = f.pass2.value.trim();
	if(passvalue != pass2value){
		alert("패스워드가 일치하지 않습니다.");
		return false;
	}
	return true;
}

function formcheck2(){
	f = document.ff;
	
	idvalue = f.id.value.trim();
	idlen = idvalue.length;
	if(idlen < 1){
		alert("ID를 입력하세요.");
		return false;
	}
	if(idlen < 8 || idlen > 20){
		alert("ID는 8~20 사이 입니다.");
		return false;
	}
	
	idreg = /^[a-z][a-zA-Z0-9-_]{7,19}$/;
	if(!(idreg.test(idvalue))){
		alert("형식에 맞지 않는 ID입니다.");
		return false;
	}
	return true;
}