package com.example.multimedia.domain;

import javax.persistence.*;
import java.util.Date;

/*
* 论坛文章表
* */
@Entity
public class Forum {
    @Id
    @GeneratedValue
    private Long id;
    //标题
    private String title;
    //标题拼音
    private String tpinyin;
    //发表文章的用户id
    private long userid;
    //内容
    @Column(length = 65536)
    private String content;
    //简介
    private String summary;
    //最佳评论id
    private long resultid = -1;
    //文章图片
    private String image;
    //点赞个数
    private long upvotenum;
    //评论个数
    private long commentnum;
    //阅读个数
    private long sawnum;
    //forum作者题词
    private String problem;
    //类别
    @OneToOne(cascade = {CascadeType.ALL})
    private ForumKind kind;
//    //是否是互联网类别
//    private boolean internet;
//    //是否是法律
//    private boolean law;
//    //是否是医药
//    private boolean medicine;
//    //是否是经济
//    private boolean economy;
//    //是否是历史
//    private boolean history;
//    //是否是理工
//    private boolean science;
//    //是否是艺术
//    private boolean art;
    //发表时间
    private Date date;

    public Forum(){}

    public Forum(String title,String summary,String content,String tpinyin,long userid,ForumKind kind){
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.tpinyin = tpinyin;
        this.userid = userid;
        this.kind = kind;
        date = new Date();
    }

    @Override
    public String toString() {
        return "Forum{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tpinyin='" + tpinyin + '\'' +
                ", userid=" + userid +
                ", content='" + content + '\'' +
                ", summary='" + summary + '\'' +
                ", resultid=" + resultid +
                ", image='" + image + '\'' +
                ", upvotenum=" + upvotenum +
                ", commentnum=" + commentnum +
                ", sawnum=" + sawnum +
                ", problem='" + problem + '\'' +
                ", kind=" + kind +
                ", date=" + date +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTpinyin() {
        return tpinyin;
    }

    public void setTpinyin(String tpinyin) {
        this.tpinyin = tpinyin;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public long getResultid() {
        return resultid;
    }

    public void setResultid(long resultid) {
        this.resultid = resultid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getUpvotenum() {
        return upvotenum;
    }

    public void setUpvotenum(long upvotenum) {
        this.upvotenum = upvotenum;
    }

    public long getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(long commentnum) {
        this.commentnum = commentnum;
    }

    public long getSawnum() {
        return sawnum;
    }

    public void setSawnum(long sawnum) {
        this.sawnum = sawnum;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public ForumKind getKind() {
        return kind;
    }

    public void setKind(ForumKind kind) {
        this.kind = kind;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
