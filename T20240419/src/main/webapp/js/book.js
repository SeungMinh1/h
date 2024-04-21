/**
 * book.js
 */
console.log('start')
const fields = ['bookCode', 'bookTitle', 'author', 'company', 'price'];

document.addEventListener('DOMContentLoaded', function(e) {
	
	// 1.도서목록 출력하도록 작성하세요.
	document.querySelector('#blist').innerHTML='';

	const xhtp = new XMLHttpRequest();
	xhtp.open('get', 'bookListJson.do');
	xhtp.send();

	xhtp.onload = function() {
		let bookList = JSON.parse(xhtp.response);
		bookList.forEach(book => {
			document.getElementById('blist').appendChild(makeRow(book));
		});
	}
	
	

	 //2.등록이벤트를 작성하세요.
	document.querySelector('#addBtn').addEventListener('click', function(e) {
		console.log('qer');
		let bookCode = document.getElementById('bcode').value;
		let bookTitle = document.getElementById('bname').value;
		let author = document.getElementById('author').value;
		let company = document.getElementById('company').value;
		let price = document.getElementById('price').value;
		
		const addHtp = new XMLHttpRequest();
		addHtp.open('get', 'bookAddJson.do?bookCode='+bookCode+'&bookTitle='+bookTitle+'&author='+author
										+'&company='+company+'&price='+price);
		addHtp.send();
		
		addHtp.onload = function(){
			let result = JSON.parse(addHtp.response);
			if(result.retCode == 'Success'){
				alert('등록성공');
				document.querySelector('#blist').innerHTML='';
				const xhtp = new XMLHttpRequest();
				xhtp.open('get', 'bookListJson.do');
				xhtp.send();
		
				xhtp.onload = function() {
					let bookList = JSON.parse(xhtp.response);
					bookList.forEach(book => {
						document.getElementById('blist').appendChild(makeRow(book));
					});
				}
			}
		}
		
	})

	 //3.선택삭제 이벤트를 작성하세요.
	document.querySelector('#delBtn').addEventListener('click', function(e) {
		console.log('adf');
		$('#blist input[type="checkbox"]:checked').each((idx, elem) =>{
			let a = elem.parentElement.parentElement;
			
			const xelhtp = new XMLHttpRequest();
			xelhtp.open('get', 'bookRemoveJson.do?bookCode='+ $(a).find('td:eq(1)').text()) ;
			xelhtp.send();
			
			xelhtp.onload = function(){
				let result = JSON.parse(xelhtp.response);
				if (result.retCode == 'Success') {
					$(a).remove();
				}else{
					console.log('no');
				}
			}
		})
		
	})

	// 필요하면 함수를 작성하세요.
	
	
	function makeRow(books={}){
		let tr = document.createElement('tr');
		let td = document.createElement('td');
		let checkbox = document.createElement('input');
		checkbox.type = 'checkbox';
		td.appendChild(checkbox);
		tr.appendChild(td);
		
		fields.forEach(elem =>{
			td = document.createElement('td');
			td.innerHTML = books[elem];
			tr.appendChild(td);
		})
		
		td = document.createElement('td');
		let btn = document.createElement('button');
		btn.innerText='삭제';
		
		btn.addEventListener('click', function(e){
			const delHtp = new XMLHttpRequest();
			delHtp.open('get', 'bookRemoveJson.do?bookCode='+books.bookCode);
			delHtp.send();
			
			delHtp.onload = function(){
				let result = JSON.parse(delHtp.response);
				if(result.retCode == 'Success'){
					alert('삭제성공');
					tr.remove();
				}else if(result.retCode == 'Fail'){
					alert('삭제처리중 에러.');
				}else{
					alert('알수없는 코드입니다.');
				}
			}
		})
		td.append(btn);
		tr.append(td);
		
		return tr;
	}
	
	
	
	
	
	

})