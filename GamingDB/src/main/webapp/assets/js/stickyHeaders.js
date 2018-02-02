    var topPos;

    function AncorControlMatches() {
        topPos = $('#tableWithBg').offset().top,
         pos = $(document).scrollTop(),
         total = pos - topPos;
        if (pos > topPos) {
            $("#tableWithBg thead tr").css("top", total).addClass('scroll');
        } else {
            $("#tableWithBg thead tr").removeClass('scroll');
        }
    }


    $(window).scroll(function () {
        AncorControlMatches();
    });

    $(document).ready(function () {
        setTimeout(function () {
            AncorControlMatches();
            $(window).trigger('resize');
        }, 300);
    });