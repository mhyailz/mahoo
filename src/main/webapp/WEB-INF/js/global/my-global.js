/**
 * Created by mahongyao on 2014/11/6.
 */
;(function($){
    /**
     */
//    var _search_wd,
//        $_search = $('.form-control');
//
//    _search_wd = $_search.width();
//
//    $_search.on({
//        'focus' : function(){
//            $(this).stop(true).animate({
//                'width' : _search_wd * 2
//            },200)
//        },
//        'blur' : function(){
//            if($.trim($(this).val()) != ''){
//                return this;
//            }
//            $(this).stop(true).animate({
//                'width' : _search_wd
//            },200)
//        }
//    })

    $('.article-each').each(function(){
        if($(this).height() > 1000){
            $(this).css({
                'height' : $(this).height() / 4
            })
        }else{
            $(this).find('.bottom-shade').hide();
        }
    });

    $('.glyphicon-chevron-right').tooltip('hide');

    $("#to_the_top").scroll2Top();

})(jQuery);