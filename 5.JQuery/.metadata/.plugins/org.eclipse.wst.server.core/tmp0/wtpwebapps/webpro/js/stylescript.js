/**
 * 
 */

function changeBorder(){
	arr = ["solid", "double", "dotted", "dashed", "inset", "outset"];
	
	cr = parseInt(Math.random() * 256);
	cg = parseInt(Math.random() * 256);
	cb = parseInt(Math.random() * 256);
	
	cr = cr.toString(16);
	cg = cg.toString(16);
	cb = cb.toString(16);
	//16진수로 변경
	
	color= "#" + cr + cg + cb;
	width = parseInt(Math.random() * 10 + 1);
	index = parseInt(Math.random() * arr.length);
	style = arr[index];
	//color = "rgb(" + cr + "," + cg + "," + cb + ")";
	
	//vdiv.style.borderWidth = width + "px"; 
	//백틱
	//vdiv.style.borderWidth = `${width}px`; 
	//vdiv.style.borderStyle = style;
	//vdiv.style.borderColor = color;
	
	vdiv.style.border = `${width}px ${style} ${color}`
}
changeColor = function(){
	//0-255(컬러의 개수) 사이의 난수 생성
	cr = parseInt(Math.random() * 256);
	cg = parseInt(Math.random() * 256);
	cb = parseInt(Math.random() * 256);
	
	//vdiv.style.color = "rgb(" + cr + "," + cg + "," + cb + ")";
	//백틱
	vdiv.style.color = `rgb(${cr}, ${cg}, ${cb})`;
}
//람다변수
changeSize = () =>{
	//15-40 사이의 난수 생성
	size = parseInt(Math.random() * 26 + 15);
	
	vdiv.style.fontSize = size + "px";
	
}