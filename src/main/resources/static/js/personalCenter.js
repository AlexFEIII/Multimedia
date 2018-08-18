var oLdA = $('.nav .same_a').eq(0);
$('.nav .same_a').on('click', function () {
    oLdA.css({
        "border-bottom": "",
    });
    oLdA = $(this);
    $(this).css({
        "border-bottom": "2px solid #1A2D27",
    });
});

$(document).on("click", '.same_a,.user_list a,.second_list a', function () {
    $("body").getNiceScroll().resize();
});
//通过class绑定click事件，可以只点击一次就触发事件，否则需要点击两次

var Select_One_Div = $('.Select_One_Div');

var oLd_div = $('.all_content .Select').eq(0);

$('.nav .same_a').on('click', function () {
    var index = $('.nav .same_a').index(this); //判断元素在当前的位置是第几个元素
    oLd_div.css({
        display: 'none',
    });
    oLd_div = $('.all_content .Select').eq(index);
    $('.all_content .Select')
        .eq(index)
        .css({
            display: 'flex',
        });
    $('.lastLong').css({
        'display': 'none',
    });
});

var length = $('.user_list a').length;
var Select_Two_Div = $('.Select_Two_Div');

for (var i = 0; i < length; i++) {
    var select_two = $('<div class="Select_Much"></div>');
    Select_Two_Div.append(select_two);
}

$('.Select_Much').eq(0).css({
    "display": "block",
});

var oLd = $('.user_list a').eq(0);
var oLdDiv = $('.Select_Much').eq(0);
$('.user_list a').on('click', function () {
    var index = $('.user_list a').index(this); //判断元素在当前的位置是第几个元素
    oLdDiv.css({
        display: 'none',
    });
    oLdDiv = $('.Select_Much').eq(index);
    $('.Select_Much')
        .eq(index)
        .css({
            display: 'block',
        });
    oLd.css({
        background: '',
    });
    oLd = $(this);
    $(this).css({
        background: '#dbdada',
    });
    //清空上一个的属性，给当前的元素添加属性
});
//左边书籍的列表

var SelectDiv = $('.Select_Much');

var ImgArray = new Array(7);

// SelectDiv.eq().find("img").attr("src", ImgArray[]);
// SelectDiv.eq().find(".under_line").html("");
// SelectDiv.eq().find(".bottom_first_a").html("");
// SelectDiv.eq().find(".bottom_two_a").append("<b></b>");
// SelectDiv.eq().find(".bottom_first_span").append("<b></b>");
// SelectDiv.eq().find(".bottom_two_span").append("<b></b>");
// SelectDiv.eq().find("p").html("");
//模板


$(function () {
    $(".draw_text").each(function () {
        var maxwidth = 72;
        if ($(this).text().length > maxwidth) {
            $(this).text($(this).text().substring(0, maxwidth));
            $(this).html($(this).html() + "...");
        };
    });
    //限制字数，超过显示...
});



var Issue = new Array(1);
Issue[0] = "../img/4.jpg";

var Video_list = $('#VideoList');
var article_list = $('.article_list');
var select_Btn = $('<div class="Select_Much" style="display:flex;"></div>');
var get_more_one = $('<div class="contain_a"><a class="contain_span" href="javascript:;"><span class="change_circle">Get More<i class="iconfont">&#xe6c3;</i></span></a></div>');
var get_more_two = $('<div class="contain_a"><a class="contain_span" href="javascript:;"><span class="change_circle">Get More<i class="iconfont">&#xe6c3;</i></span></a></div>');
var get_more_three = $('<div class="contain_a"><a class="contain_span" href="javascript:;"><span class="change_circle">Get More<i class="iconfont">&#xe6c3;</i></span></a></div>');


var answer_list = $('#AnswerList');

var collect_video = $('.collect_video');
var collect_article = $('.collect_article');
var collect_answer = $('.collect_answer');

for (var i = 0; i < 8; i++) {
    var collect_answer_list = $('<div class="issueOutContainer"><div class="ShadowBoxConatiner"><a href="javascript:;"><img src=""><span></span></a><span class="issue"></span></div></div>');
    $('.collect_answer .recommed_topic').append(collect_answer_list);
}

$('.collect_answer .recommed_topic').find("img").attr("src", Issue[0]);
$('.collect_answer .recommed_topic').find(".top_img_span").html("知识产权保卫战");
$('.collect_answer .recommed_topic').find(".issue").html("该议题被浏览 2223661 次");

for (var i = 0; i < 22; i++) {
    var c_video = $('<div class="same_module"><a href="javascript:;"><img src="../img/15.jpg"></a><span>梨视频</span></div>');
    collect_video.append(c_video);
}

$('.same_module a').hover(function () {
    $(this).addClass("a_hover a_hover_a");
}, function () {
    $(this).removeClass("a_hover a_hover_a");
});

var select_Article = $('<div class="Select_Much" style="display:flex;"></div>');

for (var i = 0; i < 7; i++) {
    var wen_list = $('<div class="other_module"><div class="left_part"><a href="javascript:;" class="under_line"></a><p class="draw_text"></p><div class="bottom_meta"><a href="javascript:;" class="bottom_first_a"></a><a href="javascript:;" class="bottom_two_a"><i class="iconfont">&#xe684;</i></a><span class="bottom_first_span"><i class="iconfont">&#xe602;</i></span><span class="bottom_two_span"><i class="iconfont">&#xe672;</i></span></div></div><a href="javascript:;" class="replace_img"><img src=""/></aa></div>');
    select_Article.append(wen_list);
}

collect_article.append(select_Article);

select_Article.eq(0).find("img").attr("src", ImgArray[0]);
select_Article.eq(0).find(".under_line").html("五一，差点只剩半条命！");
select_Article.eq(0).find(".bottom_first_a").html("5312Ana");
select_Article.eq(0).find(".bottom_two_a").append("<b>20</b>");
select_Article.eq(0).find(".bottom_first_span").append("<b>19</b>");
select_Article.eq(0).find(".bottom_two_span").append("<b>1</b>");
select_Article.eq(0).find("p").html("原本打算五一跟朋友跑完半程马拉松后就去北海拍海景，然而不幸的是，她准备跑到终点时突然晕倒了，虽然我没体验过这种晕倒的感觉，但可以想象出这种从鬼门关出来人的有多不易。");

$('.nav .same_a').eq(4).on('click', function () {
    $('.lastLong').css({
        'display': 'block',
    });
});

var OldElement = $('.collect').eq(0);

$('.second_list a').on('click', function () {
    var index = $('.second_list a').index(this);
    OldElement.css({
        'display': 'none',
    });
    OldElement = $('.collect').eq(index);
    $('.collect').eq(index).css({
        'display': 'flex',
    });
});

var firstul = $(".first_ul");
var docul = $(".user_list").children("ul");
//标志位，标记是否已经请求
var vf = false;
var dif = false,dlf = false,dmf = false,def = false,dhf = false,dsf = false,daf = false;
var ff = false;
var hf = false;
var cvf = false,cdf = false,cff = false;
//页面加载的时候执行点击事件
$(document).ready(function () {
    //加载视频
    firstul.children("li:eq(0)").click();
    //判断是否已经登录
    $.ajax({
        url:"../user/isLogin",
        type:"get",
        success:function (data) {
            console.log(data);
            if (data != ""){
                loginSuccess(data);
            }
        }
    });
});
firstul.children("li:eq(0)").click(function () {
    if (vf == false){
        $.ajax({
            url:"../video/mine",
            type:"get",
            success:function (data) {
                vf = true;
                for (var i = 0;i < data.length;i ++){
                    var select_one = $('<div class="same_module"><a href="javascript:;"><img src="'+data[i].video.image+'"></a><span>'+data[i].video.title+'</span></div>');
                    Select_One_Div.append(select_one);
                }
            },error:function (data) {
                //ignore
            }
        });
    }
});
firstul.children("li:eq(1)").click(function () {
    if (dif == false){
        dif = getMineDoc("internet",0);
    }
});
docul.children("li:eq(1)").click(function () {
    if (dlf == false){
        dlf = getMineDoc("law",1)
    }
});
docul.children("li:eq(2)").click(function () {
    if (dmf == false){
        dmf = getMineDoc("medicine",2)
    }
});
docul.children("li:eq(3)").click(function () {
    if (def == false){
        def = getMineDoc("economy",3)
    }
});
docul.children("li:eq(4)").click(function () {
    if (dhf == false){
        dhf = getMineDoc("history",4)
    }
});
docul.children("li:eq(5)").click(function () {
    if (dsf == false){
        dsf = getMineDoc("science",5)
    }
});
docul.children("li:eq(6)").click(function () {
    if (daf == false){
        daf = getMineDoc("art",6)
    }
});
function getMineDoc(type,num) {
    $.ajax({
        url:"../doc/mine/"+type,
        type:"get",
        success:function (data) {
            console.log(data);
            var username;
            for (var i = 0;i < data.length;i ++){
                username = data[i].mulUser.nickname;
                var image = "";
                if (username == null) username = data[i].mulUser.username;
                if (data[i].document.image != null) image = '<img src="'+data[i].document.image+'"/>';
                var AddDiv = $('<div class="other_module"><div class="left_part"><a style="color: #333;" href="article.html?id='+data[i].document.id+'" target="_blank" class="under_line">'+data[i].document.title+'</a><p class="draw_text">'+data[i].document.summary+'</p><div class="bottom_meta"><a href="javascript:;" class="bottom_first_a">'+username+'</a><a href="javascript:;" class="bottom_two_a"><i class="iconfont">&#xe684;</i><b>'+data[i].document.commentnum+'</b></a><span class="bottom_first_span"><i class="iconfont">&#xe602;</i><b>'+data[i].document.upvotenum+'</b></span><span class="bottom_two_span"><i class="iconfont">&#xe672;</i></span></div></div><a href="javascript:;" class="replace_img">'+image+'</aa></div>')
                SelectDiv.eq(num).append(AddDiv);
            }
            return true;
        },error:function (data) {
            //ignore
            return false;
        }
    });
}
firstul.children("li:eq(2)").click(function () {
    if (ff == false){
        $.ajax({
            url:"../forum/mine",
            type:"get",
            success:function (data) {
                ff = true;
                for (var i = 0;i < data.length;i ++){
                    var image = "../img/14.png";
                    if (data[i].forum.image != null) image = data[i].forum.image;
                    var five_block = $('<div class="issueOutContainer"><div class="ShadowBoxConatiner"><a href="javascript:;"><img src="'+image+'"><span>'+data[i].forum.title+'</span></a><span class="issue"></span></div></div>');
                    $('.Select_Three_Div .recommed_topic').append(five_block);
                }
            },error:function (data) {
                //ignore
            }
        });
    }
});
firstul.children("li:eq(3)").click(function () {
    if (hf == false){
        var historyVF = false;
        $.ajax({
            url:"../history/video",
            type:"get",
            async:false,
            success:function (data) {
                var num = 15,count = data.length;
                if (count < 15) num = count;
                for (var i = 0;i < num;i ++){
                    var v_list = $('<div class="same_module"><a href="javascript:;"><img src="'+data[i].image+'"></a><span>'+data[i].title+'</span></div>');
                    $("#VideoBox").append(v_list);
                }
                if (count > 15){
                    Video_list.append('<div id="pagingOne" class="pagingTool"></div>');
                    $('#pagingOne').Paging({
                        pagesize: 15,
                        count:data.length,
                        prevTpl: '<i class="iconfont">&#xe78c;</i>',
                        nextTpl: '<i class="iconfont">&#xe77c;</i>',
                        firstTpl: '<i class="iconfont">&#xe609;</i>',
                        lastTpl: '<i class="iconfont">&#xe6de;</i>',
                        callback:function (page,size,count) {
                            console.log("num: "+page);
                            $("#VideoBox").empty();
                            var n = page*15-1;
                            if (data.length-1 < n) n=data.length-1;
                            for (var i = (page-1)*15;i <= n;i ++){
                                var v_list = $('<div class="same_module"><a href="javascript:;"><img src="'+data[i].image+'"></a><span>'+data[i].title+'</span></div>');
                                $("#VideoBox").append(v_list);
                            }
                        }
                    });
                    $('#pagingTwo').children("li").on('click', function () {
                        $('#'+name).css({
                            '-webkit-user-select': 'none',
                            '-moz-user-select': 'none',
                            '-ms-user-select': 'none',
                            'user-select': 'none'
                        });
                    });
                }else{
                    Video_list.append('<div class="contain_a" style="padding-bottom: 20px;"><span style="text-align: center;color: #8b8c8b;">——您当前仅浏览过这些视频——</span></div>')
                }
            },error:function (data) {
                //ignore
            }
        });
        Video_list.append(get_more_one);
        $.ajax({
            url:"../history/doc",
            type:"get",
            async:false,
            success:function (data) {
                var username,num = 8;
                if (data.length < 8) num = data.length;
                for (var i = 0;i < num;i ++){
                    username = data[i].mulUser.nickname;
                    var image = "";
                    if (username == null) username = data[i].mulUser.username;
                    if (data[i].document.image != null) image = '<img src="'+data[i].document.image+'"/>';
                    var a_list = $('<div class="other_module"><div class="left_part"><a style="color: #333;" href="article.html?id='+data[i].document.id+'" target="_blank" class="under_line">'+data[i].document.title+'</a><p class="draw_text">'+data[i].document.summary+'</p><div class="bottom_meta"><a href="javascript:;" class="bottom_first_a">'+username+'</a><a href="javascript:;" class="bottom_two_a"><i class="iconfont">&#xe684;</i><b>'+data[i].document.commentnum+'</b></a><span class="bottom_first_span"><i class="iconfont">&#xe602;</i><b>'+data[i].document.upvotenum+'</b></span><span class="bottom_two_span"><i class="iconfont">&#xe672;</i></span></div></div><a href="javascript:;" class="replace_img">'+image+'</aa></div>');
                    select_Btn.append(a_list);
                }
                article_list.append(select_Btn);
                if (data.length > 8) {
                    article_list.append('<div id="pagingTwo" class="pagingTool"></div>');
                    $('#pagingTwo').Paging({
                        pagesize: 8,
                        count:data.length,
                        prevTpl: '<i class="iconfont">&#xe78c;</i>',
                        nextTpl: '<i class="iconfont">&#xe77c;</i>',
                        firstTpl: '<i class="iconfont">&#xe609;</i>',
                        lastTpl: '<i class="iconfont">&#xe6de;</i>',
                        callback:function (page,size,count) {
                            console.log("num: "+page);
                            select_Btn.empty();
                            var n = page*8-1;
                            if (data.length-1 < n) n=data.length-1;
                            for (var i = (page-1)*8;i <= n;i ++){
                                var a_list = $('<div class="other_module"><div class="left_part"><a style="color: #333;" href="article.html?id='+data[i].document.id+'" target="_blank" class="under_line">'+data[i].document.title+'</a><p class="draw_text">'+data[i].document.summary+'</p><div class="bottom_meta"><a href="javascript:;" class="bottom_first_a">'+username+'</a><a href="javascript:;" class="bottom_two_a"><i class="iconfont">&#xe684;</i><b>'+data[i].document.commentnum+'</b></a><span class="bottom_first_span"><i class="iconfont">&#xe602;</i><b>'+data[i].document.upvotenum+'</b></span><span class="bottom_two_span"><i class="iconfont">&#xe672;</i></span></div></div><a href="javascript:;" class="replace_img">'+image+'</aa></div>');
                                select_Btn.append(a_list);
                            }
                        }
                    });
                    $('#pagingTwo').children("li").on('click', function () {
                        $('#'+name).css({
                            '-webkit-user-select': 'none',
                            '-moz-user-select': 'none',
                            '-ms-user-select': 'none',
                            'user-select': 'none'
                        });
                    });
                }else{
                    article_list.append('<div class="contain_a" style="padding-bottom: 20px;"><span style="text-align: center;color: #8b8c8b;">——您当前仅浏览过这些文章——</span></div>')
                }
            },error:function () {

            }
        });
        article_list.append(get_more_two);
        var historyF = false;
        $.ajax({
            url:"../history/forum",
            type:"get",
            async: false,
            success:function (data) {
                var image,num = 18;
                if (data.length < 18) num = data.length;
                for (var i = 0;i < num;i ++){
                    image = "../img/14.png";
                    if (data[i].forum.image != null) image = data[i].forum.image;
                    var w_list = $('<div class="issueOutContainer"><div class="ShadowBoxConatiner"><a href="javascript:;"><img src="'+image+'"><span>'+data[i].forum.title+'</span></a><span class="issue">该议题被浏览 '+data[i].forum.sawnum+' 次</span></div></div>');
                    answer_list.append(w_list);
                }
                if (data.length > 18) {
                    answer_list.append('<div id="pagingThree" class="pagingTool"></div>');
                    $('#pagingThree').Paging({
                        pagesize: 18,
                        count:data.length,
                        prevTpl: '<i class="iconfont">&#xe78c;</i>',
                        nextTpl: '<i class="iconfont">&#xe77c;</i>',
                        firstTpl: '<i class="iconfont">&#xe609;</i>',
                        lastTpl: '<i class="iconfont">&#xe6de;</i>',
                        callback:function (page,size,count) {
                            console.log("num: "+page);
                            $("#AnswerBox").empty();
                            var n = page*18-1;
                            if (data.length-1 < n) n=data.length-1;
                            for (var i = (page-1)*18;i <= n;i ++){
                                var w_list = $('<div class="issueOutContainer"><div class="ShadowBoxConatiner"><a href="javascript:;"><img src="'+image+'"><span>'+data[i].forum.title+'</span></a><span class="issue">该议题被浏览 '+data[i].forum.sawnum+' 次</span></div></div>');
                                $("#AnswerBox").append(v_list);
                            }
                        }
                    });
                    $('#pagingTwo').children("li").on('click', function () {
                        $('#'+name).css({
                            '-webkit-user-select': 'none',
                            '-moz-user-select': 'none',
                            '-ms-user-select': 'none',
                            'user-select': 'none'
                        });
                    });
                }else{
                    answer_list.append('<div class="contain_a" style="padding-bottom: 20px;margin:0;"><span style="text-align: center;color: #8b8c8b;">——您当前仅浏览过这些问答——</span></div>')
                }
            },error:function () {

            }
        });
        if (historyF){
            getPaging("pagingThree")
        }
        answer_list.append(get_more_three);
        hf = true;
    }
});

//登录成功执行的方法
function loginSuccess(data) {
    $(".layui-layer-close").click();
    $(".last_li").empty();
    var image = "../img/14.png";
    if (data.headimage != null) image = data.headimage;
    $(".last_li").append('<div class="location_div_a"><a href="personalCenter.html" class="photo_cicle" target="_blank"><img src="'+image+'"> </a> <div class="msg_index_dance">进入个人中心 </div> </div> <div class="editor_article"> <a href="preset.html" target="_blank"> <span> <i class="iconfont">&#xe645;</i></span>写文章</a></div>');
    var touphoto = $(".contain_tou_photo");
    touphoto.children("a").children("img").attr("src",image);
    var nickname = data.nickname;
    if (data.nickname == null) nickname = "您尚未设置昵称";
    var address = data.address;
    if (data.address == null) address = "您尚未设置地址";
    var personality = data.personality;
    if (data.personality == null) personality = "您尚未设置个人签名" ;
    touphoto.children("div").children("span").text(nickname);
    touphoto.children("div").children("p:eq(0)").text(address);
    touphoto.children("div").children("p:eq(1)").text(personality);
}