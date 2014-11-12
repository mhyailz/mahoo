/**
 * Created by mahongyao on 2014/11/6.
 */
$(function(){
    /**
     * search box width
     */
    var _search_wd;

    /**
     *  jquery object  search
     */
    var $_search = $('.form-control');

    /**
     * init width
     */
    _search_wd = $_search.width();

    /**
     * event
     */
    $_search.on({
        'focus' : function(){
            $(this).stop(true).animate({
                'width' : _search_wd * 2
            },200)
        },
        'blur' : function(){
            if($.trim($(this).val()) != ''){
                return this;
            }
            $(this).stop(true).animate({
                'width' : _search_wd
            },200)
        }
    })


    $('.article-each').each(function(){
        $(this).css({
            'height' : $(this).height()
        })
    });

});