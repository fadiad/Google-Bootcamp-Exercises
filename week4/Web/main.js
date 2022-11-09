// $("h1").css("background-color", "blue")
// $(".red-div").css("background-color", "red")
// $("li:first-child").css("background-color", "green")
// $("li:last-child").css("background-color", "pink")
//$("#brown-div").css("background-color", "brown")

// $("#b1").addClass("aa")



// $("#my-input").val("Terabyte")
// console.log($('#my-input').val());


// const color = $("#data").data().color  
// console.log(color) //prints #2980b9


// $("#b1").hover(function () {
//     $("#b1").css("background-color", "blue")
// })


// $('button').click(function(){
//     console.log($('input').val());
// })



// $("#b1").hover(function () {
//     console.log($(this))
// })


// $(".box").hover(function(){
//     $(this).css("background-color", "blue")
// })


$('.fruits').append('<p class="red">Raspberry</p>')
$('.fruits').append('<p class="brown">Kiwi</p>')



$(".feedme").on("click", function(){
    let divCopy =  "<div class='mine'>Oh yes</div>"
    $("body").append(divCopy)
  })