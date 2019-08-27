var craw_line_offset;

function enableCrawLine () {
    craw_line_offset = 0;
    var craw_line_width = document.getElementById('marquee_text').offsetWidth;
    if (craw_line_width < 145) {
        return;
    }
    moveCrawLine (craw_line_width);
}

function moveCrawLine (w) {
    var container_width = document.getElementById('marquee_container').offsetWidth;
    step = 1;
    w = parseInt(w);
    if (craw_line_offset<(w+container_width)) {
        craw_line_offset = craw_line_offset + step;
    } else {
        craw_line_offset = 0;
    }
    document.getElementById('marquee_text').style.left = parseInt(container_width-craw_line_offset)+'px';
    setTimeout('moveCrawLine ('+w+');', 50);
}

enableCrawLine ();

function keyInterceptor() {
    var isCtrl = false;
    $(document).keyup(function (e) {
        if(e.which === 17) isCtrl=false;
    }).keydown(function (e) {
        if(e.which === 17) isCtrl=true;
        if(e.which === 13 && isCtrl === true) {
            sendMsg();
        }
    });
}

keyInterceptor();

startMain();

function refPage() {
    setTimeout("refPage()", 10000);
    refMain();
}

refPage();