package com.example.multimedia.service;

import com.example.multimedia.domain.*;
import com.example.multimedia.domain.returnMessage.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

public interface CommentService {
    /*
    * 评论功能
    * */
    Map<Long,String> comment(String type,long objid,String content);
    Map<Long,String> replyR(String type,String content,long objid,long rcommentid);

    /*
    * 删除评论
    * */
    String deleteComment(String type,long docid,long commentid);  //删除评论
    List<Long> deleteComment(String type,long docid,long commentid,long rcommentid);  //删除评论下回复

    /*
    * 返回评论
    * */
    List<DCView> getDocComment(long docid, int pagenum);
    List<FCView> getForumComment(long docid, int pageNum);
    List<VCView> getVideoComment(long docid, int pageNum);
}
