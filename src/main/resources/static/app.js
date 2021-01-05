var stomp = null;


window.onload = function() {
    connect();
};

function connect() {
    var socket = new SockJS('/socket');
    stomp = Stomp.over(socket);
    stomp.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stomp.subscribe('/topic/cartProducts', function (cartDto) {
            renderItem(cartDto);
        });
    });
}


function renderItem(cartDtoJSON) {
    var cartDto = JSON.parse(productJson.body);
        $("#sum").html(cartDto.sum);
        $("#amount").html(cartDto.amountProducts);
}
