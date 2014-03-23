// JavaScript Document
var total=5;
var ad_number=0;
var time1;
var time2;
var first=0;


$(function(){
	time2=setInterval(showImgInTime, 1500);
	time1=setInterval(showImgInTime, 1700);
	
});
function showImgInTime(){
	//alert(ad_number);
	showImg(ad_number);
	ad_number++;
	
	if(ad_number==total){
		ad_number=0;
	}
	
	//if(time2!=null){
		//clearInterval(time2);
	//}
	//clearInterval(time2);
	//alert(ad_number);
}
function showImg(index){
	var ad_height = $(".ad").height();
    $(".ad_pic").stop(true,false).animate({top : -ad_height*index},1000);
    $(".ad_number span").removeClass("ad_number_on");
    $(".ad_number span:eq("+index+")").addClass("ad_number_on");
    //alert(ad_number);
}



function onPicture(index){
	clearInterval(time1);
	if(first==0){
		clearInterval(time2);
		first=2;
	}
	showImg(index-1);
}


function outPicture(index){
	ad_number=index;
	if(ad_number==total){
		ad_number=0;
		//alert(total);
	}
	time1=setInterval(showImgInTime, 1700);
	//time2=setInterval(showImgInTime, 1700);
}