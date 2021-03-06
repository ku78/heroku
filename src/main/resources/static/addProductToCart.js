var stomp = null;

// подключаемся к серверу по окончании загрузки страницы
window.onload = function() {
    connect();
    $("a.class").on('click', function (e) {
        e.preventDefault();
        sendContent(this.id);
    });
};

function connect() {
    var socket = new SockJS('/socket');
    stomp = Stomp.over(socket);
    stomp.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stomp.subscribe('/topic/addToCart', function (cartDto) {
        console.log('topic/addToCart: ');
        renderItem(cartDto);
        //alert("Added to cart");
        });
    });
}

//// отправка сообщения на сервер
function sendContent(id) {
    stomp.send("/app/products/addToCart", {}, JSON.stringify({'id': id}));
}

// рендер сообщения, полученного от сервера
function renderItem(cartDtoJSON) {
    var cartDto = JSON.parse(cartDtoJSON.body);
        $("#sum").html(cartDto.sum);
        $("#amount").html(cartDto.amountProducts);
}
