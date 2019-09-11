var stompClient = null;

function connectMessageBroker() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/incomingBid', function (responseJSON) {
            handleBid(JSON.parse(responseJSON.body));
        });
    });
}


function handleBid(response) {

    var auctionId = response.auctionId;
    var secondsLeft = response.secondsLeft
    var numberOfBids = response.numberOfBids
    var itemPrice = response.itemPrice

    //alert(auctionId + " " + secondsLeft + " " + numberOfBids + " " + itemPrice)

        //ADD class that alerts user bid was made on this row
         $(".auctionROW#" + auctionId).addClass("newBid");

        //Removes class 3 seconds later
        setTimeout(function(){
             $(".auctionROW#" + auctionId).removeClass("newBid");
         }, 3000);


        //Finds the hidden span that holds the seconds.
        $('#'+auctionId).find("span.timeRemaining").text(secondsLeft);

        $('#'+auctionId).find("td.currentPrice").text("$" + numberWithCommas(itemPrice.toFixed(2)));


        $('#'+auctionId).find("td.numberOfBids").text(numberOfBids);
}



function placeBid(auctionId, amount) {

   if(stompClient.connected)
        stompClient.send("/app/placeBid", {}, JSON.stringify({'auctionId': auctionId, 'amount' : amount}));

}

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

$(document).ready(function(){
    connectMessageBroker()



});
