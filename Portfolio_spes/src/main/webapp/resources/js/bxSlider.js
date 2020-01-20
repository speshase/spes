/**
 * 
 */

//alert("bxSlider 연결");

$(function(){
  $('.bxslider').bxSlider({
    mode:'fade',
    captions:true,
    speed:500, //슬라이드 이동속도
    auto:true, //자동슬라이드
    autoHover:true //마우스 호버시 정지여부
  });
});