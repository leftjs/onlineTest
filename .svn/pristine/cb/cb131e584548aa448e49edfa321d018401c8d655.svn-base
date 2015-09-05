function Calendar(year, month){
	this.year = year;
	this.month = month;
	
	this.getLastDayOfMonth = function(){
		return new Date(year, month, 0).getDate();
	}

	this.getDayOfWeek = function(){
		return new Date(year, month-1, 1).getDay();
	}
}

function fillCalen(now){
	$('#calen tr:gt(0)').remove();
	var dayCountOfMonth = now.getLastDayOfMonth();
	var dayOfWeek = now.getDayOfWeek();
	var rowCount = Math.ceil((dayCountOfMonth + dayOfWeek)/7);
	var $rowTpl = $('#calen tr:eq(0)');
	for(var i=0;i<rowCount;i++){
		var $newTr = $rowTpl.clone().css({'backgroundColor':'#fff',color:'black'}).appendTo('#calen table');
		$newTr.find('td').html('').click(function(){
			$('td[f]').removeAttr('f').css({backgroundColor:'#fff', color:'#000'});
			$(this).attr('f',1).css({backgroundColor:'blue', color:'#fff'});
		}).dblclick(function(){
			var year = $('#year').val();
			var month = $('#month').val();
			var date = this.innerHTML;
			window.calen.value = year +'-'+month+'-'+date;
			$('#calen').hide();
		});
	}
	
	//填充空格和日期
	var cellContentArr = [];
	for(var i=0;i<dayOfWeek;i++){
		cellContentArr.push('');
	}
	for(var i=1;i<=dayCountOfMonth;i++){
		cellContentArr.push(i);
	}
	$('#calen tr:gt(0) td').each(function(idx, o){
		$(this).html(cellContentArr[idx]);
	});
}
$(function(){	$('body').attr('focus', 'true');
	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth() + 1;
	var now = new Calendar(year, month);
	var $calen = $('<div id="calen"/>').css({
		width:160,
		border:'1px solid blue',
		position:'absolute',
		backgroundColor:'#fff',
		cursor:'pointer'
	}).hide().click(function(){
		return false;
	}).appendTo('body');

	$('<div>&nbsp;<select id="year"/>&nbsp;年&nbsp;&nbsp;<select id="month"/>&nbsp;月</div>')
		.css({padding:3,fontSize:'13px'}).appendTo($calen);
	
	for(var i=1990;i<=2020;i++){
		var $option = $('<option/>').val(i).html(i);
		if(i == year){
			$option.attr('selected', true);
		}
		$('#year').append($option);
	}	
	var monthArr = ['一','二','三','四','五','六','七','八','九','十','十一','十二'];
	for(var i=1;i<=12;i++){
		$('#month').append($('<option value="'+i+'" ' +(i==month?"selected":"")+ '/>').html(monthArr[i-1]));
	}
	
	$('<table width="100%"><tr><td>日</td><td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td></tr></table>')
		.css({textAlign:'center',fontSize:'12px',borderCollapse:'collapse'}).appendTo($calen);	
	console.log($('#calen tr:eq(0)').length);
	

	$('#calen tr:eq(0)').css({backgroundColor:'blue',color:'#fff'});
	fillCalen(now);

	$('.calen').focus(function(){
		window.calen = this;
		var offset = $(this).offset();
		var width = $(this).width();
		$calen.css({
			top:offset.top + 20,
			left:offset.left + width + 20}
		).show();
	}).click(function(e){
		return false;
	});

	$('#calen select').change(function(){
		var year = $('#year').val();
		var month = $('#month').val();
		fillCalen(new Calendar(year, month));
	});

	$(document).click(function(){
		$calen.hide();
	});

	
});